package com.neptunesoftware.accelerex.account.response;

import com.neptunesoftware.accelerex.account.AccountStatus;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class FetchAccountBalanceResponse {
     private String accountNo;
     private String accountName;
     private BigDecimal availableBalance;
     private String currencyCode;
     private AccountStatus accountStatus;
}
