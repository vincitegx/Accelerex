package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.InterBankTransferRequest;
import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.utils.ApiResponse;

public interface AccountServices {

    ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request);
    FetchAccountBalanceResponse fetchAccountBalance(String accountNumber);
    ExternalTransferNameEnquiryResponse interBankNameEnquiry(String accountNumber);
    InterBankTransferResponse interBankTransfer(InterBankTransferRequest request);
    String intraBankNameEnquiry(String accountNumber);
    ApiResponse<NameEnquiryResponse> nameEnquiry(String nameEnquiryRequest);
}