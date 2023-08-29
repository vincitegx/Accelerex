package com.neptunesoftware.accelerex.exception;

public class AccountExistException extends RuntimeException {
    public AccountExistException(String message) {
        super(message);
    }
}
