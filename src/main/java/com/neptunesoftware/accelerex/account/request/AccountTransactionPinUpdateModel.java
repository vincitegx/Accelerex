package com.neptunesoftware.accelerex.account.request;

import lombok.NonNull;

public record AccountTransactionPinUpdateModel(
        @NonNull
        String transactionPin
) {
}
