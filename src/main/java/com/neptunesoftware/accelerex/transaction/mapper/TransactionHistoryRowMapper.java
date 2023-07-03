package com.neptunesoftware.accelerex.transaction.mapper;

import com.neptunesoftware.accelerex.transaction.TransactionType;
import com.neptunesoftware.accelerex.transaction.response.TransactionHistoryResponse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionHistoryRowMapper implements RowMapper<TransactionHistoryResponse> {
    private String senderAccountNumber;
    public TransactionHistoryRowMapper(String senderAccountNumber) {
        this.senderAccountNumber = senderAccountNumber;
    }
    @Override
    public TransactionHistoryResponse mapRow(ResultSet rs, int rowNum) throws SQLException {
        String fromAccountNumber = rs.getString("FROM_ACCT_NO");
        TransactionType transactionType = fromAccountNumber.equals(senderAccountNumber)
                ? TransactionType.DEBIT : TransactionType.CREDIT;
        return new TransactionHistoryResponse(
                rs.getString("REC_TS"),
                rs.getString("TRAN_REF"),
                rs.getString("TRAN_AMT"),
                rs.getString("NARRATION"),
                transactionType
        );
    }
}
