package com.neptunesoftware.accelerex.transaction;

import com.neptunesoftware.accelerex.account.Account;
import com.neptunesoftware.accelerex.account.AccountService;
import com.neptunesoftware.accelerex.account.AccountServices;
import com.neptunesoftware.accelerex.exception.FundTransferException;
import com.neptunesoftware.accelerex.exception.ResourceNotFoundException;
import com.neptunesoftware.accelerex.exception.TransactionNotFoundException;
import com.neptunesoftware.accelerex.transaction.mapper.TransactionMapper;
import com.neptunesoftware.accelerex.transaction.request.*;
import com.neptunesoftware.accelerex.transaction.response.CustomerToCustomerTransferResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionHistoryResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import com.neptunesoftware.accelerex.user.User;
import com.neptunesoftware.accelerex.user.UserService;

import jakarta.xml.bind.JAXBElement;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.beans.factory.annotation.Autowired;


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

    @Value("${endpoint.fundTransferWebservice}")
    private String FUND_TRANSFER_WEB_SERVICE_END_POINT_PORT;

    @Value("${rubikon.channelId}")
    private String channelId;

    @Value("${rubikon.channelCode}")
    private String channelCode;
    public static final String PACKAGE_TO_SCAN = "com.neptunesoftware.accelerex.data.fundtransfer";

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountServices accountService,
                              UserService userService, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.userService = userService;
        this.transactionMapper = transactionMapper;
    }

    public TransactionResponse transferFunds(TransactionRequest request){
        if(isValidationChecksPassed(request)){
            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());
            FundsTransferRequestData txnRequestData = buildRequestFrom(request);
            CustomerToCustomerTransfer customerToCustomerTransfer = new CustomerToCustomerTransfer();
            customerToCustomerTransfer.setArg0(txnRequestData);
            log.info("Initiating internal funds transfer of Amount: {} and reference: {} from source: {} to destination: {}", request.getAmount(), request.getReferenceNo(),
                    request.getSenderAccountNumber()
                    , request.getReceiverAccountNumber());
            JAXBElement response;
            try {
                response = (JAXBElement) webServiceTemplate.marshalSendAndReceive(
                        FUND_TRANSFER_WEB_SERVICE_END_POINT_PORT, customerToCustomerTransfer
                );
            } catch (Exception e) {
                log.error(e.getCause().getMessage());
                throw new FundTransferException("An error occurred!");
            }
            CustomerToCustomerTransferResponse responseValue = (CustomerToCustomerTransferResponse) response.getValue();
            if (!responseValue.getReturn().getResponseCode().equalsIgnoreCase("00")) {
                log.info("Transaction failed");
                throw new FundTransferException("Transaction failed");
            }
            request.setSenderAccountNumber(accountService.nameInquiry(request.getSenderAccountNumber()).getAccountName());
            request.setReceiverAccountNumber(accountService.nameInquiry(request.getReceiverAccountNumber()).getAccountName());
//            request.setBankName(bankName);
            accountService.saveTransaction(request, "InternalFundTransfer");
            log.info("internal funds transfer of Amount: {} and reference: {} from source: {} to destination: {} was successful", request.getAmount(), request.getReferenceNo(),
                    request.getSenderAccountNumber()
                    , request.getReceiverAccountNumber());
            return transactionMapper.apply(responseValue);
        }
        throw new IllegalArgumentException("Request Validation Checks Not Passed");
    }

    private Boolean isValidationChecksPassed(TransactionRequest request){
        BigDecimal amount = request.getAmount();
        String senderAccountNumber = request.getSenderAccountNumber();
        String receiverAccountNumber = request.getReceiverAccountNumber();
        Account senderAccount = accountService.accountExistsAndIsActivated(senderAccountNumber);
        return amount.compareTo(BigDecimal.ZERO) >= 1
                && !senderAccountNumber.equals(receiverAccountNumber)
                && isValidAccountNumber(senderAccountNumber)
                && isValidAccountNumber(receiverAccountNumber)
                && senderAccount.getAccountBalance().compareTo(amount) >= 0;
    }

    public TransactionResponse getTransactionStatus(String externalRefNo, String clientId) {
        User user = userService.getUserById(Integer.parseInt(clientId));
        Transaction transaction = transactionRepository.findByUserAndReferenceNo(user, externalRefNo);
        return transactionMapper.apply(transaction);
    }

    public void reverseTransaction(String externalRefNo) {
        Transaction transaction = transactionRepository.findByReferenceNo(externalRefNo).orElseThrow(()-> new TransactionNotFoundException("Transaction not found"));
        Account receiverAccount = accountService.accountExistsAndIsActivated(transaction.getReceiverAccountNumber());
        Account senderAccount = accountService.accountExistsAndIsActivated(transaction.getSenderAccountNumber());
        accountService.debitAccount(receiverAccount, transaction.getAmount());
        accountService.creditAccount(senderAccount, transaction.getAmount());
        transaction.setStatus(TransactionStatus.SUCCESS);
        transaction.setReversal('Y');
        transactionRepository.saveAndFlush(transaction);
    }

    public Transaction saveNewTransaction(TransactionRequest request, Account senderAccount, Account receiverAccount, TransactionStatus status){
        String referenceNo = request.referenceNo();
        if(request.referenceNo().length() > 30 || request.referenceNo().equals("")) referenceNo = generateTransactionReference();
        return transactionRepository.saveAndFlush(
                new Transaction(
                        senderAccount.getUser(),
                        senderAccount.getAccountNumber(),
                        receiverAccount.getAccountNumber(),
                        request.amount(),
                        referenceNo,
                        request.currencyCode(),
                        request.charge(),
                        request.narration(),
                        senderAccount.getUser().getFullName(),
                        receiverAccount.getUser().getFullName(),
                        status,
                        request.transactionType()
                )
        );
    }

    public void processBulkTransactions(BulkTransactionRequest request) {
        List<TransactionEntry> entries = request.transactionEntries();
        if (entries.size() > 6) {
            throw new IllegalArgumentException("Exceeded maximum number of entries per bulk transaction");
        }
        for (TransactionEntry entry : entries) {
            validateTransactionEntry(entry);
            if (entry.transactionType() == TransactionType.DEBIT) {
                Account debitAccount = accountService.getAccountByNumber(entry.accountNumber());
                accountService.debitAccount(debitAccount, entry.amount());
            } else if (entry.transactionType() == TransactionType.CREDIT) {
                Account creditAccount = accountService.getAccountByNumber(entry.accountNumber());
                accountService.creditAccount(creditAccount, entry.amount());
            }
            saveTransactionEntry(entry);
        }
    }

    private void validateTransactionEntry(TransactionEntry entry) {
        if (!isValidAccountNumber(entry.accountNumber())) {
            throw new IllegalArgumentException("Invalid account number: " + entry.accountNumber());
        }
        if (entry.amount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid amount: " + entry.amount());
        }
    }

    private boolean isValidAccountNumber(String accountNumber) {
        return accountService.accountExistsAndIsActivated(accountNumber) != null;
    }

    private void saveTransactionEntry(TransactionEntry entry) {
        Transaction transaction = new Transaction();
        if(entry.transactionType() == TransactionType.CREDIT){
            transaction.setReceiverAccountNumber(entry.accountNumber());
        }else{
            transaction.setSenderAccountNumber(entry.accountNumber());
        }
        transaction.setTransactionType(entry.transactionType());
        transaction.setAmount(entry.amount());
        transactionRepository.save(transaction);
    }

    private String generateTransactionReference(){
        final String VALUES = "abcdefghijklmnopqrstuvwxyz0123456789";//TSONAR
        final int referenceNumberLength = 30;
        StringBuilder builder = new StringBuilder(referenceNumberLength);
        do {
            for (int i = 0; i < referenceNumberLength; i++) {
                builder.append(VALUES.charAt(SECURE_RANDOM.nextInt(VALUES.length())));
            }
        }while (transactionRepository.existsByReferenceNo(builder.toString()));
        return builder.toString();
    }

    public List<TransactionHistoryResponse> getTransactionHistory(TransactionHistoryRequest request, Pageable pageable) {
        Slice<Transaction> transactions = transactionRepository.findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
                request.startDateTime(),
                request.endDateTime(),
                request.accountNumber(),
                request.accountNumber(),
                pageable
        );
        if(transactions.getContent().isEmpty()){
            throw new ResourceNotFoundException("no transactions");
        }
        return formatTransactions(transactions.getContent());
    }

    private List<TransactionHistoryResponse> formatTransactions(List <Transaction> transactions){
        List<TransactionHistoryResponse> transactionHistoryResponses = new ArrayList<>();
        transactions.forEach(
                transaction -> {
                    TransactionHistoryResponse transactionHistoryResponse = new TransactionHistoryResponse();
                    transactionHistoryResponse.setAmount(transaction.getAmount());
                    transactionHistoryResponse.setReceiverName(transaction.getReceiverName());
                    transactionHistoryResponse.setSenderName(transaction.getSenderName());
                    transactionHistoryResponse.setTransactionType(transaction.getTransactionType());
                    transactionHistoryResponses.add(transactionHistoryResponse);
                }
        );
        return transactionHistoryResponses;
    }

    private FundsTransferRequestData buildRequestFrom(TransactionRequest details) {
        FundsTransferRequestData txnRequestData = new FundsTransferRequestData();

        txnRequestData.setCurrBUId(-99L);
        txnRequestData.setFromAccountNumber(details.senderAccountNumber());
        txnRequestData.setFromCurrencyCode(details.currencyCode());

        txnRequestData.setToAccountNumber(details.receiverAccountNumber());
        txnRequestData.setToCurrencyCode(details.currencyCode());
        txnRequestData.setAmount(details.amount());
        txnRequestData.setTransactionAmount(details.amount());
        txnRequestData.setTxnDescription(details.narration());

        txnRequestData.setUserAccessCode("proxy_user_role");
        txnRequestData.setUserPassword("proxy_password");
        txnRequestData.setReference(details.referenceNo());
        txnRequestData.setRetrievalReferenceNumber(details.referenceNo());
        txnRequestData.setChannelId(Long.valueOf(channelId));
        txnRequestData.setChannelCode(channelCode);

        txnRequestData.setUserId(-99L);
        txnRequestData.setUserLoginId("SYSTEM");
        txnRequestData.setUserRoleId(-99L);
        txnRequestData.setXAPIServiceCode("FNT022");
        txnRequestData.setTransmissionTime(System.currentTimeMillis());
        return txnRequestData;
    }

//    @Override
//    public void saveTransaction(TransactionRequest details, String transactionMethod, String transType) {
//        accountRepository.updateTransactionHistory(SaveTransactionDetails.builder()
//                .transAppl(deCypher(rubikonCredentials.getChannelCode()))
//                .fromAcctNum(details.getSourceAccountNumber())
//                .fromAcctName(details.getSourceAccountName())
//                .transRef(details.getReferenceNo())
//                .narration(details.getNarration())
//                .transAmount(details.getAmount())
//                .transReceiver(details.getBeneficiaryAccountNumber())
//                .transReceiverName(details.getBeneficiaryName())
//                .isReversal(false)
//                .transMethod(transactionMethod)
//                .transType(transType)
//                .build());
//    }

    private Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setPackagesToScan(PACKAGE_TO_SCAN);
        return marshaller;
    }
}