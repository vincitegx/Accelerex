package com.neptunesoftware.accelerex.createCustomer;

import com.neptunesoftware.accelerex.account.request.NewCustomerAccountRequest;
import com.neptunesoftware.accelerex.account.response.CreateAccountResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vi/createNewCustomer")
@Log4j2
public class CreateCustomerAccountController {
    private final CreateCustomerAccountService customerAccountService;

    @PostMapping("createBankAccount")
    public ResponseEntity<CreateAccountResponse> createBankAccount(NewCustomerAccountRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(customerAccountService.creatNewCustomer(request));
    }
}
