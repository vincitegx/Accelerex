package com.neptunesoftware.accelerex.transaction;

public class SqlQueries {
    static final String TRANSACTION_AMOUNT_IN_ONE_DAY = """
            SELECT SUM(TRAN_AMOUNT) FROM  ALT_AGENCY_MB WHERE FROM_ACCT_NO = ? OR TO_ACCT_NO = ? and SYSTEM_TS between trunc(sysdate)
                And trunc(sysdate) + interval '1' day - interval '1' second
            """;
    static final String TRANSACTION_HISTORY_QUERY = """
            SELECT ALT_AGENCY_MB.REF_DESC, ALT_AGENCY_MB.NARRATION,ALT_AGENCY_MB.TRAN_AMT, ALT_AGENCY_MB.FROM_ACCT_NO
            FROM ALT_AGENCY_MB WHERE ALT_AGENCY_MB.FROM_ACCOUNT_NO = ? OR ALT_AGENCY_MB.TO_ACCOUNT_NO = ?
            AND ALT_AGENCY_MB.REC_TS >= ? AND ALT_AGENCY_MB.REC_TS <= ?
            """;
    static final String TRANSACTION_STATUS_QUERY = """
            SELECT ALT_AGENCY_MB.RESPONSE_CD, ALT_AGENCY_MB.TRAN_REF FROM ALT_AGENCY_MB WHERE ALT_AGENCY_MB.CUST_NO = ? AND ALT_AGENCY_MB.TRAN_REF = ?
            """;
    static final String INSERT_TRANSACTION = """
            INSERT INTO ALT_AGENCY_MB(TRAN_REF, CUST_NO, FROM_ACCT_NO, TO_ACCT_NO, TRAN_AMOUNT, NARRATION, SUB_TRAN_REF, RESPONSE_CD)
            VALUES(?,?,?,?,?,?,?,?)
            """;
    static final String REFERENCE_NO_QUERY = "SELECT EXISTS(SELECT 1 FROM ALT_AGENCY_MB WHERE TRAN_REF = ?)";
    private SqlQueries() {}
}
