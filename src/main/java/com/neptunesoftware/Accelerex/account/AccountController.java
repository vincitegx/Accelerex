package com.neptunesoftware.Accelerex.account;

import com.neptunesoftware.Accelerex.account.request.CreateBankAccountRequest;
import com.neptunesoftware.Accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.Accelerex.account.request.VirtualAccountRequest;
import com.neptunesoftware.Accelerex.account.response.CreateBankAccountResponse;
import com.neptunesoftware.Accelerex.account.response.LinkBankAccountResponse;
import com.neptunesoftware.Accelerex.account.response.VerifyTokenResponse;
import com.neptunesoftware.Accelerex.account.response.VirtualAccountResponse;
import com.neptunesoftware.Accelerex.utils.ApiResponse;
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
    public String getAccountBalance(@RequestParam("clientId") String clientId, @RequestParam("secretKey") String secretKey, @RequestParam("bankCode") String bankCode, @RequestParam("accountNo") String accountNo) {
        return null;
    } @GetMapping("/nameInquiry")
    public String nameInquiry(@RequestParam("clientId") String clientId, @RequestParam("secretKey") String secretKey, @RequestParam("bankCode") String bankCode, @RequestParam("accountNo") String accountNo) {
        return null;
    }
}
