package com.neptunesoftware.accelerex.account.response;

import lombok.Data;

@Data
public class VerifyTokenResponse {
    private String accountNo;
    private String accountName;
    private String mobileNo;
    private String email;
}
