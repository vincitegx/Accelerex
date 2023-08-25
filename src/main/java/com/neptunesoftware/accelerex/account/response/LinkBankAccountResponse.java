package com.neptunesoftware.accelerex.account.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkBankAccountResponse {
    private String userName;
    private String accountNo;
    private String accountName;
    private String mobileNo;
    private String email;
}
