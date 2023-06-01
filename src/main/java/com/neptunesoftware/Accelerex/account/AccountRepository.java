package com.neptunesoftware.Accelerex.account;

import com.neptunesoftware.Accelerex.utils.ApiResponse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Account findByUserId(Integer userId);
}
