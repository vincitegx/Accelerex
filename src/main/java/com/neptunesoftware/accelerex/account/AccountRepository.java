package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.user.User;


import java.util.Optional;

//@Repository
public interface AccountRepository  {
    Optional<Account> findAccountByUser(User user);
    Optional<Account> findAccountByAccountNumber(String accountNumber);
    String findByAccountNumber(String accountNumber);

    String findNameByAccountNumber(String accountNumber);
    String findAccountByPhoneNumber(String accountNumber);
//    BigDecimal findBalanceByAccountNumber();

    boolean existsByAccountNumber(String accountNumber);

    String findTokenByAccountNumber(String token);
    void updateOTP(String phoneNumber, String otp);
    String findUserIdByAccountNumber(String accountNumber);

}
