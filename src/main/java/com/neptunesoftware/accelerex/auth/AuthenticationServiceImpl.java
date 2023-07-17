package com.neptunesoftware.accelerex.auth;

import com.neptunesoftware.accelerex.config.CustomUserDetailService;
import com.neptunesoftware.accelerex.config.JWTService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    private final CustomUserDetailService customUserDetailService;



    @Override
    public AuthenticationResponse register(RegistrationRequest request) {
    return null;
    }

    @Override
    public AuthenticationResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmailAddress(), request.getPassword())
        );
        final UserDetails user = customUserDetailService.loadUserByUsername(request.getEmailAddress());
        if (user != null) {
            return AuthenticationResponse.builder()
                    .token(jwtService.generateToken(user)).build();
        }
       return new AuthenticationResponse(null);
    }
}
