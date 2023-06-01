package com.neptunesoftware.Accelerex.account;

import com.neptunesoftware.Accelerex.account.request.CreateBankAccountRequest;
import com.neptunesoftware.Accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.Accelerex.account.response.CreateBankAccountResponse;
import com.neptunesoftware.Accelerex.account.response.LinkBankAccountResponse;
import com.neptunesoftware.Accelerex.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vi/accountService")
public class BankAccountController {
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
    public ResponseEntity<String> verifySmsToken(String otp) {
        return ResponseEntity.ok(accountServices.verifySmsToken(otp));
       }
}
