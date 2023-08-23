package com.neptunesoftware.accelerex.user.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class JwtAuthResponse {

    private String authToken;
}
