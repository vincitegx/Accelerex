package com.neptunesoftware.accelerex.user;

import java.util.Optional;
public interface UserRepository {
    boolean existsByEmailAddress(String emailAddress);
    Optional<User> findBySmsToken(String smsToken);
    Optional<User> findByPhoneNumber(String mobileNumber);
    Optional<User> findByEmailAddress(String email);
}
