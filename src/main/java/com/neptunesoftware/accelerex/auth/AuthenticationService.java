package com.neptunesoftware.accelerex.auth;

public interface AuthenticationService {

    AuthenticationResponse register(RegistrationRequest request);

    AuthenticationResponse login(LoginRequest request);
}
