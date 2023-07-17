package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.InterBankTransferRequest;
import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.utils.ApiResponse;

public interface AccountServices {
    ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request);
    BalanceResponse intraBankBalanceEnquiry(String accountNumber);
    NameEnquiryResponse IntraBankNameEnquiry(String nameEnquiryRequest);
    ExternalTransferNameEnquiryResponse interBankNameEnquiry(String accountNumber);
    InterBankTransferResponse interBankTransfer(InterBankTransferRequest request);
     Boolean existedByAccount(String accountNumber);

}
