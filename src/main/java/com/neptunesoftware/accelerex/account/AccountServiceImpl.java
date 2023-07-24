package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.DepositToGlRequest;
import com.neptunesoftware.accelerex.account.request.InterBankTransferRequest;
import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.config.AccelerexCredentials;
import com.neptunesoftware.accelerex.data.account.BalanceEnquiryRequestData;
import com.neptunesoftware.accelerex.data.account.Balanceenquiry;
import com.neptunesoftware.accelerex.data.account.BalanceenquiryResponse;
import com.neptunesoftware.accelerex.data.fundstransfer.*;
import com.neptunesoftware.accelerex.exception.AccountNotExistException;
import com.neptunesoftware.accelerex.exception.AccountServiceException;
import com.neptunesoftware.accelerex.exception.BalanceEnquiryException;
import com.neptunesoftware.accelerex.exception.FundTransferException;
import com.neptunesoftware.accelerex.user.repo.UserRepository;
import com.neptunesoftware.accelerex.utils.ApiResponse;
import com.neptunesoftware.accelerex.utils.ResponseConstants;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;

import static com.neptunesoftware.accelerex.account.SqlQueries.UPDATE_USER_ID_WITH_ACCOUNT_NUMBER;
import static com.neptunesoftware.accelerex.utils.Cypher.deCypher;
import static com.neptunesoftware.accelerex.utils.ResponseConstants.*;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccountServiceImpl implements AccountServices {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final BalanceEnquiryService balanceEnquiryService;
    private final AccelerexCredentials accelerexCredentials ;
    private final JdbcTemplate jdbcTemplate;

    private static final String ACCOUNT_JAXB_PACKAGE = "com.neptunesoftware.accelerex.data.account";
    private static final String FUND_TRANSFER_JAXB_PACKAGE =  "com.neptunesoftware.accelerex.data.fundstransfer";

    @Override
    public ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request) {

        LinkBankAccountResponse response = new LinkBankAccountResponse();
        String opt = generateOTP();
         BalanceResponse existingData = balanceEnquiryService.balanceEnquiry(response.getAccountNo());
        if (!existedByAccount(request.getAccountNo())) {
            return new ApiResponse<>(ResponseConstants.ERROR_MESSAGE, "Invalid bank account",response);
        }
        if (!userRepository.existsByEmailAddress(request.getEmail())) {
            return new ApiResponse<>(ResponseConstants.ERROR_MESSAGE, "Email address not found", response);
        }
        sendOTP(request.getMobileNo(), opt);

        if (!verifySmsToken(request.getAccountNo(), opt)) {
            return new ApiResponse<>(ResponseConstants.ERROR_MESSAGE, "OTP verification failed", response);
        }
        String clientId = accountRepository.findUserIdByAccountNumber(request.getAccountNo());
        linkAccount(clientId, request.getAccountNo());

        response.setAccountNo(existingData.getAccountNo());
        response.setAccountName(existingData.getAccountName());
        response.setMobileNo(request.getMobileNo());
        response.setEmail(request.getEmail());

        return new ApiResponse<>(ResponseConstants.SUCCESS_MESSAGE, "Account Linked successfully", response);
    }

    @Override
    public BalanceResponse intraBankBalanceEnquiry(String accountNumber) {

        BalanceResponse response = balanceEnquiryService.balanceEnquiry(accountNumber);
            log.info("Available Balance {}", response.getAvailableBalance());
            return new BalanceResponse(response.getAccountNo(),
                    response.getAccountName(),
                    response.getAvailableBalance(),
                    response.getResponseCode(),
                    response.getMessage());
        }

    @Override
    public NameEnquiryResponse IntraBankNameEnquiry(String accountNumber) {

        BalanceResponse response = balanceEnquiryService.balanceEnquiry(accountNumber);
        log.info("AccountName {}",response.getAccountName());
        return  NameEnquiryResponse.builder()
                .accountName(response.getAccountName())
                .message(response.getMessage())
                .responseCode(response.getResponseCode()).build();
    }

    @Override
    public ExternalTransferNameEnquiryResponse interBankNameEnquiry(String accountNumber) {

        ExternalTransferNameEnquiryResponse  responseData;

        try {

            NameInquiryRequestData requestData = buildRequestForNameInquiry(accountNumber);
            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshallerTransferAndNameEnquiry());

            ExternalAccountNameInquiry nameEnquiryRequestData = new ExternalAccountNameInquiry();
            nameEnquiryRequestData.setArg0(requestData);

            NameInquiryResponseData webServiceResponse;
            JAXBElement response;

            response = (JAXBElement)webServiceTemplate.marshalSendAndReceive(accelerexCredentials.getFundTransferWsdl(),nameEnquiryRequestData);

            webServiceResponse = (NameInquiryResponseData) response.getValue();
            log.info("Account Name {}",webServiceResponse.getAccountName());

            responseData = interBankNameEnquiryResponseMapper(webServiceResponse);

        } catch (Exception e) {

            throw new AccountNotExistException("An error querying AccountNumber: " + accountNumber);
        }

        log.info("Account name is: {}", responseData.getAccountName());
        
        return responseData;
    }

    @Override
    public InterBankTransferResponse interBankTransfer(InterBankTransferRequest request) {

        InterBankTransferResponse interBankTransferResponse;
        isAccountSufficient(request.getSourceAccount(),request.getAmount());

        InterBankTransferByAccountResponse apiResponse;

        try {

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshallerTransferAndNameEnquiry());

        InterBankTransferByAcctRequestData requestData =  buildRequestDataForInterBankTransfer(request);

        InterBankTransferByAccount interBankTransferByAccount =  new InterBankTransferByAccount();
        interBankTransferByAccount.setArg0(requestData);

        JAXBElement response;

            response = (JAXBElement) webServiceTemplate.marshalSendAndReceive(accelerexCredentials.getFundTransferWsdl(),interBankTransferByAccount);

            apiResponse = (InterBankTransferByAccountResponse)response.getValue();

            interBankTransferResponse = interBankTransferResponseMapper(apiResponse);

             if (!(interBankTransferResponse.getResponseCode().equals("00"))) {

                 log.error("Webservice failed with error code of {}", apiResponse.getReturn().getResponseCode());

                 throw new FundTransferException("Unable to complete transaction. Please try again later.");
             }

        }  catch (Exception e) {
            throw new RuntimeException("");
        }
        return  interBankTransferResponse;
    }

    @Override
    public Boolean existedByAccount(String accountNumber) {

        String accountName;
        String responseCode;

        try {
            BalanceEnquiryRequestData balEnqRequest = buildRequest(accountNumber);
            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshallerB());

            Balanceenquiry balanceenquiry = new Balanceenquiry();
            balanceenquiry.setArg0(balEnqRequest);

            BalanceenquiryResponse balanceenquiryResponse;

            JAXBElement apiResponse = (JAXBElement) webServiceTemplate.marshalSendAndReceive(accelerexCredentials.getAccountWsdl(), balanceenquiry);
            balanceenquiryResponse = (BalanceenquiryResponse) apiResponse.getValue();

            responseCode = balanceenquiryResponse.getReturn().getResponseCode();
            accountName = balanceenquiryResponse.getReturn().getTargetAccountName();

            if (!responseCode.equals("00")) {
                return false;
            }

        } catch (Exception e) {
            throw new AccountServiceException(WEBSERVICE_FAILED_RESPONSE_MESSAGE);
        }
        log.info("AccountName is {}", accountName);
        return  true;
    }

                 //Todo: Deposit to General Ledger Account
    /**
     * This Api will debit the customer on rubikon server,
     * save it on clearable GL and credit the payable or receivable GL
     depending on, if it is an intraBank or interBank Transaction and
     considering if factors such as on-us,not-on-us,
     or remote-on-us as the case may be.
     */

    @Override
    public DepositToGlResponse depositToGL(DepositToGlRequest request) {
//        String processingDate = processingDate();

        validateGlTrn(request.getSourceAccountNumber(),request.getAmount());
//        XAPIBaseTxnRequestData txnRequestData = createRequestData(transactionDetails, processingDate);
//        PostDepositToGLAccountTransfer depositToGLAccountTransfer = new PostDepositToGLAccountTransfer();
//        depositToGLAccountTransfer.setArg0(txnRequestData);
//
//        log.info("Initiating deposit to GL of amount {}", transactionDetails.getAmount());
//
//        JAXBElement response;
//        try {
//            response = (JAXBElement) this.webServiceTemplate.marshalSendAndReceive(
//                    TXN_PROCESS_WEBSERVICE, depositToGLAccountTransfer);
//        } catch (Exception e) {
//            log.error(e.getMessage());
//            throw new FundTransferException("An error occurred while performing deposit to GL operation");
//        }
//        return (PostDepositToGLAccountTransferResponse) response.getValue();
        return null;
    }

    private boolean verifySmsToken(String accountNumber, String smsToken) {
        String token = accountRepository.findTokenByAccountNumber(accountNumber);
        if (!(token.equals(smsToken))) throw new AccountServiceException("Incorrect token" + " for account: " + accountNumber);
        return true;
    }

    private void validateGlTrn(String accountNo, BigDecimal amount) {
        balanceEnquiryService.isAccountSufficient(accountNo,amount);
    }
    private boolean validateBankAccount(String accountNumber) {
      String dbAccountNumber = balanceEnquiryService.balanceEnquiry(accountNumber).getAccountNo();
        return dbAccountNumber.equals(accountNumber);
    }
    private void linkAccount(String clientId, String accountNumber) {
        jdbcTemplate.update(UPDATE_USER_ID_WITH_ACCOUNT_NUMBER,clientId,accountNumber);
    }

    private void validateAccount(String accountNumber) {
        interBankNameEnquiry(accountNumber);
    }

    private Marshaller marshallerTransferAndNameEnquiry() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setPackagesToScan(accelerexCredentials.getFundTransferWsdl());
        return marshaller;
    }

    private Marshaller marshallerB() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setPackagesToScan(ACCOUNT_JAXB_PACKAGE);
        return marshaller;
    }

    private BalanceEnquiryRequestData buildRequest(String accountNumber) {

        BalanceEnquiryRequestData balEnqRequest = new BalanceEnquiryRequestData();
        balEnqRequest.setChannelCode(String.valueOf(1));
        balEnqRequest.setTargetAccountNumber(accountNumber);
        return balEnqRequest;
    }

    public String generateOTP() {
        return RandomStringUtils.randomNumeric(4);
    }

    private void sendOTP(String mobileNumber, String otp) {
        // Todo: Implementation of SMS sending API
        // Send_Token: The OTP sent to the provided mobile number, is store and call verifyTokenAPI
        accountRepository.updateOTP(mobileNumber,otp);
    }


    private NameInquiryRequestData buildRequestForNameInquiry(String accountNumber) {
        NameInquiryRequestData nameInquiryRequestData = new NameInquiryRequestData();
        nameInquiryRequestData.setSessionId(String.valueOf(System.currentTimeMillis()));
        nameInquiryRequestData.setDestinationInstitutionCode("");
        nameInquiryRequestData.setChannelCode(deCypher(accelerexCredentials.getChannelCode()));
        nameInquiryRequestData.setBicCode("");
        nameInquiryRequestData.setAccountNumber(accountNumber);
        return nameInquiryRequestData;
    }

    private InterBankTransferByAcctRequestData buildRequestDataForInterBankTransfer(InterBankTransferRequest interBankTransferRequest) {
        InterBankTransferByAcctRequestData interBankTransferByAcctRequestData = new InterBankTransferByAcctRequestData();
        interBankTransferByAcctRequestData.setSessionId(String.valueOf(System.currentTimeMillis()));
        interBankTransferByAcctRequestData.setChannelCode("AGENCY");
        interBankTransferByAcctRequestData.setChannelId(17L);
        interBankTransferByAcctRequestData.setXAPIServiceCode("STC029");
        interBankTransferByAcctRequestData.setBeneficiaryName(interBankTransferRequest.getBeneficiaryName());
        interBankTransferByAcctRequestData.setCustAccountNumber(interBankTransferRequest.getSourceAccount());
        interBankTransferByAcctRequestData.setBeneficiaryAccountNumber(interBankTransferRequest.getBeneficiaryAccountNo());
        interBankTransferByAcctRequestData.setRetrievalReferenceNumber(interBankTransferRequest.getExternalRefNo());
        interBankTransferByAcctRequestData.setBicCode(interBankTransferRequest.getBeneficiaryBankCode());
        interBankTransferByAcctRequestData.setTxnCurrencyCode(interBankTransferRequest.getCurrencyCode());
        return interBankTransferByAcctRequestData;
    }

    public void isAccountSufficient(String sourceAccountNumber, String amount) {
        validateAccount(sourceAccountNumber);
        BalanceResponse response = balanceEnquiryService.balanceEnquiry(sourceAccountNumber);
        boolean balanceEnquiryResponse = response.getAvailableBalance().compareTo(String.valueOf(new BigDecimal(amount))) < 0;
        if (balanceEnquiryResponse)
            throw new BalanceEnquiryException("Insufficient Balance");
    }

    private ExternalTransferNameEnquiryResponse interBankNameEnquiryResponseMapper(NameInquiryResponseData nameInquiryResponseData ) {

        ExternalTransferNameEnquiryResponse response = new ExternalTransferNameEnquiryResponse();
        response.setAccountName(nameInquiryResponseData.getAccountName());
        response.setResponseCode(nameInquiryResponseData.getResponseCode());
        response.setResponseMessage(nameInquiryResponseData.getErrMsg());
        response.setSessionId(String.valueOf(System.currentTimeMillis()));
        response.setSessionId(nameInquiryResponseData.getSessionId());
        return  response;
    }
    private InterBankTransferResponse interBankTransferResponseMapper(InterBankTransferByAccountResponse response) {
        InterBankTransferResponse interBankTransferResponse = new InterBankTransferResponse();
        interBankTransferResponse.setResponseCode(response.getReturn().getResponseCode());
        interBankTransferResponse.setResponseMessage("");
        interBankTransferResponse.setCoreBankingRefNo(response.getReturn().getTxnReference());
        interBankTransferResponse.setNIBSS_SessionId(String.valueOf(System.currentTimeMillis()));
        return interBankTransferResponse;
    }
}