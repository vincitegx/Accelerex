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
import com.neptunesoftware.accelerex.data.transaction.PostDepositToGLAccountTransfer;
import com.neptunesoftware.accelerex.data.transaction.PostDepositToGLAccountTransferResponse;
import com.neptunesoftware.accelerex.data.transaction.XAPIBaseTxnRequestData;
import com.neptunesoftware.accelerex.exception.*;
import com.neptunesoftware.accelerex.user.User;
import com.neptunesoftware.accelerex.utils.ApiResponse;
import com.neptunesoftware.accelerex.utils.ResponseConstants;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;
import java.util.Objects;

import static com.neptunesoftware.accelerex.utils.Cypher.deCypher;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccountServices  {
    private final AccountRepository accountRepository;
    private final BalanceEnquiryService balanceEnquiryService;
    private final AccelerexCredentials accelerexCredentials;
    private static final String ACCOUNT_JAXB_PACKAGE = "com.neptunesoftware.accelerex.data.account";
    private static final String TRANSACTION_JAXB_PACKAGE = "com.neptunesoftware.accelerex.data.transaction";

    public ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request) {
        if (request.getAccountNo() == null || request.getAccountNo().isEmpty()) {
            throw new ResourceNotFoundException("ACCOUNT NUMBER NOT PROVIDED");
        }
        if (request.getUserName() == null || request.getUserName().isEmpty()) {
            throw new ResourceNotFoundException("USERNAME NOT PROVIDED");
        }
        User user = accountRepository.findByAccountNumber(request.getAccountNo());
        if (user.getAccountNumber() != null) {
            log.info("ACCOUNT_NUMBER {} PHONE_NUMBER {}", user.getAccountNumber(), user.getPhoneNumber());

            if (accountRepository.findByUserName(request.getUserName())) {
                log.info("USERNAME ALREADY EXIST");
                throw new AccountExistException("PROFILE ALREADY EXIST");
            }
            accountRepository.linkExistingAccountToAgentProfile(user,request.getUserName());
            log.info("RECORD SAVED TO DB");
        }
        return new ApiResponse<>(ResponseConstants.SUCCESS_CODE, "Linked Successfully",
                new LinkBankAccountResponse(request.getUserName(), user.getAccountNumber(), user.getFullName(),
                        request.getMobileNo(), request.getEmail()));
    }
    public BalanceResponse intraBankBalanceEnquiry(String accountNumber) {
        BalanceResponse response = balanceEnquiryService.balanceEnquiry(accountNumber);
            log.info("AVAILABLE BALANCE {}", response.getAvailableBalance());
            return new BalanceResponse(response.getAccountNo(), response.getAccountName(), response.getAvailableBalance(),response.getResponseCode(),response.getMessage());
        }
    public NameEnquiryResponse IntraBankNameEnquiry(String accountNumber) {
        BalanceResponse response = balanceEnquiryService.balanceEnquiry(accountNumber);
        log.info("ACCOUNT NAME {}",response.getAccountName());
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
            log.info("AccountName {}",webServiceResponse.getAccountName());

            responseData = interBankNameEnquiryResponseMapper(webServiceResponse);

        } catch (Exception e) {

            throw new AccountNotExistException("An error querying AccountNumber: " + accountNumber);
        }
        
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
            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshallerAccount());
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
        log.info("ACCOUNT-NAME {}", accountName);
        return  true;
    }

    public DepositToGLResponse depositToGLTransfer(DepositToGlRequest request) {
        validateGlTrn(request.getSourceAccountNumber(), request.getAmount());
        log.info("Initiating DepositToGL Transfer with amount {}", request.getAmount());
        String responseCode;
        String transactionAmount;
        String accountNumber;
        String transactionReference;
        String retrievalReference;
        String transactionCurrencyCode;
        String txnJournalId;
        try {
            XAPIBaseTxnRequestData txnRequestData = createRequestData(request);
            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshallerTransaction());
            PostDepositToGLAccountTransfer depositToGLAccountTransfer = new PostDepositToGLAccountTransfer();
            depositToGLAccountTransfer.setArg0(txnRequestData);
            PostDepositToGLAccountTransferResponse webServiceResponse;

            JAXBElement response = (JAXBElement) webServiceTemplate.marshalSendAndReceive(
                    accelerexCredentials.getTransactionWsdl(), depositToGLAccountTransfer);
            webServiceResponse = (PostDepositToGLAccountTransferResponse) response.getValue();
                if(!Objects.equals(webServiceResponse.getReturn().getResponseCode(), "00")){
                    throw new TransferException("FAILED TO DEPOSIT TO GL ACCOUNT");
                }
                responseCode =  webServiceResponse.getReturn().getResponseCode();
                transactionAmount = String.valueOf(webServiceResponse.getReturn().getTransactionAmount());
                accountNumber = webServiceResponse.getReturn().getPrimaryAccountNumber();
                transactionReference = webServiceResponse.getReturn().getTxnReference();
                transactionCurrencyCode = webServiceResponse.getReturn().getTransactionCurrencyCode();
                txnJournalId = String.valueOf(webServiceResponse.getReturn().getTxnJournalId());
                retrievalReference = webServiceResponse.getReturn().getRetrievalReferenceNumber();
                log.info("TRANSACTION-REF {} ACCOUNT-NUMBER {} TRANSACTION-AMOUNT {}",transactionReference,accountNumber,transactionAmount);
        } catch (Exception e) {
            throw new TransferException(e.getMessage());
        }
        return DepositToGLResponse.builder()
                .responseCode(responseCode)
                .depositToGlResponseData(DepositToGlResponseData.builder()
                        .transactionReference(transactionReference)
                        .transactionAmount(transactionAmount)
                        .accountNumber(accountNumber)
                        .retrievalReference(retrievalReference)
                        .transactionCurrencyCode(transactionCurrencyCode)
                        .txnJournalId(txnJournalId)
                        .build())
                .build();
    }
    private XAPIBaseTxnRequestData createRequestData(DepositToGlRequest request){
        XAPIBaseTxnRequestData transactionData = new XAPIBaseTxnRequestData();
        transactionData.setXAPIServiceCode("TXN025");
        transactionData.setAmount(request.getAmount());
        transactionData.setChannelCode(accelerexCredentials.getChannelCode());
        transactionData.setChannelId(Long.valueOf(accelerexCredentials.getChannelId()));
        transactionData.setCurrBUId(-99L);
        transactionData.setLocalCcyId(566L);
        transactionData.setReference("SEP909090123");
        transactionData.setResponse("0");
        transactionData.setReversalIndicator("N");
        transactionData.setTransmissionTime(123456789L);
        transactionData.setUserId(-99L);
        transactionData.setUserLoginId("SYSTEM");
        transactionData.setUserRoleId(-99L);
        transactionData.setValidXapiRequest(true);
        transactionData.setAcctNo(request.getSourceAccountNumber());
        transactionData.setContraAcctNo("1-01-01-001-1-30-03-01");
        transactionData.setContraGLAccountNumber("");
        transactionData.setOrgBusinessUnitId(-99L);
        transactionData.setTxnAmount(request.getAmount());
        transactionData.setTxnCurrencyCode("NGN");
        transactionData.setTxnDate("11-12-2021");
        transactionData.setTxnDescription("UPGRADE TEST");
        transactionData.setValueDate("11-12-2021");
        return transactionData;
    }

    private void validateGlTrn(String accountNo, BigDecimal amount) {
        balanceEnquiryService.isAccountSufficient(accountNo,amount);
    }

    private boolean validateAccount(String accountNumber) {
      return   existedByAccount(accountNumber);
    }
    private Marshaller marshallerTransferAndNameEnquiry() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(accelerexCredentials.getFundTransferWsdl());
        return marshaller;
    }

    private BalanceEnquiryRequestData buildRequest(String accountNumber) {
        BalanceEnquiryRequestData balEnqRequest = new BalanceEnquiryRequestData();
        balEnqRequest.setChannelCode(String.valueOf(1));
        balEnqRequest.setTargetAccountNumber(accountNumber);
        return balEnqRequest;
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
    private Marshaller marshallerAccount() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(ACCOUNT_JAXB_PACKAGE);
        return marshaller;
    }
    private Marshaller marshallerTransaction() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(TRANSACTION_JAXB_PACKAGE);
        return marshaller;
    }
}