package com.neptunesoftware.accelerex.config;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
@AllArgsConstructor
@Service
public class CustomUserDetailService {

    @Bean
    public UserDetailsService userDetailsService(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode("accelerex_123");
        UserDetails user = org.springframework.security.core.userdetails.User.withUsername("administrator")
                .password(password).build();
        return new InMemoryUserDetailsManager(user);
    }
}
