package com.neptunesoftware.accelerex.account.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DepositToGlRequest {
    private String sourceAccountNumber;
    private String sourceAccountName;

    private String beneficiaryAccountNumber;
    private String beneficiaryName;
    private String beneficiaryBankID;
    private BigDecimal amount;

    private String transactionFee;
    private String chargeAmount;
    private String taxAmount;

    private String narration;
    @JsonIgnore
    private String transactionReferenceNo;
    private String totalTransactionAmount;
    private String bankName;

}