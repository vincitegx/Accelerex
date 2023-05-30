package com.neptunesoftware.Accelerex.user.requests;

import lombok.NonNull;

public record UserAuthenticationRequests(
        @NonNull
        String emailAddress,
        @NonNull
        String password
) {
}
