package com.neptunesoftware.accelerex.account.request;

import lombok.Data;

@Data
public class BalanceEnquiryRequest {
    
    private String clientId;
    private String secretKey;
    private String bankCode;
    private String accountNo;
}
