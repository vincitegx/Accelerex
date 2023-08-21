package com.neptunesoftware.accelerex.user;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.neptunesoftware.accelerex.account.Account;
import com.neptunesoftware.accelerex.account.AccountServices;
import com.neptunesoftware.accelerex.config.JWTService;
import com.neptunesoftware.accelerex.config.JwtProvider;
import com.neptunesoftware.accelerex.config.PasswordEncoderConfig;
import com.neptunesoftware.accelerex.exception.*;
import com.neptunesoftware.accelerex.user.repo.UserRepository;
import com.neptunesoftware.accelerex.user.requests.ChangePasswordRequest;
import com.neptunesoftware.accelerex.user.requests.LoginRequest;
import com.neptunesoftware.accelerex.user.requests.UserAuthenticationRequests;
import com.neptunesoftware.accelerex.user.requests.UserRegistrationRequest;
import com.neptunesoftware.accelerex.user.response.JwtAuthResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.*;

@Service
@Log4j2
public class UserService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AccountServices accountService;
    private final PasswordEncoderConfig passwordEncoderConfig;
    private final AuthenticationManager authenticationManager;

    @Autowired
    public UserService(UserRepository userRepository, JWTService jwtService,
                       AccountServices accountService, PasswordEncoderConfig passwordEncoderConfig,
                       AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.accountService = accountService;
        this.passwordEncoderConfig = passwordEncoderConfig;
        this.authenticationManager = authenticationManager;
    }
//    public void updateUser(User existingUser){
//        existingUser.setUpdatedAt(LocalDateTime.now());
//        userRepository.save(existingUser);
//    }

    /**
     * this service creates a new user provided the email does not exist and also invokes the account
     * service to create a new account for the user
     */
//    @Transactional
//    public void createNewUser(UserRegistrationRequest userRegistrationRequest){
//        if(userRepository.existsByEmailAddress(userRegistrationRequest.emailAddress())){
//            throw new ResourceExistsException("email address is taken");
//        }
//        User newUser = new User(
//                userRegistrationRequest.fullName(),
//                userRegistrationRequest.emailAddress(),
//                passwordEncoderConfig.passwordEncoder().encode(userRegistrationRequest.password()),
//                true,
//                userRegistrationRequest.phoneNumber());
//        newUser = userRepository.save(newUser);
//        accountService.createAccount(new Account(newUser));
//    }
    public boolean passwordMatches(String rawPassword, String encodedPassword){
        return passwordEncoderConfig.passwordEncoder().matches(rawPassword,encodedPassword);
    }
    public String authenticateUser(UserAuthenticationRequests requests){
        User existingUser = getUserByEmailAddress(requests.emailAddress());

        if (passwordMatches(requests.password(),existingUser.getPassword())){
            Map<String,Object> claims = Map.of("userId", existingUser.getId());
            return jwtService.generateToken(claims,existingUser);
        }
        throw new InvalidAuthenticationException("Invalid username or password");
    }
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String accountNumber = (String) authentication.getPrincipal();
        String password = (String) authentication.getCredentials();
        User securityUser = userRepository.findUserByAccountNumber(accountNumber);
        if (passwordMatches(password, securityUser.getPassword())) {
            return new UsernamePasswordAuthenticationToken(securityUser.getAccountNumber(), securityUser.getPassword());
        }
        throw new UserNotFoundException("The account number or password entered is not correct");
    }

//    public void changeUserPassword(ChangePasswordRequest request, Integer userId){
//        User existingUser = getUserById(userId);
//        if(!passwordEncoderConfig.passwordEncoder().matches(request.oldPassword(),existingUser.getPassword())){
//            throw new ValueMismatchException("old password does not match");
//        }
//        existingUser.setPassword(passwordEncoderConfig.passwordEncoder().encode(request.newPassword()));
//        updateUser(existingUser);
//    }

//    public User getUserById(int userId){
//        Optional<User> existingUser = userRepository.findById(userId);
//        if(existingUser.isEmpty()){
//            throw new ResourceNotFoundException("user not found");
//        }
//        return existingUser.get();
//    }
    public User getUserByEmailAddress(String emailAddress){
        Optional<User> existingUser = userRepository.findByEmailAddress(emailAddress);
        if(existingUser.isEmpty()){
            throw new ResourceNotFoundException("user not found");
        }
        return existingUser.get();
    }

    public String encodePassword(String password){
        return passwordEncoderConfig.passwordEncoder().encode(password);
    }

    public JwtAuthResponse login(LoginRequest loginRequest) {
        Authentication authenticate = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.clientId(), loginRequest.clientSecret()));
        SecurityContextHolder.getContext().setAuthentication(authenticate);
        String token = jwtService.generateJwtToken(authenticate);
        return new JwtAuthResponse(token);
    }
}
