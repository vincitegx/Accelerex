package com.neptunesoftware.Accelerex.account.response;

import com.neptunesoftware.Accelerex.account.AccountStatus;
import lombok.Data;

@Data
public class FetchAccountBalanceResponse {
     private String accountNo;
     private String accountName;
     private String availableBalance;
     private String currencyCode;
     private AccountStatus accountStatus;
}
