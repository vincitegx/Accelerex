package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.CreateBankAccountRequest;
import com.neptunesoftware.accelerex.account.request.FetchAccountBalanceRequest;
import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.account.request.VirtualAccountRequest;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vi/accountService")
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

    @GetMapping("/accountBalance")
    public ResponseEntity<ApiResponse<FetchAccountBalanceResponse>> getAccountBalance(@RequestBody FetchAccountBalanceRequest request) {
        return ResponseEntity.ok(accountServices.fetchAccountBalance(request));
    }
    @GetMapping("/nameInquiry")
    public ResponseEntity<String> nameInquiry(@RequestParam("clientId") String clientId, @RequestParam("secretKey") String secretKey, @RequestParam("bankCode") String bankCode, @RequestParam("accountNo") String accountNo) {
        return null;
    }
}
