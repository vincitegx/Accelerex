package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.account.response.ExternalTransferNameEnquiryResponse;
import com.neptunesoftware.accelerex.account.response.LinkBankAccountResponse;
import com.neptunesoftware.accelerex.account.response.NameEnquiryResponse;
import com.neptunesoftware.accelerex.account.response.VerifyTokenResponse;
import com.neptunesoftware.accelerex.data.account.BalanceenquiryResponse;
import com.neptunesoftware.accelerex.utils.ApiResponse;

public interface AccountServices {

    ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request);

    ApiResponse<NameEnquiryResponse> nameEnquiry(String nameEnquiryRequest);

    VerifyTokenResponse verifySmsToken(String smsToken);

    BalanceenquiryResponse fetchAccountBalance(String accountNumber);

    ExternalTransferNameEnquiryResponse interBankNameEnquiry(String accountNumber);

    String intraBankNameEnquiry(String accountNumber);
}