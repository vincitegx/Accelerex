package com.neptunesoftware.accelerex.transaction.request;

import com.neptunesoftware.accelerex.transaction.TransactionType;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionRequest{
        @NonNull
        private Integer clientId;
        @NonNull
        private String senderAccountNumber;
        @NonNull
        private String senderName;
        @NonNull
        private String receiverAccountNumber;
        @NonNull
        private String receiverName;
        @NonNull
        private String referenceNo;
        @NonNull
        private BigDecimal amount;
        @NonNull
        private String currencyCode;
        private BigDecimal charge;
        @NonNull
        private TransactionType transactionType;
        @NonNull
        private String narration;

        private char isReversal;
}
