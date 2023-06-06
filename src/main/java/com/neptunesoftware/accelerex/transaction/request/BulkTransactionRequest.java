package com.neptunesoftware.accelerex.transaction.request;

import java.util.List;

public record BulkTransactionRequest(
        List<TransactionEntry> transactionEntries
) {
}
