package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.*;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.data.account.BalanceenquiryResponse;
import com.neptunesoftware.accelerex.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vi/accountService")
@Log4j2
public class AccountController {
       private final AccountServices accountServices;
    @PostMapping("/linkBankAccountToAgent")
       public ResponseEntity<ApiResponse<LinkBankAccountResponse>> linkingBankAccountToExistingProfile(@RequestBody LinkBankAccountRequest request) {
           return ResponseEntity.ok(accountServices.linkBankAccountToAgent(request));
       }

    @PostMapping("/createBankAccount")
    public ResponseEntity<ApiResponse<CreateBankAccountResponse>> createBankAccount(@RequestBody CreateBankAccountRequest request) {
        return ResponseEntity.ok(accountServices.createBankAccount(request));
    }

    @PostMapping("/verifySmsToken")
    public ResponseEntity<VerifyTokenResponse> verifySmsToken(String otp) {
        return ResponseEntity.ok(accountServices.verifySmsToken(otp));
       }
       @PostMapping("/createVirtualAccount")
    public ResponseEntity<ApiResponse<VirtualAccountResponse>> createVirtualAccount(VirtualAccountRequest request) {
//        return ResponseEntity.ok(accountServices.createVirtualAccount(request));
        return null;
       }

    @GetMapping("/accountBalance/{accountNumber}")
    public ResponseEntity<BalanceenquiryResponse> getAccountBalance(@PathVariable("accountNumber") final String accountNumber) {
        log.info("Account balance for account number of {}", accountNumber );

        return ResponseEntity.status(HttpStatus.OK).body(accountServices.fetchAccountBalance(accountNumber));
    }

    @GetMapping("/name/{accountNumber}")
    public ResponseEntity<ApiResponse<NameEnquiryResponse>> NameEnquiry(@PathVariable("accountNumber") final String accountNumber) {
        log.info("Name enquiry for account number of {}", accountNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountServices.nameEnquiry(accountNumber));
    }
}
