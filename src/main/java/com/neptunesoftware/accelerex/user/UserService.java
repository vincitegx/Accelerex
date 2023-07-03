package com.neptunesoftware.accelerex.user;

import com.neptunesoftware.accelerex.account.Account;
import com.neptunesoftware.accelerex.account.AccountServices;
import com.neptunesoftware.accelerex.config.JWTService;
import com.neptunesoftware.accelerex.config.PasswordEncoderConfig;
import com.neptunesoftware.accelerex.exception.*;
import com.neptunesoftware.accelerex.user.repo.UserRepository;
import com.neptunesoftware.accelerex.user.requests.ChangePasswordRequest;
import com.neptunesoftware.accelerex.user.requests.UserAuthenticationRequests;
import com.neptunesoftware.accelerex.user.requests.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AccountServices accountService;
    private final PasswordEncoderConfig passwordEncoderConfig;

    @Autowired
    public UserService(UserRepository userRepository, JWTService jwtService, AccountServices accountService, PasswordEncoderConfig passwordEncoderConfig) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.accountService = accountService;
        this.passwordEncoderConfig = passwordEncoderConfig;
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
}
