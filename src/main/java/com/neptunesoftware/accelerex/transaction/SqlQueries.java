package com.neptunesoftware.accelerex.transaction;

public class SqlQueries {
    static final String TRANSACTION_HISTORY_QUERY = """
            SELECT REC_TS, FROM_ACCT_NO, NARRATION, TRAN_AMT, FROM_ACCT_NO
            FROM ALT_AGENCY_MB WHERE (FROM_ACCT_NO = ? OR TO_ACCT_NO = ?)
             AND REC_TS >= TIMESTAMP ? AND REC_TS <= TIMESTAMP ?;
            """;
    static final String TRANSACTION_STATUS_QUERY = """
            SELECT RESPONSE_CD, TRAN_REF FROM ALT_AGENCY_MB WHERE CUST_NO = ? AND TRAN_REF = ?
            """;
    static final String INSERT_TRANSACTION = """
            INSERT INTO ALT_AGENCY_MB (TRAN_REF, CUST_NO, FROM_ACCT_NO, TO_ACCT_NO, TRAN_AMT, NARRATION, SUB_TRAN_REF, RESPONSE_CD)
                                   VALUES (?, ?, ?, ?, ?, ?, ?, ?);
            """;
    static final String REFERENCE_NO_QUERY = """
            SELECT CASE WHEN COUNT(*) > 0 THEN 1 ELSE 0 END AS exists_tran_ref
            FROM ALT_AGENCY_MB
            WHERE TRAN_REF = ?;
            """;
    private SqlQueries() {}
}
