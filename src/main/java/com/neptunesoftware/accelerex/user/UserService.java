package com.neptunesoftware.accelerex.user;

import com.neptunesoftware.accelerex.account.AccountServices;
import com.neptunesoftware.accelerex.config.JWTService;
import com.neptunesoftware.accelerex.exception.InvalidAuthenticationException;
import com.neptunesoftware.accelerex.exception.ResourceNotFoundException;
import com.neptunesoftware.accelerex.exception.UserNotFoundException;
import com.neptunesoftware.accelerex.user.repo.UserRepository;
import com.neptunesoftware.accelerex.user.requests.UserAuthenticationRequests;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final JWTService jwtService;
    private final AccountServices accountService;
    private final PasswordEncoder passwordEncoder;


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
        return passwordEncoder.encode(encodedPassword).matches(rawPassword);
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
            return new UsernamePasswordAuthenticationToken(securityUser.getEmailAddress(), securityUser.getPassword());
//            return new UsernamePasswordAuthenticationToken(securityUser.getAccountNumber(), securityUser.getPassword());
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
        return passwordEncoder.encode(password);
    }
}
