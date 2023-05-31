package com.neptunesoftware.Accelerex.transaction;

import com.neptunesoftware.Accelerex.transaction.request.BulkTransactionRequest;
import com.neptunesoftware.Accelerex.transaction.request.TransactionHistoryRequest;
import com.neptunesoftware.Accelerex.transaction.request.TransactionRequest;
import com.neptunesoftware.Accelerex.transaction.response.TransactionStatusResponse;
import com.neptunesoftware.Accelerex.universal.ApiResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/send-funds")
    public ResponseEntity<TransactionStatusResponse> transferFunds(@RequestBody @Validated TransactionRequest request){
        TransactionStatusResponse response = transactionService.transferFunds(request);
        HttpStatus status;
        if(response.getResponse().getDescription() == "SUCCESS") status = HttpStatus.OK;
        else status = HttpStatus.EXPECTATION_FAILED;
        return new ResponseEntity<>(response, status);
    }

    @PostMapping("/bulk-transactions")
    public ResponseEntity<ApiResponse> postBulkTransactions(@RequestBody @Validated BulkTransactionRequest request) {
        transactionService.processBulkTransactions(request);
        return new ResponseEntity<>(new ApiResponse("Bulk transactions processed"), HttpStatus.OK);
    }

    @GetMapping("/transaction-status")
    public ResponseEntity<TransactionStatusResponse> getTransactionStatus(@RequestParam String externalRefNo, @RequestParam String clientId) {
        TransactionStatusResponse status = transactionService.getTransactionStatus(externalRefNo, clientId);
        return new ResponseEntity<>(status, HttpStatus.OK);
    }

    @PostMapping("/reverse-transaction")
    public ResponseEntity<ApiResponse> reverseTransaction(@RequestParam String externalRefNo) {
        transactionService.reverseTransaction(externalRefNo);
        return new ResponseEntity<>(new ApiResponse("Transaction reversed"), HttpStatus.OK);
    }
    /**
     * This controller fetches all transaction based on a range of date and also implements pagination to help reduce load time
     */
    @PostMapping()
    public ResponseEntity<ApiResponse> generateTransactionHistory(@RequestParam int size,
                                                                  @RequestParam int page,
                                                                  @RequestBody @Validated TransactionHistoryRequest request) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(new ApiResponse("transaction history",
                transactionService.getTransactionHistory(request,pageable)),
                HttpStatus.OK);
    }
}
