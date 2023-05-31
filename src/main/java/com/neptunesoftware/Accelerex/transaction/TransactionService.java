package com.neptunesoftware.Accelerex.transaction;

import com.neptunesoftware.Accelerex.account.Account;
import com.neptunesoftware.Accelerex.account.AccountService;
import com.neptunesoftware.Accelerex.exception.ResourceNotFoundException;
import com.neptunesoftware.Accelerex.exception.TransactionNotFoundException;
import com.neptunesoftware.Accelerex.transaction.mapper.TransactionMapper;
import com.neptunesoftware.Accelerex.transaction.request.*;
import com.neptunesoftware.Accelerex.transaction.response.TransactionHistoryResponse;
import com.neptunesoftware.Accelerex.transaction.response.TransactionStatusResponse;
import com.neptunesoftware.Accelerex.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountService accountService;
    private final UserService userService;
    private final TransactionMapper transactionMapper;
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountService accountService,
                              UserService userService, TransactionMapper transactionMapper) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.userService = userService;
        this.transactionMapper = transactionMapper;
    }
    @Transactional
    public TransactionStatusResponse transferFunds(TransactionRequest request){
        if(!request.senderAccountNumber().equals(request.receiverAccountNumber())){
            Account senderAccount = accountService.accountExistsAndIsActivated(request.senderAccountNumber());
            Account receiverAccount = accountService.accountExistsAndIsActivated(request.receiverAccountNumber());
            accountService.debitAccount(senderAccount, request.amount());
            accountService.creditAccount(receiverAccount, request.amount());
            Transaction transaction = saveNewTransaction(request, senderAccount, receiverAccount);
            return transactionMapper.apply(transaction);
        }
        throw new IllegalArgumentException("sender account cannot be recipient account");
    }

    public TransactionStatusResponse getTransactionStatus(String externalRefNo, String clientId) {
        Transaction transaction = transactionRepository.findByClientIdAndReferenceNo(clientId, externalRefNo);
        return transactionMapper.apply(transaction);
    }

    @Transactional
    public void reverseTransaction(String externalRefNo) {
        Transaction transaction = transactionRepository.findByReferenceNo(externalRefNo);
        if (transaction != null) {
            Account receiverAccount = accountService.accountExistsAndIsActivated(transaction.getReceiverAccountNumber());
            Account senderAccount = accountService.accountExistsAndIsActivated(transaction.getSenderAccountNumber());
            accountService.creditAccount(senderAccount, transaction.getAmount());
            accountService.debitAccount(receiverAccount, transaction.getAmount());
            transaction.setStatus(TransactionStatus.SUCCESS);
            transactionRepository.saveAndFlush(transaction);
        } else {
            throw new TransactionNotFoundException("Transaction not found");
        }
    }

    public Transaction saveNewTransaction(TransactionRequest request, Account senderAccount, Account receiverAccount){
        String referenceNo = request.referenceNo();
        if(request.referenceNo().length() > 30) referenceNo = generateTransactionReference();
        return transactionRepository.saveAndFlush(
                new Transaction(
                        request.clientId(),
                        request.senderAccountNumber(),
                        request.receiverAccountNumber(),
                        request.amount(),
                        referenceNo,
                        request.currencyCode(),
                        request.charge(),
                        request.narration(),
                        userService.getUserByUserId(senderAccount.getUserId()).getFullName(),
                        userService.getUserByUserId(receiverAccount.getUserId()).getFullName(),
                        TransactionStatus.SUCCESS,
                        request.transactionType()
                )
        );
    }

    @Transactional
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

//        Transaction transaction = new Transaction();
//        transaction.setAccountNumber(entry.getAccountNumber());

        transaction.setTransactionType(entry.transactionType());
        transaction.setAmount(entry.amount());

        // Save the transaction entry to the repository
        transactionRepository.save(transaction);
    }

    private String generateTransactionReference(){
        final String VALUES = "abcdefghijklmnopqrstuvwxyz0123456789";
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
        return formatTransactions(transactions.getContent(), request.accountNumber());
    }

    private List<TransactionHistoryResponse> formatTransactions(List <Transaction> transactions, String userAccountNumber){
        List<TransactionHistoryResponse> transactionHistoryResponses = new ArrayList<>();
        transactions.forEach(
                transaction -> {
                    TransactionHistoryResponse transactionHistoryResponse = new TransactionHistoryResponse();
                    transactionHistoryResponse.setAmount(transaction.getAmount());
                    transactionHistoryResponse.setReceiverName(transaction.getReceiverName());
                    transactionHistoryResponse.setSenderName(transaction.getSenderName());
                    transactionHistoryResponse.setTransactionType(checkTransactionType(transaction, userAccountNumber));
                    transactionHistoryResponses.add(transactionHistoryResponse);
                }
        );
        return transactionHistoryResponses;
    }

    public TransactionType checkTransactionType(Transaction transaction, String userAccountNumber){
        if(transaction.getReceiverAccountNumber().equals(userAccountNumber)){
            return TransactionType.CREDIT;
        }else if(transaction.getSenderAccountNumber().equals(userAccountNumber)){
            return TransactionType.DEBIT;
        }
        throw new IllegalArgumentException("error processing cannot determine transaction type");
    }
}