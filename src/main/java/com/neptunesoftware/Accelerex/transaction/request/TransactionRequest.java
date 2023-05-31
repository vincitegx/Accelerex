package com.neptunesoftware.Accelerex.transaction.request;

import com.neptunesoftware.Accelerex.transaction.TransactionType;
import lombok.NonNull;

import java.math.BigDecimal;

public record TransactionRequest(
        @NonNull
        Integer clientId,
        @NonNull
        String senderAccountNumber,
        @NonNull
        String senderName,
        @NonNull
        String receiverAccountNumber,
        @NonNull
        String receiverName,
        @NonNull
        String referenceNo,
        @NonNull
        BigDecimal amount,
        @NonNull
        String currencyCode,
        BigDecimal charge,
        @NonNull
        TransactionType transactionType,
//        @NonNull
//        String transactionPin,
        @NonNull
        String narration
) {
}
