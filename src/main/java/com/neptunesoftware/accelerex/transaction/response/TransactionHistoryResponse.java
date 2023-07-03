package com.neptunesoftware.accelerex.transaction.response;

import com.neptunesoftware.accelerex.transaction.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TransactionHistoryResponse {
    private String transactionDate;
    private String tranRef;
    private String amount;
    private String narration;
    private TransactionType transactionType;
}
