package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.InterBankTransferRequest;
import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.config.AccelerexCredentials;
import com.neptunesoftware.accelerex.exception.AccountNotExistException;
import com.neptunesoftware.accelerex.exception.AccountServiceException;
import com.neptunesoftware.accelerex.exception.BalanceEnquiryException;
import com.neptunesoftware.accelerex.exception.FundTransferException;
import com.neptunesoftware.accelerex.user.repo.UserRepository;
import com.neptunesoftware.accelerex.utils.ApiResponse;
import com.neptunesoftware.accelerex.utils.ResponseConstants;
import data.FundTransfer.*;
import data.account.BalanceEnquiryRequestData;
import data.account.Balanceenquiry;
import data.account.BalanceenquiryResponse;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;

import static com.neptunesoftware.accelerex.account.SqlQueries.UPDATE_USER_ID_WITH_ACCOUNT_NUMBER;
import static com.neptunesoftware.accelerex.utils.Cypher.deCypher;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccountServiceImpl implements AccountServices {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final AccelerexCredentials ACCELEREX_CREDENTIALS ;
    @Value("${endpoint.accountWebservice}")
    private String ACCOUNT_WEB_SERVICE_END_POINT_PORT;
    @Value("${endpoint.fundTransferWebservice}")
    private String FUND_TRANSFER_SERVICE_END_POINT;
    private final JdbcTemplate jdbcTemplate;
    //private final Jaxb2Marshaller marshaller;
    private static final String ACCOUNT_JAXB_PACKAGE = "com.neptunesoftware.accelerex.data.account";
    private static final String FUND_TRANSFER_JAXB_PACKAGE =  "com.neptunesoftware.accelerex.data.FundTransfer";

    @Override
    public ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request) {

        LinkBankAccountResponse response = new LinkBankAccountResponse();
        String opt = generateOTP();
        boolean isAccountValid = validateBankAccount(request.getAccountNo());
        boolean existsByEmailAddress = userRepository.existsByEmailAddress(request.getEmail());
        boolean isOtpVerified = verifySmsToken(request.getAccountNo(), opt);

        if (existsByEmailAddress && isAccountValid) {
            sendOTP(request.getMobileNo(), opt);
            if (isOtpVerified) {
                String clientId = accountRepository.findUserIdByAccountNumber(request.getAccountNo());
                linkAccount(clientId, request.getAccountNo());
                String accountName = accountRepository.findNameByAccountNumber(request.getAccountNo());
                String accountNumber = accountRepository.findAccountByPhoneNumber(request.getMobileNo());
                if (request.getAccountNo().equals(accountNumber)) {
                    response.setAccountNo(accountRepository.findAccountByPhoneNumber(accountNumber));
                    response.setAccountName(accountName);
                }
            }
        }
     return  new ApiResponse<>(ResponseConstants.SUCCESS_MESSAGE,"Account Linked successfully",response);
    }
    
    @Override
    public FetchAccountBalanceResponse fetchAccountBalance(String accountNumber) {
        validateAccount(accountNumber);
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());
        FetchAccountBalanceResponse accountBalanceResponse;
        BalanceenquiryResponse balanceenquiryResponse;
        BalanceEnquiryRequestData balEnqRequest = buildRequestForBalanceInquiry(accountNumber);
        Balanceenquiry balanceenquiry = new Balanceenquiry();
        balanceenquiry.setArg0(balEnqRequest);
        JAXBElement response;
        try {
            response = (JAXBElement) webServiceTemplate.marshalSendAndReceive(
                    ACCOUNT_WEB_SERVICE_END_POINT_PORT, balanceenquiry);
              balanceenquiryResponse = (BalanceenquiryResponse) response.getValue();
              accountBalanceResponse = mapAccountBalanceToBalanceEnquiryResponse(balanceenquiryResponse);

        } catch (Exception e) {
            throw new BalanceEnquiryException("An error occurred while querying the account balance "
                    + " for account " + accountNumber);
        }
        return accountBalanceResponse;
    }

    @Override
    public ExternalTransferNameEnquiryResponse interBankNameEnquiry(String accountNumber) {
        ExternalTransferNameEnquiryResponse  responseData;
        NameenquirysingleitemResponse responseFromWebServiceCall;
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());
        NameInquiryRequestData requestData = buildRequestForNameInquiry(accountNumber);
        ExternalAccountNameInquiry nameEnquiryRequestData = new ExternalAccountNameInquiry();
        nameEnquiryRequestData.setArg0(requestData);

        JAXBElement response;
        try {
            response = (JAXBElement)webServiceTemplate.marshalSendAndReceive(FUND_TRANSFER_SERVICE_END_POINT,nameEnquiryRequestData);
            responseFromWebServiceCall = (NameenquirysingleitemResponse) response.getValue();
            responseData = mapInterBankNameEnquiryResponse(responseFromWebServiceCall);

        } catch (Exception e) {
            throw new AccountNotExistException("An error occurred while querying Account name, for Account number: " + accountNumber);
        }
        log.info("Account name is: {}", responseData.getAccountName());
        return responseData;
    }

    @Override
    public InterBankTransferResponse interBankTransfer(InterBankTransferRequest request) {
        InterBankTransferResponse interBankTransferResponse;
        validateAccount(request.getBeneficiaryAccountNo());
        isAccountSufficient(request.getSourceAccount(),request.getAmount());

        InterBankTransferByAccountResponse apiResponse;
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());
        InterBankTransferByAcctRequestData requestData =  buildRequestDataForInterBankTransfer(request);
        InterBankTransferByAccount interBankTransferByAccount =  new InterBankTransferByAccount();
        interBankTransferByAccount.setArg0(requestData);
        JAXBElement response;

        try {
            response = (JAXBElement) webServiceTemplate.marshalSendAndReceive(FUND_TRANSFER_SERVICE_END_POINT,interBankTransferByAccount);
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
    public String intraBankNameEnquiry(String accountNumber) {
        //Todo:
        return null;
    }


    private BalanceEnquiryRequestData buildRequestForBalanceInquiry(String accountNumber) {
        BalanceEnquiryRequestData balEnqRequest = new BalanceEnquiryRequestData();
        balEnqRequest.setSessionId(String.valueOf(System.currentTimeMillis()));
        balEnqRequest.setDestinationInstitutionCode("");
        balEnqRequest.setChannelCode(deCypher(ACCELEREX_CREDENTIALS.getChannelCode()));
        balEnqRequest.setAuthorizationCode("");
        balEnqRequest.setTargetAccountName("");
        balEnqRequest.setTargetBankVerificationNumber("");
        balEnqRequest.setTargetAccountNumber(accountNumber);
        return balEnqRequest;
    }

    private NameInquiryRequestData buildRequestForNameInquiry(String accountNumber) {
        NameInquiryRequestData nameInquiryRequestData = new NameInquiryRequestData();
        nameInquiryRequestData.setSessionId(String.valueOf(System.currentTimeMillis()));
        nameInquiryRequestData.setDestinationInstitutionCode("");
        nameInquiryRequestData.setChannelCode(deCypher(ACCELEREX_CREDENTIALS.getChannelCode()));
        nameInquiryRequestData.setBicCode("");
        nameInquiryRequestData.setAccountNumber(accountNumber);
        return nameInquiryRequestData;
    }
    
    private InterBankTransferByAcctRequestData buildRequestDataForInterBankTransfer(InterBankTransferRequest interBankTransferRequest) {
        InterBankTransferByAcctRequestData interBankTransferByAcctRequestData = new InterBankTransferByAcctRequestData();
        interBankTransferByAcctRequestData.setSessionId(String.valueOf(System.currentTimeMillis()));
        interBankTransferByAcctRequestData.setChannelCode("AGENCY");
        interBankTransferByAcctRequestData.setChannelId(17L);
        interBankTransferByAcctRequestData.setXAPIServiceCode("");
        interBankTransferByAcctRequestData.setBeneficiaryAccountNumber(interBankTransferRequest.getBeneficiaryAccountNo());
        interBankTransferByAcctRequestData.setBeneficiaryName(interBankTransferRequest.getBeneficiaryName());
        interBankTransferByAcctRequestData.setCustAccountNumber(interBankTransferRequest.getSourceAccount());
        interBankTransferByAcctRequestData.setRetrievalReferenceNumber(interBankTransferRequest.getExternalRefNo());
        interBankTransferByAcctRequestData.setBicCode(interBankTransferRequest.getBeneficiaryBankCode());
        interBankTransferByAcctRequestData.setTxnCurrencyCode(interBankTransferRequest.getCurrencyCode());
        return interBankTransferByAcctRequestData;
    }

    public void isAccountSufficient(String sourceAccountNumber, String amount) {
        validateAccount(sourceAccountNumber);
        FetchAccountBalanceResponse response = fetchAccountBalance(sourceAccountNumber);
        boolean balanceEnquiryResponse = response.getAvailableBalance().compareTo(new BigDecimal(amount)) < 0;
        if (balanceEnquiryResponse)
            throw new BalanceEnquiryException("Account has insufficient balance");
    }
    private FetchAccountBalanceResponse mapAccountBalanceToBalanceEnquiryResponse (BalanceenquiryResponse response) {
        FetchAccountBalanceResponse fetchAccountBalanceResponse = new FetchAccountBalanceResponse();
        fetchAccountBalanceResponse.setAvailableBalance(response.getReturn().getAvailableBalance());
        fetchAccountBalanceResponse.setAccountName(response.getReturn().getTargetAccountName());
        fetchAccountBalanceResponse.setAccountNo(response.getReturn().getTargetAccountNumber());
        return fetchAccountBalanceResponse;
    }

    private ExternalTransferNameEnquiryResponse mapInterBankNameEnquiryResponse(NameenquirysingleitemResponse nameenquirysingleitemResponse ) {
        ExternalTransferNameEnquiryResponse response = new ExternalTransferNameEnquiryResponse();
        response.setAccountName(nameenquirysingleitemResponse.getReturn().getAccountName());
        response.setResponseCode(nameenquirysingleitemResponse.getReturn().getResponseCode());
        response.setResponseMessage(nameenquirysingleitemResponse.getReturn().getErrMsg());
        response.setSessionId(String.valueOf(System.currentTimeMillis()));
//            responseData.setSessionId(nameInquiryResponseData.getSessionId());
        return  response;
    }
    private InterBankTransferResponse interBankTransferResponseMapper(InterBankTransferByAccountResponse response) {
        InterBankTransferResponse interBankTransferResponse = new InterBankTransferResponse();
        interBankTransferResponse.setResponseCode(response.getReturn().getResponseCode());
//        interBankTransferResponse.setResponseMessage("");
        interBankTransferResponse.setCoreBankingRefNo(response.getReturn().getTxnReference());
//        interBankTransferResponse.setNIBSS_SessionId("");
        return interBankTransferResponse;
    }
    
    @Override
    public ApiResponse<NameEnquiryResponse> nameEnquiry(String accountNumber) {
        String accountName = accountRepository.findNameByAccountNumber(accountNumber);
        if (accountName.equals(Strings.EMPTY)) {
            throw new AccountNotExistException("The specified account number does not exist " + accountNumber);
        }
        return new ApiResponse<>(ResponseConstants.SUCCESS_MESSAGE, "The account name is: ", NameEnquiryResponse.builder()
                .accountName(accountName).build());
    }

//    @Override
//    public VerifyTokenResponse verifySmsToken(String smsToken) {
//        User user = userRepository.findBySmsToken(smsToken).get();
//        VerifyTokenResponse response = new VerifyTokenResponse();
//        response.setAccountName(user.getFullName());
//        response.setAccountNo(user.getPhoneNumber());
//        response.setEmail(user.getEmailAddress());
//        return response;
//    }
    private boolean verifySmsToken(String accountNumber, String smsToken) {
        String token = accountRepository.findTokenByAccountNumber(accountNumber);
        if (!(token.equals(smsToken))) throw new AccountServiceException("Incorrect token" + " for account: " + accountNumber);
        return true;
    }

    private boolean validateBankAccount(String accountNumber) {
        String accountNum = accountRepository.findByAccountNumber(accountNumber);
        if (!(accountNum.equals(accountNumber))) {
            throw new AccountNotExistException("Account does not exist");
        }
        return true;
    }
    private void linkAccount(String clientId, String accountNumber) {
        jdbcTemplate.update(UPDATE_USER_ID_WITH_ACCOUNT_NUMBER,clientId,accountNumber);
    }


    private void validateAccount(String accountNumber) {
        interBankNameEnquiry(accountNumber);
    }
    private Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setPackagesToScan(ACCOUNT_JAXB_PACKAGE,FUND_TRANSFER_JAXB_PACKAGE);
        return marshaller;
    }

    public String generateOTP() {
        return RandomStringUtils.randomNumeric(4);
    }

    private void sendOTP(String mobileNumber, String otp) {
        // Todo: Implementation of SMS sending API
        // Send_Token: The OTP sent to the provided mobile number, is store and call verifyTokenAPI
        accountRepository.updateOTP(mobileNumber,otp);
    }
}