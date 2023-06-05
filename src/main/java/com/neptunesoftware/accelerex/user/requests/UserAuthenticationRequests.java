package com.neptunesoftware.accelerex.user.requests;

import lombok.NonNull;

public record UserAuthenticationRequests(
        @NonNull
        String emailAddress,
        @NonNull
        String password
) {
}
