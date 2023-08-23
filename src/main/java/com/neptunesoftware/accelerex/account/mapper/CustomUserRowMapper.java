package com.neptunesoftware.accelerex.account.mapper;

import com.neptunesoftware.accelerex.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomUserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setFullName(rs.getString("AGENT_NAME"));
        user.setAccountNumber(rs.getString("PRIMARY_ACCOUNT_NUMBER"));
        user.setUserName(rs.getString("USERNAME"));
        user.setEmailAddress(rs.getString("AGENT_EMAIL"));
        user.setPhoneNumber(rs.getString("PHONE_NUMBER"));
        user.setDataOfBirth(rs.getString("DATE_OF_BIRTH"));
        return user;
    }
}
