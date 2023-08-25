package com.neptunesoftware.accelerex.account.sql;

public final class SqlQueries {

    public  static final String UPDATE_CUSTOMER_STATUS = """
            UPDATE CUSTOMER SET REC_ST = 'A'  WHERE CUST_NO = ?
            """;
    public  static final String INSERT_IMAGE = """
            UPDATE CUSTOMER_IMAGE SET BINARY_IMAGE = ? WHERE CUST_ID = ?
            """;
    public static final String SELECT_USER_BY_PHONE_NUMBER = """
             SELECT * FROM ALT_AGENCY_PPS_USERS
                     WHERE PHONE_NUMBER = ?
            """;
    public static final String SELECT_USER_BY_PHONE_NUMBER_EMAIL_DOB = """
            SELECT * FROM ALT_AGENCY_PPS_USERS
            WHERE PHONE_NUMBER = ? AND DATE_OF_BIRTH = ?  AND AGENT_EMAIL = ?
                  
            """;
    public static final String SELECT_USER_BY_PHONE_AND_ACCOUNT_NUMBER = """
            SELECT * FROM ALT_AGENCY_PPS_USERS
            WHERE PHONE_NUMBER = ? AND PRIMARY_ACCOUNT_NUMBER = ?
                  
            """;
    public static final String SAVE_REGISTRATION_DETAILS = """
            INSERT INTO ALT_AGENCY_PPS_USERS (USERNAME,AGENT_NAME,AGENT_EMAIL,PHONE_NUMBER,DATE_OF_BIRTH,PRIMARY_ACCOUNT_NUMBER)
             VALUES(?,?,?,?,?,?)
            """ ;
    public static final String LINK_DETAILS_AGENT_DETAILS = """
             INSERT INTO ALT_AGENCY_PPS_USERS (USERNAME,AGENT_NAME,AGENT_EMAIL,PHONE_NUMBER,PRIMARY_ACCOUNT_NUMBER)
             VALUES(?,?,?,?,?,?)
            """ ;

    public static final String FIND_AGENT_DETAILS_WITH_ACCOUNT_NUMBER = """
            SELECT DISTINCT
                T1.CUST_NM,
                T1.CUST_NO,
                (SELECT cm.contact FROM customer_contact_mode cm\s
                 WHERE cm.cust_id = T1.cust_id\s
                   AND contact_mode_id IN (201, 301, 323, 322)\s
                   AND ROWNUM = 1) EMAIL,
                (SELECT c.contact FROM customer_contact_mode c
                 WHERE c.cust_id = T1.cust_id\s
                   AND contact_mode_id IN (206, 204, 203)\s
                   AND ROWNUM = 1) PHONE_NUMBER,
                A1.BIRTH_DT,
                T2.ACCT_NO,
                Y.IDENT_NO BVN,
                1 KYC
            FROM
                CUSTOMER T1,
                ACCOUNT T2,
                PERSON A1,
                (SELECT Q.IDENT_NO, Q.CUST_ID\s
                 FROM CUSTOMER_IDENTIFICATION Q, CUSTOMER_IDENTIFICATION_XREF QA
                 WHERE Q.CUST_IDENT_ID = QA.CUST_IDENT_XREF_ID \s
                   AND LENGTH(Q.IDENT_NO) = 11) Y	
            WHERE
                T1.CUST_ID = T2.CUST_ID
                AND T2.PROD_CAT_TY = 'DP' 				\s
                AND T2.REC_ST = 'A'
                AND T1.CUST_ID = A1.CUST_ID(+)
                AND T1.CUST_ID = Y.CUST_ID(+)
                AND T2.ACCT_NO = ?
                        
            """;
    private SqlQueries() {
    }
}
