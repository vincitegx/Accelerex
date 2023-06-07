package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.*;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.transaction.request.TransactionRequest;
import com.neptunesoftware.accelerex.utils.ApiResponse;

public interface AccountServices {

    ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request);

    NameInquiryResponse nameInquiry(String accountNumber);

    VerifyTokenResponse verifySmsToken(String smsToken);
    ApiResponse<CreateBankAccountResponse> createBankAccount(CreateBankAccountRequest createBankAccountRequest);

   ApiResponse<VerifyTokenResponse> createVirtualAccount(VirtualAccountRequest request);

    ApiResponse<FetchAccountBalanceResponse> fetchAccountBalance(FetchAccountBalanceRequest request);

    void saveTransaction(TransactionRequest details, String tranMethod);

    Account accountExistsAndIsActivated(String senderAccountNumber)
}