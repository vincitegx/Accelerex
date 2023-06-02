package com.neptunesoftware.Accelerex.user;

import com.neptunesoftware.Accelerex.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findBySmsToken(String smsToken);
    Optional<User> findByPhoneNumber(String mobileNumber);
    Optional<User> findByEmailAddress(String email);
}