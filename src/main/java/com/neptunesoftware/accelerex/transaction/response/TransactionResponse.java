package com.neptunesoftware.accelerex.transaction.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class TransactionResponse {
    private TransactionResponseStatus response;
    private String coreBankingRefNo;
}
