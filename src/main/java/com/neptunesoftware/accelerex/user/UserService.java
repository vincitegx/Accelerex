package com.neptunesoftware.accelerex.user;

import com.neptunesoftware.accelerex.account.AccountService;
import com.neptunesoftware.accelerex.config.JWTService;
import com.neptunesoftware.accelerex.exception.InvalidAuthenticationException;
import com.neptunesoftware.accelerex.exception.ResourceExistsException;
import com.neptunesoftware.accelerex.exception.ResourceNotFoundException;
import com.neptunesoftware.accelerex.exception.ValueMismatchException;
import com.neptunesoftware.accelerex.user.requests.ChangePasswordRequest;
import com.neptunesoftware.accelerex.user.requests.UserAuthenticationRequests;
import com.neptunesoftware.accelerex.user.requests.UserRegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Optional;
//@Service
//public class UserService {
//    private final UserRepository userRepository;
//    private final JWTService jwtService;
//    private final AccountService accountService;
//    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
//
//    @Autowired
//    public UserService(UserRepository userRepository, JWTService jwtService, AccountService accountService) {
//        this.userRepository = userRepository;
//        this.jwtService = jwtService;
//        this.accountService = accountService;
//    }
//
//
//    public void updateUser(User existingUser){
//        existingUser.setUpdatedAt(LocalDateTime.now());
//        userRepository.save(existingUser);
//    }
//
//
//    /**
//     * this service creates a new user provided the email does not exist and also invokes the account
//     * service to create a new account for the user
//     */
//    @Transactional
//    public void createNewUser(UserRegistrationRequest userRegistrationRequest){
//        if(userRepository.existsByEmailAddress(userRegistrationRequest.emailAddress())){
//            throw new ResourceExistsException("email address is taken");
//        }
//        User newUser = new User(
//                userRegistrationRequest.fullName(),
//                userRegistrationRequest.emailAddress(),
//                bCryptPasswordEncoder.encode(userRegistrationRequest.password()),
//                true,
//                userRegistrationRequest.phoneNumber());
//
//        newUser = userRepository.save(newUser);
//        accountService.createAccount(new Account(newUser));
//    }
//
//    public boolean passwordMatches(String rawPassword, String encodedPassword){
//        return bCryptPasswordEncoder.matches(rawPassword,encodedPassword);
//    }
//
//
//    public String authenticateUser(UserAuthenticationRequests requests){
//        User existingUser = getUserByEmailAddress(requests.emailAddress());
//
//        if (passwordMatches(requests.password(),existingUser.getPassword())){
//            Map<String,Object> claims = Map.of("userId", existingUser.getId());
//            return jwtService.generateToken(claims,existingUser);
//        }
//        throw new InvalidAuthenticationException("Invalid username or password");
//
//    }
//
//    public void changeUserPassword(ChangePasswordRequest request, Integer userId){
//        User existingUser = getUserById(userId);
//
//        if(!bCryptPasswordEncoder.matches(request.oldPassword(),existingUser.getPassword())){
//            throw new ValueMismatchException("old password does not match");
//        }
//
//        existingUser.setPassword(bCryptPasswordEncoder.encode(request.newPassword()));
//        updateUser(existingUser);
//
//
//    }
//
//    public User getUserById(int userId){
//        Optional<User> existingUser = userRepository.findById(userId);
//        if(existingUser.isEmpty()){
//            throw new ResourceNotFoundException("user not found");
//        }
//        return existingUser.get();
//    }
//    public User getUserByEmailAddress(String emailAddress){
//        Optional<User> existingUser = userRepository.findByEmailAddress(emailAddress);
//        if(existingUser.isEmpty()){
//            throw new ResourceNotFoundException("user not found");
//        }
//        return existingUser.get();
//    }
//
//
//    public String encodePassword(String password){
//        return bCryptPasswordEncoder.encode(password);
//    }
//
//}
