package com.neptunesoftware.accelerex.exception;

import lombok.Data;

@Data
public class CustomerFailedException extends RuntimeException {

    public CustomerFailedException(String message) {
        super(message);
    }
}
