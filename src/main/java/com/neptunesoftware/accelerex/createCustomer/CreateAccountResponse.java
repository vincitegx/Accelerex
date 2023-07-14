package com.neptunesoftware.accelerex.createCustomer;

import lombok.Data;

@Data
public class CreateAccountResponse {
    public String accountNo;
    public String accountId;
    public String accountStatus;
    private String responseCode;
    private String responseMessage;
}
