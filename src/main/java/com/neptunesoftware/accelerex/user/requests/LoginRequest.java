package com.neptunesoftware.accelerex.user.requests;

import lombok.NonNull;

public record LoginRequest(
        @NonNull
        String clientId,
        @NonNull
        String clientSecret
) {
        }
