package com.neptunesoftware.accelerex.account.response;

import lombok.Data;

@Data
public class NameEnquiryResponse {
    private String accountName;
    private String message;
    private String responseCode;
}
