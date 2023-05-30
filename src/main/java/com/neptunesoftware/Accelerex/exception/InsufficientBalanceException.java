package com.neptunesoftware.Accelerex.exception;

public class InsufficientBalanceException extends RuntimeException{
    public InsufficientBalanceException(String message){
        super(message);
    }
}