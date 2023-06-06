package com.neptunesoftware.accelerex.general;

import com.neptunesoftware.accelerex.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepo extends JpaRepository<Client,String> {
    User findByClientIdAndSecretKey(String clientId,String secretKey);
}
