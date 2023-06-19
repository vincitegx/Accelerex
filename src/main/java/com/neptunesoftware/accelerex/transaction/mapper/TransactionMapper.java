package com.neptunesoftware.accelerex.transaction.mapper;

import com.neptunesoftware.accelerex.data.fundstransfer.CustomerToCustomerTransferResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponseStatus;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class TransactionMapper implements Function<CustomerToCustomerTransferResponse, TransactionResponse> {
    @Override
    public TransactionResponse apply(CustomerToCustomerTransferResponse response) {
        TransactionResponseStatus transactionResponseStatus;
        if(response.getReturn().getResponseCode() == "0"){
            transactionResponseStatus = TransactionResponseStatus.SUCCESS;
        } else{
            transactionResponseStatus = TransactionResponseStatus.FAIL;
        }
        return new TransactionResponse(
                transactionResponseStatus, response.getReturn().getTxnReference()
        );
    }
}
