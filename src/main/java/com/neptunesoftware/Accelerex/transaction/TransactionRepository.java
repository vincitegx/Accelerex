package com.neptunesoftware.Accelerex.transaction;
import com.neptunesoftware.Accelerex.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    boolean existsByReferenceNo(String referenceNo);
    Optional<Transaction> findByReferenceNo(String referenceNo);
    Transaction findByUserAndReferenceNo(User user, String referenceNo);
    Page<Transaction> findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
            LocalDateTime startDate,LocalDateTime endDate, String senderAccountNumber, String receiverAccountNumber, Pageable pageable
    );
}

