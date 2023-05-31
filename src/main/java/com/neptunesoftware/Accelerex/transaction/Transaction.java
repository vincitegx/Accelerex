package com.neptunesoftware.Accelerex.transaction;

import jakarta.persistence.Id;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.NonNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

    @Id
    @SequenceGenerator(
            name = "transaction_id_sequence",
            sequenceName = "transaction_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "transaction_id_sequence"
    )
    private Integer id;
    @NonNull
    private Integer clientId;
    @NonNull
    private String senderAccountNumber;
    @NonNull
    private String receiverAccountNumber;
    @NonNull
    private String senderName;
    @NonNull
    private String receiverName;
    @Column(unique = true, nullable = false)
    private String referenceNo;
    @NonNull
    private BigDecimal amount;
    @NonNull
    private String currencyCode;
    private BigDecimal charge;
    @NonNull
    private String narration;

    @Enumerated(EnumType.STRING)
    @NonNull
    private TransactionStatus status;

    @Enumerated(EnumType.STRING)
    @NonNull
    private TransactionType transactionType;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Transaction(Integer clientId, String senderAccountNumber, String receiverAccountNumber,
                       BigDecimal amount, String referenceNo, String currencyCode, BigDecimal charge,
                       String narration, String senderName, String receiverName, TransactionStatus status, TransactionType transactionType) {
        this.clientId = clientId;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.referenceNo = referenceNo;
        this.narration = narration;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.charge = charge;
        this.currencyCode = currencyCode;
        this.status = status;
        this.transactionType = transactionType;
        this.createdAt = LocalDateTime.parse(
                DATE_TIME_FORMATTER.format(LocalDateTime.now()),
                DATE_TIME_FORMATTER);
        this.updatedAt = createdAt;
    }

    public Transaction(){
        this.createdAt = LocalDateTime.parse(
                DATE_TIME_FORMATTER.format(LocalDateTime.now()),
                DATE_TIME_FORMATTER);
        this.updatedAt = createdAt;
    }
}
