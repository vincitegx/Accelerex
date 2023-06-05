package com.neptunesoftware.accelerex.transaction.response;

public enum TransactionResponseStatus {
    SUCCESS("SUCCESS", 0),
    FAIL("FAIL", -1);
    private final String description;
    private final int code;

    TransactionResponseStatus(String description, int code) {
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
