package com.neptunesoftware.Accelerex.exception;

import lombok.Data;

public class ValidationException extends RuntimeException {

    private String message;

    public ValidationException() {
        super();
        this.message = "Validation failed";
    }
    public ValidationException(String msg) {
        super(msg);
        this.message = msg;
    }
}
