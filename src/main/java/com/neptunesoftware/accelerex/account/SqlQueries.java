package com.neptunesoftware.accelerex.account;

final class SqlQueries {

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
    public static final String SELECT_PHONE_NUM = """
           
            """;

    private SqlQueries() {
    }
}
