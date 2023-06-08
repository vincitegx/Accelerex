package com.neptunesoftware.accelerex.transaction.mapper;

import com.neptunesoftware.accelerex.transaction.response.TransactionHistoryResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionHistoryRowMapper implements RowMapper<TransactionHistoryResponse> {
    @Override
    public TransactionHistoryResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new TransactionHistoryResponse(
                rs.getString("REC_TS"),
                rs.getString("TRAN_AMT"),
                rs.getString("SUB_TRAN_REF"),
                rs.getString(""),
                rs.getString(""),
                rs.getString("NARRATION")
        );
    }
}
