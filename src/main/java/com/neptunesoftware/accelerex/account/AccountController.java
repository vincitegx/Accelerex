package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.CreateAccountRequest;
import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.createNewCustomer.CreateCustomerAccountService;
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
       private final CreateCustomerAccountService customerAccountService;
    @PostMapping("/linkBankAccountToAgent")
       public ResponseEntity<ApiResponse<LinkBankAccountResponse>> linkingBankAccountToExistingProfile(@RequestBody LinkBankAccountRequest request) {
           return ResponseEntity.status(HttpStatus.OK).body(accountServices.linkBankAccountToAgent(request));
       }

    @PostMapping("/verifySmsToken")
    public ResponseEntity<VerifyTokenResponse> verifySmsToken(String otp) {
        return ResponseEntity.status(HttpStatus.OK).body(accountServices.verifySmsToken(otp));
       }

    @GetMapping("/accountBalance/{accountNumber}")
    public ResponseEntity<BalanceenquiryResponse> fetchAccountBalance(@PathVariable("accountNumber") final String accountNumber) {
        log.info("Account balance for account number of {}", accountNumber );

        return ResponseEntity.status(HttpStatus.OK).body(accountServices.fetchAccountBalance(accountNumber));
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

    @PostMapping("createBankAccount")
    public ResponseEntity<CreateAccountResponse> createBankAccount(CreateAccountRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(customerAccountService.creatNewCustomer(request));
    }
}