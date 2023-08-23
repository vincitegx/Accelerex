package com.neptunesoftware.accelerex.customer.controller;

import com.neptunesoftware.accelerex.customer.request.CreateCustomerRequest;
import com.neptunesoftware.accelerex.customer.response.CreateCustomerResponse;
import com.neptunesoftware.accelerex.customer.service.CreateBankAccountService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/v1/customer")
@Tag(name = "Customer")

public class CreateCustomerAccountController {
    private final CreateBankAccountService customerAccountService;
    @PostMapping("create")
    public ResponseEntity<CreateCustomerResponse> createCustomer(@RequestBody CreateCustomerRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(customerAccountService.createCustomer(request));
    }
    
}