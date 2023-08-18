//package com.neptunesoftware.accelerex.auth;
//
//import com.neptunesoftware.accelerex.auth.request.AuthRequest;
//import com.neptunesoftware.accelerex.auth.request.RegistrationRequest;
//import com.neptunesoftware.accelerex.auth.response.AuthResponse;
//import com.neptunesoftware.accelerex.config.JWTService;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//@Log4j2
//public class AuthenticationService {
//    private final JWTService jwtService;
//    private final AuthenticationManager authenticationManager;
////    private final CustomUserDetailService customUserDetailService;
//
//
//    public AuthResponse register(RegistrationRequest request) {
//    return null;
//    }
//
//
//    public AuthResponse login(AuthRequest request) {
//      Authentication authentication = authenticationManager.authenticate(
//              new UsernamePasswordAuthenticationToken(request.getEmailAddress(), request.getPassword()));
////        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        log.info("***********Authenticated successfully*********");
//
//        UserDetails securedUser = (UserDetails) authentication.getPrincipal();
//        String token = jwtService.generateToken(securedUser);
//          log.info("JwtToken: {}",token);
//        return AuthResponse.builder().token(token).build();
//    }
//}
