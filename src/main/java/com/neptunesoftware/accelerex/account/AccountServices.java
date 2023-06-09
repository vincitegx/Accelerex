package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.*;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.data.account.BalanceenquiryResponse;
import com.neptunesoftware.accelerex.utils.ApiResponse;

public interface AccountServices {

    ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request);

    ApiResponse<NameEnquiryResponse> nameEnquiry(String nameEnquiryRequest);

    VerifyTokenResponse verifySmsToken(String smsToken);
    ApiResponse<CreateBankAccountResponse> createBankAccount(CreateBankAccountRequest createBankAccountRequest);

    BalanceenquiryResponse fetchAccountBalance(String accountNumber);

}