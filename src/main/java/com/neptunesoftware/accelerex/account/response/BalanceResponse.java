package com.neptunesoftware.accelerex.account.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class BalanceResponse {
     private String accountNo;
     private String accountName;
     private String availableBalance;
     private String responseCode;
     private String message;

     public BalanceResponse(String responseCode, String message) {
          this.responseCode = responseCode;
          this.message = message;
     }
}
