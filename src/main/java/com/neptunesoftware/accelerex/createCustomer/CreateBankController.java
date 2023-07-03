package com.neptunesoftware.accelerex.createCustomer;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vi/createNewCustomer")
@Log4j2
public class CreateBankController {
    private final CreateBankAccountService customerAccountService;

    @PostMapping("createBankAccount")
    public ResponseEntity<CreateBankAccountResponse> createBankAccount(CreateBankAccountRequest request) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(customerAccountService.createCustomer(request));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
