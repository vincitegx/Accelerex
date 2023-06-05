package com.neptunesoftware.accelerex.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    boolean existsByEmailAddress(String emailAddress);
    Optional<User> findByEmailAddress(String email);
}
