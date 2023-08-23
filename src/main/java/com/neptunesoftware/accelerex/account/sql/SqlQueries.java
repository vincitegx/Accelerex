package com.neptunesoftware.accelerex.account.sql;

public final class SqlQueries {

    public static final String ACCOUNT_NUMBER_ENQUIRY = """
            SELECT ACCT_NM FROM ACCOUNT WHERE ACCT_NO = ?       
            """;
    public static final String IS_ACCOUNT_EXISTING = """
           SELECT ACCT_NO FROM ACCOUNT WHERE ACCT_NO = ?
           """;
       public static final String TOKEN = """
""";

    public static final String SAVE_SMS = """
          
            """;

    public static final String SELECT_CUSTOMER_ID = """
            """;

    public  static final String UPDATE_USER_ID_WITH_ACCOUNT_NUMBER = """
            UPDATE ACCOUNT set USER_ID = ? where ACCT_NO = ?;
            """;
    public  static final String UPDATE_CUSTOMER_STATUS = """
            UPDATE CUSTOMER SET REC_ST = 'A'  WHERE CUST_NO = ?
            """;

    public  static final String INSERT_IMAGE = """
            UPDATE CUSTOMER_IMAGE SET BINARY_IMAGE = ? WHERE CUST_NO = ?
            """;
    public static final String SELECT_PHONE_NUM = """
           
            """;
    public static final String SAVE_REGISTRATION_DETAILS = """
            INSERT INTO ALT_AGENCY_PPS_USERS (USERNAME,AGENT_NAME,AGENT_EMAIL,PHONE_NUMBER,DATE_OF_BIRTH,PRIMARY_ACCOUNT_NUMBER)
             VALUES(?,?,?,?,?,?)
            """ ;
    private SqlQueries() {
    }
}
