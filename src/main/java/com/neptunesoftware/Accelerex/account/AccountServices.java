package com.neptunesoftware.Accelerex.account;

import com.neptunesoftware.Accelerex.account.request.CreateBankAccountRequest;
import com.neptunesoftware.Accelerex.account.request.FetchAccountBalanceRequest;
import com.neptunesoftware.Accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.Accelerex.account.request.VirtualAccountRequest;
import com.neptunesoftware.Accelerex.account.response.CreateBankAccountResponse;
import com.neptunesoftware.Accelerex.account.response.VerifyTokenResponse;
import com.neptunesoftware.Accelerex.utils.ApiResponse;
import com.neptunesoftware.Accelerex.account.response.LinkBankAccountResponse;

public interface AccountServices {

    ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request);
    VerifyTokenResponse verifySmsToken(String smsToken);
    ApiResponse<CreateBankAccountResponse> createBankAccount(CreateBankAccountRequest createBankAccountRequest);

   ApiResponse<VerifyTokenResponse> createVirtualAccount(VirtualAccountRequest request);

    ApiResponse<FetchAccountBalanceRequest> fetchAccountBalance(FetchAccountBalanceRequest request);
}