package com.neptunesoftware.Accelerex.account.request;

import lombok.NonNull;

public record AccountTransactionPinUpdateModel(
        @NonNull
        String transactionPin
) {
}
