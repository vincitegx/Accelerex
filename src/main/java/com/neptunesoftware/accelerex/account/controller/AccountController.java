package com.neptunesoftware.accelerex.account.controller;

import com.neptunesoftware.accelerex.account.request.DepositToGlRequest;
import com.neptunesoftware.accelerex.account.request.InterBankTransferRequest;
import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.account.service.AccountServices;
import com.neptunesoftware.accelerex.utils.ApiResponse;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v3/accounts")
@Log4j2
@Tag(name = "Account")
public class AccountController {
       private final AccountServices accountServices;

    @PostMapping("linkBankAccountToAgent")
    @Hidden
       public ResponseEntity<ApiResponse<LinkBankAccountResponse>> linkingBankAccountToExistingProfile(@RequestBody LinkBankAccountRequest request) {
           return ResponseEntity.status(HttpStatus.OK).body(accountServices.linkBankAccountToAgent(request));
       }
    @GetMapping("intraBankBalanceEnquiry/{accountNumber}")
    public ResponseEntity<BalanceResponse> intraBankBalanceEnquiry(@PathVariable ("accountNumber") final String accountNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(accountServices.intraBankBalanceEnquiry(accountNumber));
    }
    @GetMapping("intraBankNameEnquiry/{accountNumber}")
    public ResponseEntity<NameEnquiryResponse> intraBankNameEnquiry(@PathVariable("accountNumber") final String accountNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(accountServices.IntraBankNameEnquiry(accountNumber));
    }
    @GetMapping("interBankNameEnquiry/{accountNumber}")
    public ResponseEntity<ExternalTransferNameEnquiryResponse>  interBankNameEnquiry(@PathVariable("accountNumber") final String accountNumber) {
          return ResponseEntity.status(HttpStatus.OK).body(accountServices.interBankNameEnquiry(accountNumber));
    }
    @PostMapping("interBankTransfer")
    public ResponseEntity<InterBankTransferResponse> interBankTransfer(@RequestBody InterBankTransferRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(accountServices.interBankTransfer(request));
    }

    @PostMapping("depositToGLAccount")
    @Hidden
    public ResponseEntity<DepositToGLResponse> depositToGL(@RequestBody DepositToGlRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(accountServices.depositToGL(request));
    }
    @GetMapping("accountExist/{accountNumber}")
//    @Hidden
    public ResponseEntity<Boolean>  accountExist(@PathVariable("accountNumber") final String accountNumber) {
        return ResponseEntity.status(HttpStatus.OK).body(accountServices.existedByAccount(accountNumber));
    }
}