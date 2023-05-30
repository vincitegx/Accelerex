package com.neptunesoftware.Accelerex.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findAccountByUserId(Integer userId);
    Optional<Account> findAccountByAccountNumber(String accountNumber);
    boolean existsByAccountNumber(String accountNumber);

}
