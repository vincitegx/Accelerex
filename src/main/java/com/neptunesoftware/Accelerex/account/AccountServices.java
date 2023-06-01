package com.neptunesoftware.Accelerex.account;

import com.neptunesoftware.Accelerex.account.request.CreateBankAccountRequest;
import com.neptunesoftware.Accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.Accelerex.account.response.CreateBankAccountResponse;
import com.neptunesoftware.Accelerex.utils.ApiResponse;
import com.neptunesoftware.Accelerex.account.response.LinkBankAccountResponse;

public interface AccountServices {

    ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request);
    String verifySmsToken(String smsToken);
    ApiResponse<CreateBankAccountResponse> createBankAccount(CreateBankAccountRequest createBankAccountRequest);
}
