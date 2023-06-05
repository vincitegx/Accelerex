package com.neptunesoftware.accelerex.transaction.request;

import com.neptunesoftware.accelerex.transaction.TransactionType;

import java.math.BigDecimal;

public record TransactionEntry(
        String accountNumber,TransactionType transactionType, BigDecimal amount
) {
}
