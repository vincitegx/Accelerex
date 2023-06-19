package com.neptunesoftware.accelerex.transaction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class TransactionDetails {
    private String tranRef;
    private String customerNo;
    private String fromAccountNumber;
    private String toAccountNumber;
    private String amount;
    private String narration;
    private char isReversal;
    private String subTranRef;
    private String responseCode;
    private String recTs;
}
