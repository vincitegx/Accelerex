package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.transaction.request.TransactionRequest;
import com.neptunesoftware.accelerex.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository {
    Optional<Account> findAccountByUser(User user);
    Optional<Account> findAccountByAccountNumber(String accountNumber);
    Optional<Account> findAccountByUserId(Integer user_id);
    boolean existsByAccountNumber(String accountNumber);
    void updateTransactionHistory(TransactionRequest details);
}
