package com.neptunesoftware.Accelerex.transaction.response;

public enum TransactionResponse {
    SUCCESS("SUCCESS", 00),
    FAIL("FAIL", -1);

    private final String description;
    private final int code;

    TransactionResponse(String description, int code) {
        this.description = description;
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public int getCode() {
        return code;
    }
}
