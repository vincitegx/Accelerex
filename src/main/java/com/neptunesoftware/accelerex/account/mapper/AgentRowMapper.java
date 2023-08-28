package com.neptunesoftware.accelerex.account.mapper;

import com.neptunesoftware.accelerex.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AgentRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserName(rs.getString("USERNAME"));
        user.setFullName(rs.getString("AGENT_NAME"));
        user.setEmailAddress(rs.getString("AGENT_EMAIL"));
        user.setDataOfBirth(rs.getString("DATE_OF_BIRTH"));
        user.setAccountNumber(rs.getString("PRIMARY_ACCOUNT_NUMBER"));
        user.setPhoneNumber(rs.getString("PHONE_NUMBER"));
        return user;
    }
}