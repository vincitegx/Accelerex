package com.neptunesoftware.accelerex.transaction.mapper;

import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponseStatus;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Log4j2
public class TransactionResponseRowMapper implements RowMapper<TransactionResponse> {
    @Override
    public TransactionResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        TransactionResponseStatus transactionResponseStatus = TransactionResponseStatus.SUCCESS;
        if(!rs.getString("RESPONSE_CD").equals("00")){
            transactionResponseStatus = TransactionResponseStatus.FAIL;
        }
        return new TransactionResponse(
                transactionResponseStatus,
                rs.getString("TRAN_REF")
        );
    }
}
