package com.neptunesoftware.Accelerex.transaction;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.neptunesoftware.Accelerex.account.Account;
import com.neptunesoftware.Accelerex.account.AccountService;
import com.neptunesoftware.Accelerex.exception.ResourceNotFoundException;
import com.neptunesoftware.Accelerex.exception.TransactionNotFoundException;
import com.neptunesoftware.Accelerex.exception.ValueMismatchException;
import com.neptunesoftware.Accelerex.transaction.request.BulkTransactionRequest;
import com.neptunesoftware.Accelerex.transaction.request.FundsTransferRequest;
import com.neptunesoftware.Accelerex.transaction.request.TransactionEntry;
import com.neptunesoftware.Accelerex.transaction.request.TransactionHistoryRequest;
import com.neptunesoftware.Accelerex.transaction.response.TransactionHistoryResponse;
import com.neptunesoftware.Accelerex.transaction.response.TransactionStatusResponse;
import com.neptunesoftware.Accelerex.transaction.response.TransactionType;
import com.neptunesoftware.Accelerex.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.scheduling.annotation.Async;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountService accountService;
    private final UserService userService;
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();
    private static final SecureRandom SECURE_RANDOM = new SecureRandom();

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountService accountService, UserService userService) {
        this.transactionRepository = transactionRepository;
        this.accountService = accountService;
        this.userService = userService;
    }

    @Transactional
    public void transferFunds(FundsTransferRequest request){
        if(!request.senderAccountNumber().equals(request.receiverAccountNumber())){
            Account senderAccount = accountService.accountExistsAndIsActivated(request.senderAccountNumber());
            if(ENCODER.matches(request.transactionPin(), senderAccount.getTransactionPin())) {
                Account receiverAccount = accountService.accountExistsAndIsActivated(request.receiverAccountNumber());
                accountService.debitAccount(senderAccount, request.amount());
                accountService.creditAccount(receiverAccount, request.amount());
                saveNewTransaction(request, senderAccount, receiverAccount);
                return;
            }
            throw new ValueMismatchException("incorrect transaction pin");
        }
        throw new IllegalArgumentException("sender account cannot be recipient account");
    }

    public TransactionStatusResponse getTransactionStatus(String externalRefNo, String clientId) {
        Transaction transaction = transactionRepository.findByClientIdAndReferenceNum(clientId, externalRefNo);
        TransactionStatusResponse status = new TransactionStatusResponse();
        return status;
    }

    @Transactional
    public void reverseTransaction(String externalRefNo) {
        Transaction transaction = transactionRepository.findByReferenceNum(externalRefNo);
        if (transaction != null) {
            Account receiverAccount = accountService.accountExistsAndIsActivated(transaction.getReceiverAccountNumber());
            Account senderAccount = accountService.accountExistsAndIsActivated(transaction.getSenderAccountNumber());
            accountService.creditAccount(senderAccount, transaction.getAmount());
            accountService.debitAccount(receiverAccount, transaction.getAmount());
            transaction.setStatus(TransactionStatus.REVERSED);
            transactionRepository.save(transaction);
        } else {
            throw new TransactionNotFoundException("Transaction not found");
        }
    }


    /**
     * This method save a new transaction after completion, it is an asynchronous process
     * because the method using it doesn't need it response
     */
    @Async
    public void saveNewTransaction(FundsTransferRequest request, Account senderAccount, Account receiverAccount){
        transactionRepository.save(
                new Transaction(request.senderAccountNumber(),
                        request.receiverAccountNumber(),
                        request.amount(),
                        generateTransactionReference(),
                        null,
                        TransactionType.CREDIT,
                        null,
                        request.narration(),
                        TransactionStatus.SUCCESS,
                        userService.getUserByUserId(senderAccount.getUserId()).getFullName(),
                        userService.getUserByUserId(receiverAccount.getUserId()).getFullName())
        );
    }


    @Transactional
    public void processBulkTransactions(BulkTransactionRequest request) {
        // Perform validation and processing of the bulk transaction entries
        List<TransactionEntry> entries = request.transactionEntries();

        // Validate the number of entries
        if (entries.size() > 6) {
            throw new IllegalArgumentException("Exceeded maximum number of entries per bulk transaction");
        }

        // Iterate through the entries and process each one
        for (TransactionEntry entry : entries) {
            // Validate the entry details
            validateTransactionEntry(entry);

            // Process the debit or credit based on the entry type
            if (entry.transactionType() == TransactionType.DEBIT) {
                // Debit the account
                Account debitAccount = accountService.getAccountByNumber(entry.accountNumber());
                accountService.debitAccount(debitAccount, entry.amount());
            } else if (entry.transactionType() == TransactionType.CREDIT) {
                // Credit the account
                Account creditAccount = accountService.getAccountByNumber(entry.accountNumber());
                accountService.creditAccount(creditAccount, entry.amount());
            }

            // Save the transaction entry to the database
            saveTransactionEntry(entry);
        }
    }

    private void validateTransactionEntry(TransactionEntry entry) {
        // Validate the account number
        if (!isValidAccountNumber(entry.accountNumber())) {
            throw new IllegalArgumentException("Invalid account number: " + entry.accountNumber());
        }

        // Validate the amount
        if (entry.amount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Invalid amount: " + entry.amount());
        }

        // Add more validation logic as per your requirements
    }

    private boolean isValidAccountNumber(String accountNumber) {
        // Implement account number validation logic
        // Example: Check if the account number exists in your database or external system
        // You can use a repository or service to perform the validation
        return accountService.accountExistsAndIsActivated(accountNumber) != null ? true : false;
    }

    private void saveTransactionEntry(TransactionEntry entry) {
        // Save the transaction entry to the repository
        // Implement the necessary logic to save the entry, e.g., using a transaction repository or database ORM
        Transaction transaction = new Transaction(null,
                null, null, null,
                null, null, null,
                null, null, null, null);
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

    /**
     * generates random reference number it keeps generating until it gets a unique value.
     */
    private String generateTransactionReference(){
        final String VALUES = "abcdefghijklmnopqrstuvwxyz0123456789";
        final int referenceNumberLength = 12;
        StringBuilder builder = new StringBuilder(referenceNumberLength);
        do {
            for (int i = 0; i < referenceNumberLength; i++) {
                builder.append(VALUES.charAt(SECURE_RANDOM.nextInt(VALUES.length())));
            }
        }while (transactionRepository.existsByReferenceNum(builder.toString()));
        return builder.toString();
    }

    /**
     * This method returns a list of transactions for a particular account by userId
     */
    public List<TransactionHistoryResponse> getTransactionHistoryByUserId(TransactionHistoryRequest request, int userId, Pageable pageable) {
        Account userAccount = accountService.getAccountByUserId(userId);
        Slice<Transaction> transactions = transactionRepository.findAllByStatusAndCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
                TransactionStatus.SUCCESS,
                request.startDateTime(),
                request.endDateTime(),
                userAccount.getAccountNumber(),
                userAccount.getAccountNumber(),
                pageable
        );
        if(transactions.getContent().isEmpty()){
            throw new ResourceNotFoundException("no transactions");
        }
        return formatTransactions(transactions.getContent(), userAccount.getAccountNumber());
    }

    private List<Transaction> getTransactionHistoryByUserId(TransactionHistoryRequest request, int userId) {
        Account userAccount = accountService.getAccountByUserId(userId);
        List<Transaction> transactions = transactionRepository.findAllByStatusAndCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
                TransactionStatus.SUCCESS,
                request.startDateTime(),
                request.endDateTime(),
                userAccount.getAccountNumber(),
                userAccount.getAccountNumber()
        );
        if(transactions.isEmpty()){
            throw new ResourceNotFoundException("no transactions found");
        }
        return transactions;
    }

    /**
     *
     * This method formats the transactions into the desired format which classifies each transaction into either credit and debit for easier understanding.
     */
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

    /**
     * This method generates an account statement for a particular account by userId, month, year and returns it as a pdf file
     */
    public ByteArrayOutputStream generateTransactionStatement(TransactionHistoryRequest request, int userId) throws DocumentException {
        Account account = accountService.getAccountByUserId(userId);
        List<Transaction> transactions = getTransactionHistoryByUserId(request,userId);
        return formatTransactionHistoryToDocument(request, transactions, account);
    }
    private ByteArrayOutputStream formatTransactionHistoryToDocument(TransactionHistoryRequest request, List<Transaction> transactions, Account userAccount) throws DocumentException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Document document = new Document();
        PdfWriter.getInstance(document, outputStream);
        document.open();
        document.add(new Paragraph("Account Statement for " + request.startDateTime()));
        document.add(new Paragraph("Account Number: " + userAccount.getAccountNumber()));
        document.add(new Paragraph("Account Holder: " + userService.getUserByUserId(userAccount.getUserId()).getFullName()));
        document.add(Chunk.NEWLINE);

        Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
//        PdfPTable table = new PdfPTable(new float[]{1, 1, 1, 1, 1, 1});
        PdfPTable table = new PdfPTable(new float[]{1, 1, 1, 1, 1});

        table.addCell(new PdfPCell(new Phrase("Reference Number", boldFont)));
//        table.addCell(new PdfPCell(new Phrase("Transaction Date", boldFont)));
        table.addCell(new PdfPCell(new Phrase("Amount", boldFont)));
        table.addCell(new PdfPCell(new Phrase("Sender", boldFont)));
        table.addCell(new PdfPCell(new Phrase("Recipient", boldFont)));
        table.addCell(new PdfPCell(new Phrase("Description", boldFont)));

        transactions.forEach(transaction -> {
            table.addCell(new PdfPCell(new Phrase(transaction.getReferenceNum())));
//            table.addCell(new PdfPCell(new Phrase(transaction.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME))));
            table.addCell(new PdfPCell(new Phrase(String.format("%.2f", transaction.getAmount()))));
            table.addCell(new PdfPCell(new Phrase(transaction.getSenderName())));
            table.addCell(new PdfPCell(new Phrase(transaction.getReceiverName())));
            table.addCell(new PdfPCell(new Phrase(transaction.getDescription())));
        });
        document.add(table);
        document.close();
        return outputStream;
    }
}