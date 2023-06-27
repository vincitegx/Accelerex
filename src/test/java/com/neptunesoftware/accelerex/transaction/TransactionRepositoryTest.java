package com.neptunesoftware.accelerex.transaction;

import com.github.javafaker.Faker;
import com.neptunesoftware.accelerex.user.User;
import com.neptunesoftware.accelerex.user.UserRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ContextConfiguration;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Disabled
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class TransactionRepositoryTest {
//    @Autowired
//    private TransactionRepository transactionRepository; //TSONAR
//    @Autowired
//    private UserRepository userRepository; //TSONAR
//    protected static final Faker FAKER = new Faker();
//    private static final String REFERENCE_NO = FAKER.random().toString();
//    private static final String SENDER_ACCOUNT_NO = FAKER.finance().iban("NGN");
//    private static final String RECEIVER_ACCOUNT_NO = FAKER.finance().iban("NGN");
//
//    @BeforeEach
//    void setUp(){
//        User user = new User(FAKER.name().fullName(),
//                FAKER.internet().safeEmailAddress(),
//                FAKER.internet().password(),
//                FAKER.bool().bool(),
//                FAKER.phoneNumber().phoneNumber());
//        userRepository.save(user);
//        BigDecimal amount = BigDecimal.valueOf(FAKER.number().randomNumber(3, true));
//        String currencyCode = FAKER.currency().code();
//        BigDecimal fee = BigDecimal.valueOf(FAKER.number().randomNumber(3, true));
//        String description = FAKER.lorem().characters(10);
//        String senderName = FAKER.name().fullName();
//        String receiverName = user.getFullName();
//        Transaction transaction = new Transaction(user, SENDER_ACCOUNT_NO, RECEIVER_ACCOUNT_NO, amount,
//                REFERENCE_NO, currencyCode, fee, description, senderName, receiverName, TransactionStatus.SUCCESS, TransactionType.CREDIT);
//        transactionRepository.save(transaction);
//    }
//    @AfterEach
//    void tearDown() {
//        userRepository.deleteAll();
//        transactionRepository.deleteAll();
//    }
//    private Transaction createTransaction(User user, TransactionStatus status, TransactionType type) {
//        String referenceNo = FAKER.random().toString();
//        BigDecimal amount = BigDecimal.valueOf(FAKER.number().randomNumber(3, true));
//        String currencyCode = FAKER.currency().code();
//        BigDecimal fee = BigDecimal.valueOf(FAKER.number().randomNumber(3, true));
//        String description = FAKER.lorem().characters(10);
//        String senderName = FAKER.name().fullName();
//        String receiverName = user.getFullName();
//        return new Transaction(user, SENDER_ACCOUNT_NO, RECEIVER_ACCOUNT_NO, amount,
//                referenceNo, currencyCode, fee, description, senderName, receiverName, status, type);
//    }
//    @Test
//    void existsByReferenceNo_shouldReturnTrueIfTransactionExistsWithReferenceNo() {
//        boolean exists = transactionRepository.existsByReferenceNo(REFERENCE_NO);
//        Assertions.assertTrue(exists);
//    }
//    @Test
//    void findByReferenceNo_shouldReturnTransactionWithMatchingReferenceNo() {
//        Optional<Transaction> foundTransaction = transactionRepository.findByReferenceNo(REFERENCE_NO);
//        Assertions.assertTrue(foundTransaction.isPresent());
//        Assertions.assertEquals(REFERENCE_NO, foundTransaction.get().getReferenceNo());
//    }
//    @Test
//    void findByUserAndReferenceNo_shouldReturnTransactionWithMatchingUserAndReferenceNo() {
//        User user = userRepository.findById(1).get();
//        Transaction foundTransaction = transactionRepository.findByUserAndReferenceNo(user, REFERENCE_NO);
//        Assertions.assertNotNull(foundTransaction);
//        Assertions.assertEquals(REFERENCE_NO, foundTransaction.getReferenceNo());
//    }
//    @Test
//    void testFindAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber() {
//        User user = new User(FAKER.name().fullName(),
//                FAKER.internet().safeEmailAddress(),
//                FAKER.internet().password(),
//                FAKER.bool().bool(),
//                FAKER.phoneNumber().phoneNumber());
//        userRepository.save(user);
//        Transaction creditTransactionSuccessful = createTransaction(user, TransactionStatus.SUCCESS, TransactionType.CREDIT);
//        Transaction debitTransactionSuccessful = createTransaction(user, TransactionStatus.SUCCESS, TransactionType.DEBIT);
//        Transaction creditTransactionFailed = createTransaction(user, TransactionStatus.FAIL, TransactionType.CREDIT);
//        Transaction debitTransactionFailed = createTransaction(user, TransactionStatus.FAIL, TransactionType.DEBIT);
//        transactionRepository.saveAll(Arrays.asList(creditTransactionSuccessful, debitTransactionSuccessful,
//                creditTransactionFailed, debitTransactionFailed));
//
//        LocalDateTime startDate = LocalDateTime.of(2022, 1, 1, 0, 0);
////        LocalDateTime endDate = LocalDateTime.of(2022, 12, 31, 23, 59);
//        LocalDateTime endDate = LocalDateTime.now();
//        Pageable pageable = PageRequest.of(0, 10);
//        Page<Transaction> foundTransactions = transactionRepository
//                .findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
//                        startDate, endDate, RECEIVER_ACCOUNT_NO, RECEIVER_ACCOUNT_NO, pageable);
//        Assertions.assertEquals(4, foundTransactions.getTotalElements());
//        List<String> senderAccountNumbers = foundTransactions.stream()
//                .map(Transaction::getSenderAccountNumber)
//                .toList();
//        List<String> receiverAccountNumbers = foundTransactions.stream()
//                .map(Transaction::getReceiverAccountNumber)
//                .toList();
//        Assertions.assertTrue(senderAccountNumbers.contains(SENDER_ACCOUNT_NO));
//        Assertions.assertTrue(senderAccountNumbers.contains(RECEIVER_ACCOUNT_NO));
//        Assertions.assertTrue(receiverAccountNumbers.contains(SENDER_ACCOUNT_NO));
//        Assertions.assertTrue(receiverAccountNumbers.contains(RECEIVER_ACCOUNT_NO));
//    }
}