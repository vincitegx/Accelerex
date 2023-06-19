package com.neptunesoftware.accelerex.user;

public class SqlQueries {
    public static final String FIND_BY_EMAIL = """
               SELECT * FROM user WHERE emailAddress = ?;          
            """;
}
