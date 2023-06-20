package com.neptunesoftware.accelerex.transaction.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.NonNull;

import java.time.LocalDateTime;

public record TransactionHistoryRequest(
        @NonNull
        String accountNumber,
        @NonNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime startDateTime,

        @NonNull
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
        LocalDateTime endDateTime
) {
}
