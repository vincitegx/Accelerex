package com.neptunesoftware.accelerex.transaction.mapper;

import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponseStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionResponseRowMapper implements RowMapper<TransactionResponse> {
    @Override
    public TransactionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        TransactionResponseStatus transactionResponseStatus = TransactionResponseStatus.SUCCESS;
        if(rs.getString("RESPONSE_CD") != "0"){
            transactionResponseStatus = TransactionResponseStatus.FAIL;
        }
        return new TransactionResponse(
                transactionResponseStatus,
                rs.getString("TRAN_REF")
        );
    }
}
