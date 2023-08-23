package com.neptunesoftware.accelerex.user;

public class SqlQueries {
    public static final String FIND_BY_EMAIL = """
            SELECT COUNT(*) FROM USERS WHERE emailAddress = ?""";
    public static final  String FIND_BY_PHONE_NUMBER = """
               SELECT * FROM HTE_USERS WHERE emailAddress = ?""";

}