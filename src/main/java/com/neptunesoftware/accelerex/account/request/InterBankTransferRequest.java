package com.neptunesoftware.accelerex.account.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class InterBankTransferRequest {
    private String externalRefNo;
    private String sessionId;
    private String clientId;
    private String beneficiaryBankCode;
    private String beneficiaryAccountNo;
    private String beneficiaryName;
    private BigDecimal amount;
    private String currencyCode;
    private String sourceAccount;
    private String sourceAccountName;
    private String transferDetail;
}
