package com.neptunesoftware.accelerex.exception;

import com.neptunesoftware.accelerex.account.response.BalanceResponse;
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
    @ExceptionHandler(TransferException.class)
    public final ResponseEntity<ApiResponse> handleResourceNotFoundException(TransferException exception){
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(MissingParameterException.class)
    public final ResponseEntity<ApiResponse> handleResourceNotFoundException(MissingParameterException exception){
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccountExistException.class)
    public final ResponseEntity<ApiResponse> handleResourceNotFoundException(AccountExistException exception){
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomerFailedException.class)
    public final ResponseEntity<ApiResponse> handleCustomerFailedException(CustomerFailedException exception){
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BalanceEnquiryException.class)
    public final ResponseEntity<BalanceResponse> handleCustomerFailedException(BalanceEnquiryException exception){
        return new ResponseEntity<>(new BalanceResponse(null,null,null,exception.getResponseCode(),exception.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CustomException.class)
    public final ResponseEntity<ApiResponse> handleCustomException(CustomException exception){
        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
