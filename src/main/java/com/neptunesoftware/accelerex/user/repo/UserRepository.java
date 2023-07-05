package com.neptunesoftware.accelerex.user.repo;

import com.neptunesoftware.accelerex.user.User;

import java.util.Optional;
public interface UserRepository  {
    boolean existsByEmailAddress(String emailAddress);
    Optional<User> findByPhoneNumber(String mobileNumber);
    Optional<User> findByEmailAddress(String email);
    User findUserByAccountNumber(String accountNumber);

    void saveRegistrationDetails(User user);

}