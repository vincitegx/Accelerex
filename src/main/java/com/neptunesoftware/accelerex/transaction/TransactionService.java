package com.neptunesoftware.accelerex.transaction;

import com.neptunesoftware.accelerex.account.AccountServices;
import com.neptunesoftware.accelerex.account.BalanceEnquiryService;
import com.neptunesoftware.accelerex.data.fundstransfer.CustomerToCustomerTransfer;
import com.neptunesoftware.accelerex.data.fundstransfer.CustomerToCustomerTransferResponse;
import com.neptunesoftware.accelerex.data.fundstransfer.FundsTransferOutputData;
import com.neptunesoftware.accelerex.data.fundstransfer.FundsTransferRequestData;
import com.neptunesoftware.accelerex.exception.FundTransferException;
import com.neptunesoftware.accelerex.exception.ResourceNotFoundException;
import com.neptunesoftware.accelerex.transaction.mapper.TransactionMapper;
import com.neptunesoftware.accelerex.transaction.request.*;
import com.neptunesoftware.accelerex.transaction.response.TransactionHistoryResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponseStatus;
import com.neptunesoftware.accelerex.user.UserService;

import jakarta.xml.bind.JAXBElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountServices accountService;
    private final UserService userService;
    private final TransactionMapper transactionMapper;
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();
    private final BalanceEnquiryService balanceEnquiryService;
    @Value("${endpoint.fundTransferWebservice}")
    private String FUND_TRANSFER_WEB_SERVICE_END_POINT_PORT;

    @Value("${rubikon.channelId}")
    private String channelId;

    @Value("${rubikon.channelCode}")
    private String channelCode;
    public static final String PACKAGE_TO_SCAN = "com.neptunesoftware.accelerex.data.fundtransfer";

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountServices accountService,
                              UserService userService, TransactionMapper transactionMapper, BalanceEnquiryService balanceEnquiryService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.userService = userService;
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
                log.info("Transaction failed");
                throw new FundTransferException("Transaction failed");
            }
            int transactionResponse = saveTransaction(responseValue.getReturn(), "InternalFundTransfer", request);
            if (transactionResponse == 1) {
                log.info("Internal funds transfer of Amount: {} and reference: {} from source: {} to destination: {} was successful", request.getAmount(), request.getReferenceNo(),
                        request.getSenderAccountNumber(), request.getReceiverAccountNumber());
                return new TransactionResponse(TransactionResponseStatus.SUCCESS, request.getReferenceNo());
            } else {
                try {
                    saveTransactionWithRetry(responseValue.getReturn(), "InternalFundTransfer", request);
                    log.info("Internal funds transfer of amount: {} and reference: {} from source: {} to destination: {} was successfully saved after retry", request.getAmount(), request.getReferenceNo(),
                            request.getSenderAccountNumber(), request.getReceiverAccountNumber());
                    return new TransactionResponse(TransactionResponseStatus.SUCCESS, request.getReferenceNo());
                } catch (Exception e) {
                    log.error("Internal funds transfer of amount: {} and reference: {} from source: {} to destination: {} failed to save after retry", request.getAmount(), request.getReferenceNo(),
                            request.getSenderAccountNumber(), request.getReceiverAccountNumber());
                    return new TransactionResponse(TransactionResponseStatus.FAIL, request.getReferenceNo());
                }
            }
        } catch (FundTransferException e) {
            log.error(e.getMessage());
            return new TransactionResponse(TransactionResponseStatus.FAIL, request.getReferenceNo());
        }
    }

    @Retryable(value = { FundTransferException.class }, maxAttempts = 3, backoff = @Backoff(delay = 1000))
    private int saveTransactionWithRetry(FundsTransferOutputData fundsTransferOutputData, String subTranRef, TransactionRequest request) {
        return saveTransaction(fundsTransferOutputData, subTranRef, request);
    }

    @Recover
    private TransactionResponse handleRetryExhaustion(Exception e, FundsTransferOutputData response, String type, TransactionRequest request) {
        log.error("Internal funds transfer of Amount: {} and reference: {} from source: {} to destination: {} failed to save after retry", request.getAmount(), request.getReferenceNo(),
                request.getSenderAccountNumber(), request.getReceiverAccountNumber());
        return new TransactionResponse(TransactionResponseStatus.FAIL, request.getReferenceNo());
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
        TransactionResponse transactionResponse = transactionRepository.findByClientIdAndReferenceNo(clientId, externalRefNo);
        return transactionResponse;
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

//    public void processBulkTransactions(BulkTransactionRequest request) {
//        List<TransactionEntry> entries = request.transactionEntries();
//        if (entries.size() > 6) {
//            throw new IllegalArgumentException("Exceeded maximum number of entries per bulk transaction");
//        }
//        for (TransactionEntry entry : entries) {
//            validateTransactionEntry(entry);
//            if (entry.transactionType() == TransactionType.DEBIT) {
//                Account debitAccount = accountService.getAccountByNumber(entry.accountNumber());
//                accountService.debitAccount(debitAccount, entry.amount());
//            } else if (entry.transactionType() == TransactionType.CREDIT) {
//                Account creditAccount = accountService.getAccountByNumber(entry.accountNumber());
//                accountService.creditAccount(creditAccount, entry.amount());
//            }
//            saveTransactionEntry(entry);
//        }
//    }
//
//    private void validateTransactionEntry(TransactionEntry entry) {
//        if (!isValidAccountNumber(entry.accountNumber())) {
//            throw new IllegalArgumentException("Invalid account number: " + entry.accountNumber());
//        }
//        if (entry.amount().compareTo(BigDecimal.ZERO) <= 0) {
//            throw new IllegalArgumentException("Invalid amount: " + entry.amount());
//        }
//    }

    private boolean isValidAccountNumber(String accountNumber) {
        return accountService.accountExistsAndIsActivated(accountNumber);
    }
//
//    private void saveTransactionEntry(TransactionEntry entry) {
//        Transaction transaction = new Transaction();
//        if(entry.transactionType() == TransactionType.CREDIT){
//            transaction.setReceiverAccountNumber(entry.accountNumber());
//        }else{
//            transaction.setSenderAccountNumber(entry.accountNumber());
//        }
//        transaction.setTransactionType(entry.transactionType());
//        transaction.setAmount(entry.amount());
//        transactionRepository.save(transaction);
//    }

    private Boolean existsByReferenceNo(String referenceNo){
        return transactionRepository.existsByReferenceNo(referenceNo);
    }

    public List<TransactionHistoryResponse> getTransactionHistory(TransactionHistoryRequest request) {
        List<TransactionHistoryResponse> responses = transactionRepository.findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
                request.startDateTime(),
                request.endDateTime(),
                request.accountNumber(),
                request.accountNumber()
        );
        if(responses.isEmpty()){
            throw new ResourceNotFoundException("no transactions");
        }
//        return responses;
        return formatTransactions(responses, request);
    }

    private List<TransactionHistoryResponse> formatTransactions(List <TransactionHistoryResponse> responses, TransactionHistoryRequest request){
        List<TransactionHistoryResponse> transactionHistoryResponses = new ArrayList<>();
        responses.forEach(
                response -> {
                    TransactionHistoryResponse transactionHistoryResponse = new TransactionHistoryResponse();
                    transactionHistoryResponse.setAmount(response.getAmount());
                    transactionHistoryResponse.setTransactionDate(response.getTransactionDate());
                    transactionHistoryResponse.setNarration(response.getNarration());
                    transactionHistoryResponse.setTransactionType(checkTransactionType(response.getSenderAccountNumber(), request.accountNumber()));
                    transactionHistoryResponses.add(transactionHistoryResponse);
                }
        );
        return transactionHistoryResponses;
    }

    public TransactionType checkTransactionType(String senderAccountNumber, String userAccountNumber){
        if(senderAccountNumber.equals(userAccountNumber)){
            return TransactionType.DEBIT;
        }else {
            return TransactionType.DEBIT;
        }
    }

    private FundsTransferRequestData buildRequestFrom(TransactionRequest details) {
        FundsTransferRequestData txnRequestData = new FundsTransferRequestData();
        txnRequestData.setCurrBUId(-99L);
        txnRequestData.setFromAccountNumber(details.getSenderAccountNumber());
        txnRequestData.setFromCurrencyCode(details.getCurrencyCode());
        txnRequestData.setToAccountNumber(details.getReceiverAccountNumber());
        txnRequestData.setToCurrencyCode(details.getCurrencyCode());
        txnRequestData.setAmount(details.getAmount());
        txnRequestData.setTransactionAmount(details.getAmount());
        txnRequestData.setTxnDescription(details.getNarration());
        txnRequestData.setUserAccessCode("proxy_user_role");
        txnRequestData.setUserPassword("proxy_password");
        txnRequestData.setReference(details.getReferenceNo());
        txnRequestData.setRetrievalReferenceNumber(details.getReferenceNo());
        txnRequestData.setChannelId(Long.valueOf(channelId));
        txnRequestData.setChannelCode(channelCode);
        txnRequestData.setUserId(-99L);
        txnRequestData.setUserLoginId("SYSTEM");
        txnRequestData.setUserRoleId(-99L);
        txnRequestData.setXAPIServiceCode("FNT022");
        txnRequestData.setTransmissionTime(System.currentTimeMillis());
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