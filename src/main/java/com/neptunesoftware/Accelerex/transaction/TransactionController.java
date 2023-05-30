package com.neptunesoftware.Accelerex.transaction;

import com.itextpdf.text.DocumentException;
import com.neptunesoftware.Accelerex.config.JWTService;
import com.neptunesoftware.Accelerex.transaction.request.BulkTransactionRequest;
import com.neptunesoftware.Accelerex.transaction.request.FundsTransferRequest;
import com.neptunesoftware.Accelerex.transaction.request.TransactionHistoryRequest;
import com.neptunesoftware.Accelerex.transaction.response.TransactionStatusResponse;
import com.neptunesoftware.Accelerex.universal.ApiResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.io.ByteArrayOutputStream;

import java.io.ByteArrayOutputStream;

@RestController
@RequestMapping("/api/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;
    private final JWTService jwtService;

    public TransactionController(TransactionService transactionService, JWTService jwtService) {
        this.transactionService = transactionService;
        this.jwtService = jwtService;
    }

    @PostMapping("/send-funds")
    public ResponseEntity<ApiResponse> transferFunds(@RequestBody @Validated FundsTransferRequest request){
        transactionService.transferFunds(request);
        return new ResponseEntity<>(new ApiResponse("funds transferred"), HttpStatus.OK);
    }

    @PostMapping("/bulk-transactions")
    public ResponseEntity<ApiResponse> postBulkTransactions(@RequestBody @Validated BulkTransactionRequest request) {
        transactionService.processBulkTransactions(request);
        return new ResponseEntity<>(new ApiResponse("Bulk transactions processed"), HttpStatus.OK);
    }

    @GetMapping("/transaction-status")
    public ResponseEntity<?> getTransactionStatus(@RequestParam String externalRefNo, @RequestParam String clientId) {
        TransactionStatusResponse status = transactionService.getTransactionStatus(externalRefNo, clientId);
        if (status != null) {
            // Build the response object with the required fields
            TransactionStatusResponse response = new TransactionStatusResponse(status.getResponseCode(), status.getResponseMessage(),
                    status.getCoreBankingRefNo(), status.getTransactionId());
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new ApiResponse("Transaction not found"), HttpStatus.NOT_FOUND);
        }
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
    public ResponseEntity<ApiResponse> generateTransactionHistory(@RequestHeader("Authorization") String jwt,
                                                                  @RequestParam int size,
                                                                  @RequestParam int page,
                                                                  @RequestBody @Validated TransactionHistoryRequest request) {
        Pageable pageable = PageRequest.of(page, size);
        return new ResponseEntity<>(new ApiResponse("transaction history",
                transactionService.getTransactionHistoryByUserId(request,jwtService.extractUserIdFromToken(jwt),pageable)),
                HttpStatus.OK);
    }

    /**
     * This controller generates monthly or yearly account statement in pdf format
     */
    @PostMapping(value = "/transaction-report", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generateTransactionStatement(
            @RequestHeader("Authorization") String jwt,
            @RequestBody TransactionHistoryRequest request) throws DocumentException {

        int userId = jwtService.extractUserIdFromToken(jwt);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(
                ContentDisposition.builder("inline")
                        .filename("transaction_report.pdf")
                        .build()
        );

        ByteArrayOutputStream outputStream = transactionService.generateTransactionStatement(
                request,userId
        );


        return new ResponseEntity<>(outputStream.toByteArray(), headers, HttpStatus.OK);
    }
}
