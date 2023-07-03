package com.neptunesoftware.accelerex.account.response;

import lombok.Data;

@Data
public class InterBankTransferResponse {
    private String coreBankingRefNo;
    private String responseCode;
    private String responseMessage;
    private String NIBSS_SessionId;
}
