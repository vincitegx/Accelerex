package com.neptunesoftware.Accelerex.transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    boolean existsByReferenceNum(String referenceNumber);
    Transaction findByReferenceNum(String referenceNumber);
    Transaction findByClientIdAndReferenceNum(String clientId, String referenceNumber);
    Page<Transaction> findAllByStatusAndCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
            TransactionStatus status,LocalDateTime startDate,LocalDateTime endDate, String senderAccountNumber, String receiverAccountNumber, Pageable pageable
    );

    List<Transaction> findAllByStatusAndCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
            TransactionStatus status,LocalDateTime startDate,LocalDateTime endDate, String senderAccountNumber, String receiverAccountNumber);

}

