package com.neptunesoftware.accelerex.account.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepositToGlResponseData {
    private String transactionAmount;
    private String accountNumber;
    private String transactionReference;
    private String retrievalReference;
    private String transactionCurrencyCode;
    private String txnJournalId;
}
