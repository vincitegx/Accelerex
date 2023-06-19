package com.neptunesoftware.accelerex.general;

import com.neptunesoftware.accelerex.user.User;

public interface ClientRepo {
    User findByClientIdAndSecretKey(String clientId,String secretKey);
}
