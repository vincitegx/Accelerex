package com.neptunesoftware.accelerex.account.request;

import lombok.Data;

@Data
public class InfoRequest {
    private String accountNumber;
    private String accountName;
    private String phoneNumber;
    private String email;
}
