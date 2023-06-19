package com.neptunesoftware.accelerex.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

//    @ExceptionHandler(ResourceExistsException.class)
//    public final ResponseEntity<ApiResponse> handleResourceExistsException(ResourceExistsException exception){
//        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.CONFLICT);
//    }
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public final ResponseEntity<ApiResponse<N>> handleResourceNotFoundException(ResourceNotFoundException exception){
//        return new ResponseEntity<>(new ApiResponse<N>(exception.getMessage()), HttpStatus.NOT_FOUND);
//    }

//    @ExceptionHandler(AccountNotActivatedException.class)
//    public final ResponseEntity<ApiResponse> handleAccountNotActivatedException(AccountNotActivatedException exception){
//        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.FORBIDDEN);
//    }
//    @ExceptionHandler(AccountNotClearedException.class)
//    public final ResponseEntity<ApiResponse> handleAccountNotClearedException(AccountNotClearedException exception){
//        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.NOT_ACCEPTABLE);
//    }
//    @ExceptionHandler(InsufficientBalanceException.class)
//    public final ResponseEntity<ApiResponse> handleInsufficientBalanceException(InsufficientBalanceException exception){
//        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.BAD_REQUEST);
//    }
//    @ExceptionHandler(InvalidAuthenticationException.class)
//    public final ResponseEntity<ApiResponse> handleInvalidAuthenticationException(InvalidAuthenticationException exception){
//        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.UNAUTHORIZED);
//    }
//    @ExceptionHandler(InvalidAuthorizationException.class)
//    public final ResponseEntity<ApiResponse> handleInvalidAuthorizationException(InvalidAuthorizationException exception){
//        return new ResponseEntity<>(new ApiResponse(exception.getMessage()), HttpStatus.UNAUTHORIZED);
//    }
//    @ExceptionHandler(ValueMismatchException.class)
//    public final ResponseEntity<ApiResponse<N>> handleValueMismatchException(ValueMismatchException exception){
//        return new ResponseEntity<>(new ApiResponse<N>(exception.getMessage()), HttpStatus.BAD_REQUEST);
//    }
}
