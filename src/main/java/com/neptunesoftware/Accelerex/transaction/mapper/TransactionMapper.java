package com.neptunesoftware.Accelerex.transaction.mapper;

import com.neptunesoftware.Accelerex.transaction.Transaction;
import com.neptunesoftware.Accelerex.transaction.TransactionStatus;
import com.neptunesoftware.Accelerex.transaction.response.TransactionResponse;
import com.neptunesoftware.Accelerex.transaction.response.TransactionStatusResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TransactionMapper implements Function<Transaction, TransactionStatusResponse> {
    @Override
    public TransactionStatusResponse apply(Transaction transaction) {
        TransactionResponse transactionResponse;
        if(transaction.getStatus() == TransactionStatus.SUCCESS){
            transactionResponse = TransactionResponse.SUCCESS;
        } else{
            transactionResponse = TransactionResponse.FAIL;
        }
        return new TransactionStatusResponse(
                transactionResponse, transaction.getReferenceNo(), transaction.getId()
        );
    }
}
