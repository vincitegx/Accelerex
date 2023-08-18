package com.neptunesoftware.accelerex.account.exception;

import org.springframework.ws.client.WebServiceIOException;

public class BalanceEnquiryException extends RuntimeException{
    public BalanceEnquiryException() {
    }
    public BalanceEnquiryException(String message) {
        super(message);
    }

    public BalanceEnquiryException(String s, Exception e) {
    }
}
