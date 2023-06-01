package com.neptunesoftware.Accelerex.account.response;

import lombok.Data;

@Data
public class CreateBankAccountResponse {
    private String AccountName;
    private String MobileNo;
    private String Email;
    private String accountNumber;
}
