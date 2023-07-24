package com.neptunesoftware.accelerex.user;

public class SqlQueries {
    public static final String FIND_BY_EMAIL = """
            SELECT COUNT(*) FROM USERS WHERE emailAddress = ?""";
    public static final  String FIND_BY_PHONE_NUMBER = """
               SELECT * FROM HTE_USERS WHERE emailAddress = ?""";

    public static final String SAVE_REGISTRATION_DETAILS = """
            INSERT INTO HTL_USERS (FULL_NAME, EMAIL_ADDRESS, PASSWORD, PHONE_NUMBER, IS_NOT_BLOCKED, CREATED_AT, UPDATED_AT)
             VALUES (?, ?, ?, ?, ?, ?, ?)
            """ ;
}