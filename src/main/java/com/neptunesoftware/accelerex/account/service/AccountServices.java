package com.neptunesoftware.accelerex.account.service;

import com.neptunesoftware.accelerex.account.request.DepositToGlRequest;
import com.neptunesoftware.accelerex.account.request.InterBankTransferRequest;
import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.account.sql.AccountRepository;
import com.neptunesoftware.accelerex.config.AccelerexCredentials;
import com.neptunesoftware.accelerex.data.account.BalanceEnquiryRequestData;
import com.neptunesoftware.accelerex.data.account.Balanceenquiry;
import com.neptunesoftware.accelerex.data.account.BalanceenquiryResponse;
import com.neptunesoftware.accelerex.data.fundstransfer.*;
import com.neptunesoftware.accelerex.exception.AccountNotExistException;
import com.neptunesoftware.accelerex.exception.AccountServiceException;
import com.neptunesoftware.accelerex.exception.BalanceEnquiryException;
import com.neptunesoftware.accelerex.exception.FundTransferException;
import com.neptunesoftware.accelerex.utils.ApiResponse;
import com.neptunesoftware.accelerex.utils.ResponseConstants;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static com.neptunesoftware.accelerex.utils.Cypher.deCypher;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccountServices  {

    private final AccountRepository accountRepository;
    private final BalanceEnquiryService balanceEnquiryService;
    private final AccelerexCredentials accelerexCredentials;
    private static final String ACCOUNT_JAXB_PACKAGE = "com.neptunesoftware.accelerex.data.account";
//    private static final String FUND_TRANSFER_JAXB_PACKAGE =  "com.neptunesoftware.accelerex.data.fundstransfer";
    
    public ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request) {
        LinkBankAccountResponse response = new LinkBankAccountResponse();
        if (!accountRepository.findAccountByPhoneAndAccountNumber(request.getMobileNo(), request.getAccountNo())) {
             throw new AccountNotExistException("Account Does Not Exist");
        }
        String otp = generateOTP();
        //Todo: API to verify otp
//        accountRepository.linkedAccount("",request.getMobileNo(),request.getEmail(),request.getAccountNo());
//        response.setAccountName(existingData.getAccountName());
        response.setMobileNo(request.getMobileNo());
        response.setEmail(request.getEmail());
        response.setAccountNo(request.getAccountNo());
        return new ApiResponse<>(ResponseConstants.SUCCESS_CODE, "Linked Successfully", response);
    }
    public BalanceResponse intraBankBalanceEnquiry(String accountNumber) {
        BalanceResponse response = balanceEnquiryService.balanceEnquiry(accountNumber);
            log.info("Available Balance {}", response.getAvailableBalance());
            return new BalanceResponse(response.getAccountNo(), response.getAccountName(), response.getAvailableBalance(),response.getResponseCode(),response.getMessage());
        }
    public NameEnquiryResponse IntraBankNameEnquiry(String accountNumber) {
        BalanceResponse response = balanceEnquiryService.balanceEnquiry(accountNumber);
        log.info("AccountName {}",response.getAccountName());
        return NameEnquiryResponse.builder().accountName(response.getAccountName()).accountNumber(response.getAccountNo()).build();
    }

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
    
    public InterBankTransferResponse interBankTransfer(InterBankTransferRequest request) {
        InterBankTransferResponse interBankTransferResponse;
        validateTransferRequest(request.getSourceAccount(),request.getBeneficiaryAccountNo(),request.getAmount());
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
                 throw new FundTransferException("Unable to complete transaction. Please try again later!");
             }

        }  catch (Exception e) {
            throw new RuntimeException("");
        }
        return  interBankTransferResponse;
    }
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
            throw new AccountServiceException("Error Fetching Details");
        }
        log.info("AccountName is {}", accountName);
        return  true;
    }

    public DepositToGLResponse depositToGL(DepositToGlRequest request) {
        String processingDate =  formatDate(LocalDate.now());
        validateGlTrn(request.getSourceAccountNumber(),request.getAmount());
//        XAPIBaseTxnRequestData txnRequestData = createRequestData(request,processingDate);
//        PostDepositToGLAccountTransfer depositToGLAccountTransfer = new PostDepositToGLAccountTransfer();
//        depositToGLAccountTransfer.setArg0(txnRequestData);
//
//        log.info("Initiating deposit to GL of amount {}", request.getAmount());
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

    private static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

//    private boolean verifySmsToken(String accountNumber, String smsToken) {
//        String token = accountRepository.findTokenByAccountNumber(accountNumber);
//        if (!(token.equals(smsToken))) throw new AccountServiceException("Incorrect token" + " for account: " + accountNumber);
//        return true;
//    }

    private void validateGlTrn(String accountNo, BigDecimal amount) {
        balanceEnquiryService.isAccountSufficient(accountNo,amount);
    }
    private boolean validateBankAccount(String accountNumber) {
      String dbAccountNumber = balanceEnquiryService.balanceEnquiry(accountNumber).getAccountNo();
        return dbAccountNumber.equals(accountNumber);
    }

    private boolean validateAccount(String accountNumber) {
      return   existedByAccount(accountNumber);
    }

    private Marshaller marshallerTransferAndNameEnquiry() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setPackagesToScan(accelerexCredentials.getFundTransferWsdl());
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

    private void validateTransferRequest(String senderAccountNumber, String receiverAccountNumber, BigDecimal amount) {

        if (!validateAccount(senderAccountNumber)) {
            throw new AccountNotExistException("Account Does Not Exist");
        }
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new FundTransferException("Transaction amount must be greater than 0");
        }
            BalanceResponse response = balanceEnquiryService.balanceEnquiry(senderAccountNumber);
            if (response.getAvailableBalance().compareTo(String.valueOf(new BigDecimal(String.valueOf(amount)))) < 0)
                throw new BalanceEnquiryException("Insufficient Balance");
        if (senderAccountNumber.equals(receiverAccountNumber)) {
            throw new FundTransferException("Sender and Receiver account cannot be the same");
        }
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
    private Marshaller marshallerB() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(ACCOUNT_JAXB_PACKAGE);
        return marshaller;
    }
}