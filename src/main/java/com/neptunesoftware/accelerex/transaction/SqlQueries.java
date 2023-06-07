package com.neptunesoftware.accelerex.transaction;

public class SqlQueries {
    static final String TRANSACTION_AMOUNT_IN_ONE_DAY = """
            SELECT SUM(TRAN_AMOUNT) FROM  ALT_AGENCY_MB WHERE FROM_ACCT_NO = ? OR TO_ACCT_NO = ? and SYSTEM_TS between trunc(sysdate)
                And trunc(sysdate) + interval '1' day - interval '1' second
            """;

    private SqlQueries() {

    }
}
