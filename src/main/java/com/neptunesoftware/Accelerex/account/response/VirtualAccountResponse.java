package com.neptunesoftware.Accelerex.account.response;

import lombok.Data;

import java.util.Map;

@Data
public class VirtualAccountResponse {
    private String accountId;
    private String accountName;
    private String bankName;
    private String accountNumber;
    private String callbackURL;
    private Map<String, Object> metadata;
}
