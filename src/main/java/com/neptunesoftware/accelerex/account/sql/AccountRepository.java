package com.neptunesoftware.accelerex.account.sql;

import com.neptunesoftware.accelerex.user.User;

public interface AccountRepository  {
    User findByAccountNumber(String accountNumber);
    boolean findByPhoneAndDateOfBirth(String phoneNumber, String dob);
    void  linkExistingAccountToAgentProfile(User user, String userName);
    boolean findByUserName(String username);
}