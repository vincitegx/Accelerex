package com.neptunesoftware.accelerex.account.request;

import lombok.Data;

@Data
public class CreateBankAccountRequest {
    private String accountName;
    private String mobileNo;
    private String Email;
    private String password;
}
