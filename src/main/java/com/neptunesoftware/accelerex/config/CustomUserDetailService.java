//package com.neptunesoftware.accelerex.config;
//
//import com.neptunesoftware.accelerex.user.Role;
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.jackson.JsonComponent;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//
////@AllArgsConstructor
//@Service
//@JsonComponent
//@RequiredArgsConstructor
//public class CustomUserDetailService implements UserDetailsService {
//
//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        String client_Id = "acelerxAdmin";
//        String client_secret =  "pass@acelerex";
//        return new org.springframework.security.core.userdetails.User(
//                client_Id, client_secret, Collections.singleton(new SimpleGrantedAuthority(Role.ROLE_ADMIN.name())));
//    }
//}
