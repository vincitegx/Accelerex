package com.neptunesoftware.Accelerex.transaction.request;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

public record BulkTransactionRequest(
        List<TransactionEntry> transactionEntries
) {
}
