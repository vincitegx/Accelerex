package com.neptunesoftware.Accelerex.transaction;

import com.neptunesoftware.Accelerex.user.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Java6Assertions.assertThat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.math.BigDecimal;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @AfterEach
    void tearDown() {
        transactionRepository.deleteAll();
    }

    @Test
    void existsByReferenceNo() {
        Transaction newTransaction = new Transaction(
                new User(1,"David", "Ogbodu","david", false),
                "6765456434",
                "6765456434",
                new BigDecimal(50),
                "dvhbjh37878",
                "NGN",
                new BigDecimal(50),
                "test transaction",
                "David",
                "Tega",
                TransactionStatus.SUCCESS,
                TransactionType.CREDIT
        );
        transactionRepository.save(newTransaction);
        //when
        boolean status = transactionRepository.existsByReferenceNo(newTransaction.getReferenceNo());
        //then
        assertThat(status).isTrue();
    }

    @Test
    void findByReferenceNo() {
    }

    @Test
    void findByClientIdAndReferenceNo() {
    }

    @Test
    void findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber() {
    }
}