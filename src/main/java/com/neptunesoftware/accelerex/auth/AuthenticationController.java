package com.neptunesoftware.accelerex.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    ResponseEntity<AuthenticationResponse>register(@RequestBody RegistrationRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.register(request));
    }

    @PostMapping("/login")
    ResponseEntity<AuthenticationResponse>login(@RequestBody LoginRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(authenticationService.login(request));
    }
}
