package com.neptunesoftware.accelerex.account.response;

import lombok.Data;

@Data
public class BalanceResponse {
     private String accountNo;
     private String accountName;
     private String availableBalance;
     private String currencyCode;
     private String responseCode;
     private String responseMessage;

     public BalanceResponse(String accountNo, String responseCode, String responseMessage) {
          this.accountNo = accountNo;
          this.responseCode = responseCode;
          this.responseMessage = responseMessage;
     }

     public BalanceResponse(String accountNo,String accountName, String availableBalance, String responseCode, String responseMessage) {
          this.accountNo = accountNo;
          this.accountName = accountName;
          this.availableBalance = availableBalance;
          this.responseCode = responseCode;
          this.responseMessage = responseMessage;
     }

     public BalanceResponse() {
    
     }
}
