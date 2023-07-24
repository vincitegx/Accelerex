package com.neptunesoftware.accelerex.account;

public interface AccountRepository  {
    String findNameByAccountNumber(String accountNumber);
    String findAccountByPhoneNumber(String accountNumber);

    String findTokenByAccountNumber(String token);
    void updateOTP(String phoneNumber, String otp);
    String findUserIdByAccountNumber(String accountNumber);

}
