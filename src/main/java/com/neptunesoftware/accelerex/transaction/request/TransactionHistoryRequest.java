package com.neptunesoftware.accelerex.transaction.request;

import lombok.NonNull;

public record TransactionHistoryRequest (
        @NonNull
        String accountNumber,
        @NonNull
        String startDateTime,
        @NonNull
        String endDateTime
){}
