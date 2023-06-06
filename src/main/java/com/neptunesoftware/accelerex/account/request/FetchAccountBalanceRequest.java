package com.neptunesoftware.accelerex.account.request;

import lombok.Data;

@Data
public class FetchAccountBalanceRequest {
    
    private String clientId;
    private String secretKey;
    private String bankCode;
    private String accountNo;
}
