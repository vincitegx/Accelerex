package com.neptunesoftware.accelerex.transaction.request;

import com.neptunesoftware.accelerex.transaction.TransactionType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
@Builder
public class TransactionRequest {
        @NonNull
        private Integer clientId;
        @NonNull
        @NotBlank(message = "accountNumber field can't be blank")
        @Size(min = 10, max = 10, message = "Account Number should be 10 digits")
        private String senderAccountNumber;
        @NonNull
        private String senderName;
        @NonNull
        @NotBlank(message = "accountNumber field can't be blank")
        @Size(min = 10, max = 10, message = "Account Number should be 10 digits")
        private String receiverAccountNumber;
        @NonNull
        private String receiverName;
        @NonNull
        private String referenceNo;
        @NonNull
        @Positive
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
