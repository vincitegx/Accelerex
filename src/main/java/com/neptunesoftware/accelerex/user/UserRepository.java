package com.neptunesoftware.accelerex.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmailAddress(String emailAddress);
    Optional<User> findBySmsToken(String smsToken);
    Optional<User> findByPhoneNumber(String mobileNumber);
    Optional<User> findByEmailAddress(String email);
}
