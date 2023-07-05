package com.neptunesoftware.accelerex.createCustomer;

import lombok.Data;

@Data
public class CreateBankAccountResponse {

    private String responseCode;
    private String responseMessage;
    private String customerId;
    private String customerNo;
    private String accountId;
    private String accountNumber;

    public CreateBankAccountResponse(String responseCode, String responseMessage, String custNo, String customerId, String accountId, String accountNumber) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.customerNo = custNo;
        this.customerId = customerId;
        this.accountNumber = accountNumber;
        this.accountId = accountId;
    }

    public CreateBankAccountResponse(String responseCode, String responseMessage, String custNo, String customerId) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.customerNo = custNo;
        this.customerId = customerId;
    }
   public CreateBankAccountResponse() {

    }
}
