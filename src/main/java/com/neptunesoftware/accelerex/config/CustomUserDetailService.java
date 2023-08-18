//package com.neptunesoftware.accelerex.config;
//
//import com.neptunesoftware.accelerex.user.Role;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.jackson.JsonComponent;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
////@AllArgsConstructor
//@Service
//@JsonComponent
//@RequiredArgsConstructor
//@Configuration
//public class CustomUserDetailService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        String client_Id = "accelerexAdmin";
//        String client_secret = passwordEncoder().encode( "pass@acelerex");
//        return new org.springframework.security.core.userdetails.User(
//                client_Id, client_secret, Collections.singleton(new SimpleGrantedAuthority(Role.ROLE_ADMIN.name())));
//    }
//        @Bean
//    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
//        return config.getAuthenticationManager();
//    }
//        @Bean
//    public AuthenticationProvider authenticationProvider() {
//            DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//            authProvider.setUserDetailsService(userDetailsService());
//            authProvider.setPasswordEncoder(passwordEncoder());
//            return authProvider;
//        }
//    @Bean
//    public UserDetailsService userDetailsService() {
//       return this;
//    }
//
//        @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
