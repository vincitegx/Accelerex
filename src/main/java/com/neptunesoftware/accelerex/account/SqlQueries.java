package com.neptunesoftware.accelerex.account;

final class SqlQueries {

    public static final String NAME_ENQUIRY = """
            
            """;

    public static final String IS_ACCOUNT_EXISTING = """
          
           """;
       public static final String TOKEN = """
""";
    public static final String GET_ACCOUNT_BY_USER = """
            
            """;
    public static final String SAVE_OTP = """
            
            """;
    public static final String SAVE_SMS = """
          
            """;
    public static final String OTP_EXPIRY_TIME = """
           
            """;
    public static final String SELECT_CUSTOMER_ID = """
            """;
    public static final String SELECT_USER_ID = """
            """;
    public  static final String UPDATE_USER_ID_WITH_ACCOUNT_NUMBER = """
            update account set user_id = ? where account_number = ?;
            """;

    public static final String ACCOUNT_HISTORY_QUERY = """
          
            """;

    public static final String SELECT_EMAIL = """
           
            """;
    public static final String SELECT_PHONE_NUM = """
           
            """;

    public static final String QUERY_PHONE_NUMBER = """
           
            """;
    public static final String QUERY_ACCOUNT_NUMBER = """
            """;
    public static final String SELECT_BVN = """
    
            """;
    public static final String UPDATE_ACCESS_PIN = """
           
            """;
    public static final String UPDATE_PASSWORD = """
          
            """;

    public static final String ACCOUNT_INFO = """
            
            """;
    public static final String DELETE_BENEFICIARY = """
             
            """;
    public static final String INSERT_BENEFICIARY = """
           
            """;
    public static final String SELECT_BENEFICIARY = """
         
            """;
    public static final String ACCOUNT_INFORMATION = """
           
            """;
    public static final String GET_USER_BY_ACCOUNT_NUMBER = """
            
            """;
    private SqlQueries() {
    }
}
