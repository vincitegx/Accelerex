package com.neptunesoftware.accelerex.auth;

public interface AuthenticationService {

    AuthenticationResponse register(RegistrationRequest request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
