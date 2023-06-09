package com.neptunesoftware.accelerex.exception;

public class AccountNotExistException extends RuntimeException{
    private String message;
    public AccountNotExistException() {
        super();
        this.message = "Validation failed";
    }
    public AccountNotExistException(String msg) {
        super(msg);
        this.message = msg;
    }
}
