package com.neptunesoftware.Accelerex.transaction.mapper;

import com.neptunesoftware.Accelerex.transaction.Transaction;
import com.neptunesoftware.Accelerex.transaction.TransactionStatus;
import com.neptunesoftware.Accelerex.transaction.response.TransactionResponseStatus;
import com.neptunesoftware.Accelerex.transaction.response.TransactionResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TransactionMapper implements Function<Transaction, TransactionResponse> {
    @Override
    public TransactionResponse apply(Transaction transaction) {
        TransactionResponseStatus transactionResponseStatuse;
        if(transaction.getStatus() == TransactionStatus.SUCCESS){
            transactionResponseStatuse = TransactionResponseStatus.SUCCESS;
        } else{
            transactionResponseStatuse = TransactionResponseStatus.FAIL;
        }
        return new TransactionResponse(
                transactionResponseStatuse, transaction.getReferenceNo(), transaction.getId()
        );
    }
}
