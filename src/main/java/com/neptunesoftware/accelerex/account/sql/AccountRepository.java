package com.neptunesoftware.accelerex.account.sql;

import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;

public interface AccountRepository  {
    boolean findAccountByPhoneAndAccountNumber(String phoneNum,String accountNumber);
    public void  linkExistingAccountToAgentProfile(LinkBankAccountRequest linkBankAccountRequest);
}