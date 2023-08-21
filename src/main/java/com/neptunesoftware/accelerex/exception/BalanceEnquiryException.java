package com.neptunesoftware.accelerex.exception;

import lombok.Data;

@Data
public class BalanceEnquiryException extends RuntimeException{
    private String responseCode;
    private String message;
    public BalanceEnquiryException(String message){
        super(message);
    } public BalanceEnquiryException(String responseCode,String message ){
        this.message = message;
        this.responseCode = responseCode;
    }
}
