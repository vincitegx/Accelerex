package com.neptunesoftware.accelerex.transaction.response;

import com.neptunesoftware.accelerex.transaction.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TransactionHistoryResponse {
    LocalDateTime transactionDateTime;
    BigDecimal amount;
    TransactionType transactionType;
    String senderName;
    String receiverName;
    String description;
}
