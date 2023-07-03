package com.neptunesoftware.accelerex.account.response;

import lombok.Data;

@Data
public class ExternalTransferNameEnquiryResponse {
    private String accountName;
    private String responseCode;
    private String responseMessage;
    private String nameInquiryRef;
    private String sessionId;
}
