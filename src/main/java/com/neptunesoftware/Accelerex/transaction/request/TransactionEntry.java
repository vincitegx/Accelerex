package com.neptunesoftware.Accelerex.transaction.request;

import com.neptunesoftware.Accelerex.transaction.response.TransactionType;

import java.math.BigDecimal;

public record TransactionEntry(
        String accountNumber,TransactionType transactionType, BigDecimal amount
) {
}
