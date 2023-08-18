//package com.neptunesoftware.accelerex.auth.controller;
//
//import com.neptunesoftware.accelerex.auth.AuthenticationService;
//import com.neptunesoftware.accelerex.auth.request.AuthRequest;
//import com.neptunesoftware.accelerex.auth.request.RegistrationRequest;
//import com.neptunesoftware.accelerex.auth.response.AuthResponse;
//import io.swagger.v3.oas.annotations.Hidden;
//import io.swagger.v3.oas.annotations.tags.Tag;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("api/v1/auth")
//@RequiredArgsConstructor
//@CrossOrigin
//@Tag(name = "Authentication")
//
//public class AuthenticationController {
//    private final AuthenticationService authenticationService;
//    @PostMapping("/register")
//    @Hidden
//    ResponseEntity<AuthResponse>register(@RequestBody RegistrationRequest request) {
//        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.register(request));
//    }
//
//    @PostMapping("/login")
//    ResponseEntity<AuthResponse>login(@RequestBody AuthRequest request) {
//        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.login(request));
//    }
//}