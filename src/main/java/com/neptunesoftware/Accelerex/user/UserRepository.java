package com.neptunesoftware.Accelerex.user;

import com.neptunesoftware.Accelerex.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findBySmsToken(String smsToken);
     Optional<User> findUsersByEmailAndMobileNumber(String email,String mobileNo);
    Optional<User> findByMobileNumber(String mobileNumber);
    Optional<User> findByEmail(String email);
}