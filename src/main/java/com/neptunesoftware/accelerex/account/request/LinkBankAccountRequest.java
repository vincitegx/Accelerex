package com.neptunesoftware.accelerex.account.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class LinkBankAccountRequest {
    private String accountNo;
    private String accountName;
    private String mobileNo;
    private String email;
}