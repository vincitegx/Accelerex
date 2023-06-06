package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.*;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.utils.ApiResponse;

public interface AccountServices {

    ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request);

    ApiResponse<NameInquiryResponse> nameInquiry(NameInquiryRequest nameInquiryRequest);

    VerifyTokenResponse verifySmsToken(String smsToken);
    ApiResponse<CreateBankAccountResponse> createBankAccount(CreateBankAccountRequest createBankAccountRequest);

   ApiResponse<VerifyTokenResponse> createVirtualAccount(VirtualAccountRequest request);

    ApiResponse<FetchAccountBalanceResponse> fetchAccountBalance(FetchAccountBalanceRequest request);

}