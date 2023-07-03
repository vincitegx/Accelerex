package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.transaction.request.TransactionRequest;
import com.neptunesoftware.accelerex.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

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
    String findBvnByAccountNum(String accountNumber);
}
