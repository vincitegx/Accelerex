package com.neptunesoftware.accelerex.user;

import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository  {
    boolean existsByEmailAddress(String emailAddress);
    Optional<User> findBySmsToken(String smsToken);
    Optional<User> findByPhoneNumber(String mobileNumber);
    Optional<User> findByEmailAddress(String email);
    String findByEmail(String email);
}