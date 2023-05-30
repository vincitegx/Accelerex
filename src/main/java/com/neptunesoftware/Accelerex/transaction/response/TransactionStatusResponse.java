package com.neptunesoftware.Accelerex.transaction.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TransactionStatusResponse {
    private String responseCode;
    private String responseMessage;
    private String coreBankingRefNo;
    private Integer transactionId;
}
