package com.neptunesoftware.accelerex.transaction;

import com.neptunesoftware.accelerex.exception.FundTransferException;
import com.neptunesoftware.accelerex.exception.TransactionNotFoundException;
import com.neptunesoftware.accelerex.transaction.mapper.TransactionHistoryRowMapper;
import com.neptunesoftware.accelerex.transaction.mapper.TransactionResponseRowMapper;
import com.neptunesoftware.accelerex.transaction.response.TransactionHistoryResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@AllArgsConstructor
@Slf4j
public class TransactionRepository {
    private final JdbcTemplate jdbcTemplate;

    TransactionResponse findByClientIdAndReferenceNo(String clientId, String referenceNo){
        try {
            TransactionResponse transactionResponse = jdbcTemplate.query(SqlQueries.TRANSACTION_STATUS_QUERY, new TransactionResponseRowMapper(),clientId, referenceNo).stream().findFirst().get();
            return transactionResponse;
        } catch (Exception e) {
            throw new TransactionNotFoundException("Unable to load transaction status");
        }
    }
    List<TransactionHistoryResponse> findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
            LocalDateTime startDate,LocalDateTime endDate, String senderAccountNumber, String receiverAccountNumber
    ){
        try {
            return jdbcTemplate.query(SqlQueries.TRANSACTION_HISTORY_QUERY, new TransactionHistoryRowMapper(), startDate, endDate, senderAccountNumber, receiverAccountNumber);
        } catch (Exception e) {
            throw new TransactionNotFoundException("Unable to load account history" + " for account ");
        }
    }
    public int saveTransaction(TransactionDetails details) {
        try {
            return jdbcTemplate.update(SqlQueries.INSERT_TRANSACTION, details.getTranRef(),
                    details.getCustomerNo(), details.getFromAccountNumber(), details.getToAccountNumber(),
                    details.getAmount(), details.getNarration(),
                    details.getSubTranRef(), details.getResponseCode());
        } catch (DataAccessException e) {
            log.error("Error saving transaction to the database");
            log.error(e.getMessage());
            throw new FundTransferException("Error saving transaction to the database");
        }
    }
    public boolean existsByReferenceNo(String referenceNo) {
        return jdbcTemplate.queryForObject(SqlQueries.REFERENCE_NO_QUERY, new Object[]{referenceNo}, Boolean.class);
    }
}

