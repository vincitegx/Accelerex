package com.neptunesoftware.Accelerex.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByUserId(Integer userId);
    Optional<Account>findByAccountNumber(String accountNumber);
}
