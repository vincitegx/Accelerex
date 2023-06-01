package com.neptunesoftware.Accelerex.account.request;

import lombok.Data;

@Data
public class CreateBankAccountRequest {
    private String AccountName;
    private String MobileNo;
    private String Email;
    private String password;
}
