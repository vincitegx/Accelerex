package com.neptunesoftware.accelerex.account.request;

import lombok.Data;

@Data
public class NameEnquiryRequest {
    private String accountNo;
    private String accountName;
    private String mobileNo;
    private String email;
}
