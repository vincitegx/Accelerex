package com.neptunesoftware.accelerex.exception;

import com.neptunesoftware.accelerex.universal.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(FundTransferException.class)
    public final ResponseEntity<ApiResponse> handleFundTransferException(FundTransferException exception){
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TransactionNotFoundException.class)
    public final ResponseEntity<ApiResponse> handleTransactionNotFoundException(TransactionNotFoundException exception){
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ResourceNotFoundException.class)
    public final ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException exception){
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
//    @ExceptionHandler(UsernameNotFoundException.class)
//    public final ResponseEntity<ApiResponse> handleUsernameNotFoundException(UsernameNotFoundException exception){
//        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
//    }
    @ExceptionHandler(CustomerFailedException.class)
    public final ResponseEntity<ApiResponse> handleCustomerFailedException(CustomerFailedException exception){
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }
}
