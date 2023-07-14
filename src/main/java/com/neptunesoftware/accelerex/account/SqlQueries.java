package com.neptunesoftware.accelerex.account;

final class SqlQueries {

    public static final String NAME_ENQUIRY = """
            SELECT ACCT_NM FROM ACCOUNT WHERE ACCT_NO = ?       
            """;
    public static final String IS_ACCOUNT_EXISTING = """
          
           """;
       public static final String TOKEN = """
""";

    public static final String SAVE_OTP = """
            
            """;
    public static final String SAVE_SMS = """
          
            """;

    public static final String SELECT_CUSTOMER_ID = """
            """;

    public  static final String UPDATE_USER_ID_WITH_ACCOUNT_NUMBER = """
            update account set user_id = ? where account_number = ?;
            """;



    public static final String SELECT_PHONE_NUM = """
           
            """;

    public static final String SELECT_BVN = """
    
            """;

    public static final String UPDATE_PASSWORD = """
          
            """;

    public static final String DELETE_BENEFICIARY = """
             
            """;
 
    private SqlQueries() {
    }
}
