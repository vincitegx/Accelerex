package com.neptunesoftware.accelerex.transaction;

import com.neptunesoftware.accelerex.transaction.request.BulkTransactionRequest;
import com.neptunesoftware.accelerex.transaction.request.TransactionHistoryRequest;
import com.neptunesoftware.accelerex.transaction.request.TransactionRequest;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import com.neptunesoftware.accelerex.universal.ApiResponse;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/v1/transactions")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Transaction")
public class TransactionController {
    private final TransactionService transactionService;
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/send-funds")
    public ResponseEntity<TransactionResponse> transferFunds(@RequestBody @Validated TransactionRequest request){
        TransactionResponse response = transactionService.transferFunds(request);
        HttpStatus status;
        if(Objects.equals(response.getResponse().getDescription(), "SUCCESS")) status = HttpStatus.OK;
        else status = HttpStatus.EXPECTATION_FAILED;
        return new ResponseEntity<>(response, status);
    }
    @PostMapping("/bulk-transactions")
    @Hidden
    public ResponseEntity<ApiResponse> postBulkTransactions(@RequestBody @Validated BulkTransactionRequest request) {
        transactionService.processBulkTransactions(request);
        return new ResponseEntity<>(new ApiResponse("Bulk transactions processed"), HttpStatus.OK);
    }
    @GetMapping("/transaction-status")
    public ResponseEntity<TransactionResponse> getTransactionStatus(@RequestParam String externalRefNo, @RequestParam String clientId) {
        TransactionResponse status = transactionService.getTransactionStatus(externalRefNo, clientId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }
    @PostMapping("/reverse-transaction")
    public ResponseEntity<ApiResponse> reverseTransaction(@RequestParam String externalRefNo) {
        transactionService.reverseTransaction(externalRefNo);
        return new ResponseEntity<>(new ApiResponse("Transaction reversed"), HttpStatus.OK);
    }
    @PostMapping("/transaction-history")
    public ResponseEntity<ApiResponse> generateTransactionHistory(@RequestParam int size,
                                                                  @RequestParam int page,
                                                                  @RequestBody @Validated TransactionHistoryRequest request) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(new ApiResponse("transaction history",
                transactionService.getTransactionHistory(request,pageable)),
                HttpStatus.OK);
    }
}
