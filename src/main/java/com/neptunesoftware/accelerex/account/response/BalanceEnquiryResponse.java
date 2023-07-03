package com.neptunesoftware.accelerex.account.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BalanceEnquiryResponse {
     private String accountNo;
     private String accountName;
     private BigDecimal availableBalance;
//     private String currencyCode;
//     private String accountStatus;
}
