package com.neptunesoftware.accelerex.transaction;

import com.neptunesoftware.accelerex.account.AccountServices;
import com.neptunesoftware.accelerex.account.BalanceEnquiryService;
import com.neptunesoftware.accelerex.data.fundstransfer.CustomerToCustomerTransfer;
import com.neptunesoftware.accelerex.data.fundstransfer.CustomerToCustomerTransferResponse;
import com.neptunesoftware.accelerex.data.fundstransfer.FundsTransferOutputData;
import com.neptunesoftware.accelerex.data.fundstransfer.FundsTransferRequestData;
import com.neptunesoftware.accelerex.exception.FundTransferException;
import com.neptunesoftware.accelerex.transaction.mapper.TransactionMapper;
import com.neptunesoftware.accelerex.transaction.request.*;
import com.neptunesoftware.accelerex.transaction.response.TransactionHistoryResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponseStatus;

import jakarta.xml.bind.JAXBElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountServices accountService;
    private final TransactionMapper transactionMapper;
    private final BalanceEnquiryService balanceEnquiryService;
    @Value("${endpoint.fundTransferWebservice}")
    private String FUND_TRANSFER_WEB_SERVICE_END_POINT_PORT;

    @Value("${rubikon.channelId}")
    private String channelId;

    @Value("${rubikon.channelCode}")
    private String channelCode;
    public static final String PACKAGE_TO_SCAN = "com.neptunesoftware.accelerex.data.fundstransfer";

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountServices accountService,
                              TransactionMapper transactionMapper, BalanceEnquiryService balanceEnquiryService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.transactionMapper = transactionMapper;
        this.balanceEnquiryService = balanceEnquiryService;
    }
    public TransactionResponse transferFunds(TransactionRequest request){
        try{
            if (!isValidationChecksPassed(request)) {
                return new TransactionResponse(TransactionResponseStatus.FAIL, request.getReferenceNo());
            }
            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());
            FundsTransferRequestData txnRequestData = buildRequestFrom(request);
            CustomerToCustomerTransfer customerToCustomerTransfer = new CustomerToCustomerTransfer();
            customerToCustomerTransfer.setArg0(txnRequestData);
            log.info("Initiating internal funds transfer of Amount: {} and reference: {} from source: {} to destination: {}", request.getAmount(), request.getReferenceNo(),
                    request.getSenderAccountNumber(), request.getReceiverAccountNumber());
            JAXBElement response = (JAXBElement) webServiceTemplate.marshalSendAndReceive(
                    FUND_TRANSFER_WEB_SERVICE_END_POINT_PORT, customerToCustomerTransfer
            );
            CustomerToCustomerTransferResponse responseValue = (CustomerToCustomerTransferResponse) response.getValue();
            log.info("Response Code: {}", responseValue.getReturn().getResponseCode());
            if (!responseValue.getReturn().getResponseCode().equalsIgnoreCase("00")) {
                throw new FundTransferException("Transaction failed");
            }
            int transactionResponse = saveTransaction(responseValue.getReturn(), "InternalFundTransfer", request);
            if (transactionResponse != 1) {
                throw new FundTransferException("Internal funds transfer of amount: "+
                        request.getAmount()+" and reference: "+
                        request.getReferenceNo()+" from source: "+
                        request.getSenderAccountNumber()+" to destination: "+
                        request.getReceiverAccountNumber()+" failed to save to database");
            }
            return new TransactionResponse(TransactionResponseStatus.SUCCESS, request.getReferenceNo());
        } catch (FundTransferException e) {
            log.error(e.getMessage());
            return new TransactionResponse(TransactionResponseStatus.FAIL, request.getReferenceNo());
        }
    }
    private boolean isValidationChecksPassed(TransactionRequest request){
        BigDecimal amount = request.getAmount();
        String senderAccountNumber = request.getSenderAccountNumber();
        String receiverAccountNumber = request.getReceiverAccountNumber();
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new FundTransferException("Transaction amount must be greater than 0");
        }
        if (senderAccountNumber.equals(receiverAccountNumber)) {
            throw new FundTransferException("Sender and Receiver account cannot be the same");
        }
        if (!isValidAccountNumber(senderAccountNumber)) {
            throw new FundTransferException("The sender account number is invalid: " + senderAccountNumber);
        }
        if (!isValidAccountNumber(receiverAccountNumber)) {
            throw new FundTransferException("The receiver account number is invalid: " + receiverAccountNumber);
        }
        if (!balanceEnquiryService.isAccountSufficient(senderAccountNumber, amount)) {
            throw new FundTransferException("Insufficient funds");
        }
        if (existsByReferenceNo(request.getReferenceNo())) {
            throw new FundTransferException("Reference Number already exists");
        }
        return true;
    }
    public TransactionResponse getTransactionStatus(String externalRefNo, String clientId) {
        try{
            TransactionResponse transactionResponse = transactionRepository.findByClientIdAndReferenceNo(clientId, externalRefNo);
            return transactionResponse;
        }catch (Exception ex){
            log.error(ex.getMessage());
            return new TransactionResponse(TransactionResponseStatus.FAIL, externalRefNo);
        }
    }

//    public void reverseTransaction(String externalRefNo) {
//        Transaction transaction = transactionRepository.findByReferenceNo(externalRefNo).orElseThrow(()-> new TransactionNotFoundException("Transaction not found"));
//        Account receiverAccount = accountService.accountExistsAndIsActivated(transaction.getReceiverAccountNumber());
//        Account senderAccount = accountService.accountExistsAndIsActivated(transaction.getSenderAccountNumber());
//        accountService.debitAccount(receiverAccount, transaction.getAmount());
//        accountService.creditAccount(senderAccount, transaction.getAmount());
//        transaction.setStatus(TransactionStatus.SUCCESS);
//        transaction.setReversal('Y');
//        transactionRepository.saveAndFlush(transaction);
//    }
    private boolean isValidAccountNumber(String accountNumber) {
        return true;
//        return accountService.accountExistsAndIsActivated(accountNumber);
    }
    private boolean existsByReferenceNo(String referenceNo){
        return transactionRepository.existsByReferenceNo(referenceNo);
    }
    public List<TransactionHistoryResponse> getTransactionHistory(TransactionHistoryRequest request) {
        List<TransactionHistoryResponse> responses = transactionRepository.findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
                request.startDateTime(),
                request.endDateTime(),
                request.accountNumber(),
                request.accountNumber()
        );
        return responses;
    }

    private FundsTransferRequestData buildRequestFrom(TransactionRequest details) {
        FundsTransferRequestData txnRequestData = new FundsTransferRequestData();
        txnRequestData.setCurrBUId(-99L);
        txnRequestData.setChannelId(Long.valueOf(channelId));
        txnRequestData.setChannelCode(channelCode);
        txnRequestData.setXAPIServiceCode("FNT022");
        txnRequestData.setLocalCcyId(732L);
        txnRequestData.setTransmissionTime(System.currentTimeMillis());
        txnRequestData.setFromAccountNumber(details.getSenderAccountNumber());
        txnRequestData.setFromCurrencyCode(details.getCurrencyCode());
        txnRequestData.setToAccountNumber(details.getReceiverAccountNumber());
        txnRequestData.setToCurrencyCode(details.getCurrencyCode());
        txnRequestData.setAmount(details.getAmount());
        txnRequestData.setTransactionAmount(details.getAmount());
        txnRequestData.setTxnDescription(details.getNarration());
        txnRequestData.setTxnDate(Date.from(Instant.now()).toString());
        txnRequestData.setReference(details.getReferenceNo());
        txnRequestData.setRetrievalReferenceNumber(details.getReferenceNo());
        txnRequestData.setReversalIndicator("N");
        txnRequestData.setReversal(false);
        txnRequestData.setUserAccessCode("proxy_user_role");
        txnRequestData.setUserPassword("proxy_password");
        txnRequestData.setUserId(-99L);
        txnRequestData.setUserLoginId("SYSTEM");
        txnRequestData.setUserRoleId(-99L);
        txnRequestData.setUserBusinessRoleId(-99L);
        txnRequestData.setOriginatorUserId(-99L);
        return txnRequestData;
    }

    public int saveTransaction(FundsTransferOutputData fundsTransferOutputData, String subTranRef, TransactionRequest request) {
        TransactionDetails details = TransactionDetails.builder()
                .tranRef(fundsTransferOutputData.getTxnReference())
                .customerNo(request.getClientId().toString())
                .fromAccountNumber(fundsTransferOutputData.getFromAccountNumber())
                .toAccountNumber(fundsTransferOutputData.getToAccountNumber())
                .amount(fundsTransferOutputData.getTransactionAmount().toString())
                .responseCode(fundsTransferOutputData.getResponseCode())
                .subTranRef(subTranRef)
                .narration(request.getNarration())
                .build();
        return transactionRepository.saveTransaction(details);
    }
    private Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(PACKAGE_TO_SCAN);
        return marshaller;
    }
}