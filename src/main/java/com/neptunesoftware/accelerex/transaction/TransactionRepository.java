package com.neptunesoftware.accelerex.transaction;

import com.neptunesoftware.accelerex.exception.FundTransferException;
import com.neptunesoftware.accelerex.exception.TransactionNotFoundException;
import com.neptunesoftware.accelerex.transaction.mapper.TransactionHistoryRowMapper;
import com.neptunesoftware.accelerex.transaction.mapper.TransactionResponseRowMapper;
import com.neptunesoftware.accelerex.transaction.response.TransactionHistoryResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
@AllArgsConstructor
@Log4j2
public class TransactionRepository {
    private final JdbcTemplate jdbcTemplate;

    TransactionResponse findByClientIdAndReferenceNo(String clientId, String referenceNo){
        try {
            Optional<TransactionResponse> transactionResponse = jdbcTemplate.query(SqlQueries.TRANSACTION_STATUS_QUERY, new TransactionResponseRowMapper(),clientId, referenceNo).stream().findFirst();
            if (transactionResponse.isPresent()) {
                return transactionResponse.get();
            } else {
                return null;
            }
        } catch (Exception e) {
            throw new TransactionNotFoundException("Unable to load transaction status");
        }
    }
    List<TransactionHistoryResponse> findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
            String startDate,String endDate, String senderAccountNumber, String receiverAccountNumber
    ){
        try {
            TransactionHistoryRowMapper rowMapper = new TransactionHistoryRowMapper(senderAccountNumber);
            return jdbcTemplate.query(SqlQueries.TRANSACTION_HISTORY_QUERY, rowMapper, senderAccountNumber, receiverAccountNumber, startDate, endDate);
        } catch (Exception e) {
            throw new TransactionNotFoundException(e.getMessage());
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
        int exists = jdbcTemplate.queryForObject(SqlQueries.REFERENCE_NO_QUERY, new Object[]{referenceNo}, Integer.class);
        return exists == 1;
    }
}

