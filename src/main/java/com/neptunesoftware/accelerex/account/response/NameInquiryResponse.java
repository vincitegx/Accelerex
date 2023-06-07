package com.neptunesoftware.accelerex.account.response;

import com.neptunesoftware.accelerex.account.AccountStatus;
import lombok.*;

@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
public class NameInquiryResponse {
    private String accountNo;
    private String accountName;
    private String availableBalance;
    private String currencyCode;
    private AccountStatus accountStatus;
}
