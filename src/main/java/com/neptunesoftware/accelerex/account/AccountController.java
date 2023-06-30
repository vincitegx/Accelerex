package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.InterBankTransferRequest;
import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.account.response.*;
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
           return ResponseEntity.status(HttpStatus.OK).body(accountServices.linkBankAccountToAgent(request));
       }
       

    @GetMapping("/accountBalance/{accountNumber}")
    public ResponseEntity<BalanceEnquiryResponse> BalanceEnquiry(@PathVariable("accountNumber") final String accountNumber) {
        log.info("Account balance for account number of {}", accountNumber );

        return ResponseEntity.status(HttpStatus.OK).body(accountServices.balanceEnquiry(accountNumber));
    }

    @GetMapping("/name/{accountNumber}")
    public ResponseEntity<ApiResponse<NameEnquiryResponse>> nameEnquiry(@PathVariable("accountNumber") final String accountNumber) {
        log.info("Name enquiry for account number of {}", accountNumber);

        return ResponseEntity.status(HttpStatus.OK).body(accountServices.nameEnquiry(accountNumber));
    }
    @GetMapping("account/{accountNumber}")
    public ResponseEntity<ExternalTransferNameEnquiryResponse>  interBankNameEnquiry(@PathVariable("accountNumber") final String accountNumber) {
          return ResponseEntity.status(HttpStatus.OK).body(accountServices.interBankNameEnquiry(accountNumber));
    }

    @GetMapping("account/{accountNumber}")
    public ResponseEntity<String>  intraBankNameEnquiry(@PathVariable("accountNumber") final String accountNumber) {
          return ResponseEntity.status(HttpStatus.OK).body(accountServices.intraBankNameEnquiry(accountNumber));
    }
    @PostMapping("/interBankTransfer")
    public ResponseEntity<InterBankTransferResponse> interBankTransfer(@RequestBody InterBankTransferRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(accountServices.interBankTransfer(request));
    }
}