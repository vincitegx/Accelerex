package com.neptunesoftware.accelerex.createCustomer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/v1/createNewCustomer")
@Log4j2
public class CreateBankController {

    private final CreateBankAccountService customerAccountService;

    @PostMapping("/createCustomer")
    public ResponseEntity<CreateCustomerResponse> createCustomer(@RequestBody CreateCustomerRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(customerAccountService.createCustomer(request));
    }
    @PostMapping("/createBankAccountForCustomer")
    public ResponseEntity<CreateAccountResponse> createAccount(@RequestBody DepositAccountRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(customerAccountService.createDepositAccount(request));
    }
}