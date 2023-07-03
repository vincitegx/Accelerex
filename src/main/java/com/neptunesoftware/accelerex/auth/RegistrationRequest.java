package com.neptunesoftware.accelerex.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class RegistrationRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String emailAddress;
    private String password;
    private String phoneNumber;
}
