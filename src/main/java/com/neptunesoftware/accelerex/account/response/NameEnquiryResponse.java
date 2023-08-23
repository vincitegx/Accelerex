package com.neptunesoftware.accelerex.account.response;

import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class NameEnquiryResponse {
    private String accountName;
    private String message;
    private String responseCode;
}
