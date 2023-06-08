package com.neptunesoftware.accelerex.transaction;
import com.neptunesoftware.accelerex.exception.TransactionNotFoundException;
import com.neptunesoftware.accelerex.transaction.mapper.TransactionHistoryRowMapper;
import com.neptunesoftware.accelerex.transaction.mapper.TransactionMapper;
import com.neptunesoftware.accelerex.transaction.mapper.TransactionResponseRowMapper;
import com.neptunesoftware.accelerex.transaction.response.TransactionHistoryResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
@AllArgsConstructor
public class TransactionRepository {
    private final JdbcTemplate jdbcTemplate;
    public static final String TRANSACTION_HISTORY_QUERY = """
            select  *  FROM (select T3.REF_DESC, T1.tran_desc, T1.txn_amt, T1.stmnt_bal,
                   to_char(T1.sys_create_ts,'dd-MON-yyyy') as DATE_DESC ,T1.DR_CR_IND, T1.TRAN_REF_TXT
            from deposit_account_history T1 join ACCOUNT T2 on T1.acct_no = T2.acct_no
                                            left join PRODUCT_CATEGORY_REF T3 on T3.REF_KEY = T2.PROD_CAT_TY
            where t1.acct_no = ?
            order by T1.ROW_TS desc) where ROWNUM<= 5
            """;

    public static final String TRANSACTION_STATUS_QUERY = """
            select  *  FROM (select T3.REF_DESC, T1.tran_desc, T1.txn_amt, T1.stmnt_bal,
                   to_char(T1.sys_create_ts,'dd-MON-yyyy') as DATE_DESC ,T1.DR_CR_IND, T1.TRAN_REF_TXT
            from deposit_account_history T1 join ACCOUNT T2 on T1.acct_no = T2.acct_no
                                            left join PRODUCT_CATEGORY_REF T3 on T3.REF_KEY = T2.PROD_CAT_TY
            where t1.acct_no = ?
            order by T1.ROW_TS desc) where ROWNUM<= 5
            """;
    public boolean existsByReferenceNo(String referenceNo){
        return true;
    }
//    Optional<Transaction> findByReferenceNo(String referenceNo);
    TransactionResponse findByUserAndReferenceNo(String clientId, String referenceNo){
        try {
            TransactionResponse transactionResponse = jdbcTemplate.query(TRANSACTION_STATUS_QUERY, new TransactionResponseRowMapper(),clientId, referenceNo).stream().findFirst().get();
            return transactionResponse;
        } catch (Exception e) {
            throw new TransactionNotFoundException("Unable to load account history" + " for account ");
        }
    }
    List<TransactionHistoryResponse> findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
            LocalDateTime startDate,LocalDateTime endDate, String senderAccountNumber, String receiverAccountNumber
    ){
        try {
            List<TransactionHistoryResponse> transactionHistoryResponses = jdbcTemplate.query(TRANSACTION_HISTORY_QUERY, new TransactionHistoryRowMapper(), senderAccountNumber, receiverAccountNumber);
            return transactionHistoryResponses;
        } catch (Exception e) {
            throw new TransactionNotFoundException("Unable to load account history" + " for account ");
        }
    }
}

