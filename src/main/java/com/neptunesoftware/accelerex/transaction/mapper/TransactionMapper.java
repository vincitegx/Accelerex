package com.neptunesoftware.accelerex.transaction.mapper;

import com.neptunesoftware.accelerex.transaction.Transaction;
import com.neptunesoftware.accelerex.transaction.TransactionStatus;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponseStatus;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TransactionMapper implements Function<Transaction, TransactionResponse> {
    @Override
    public TransactionResponse apply(Transaction transaction) {
        TransactionResponseStatus transactionResponseStatus;
        if(transaction.getStatus() == TransactionStatus.SUCCESS){
            transactionResponseStatus = TransactionResponseStatus.SUCCESS;
        } else{
            transactionResponseStatus = TransactionResponseStatus.FAIL;
        }
        return new TransactionResponse(
                transactionResponseStatus, transaction.getReferenceNo(), transaction.getId()
        );
    }
}
