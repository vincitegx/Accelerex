package com.neptunesoftware.accelerex.account.sql;

public final class SqlQueries {

    public  static final String UPDATE_CUSTOMER_STATUS = """
            UPDATE CUSTOMER SET REC_ST = 'A'  WHERE CUST_NO = ?
            """;
    public  static final String INSERT_IMAGE = """
            UPDATE CUSTOMER_IMAGE SET BINARY_IMAGE = ? WHERE CUST_NO = ?
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
//    public static final String LINK_DETAILS = """
//            INSERT INTO ALT_AGENCY_PPS_USERS (USERNAME,AGENT_NAME,AGENT_EMAIL,PRIMARY_ACCOUNT_NUMBER)
//             VALUES(?,?,?,?,?)
//            """ ;
    private SqlQueries() {
    }
}
