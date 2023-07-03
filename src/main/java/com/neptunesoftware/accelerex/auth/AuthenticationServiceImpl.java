package com.neptunesoftware.accelerex.auth;

import com.neptunesoftware.accelerex.config.JWTService;
import com.neptunesoftware.accelerex.user.Role;
import com.neptunesoftware.accelerex.user.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    @Override
    public AuthenticationResponse register(RegistrationRequest request) {

        if (userRepository.findByEmailAddress(request.getEmailAddress()).isPresent()) {
            throw new RuntimeException("User with Email already exist");
        }
        if (userRepository.findByPhoneNumber(request.getPhoneNumber()).isPresent()) {
            throw new RuntimeException("Phone number Already exist");
        }
        String name;
        if (request.getMiddleName().isEmpty()){
            name = request.getFirstName()+ " "+ request.getLastName();
        } else {
            name = request.getFirstName()+" "+ request.getMiddleName()+" "+ request.getLastName();
        }
        var  user = com.neptunesoftware.accelerex.user.User.builder()
                .fullName(name)
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .emailAddress(request.getEmailAddress())
                .role(Role.ROLE_USER)
                .build();
        return new AuthenticationResponse(jwtService.generateToken(user));
    }

    @Override
    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmailAddress(),
                request.getPassword()
        ));
        var user = userRepository.findByEmailAddress(request.getEmailAddress()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken).build();
    }
}