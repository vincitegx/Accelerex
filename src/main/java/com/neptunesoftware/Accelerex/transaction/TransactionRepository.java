package com.neptunesoftware.Accelerex.transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    boolean existsByReferenceNo(String referenceNo);
    Transaction findByReferenceNo(String referenceNo);
    Transaction findByClientIdAndReferenceNo(String clientId, String referenceNo);
    Page<Transaction> findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
            LocalDateTime startDate,LocalDateTime endDate, String senderAccountNumber, String receiverAccountNumber, Pageable pageable
    );

    List<Transaction> findAllByStatusAndCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
            TransactionStatus status,LocalDateTime startDate,LocalDateTime endDate, String senderAccountNumber, String receiverAccountNumber);

}

