package com.neptunesoftware.Accelerex.transaction;

import com.neptunesoftware.Accelerex.transaction.response.TransactionType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;

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

    private String clientId;
    @NonNull
    private String senderAccountNumber;
    @NonNull
    private String receiverAccountNumber;
    @NonNull
    private String senderName;
    @NonNull
    private String receiverName;
    @NonNull
    private BigDecimal amount;
    @Column(unique = true, nullable = false)
    private String referenceNum;
    @NonNull
    private String description;
    @Enumerated(EnumType.STRING)
    @NonNull
    private TransactionStatus status;
    private BigDecimal transactionFee;
    @NonNull
    private String currencyCode;
    @Enumerated(EnumType.STRING)
    @NonNull
    private TransactionType transactionType;

    public Transaction(String senderAccountNumber, String receiverAccountNumber,
                       BigDecimal amount, String referenceNum, String currencyCode,
                       TransactionType transactionType, BigDecimal transactionFee,
                       String description, TransactionStatus status, String senderName, String receiverName) {
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.amount = amount;
        this.referenceNum = referenceNum;
        this.status = status;
        this.description = description;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.transactionType = transactionType;
        this.transactionFee = transactionFee;
        this.currencyCode = currencyCode;
    }
}
