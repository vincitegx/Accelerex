package com.neptunesoftware.accelerex.transaction.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.NonNull;

public record TransactionHistoryRequest (
        @NonNull
        String accountNumber,
        @Schema(name = "start date", pattern = "yyyy-MM-dd HH:mm:ss")
        @NonNull
        String startDateTime,
        @Schema(name = "end date", pattern = "yyyy-MM-dd HH:mm:ss")
        @NonNull
        String endDateTime
){}
