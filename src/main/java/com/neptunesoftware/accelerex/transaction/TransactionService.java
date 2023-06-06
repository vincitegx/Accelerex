package com.neptunesoftware.accelerex.transaction;

import com.neptunesoftware.accelerex.account.Account;
import com.neptunesoftware.accelerex.account.AccountService;
import com.neptunesoftware.accelerex.exception.ResourceNotFoundException;
import com.neptunesoftware.accelerex.exception.TransactionNotFoundException;
import com.neptunesoftware.accelerex.transaction.mapper.TransactionMapper;
import com.neptunesoftware.accelerex.transaction.request.*;
import com.neptunesoftware.accelerex.transaction.response.TransactionHistoryResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import com.neptunesoftware.accelerex.user.User;
import com.neptunesoftware.accelerex.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
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

    public TransactionResponse transferFunds(TransactionRequest request){
        if(isValidationChecksPassed(request)){
            Account senderAccount  = accountService.getAccountByUserId(request.clientId());
            Account receiverAccount = accountService.accountExistsAndIsActivated(request.receiverAccountNumber());
            accountService.debitAccount(senderAccount, request.amount());
            accountService.creditAccount(receiverAccount, request.amount());
            Transaction transaction = saveNewTransaction(request, senderAccount, receiverAccount, TransactionStatus.SUCCESS);
            return transactionMapper.apply(transaction);
        }
        throw new IllegalArgumentException("Request Validation Checks Not Passed");
    }

    private Boolean isValidationChecksPassed(TransactionRequest request){
        BigDecimal amount = request.amount();
        String senderAccountNumber = request.senderAccountNumber();
        String receiverAccountNumber = request.receiverAccountNumber();
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
}