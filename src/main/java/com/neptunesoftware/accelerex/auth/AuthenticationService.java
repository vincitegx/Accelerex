package com.neptunesoftware.accelerex.auth;

public interface AuthenticationService {

    AuthResponse register(RegistrationRequest request);

    AuthResponse login(AuthRequest request);
}
