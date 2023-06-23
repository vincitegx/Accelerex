package com.neptunesoftware.accelerex.user.repo;

import com.neptunesoftware.accelerex.user.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository  {
    boolean existsByEmailAddress(String emailAddress);
    Optional<User> findByPhoneNumber(String mobileNumber);
    Optional<User> findByEmailAddress(String email);
}