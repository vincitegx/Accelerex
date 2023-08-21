package com.neptunesoftware.accelerex.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccelerexUser {

    private Long id;

    private String username;

    private String password;

    private LocalDateTime createdAt;

    private Boolean nonLocked;

    private Boolean enabled;

    private Set<Role> roles;
}
