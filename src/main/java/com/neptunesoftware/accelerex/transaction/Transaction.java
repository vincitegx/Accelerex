package com.neptunesoftware.accelerex.transaction;

import com.neptunesoftware.accelerex.user.User;
import jakarta.persistence.*;
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
    @ManyToOne
    private User user;
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

    private char reversal = 'N';

    private LocalDateTime createdAt;

    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public Transaction(User user, String senderAccountNumber, String receiverAccountNumber,
                       BigDecimal amount, String referenceNo, String currencyCode, BigDecimal charge,
                       String narration, String senderName, String receiverName, TransactionStatus status, TransactionType transactionType) {
        this.user = user;
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
    }

    public Transaction(){
        this.createdAt = LocalDateTime.parse(
                DATE_TIME_FORMATTER.format(LocalDateTime.now()),
                DATE_TIME_FORMATTER);
    }
}
