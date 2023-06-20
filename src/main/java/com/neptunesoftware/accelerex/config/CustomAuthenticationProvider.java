package com.neptunesoftware.accelerex.config;

import com.neptunesoftware.accelerex.user.User;
import com.neptunesoftware.accelerex.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

//@Component
//@RequiredArgsConstructor
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//    private final PasswordEncoder passwordEncoder;
//    private final UserRepository repository;
//
//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
////        String accountNumber = (String) authentication.getPrincipal();
////        String password = (String) authentication.getCredentials();
////        User securityUser = repository.findUserByAccountNumber(accountNumber);
////        if (passwordEncoder.matches(password, securityUser.getPassword())) {
////            return new UsernamePasswordAuthenticationToken(securityUser.getAccountNumber(), securityUser.getPassword());
////        }
////        throw new LoginServiceException("The account number or password entered is not correct");
//        return null;
//    }
//
//    @Override
//    public boolean supports(Class<?> authenticationType) {
//        return authenticationType.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}
