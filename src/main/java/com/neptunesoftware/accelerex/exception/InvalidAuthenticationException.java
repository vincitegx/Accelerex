package com.neptunesoftware.accelerex.exception;

public class InvalidAuthenticationException extends RuntimeException{

    public InvalidAuthenticationException(String message) {
        super(message);
    }
}