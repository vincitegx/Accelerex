package com.neptunesoftware.accelerex.account.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NameEnquiryResponse {
    private String accountName;
    private String accountNumber;
}
