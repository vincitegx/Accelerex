package com.neptunesoftware.accelerex.createCustomer;

import lombok.Data;

@Data
public class CreateAccountResponse {

    private String responseCode;
    private String responseMessage;
    private String customerId;
    private String customerNo;
    private String accountId;
    private String accountNumber;

    public CreateAccountResponse(String responseCode, String responseMessage, String custNo, String customerId, String accountId,String accountNumber) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.customerNo = custNo;
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.accountId = accountId;
    }
   public CreateAccountResponse() {

    }
}
