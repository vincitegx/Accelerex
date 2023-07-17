package com.neptunesoftware.accelerex.config;

import com.neptunesoftware.accelerex.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//@AllArgsConstructor
@Service
@JsonComponent
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String defaultUsername = "admin";
        String defaultPassword =  "1234";
        if (email.equals(defaultUsername)) {
            return User.builder()
                    .emailAddress(defaultUsername)
                    .password(defaultPassword).build();
        } else {
          throw new UsernameNotFoundException("User not found");
        }
    }
}