package com.neptunesoftware.accelerex.account.response;

import lombok.Data;

@Data
public class BalanceResponse {
     private String accountNo;
     private String accountName;
     private String availableBalance;
     private String responseCode;
     private String message;

     public BalanceResponse(String accountNo,String accountName, String availableBalance, String responseCode, String message) {
          this.accountNo = accountNo;
          this.accountName = accountName;
          this.availableBalance = availableBalance;
          this.responseCode = responseCode;
          this.message = message;
     }

     public BalanceResponse() {
    
     }

     public BalanceResponse(String accountNo, String accountName, String availableBalance, String webserviceUnavailableMessage) {
     }

     public BalanceResponse(String accountNo, String message) {

     }
}
