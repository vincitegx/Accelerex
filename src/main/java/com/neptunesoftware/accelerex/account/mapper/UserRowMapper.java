package com.neptunesoftware.accelerex.account.mapper;

import com.neptunesoftware.accelerex.user.Role;
import com.neptunesoftware.accelerex.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class UserRowMapper implements RowMapper<User> {
    public User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("userid");
        String fullName = resultSet.getString("AGENT_NAME");
        String userName = resultSet.getString("USERNAME");
        String emailAddress = resultSet.getString("AGENT_EMAIL");
        String password = resultSet.getString("PASSWORD");
        String phoneNumber = resultSet.getString("PHONE_NUMBER");
        String dateOfBirth = resultSet.getString("DATE_OF_BIRTH");
        Role role = Role.valueOf(resultSet.getString("ROLE"));
        boolean isNotBlocked = resultSet.getBoolean("IS_ACCOUNT_NOT_BLOCKED");
        LocalDateTime createdAt = resultSet.getTimestamp("CREATED_AT").toLocalDateTime();
        LocalDateTime updatedAt = resultSet.getTimestamp("UPDATED_AT").toLocalDateTime();

        return User.builder()
                .id(id)
                .fullName(fullName)
                .dataOfBirth(dateOfBirth)
                .userName(userName)
                .emailAddress(emailAddress)
                .password(password)
                .phoneNumber(phoneNumber)
                .role(role)
                .isNotBlocked(isNotBlocked)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }

    @Override
    public User mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        String fullName = resultSet.getString("AGENT_NAME");
        String userName = resultSet.getString("USERNAME");
        String emailAddress = resultSet.getString("AGENT_EMAIL");
        String password = resultSet.getString("PASSWORD");
        String phoneNumber = resultSet.getString("PHONE_NUMBER");
        String dateOfBirth = resultSet.getString("DATE_OF_BIRTH");
        Role role = Role.valueOf(resultSet.getString("ROLE"));
        boolean isNotBlocked = resultSet.getBoolean("IS_ACCOUNT_NOT_BLOCKED");
        LocalDateTime createdAt = resultSet.getTimestamp("CREATED_AT").toLocalDateTime();
        LocalDateTime updatedAt = resultSet.getTimestamp("UPDATED_AT").toLocalDateTime();

        return User.builder()
                .fullName(fullName)
                .dataOfBirth(dateOfBirth)
                .userName(userName)
                .emailAddress(emailAddress)
                .password(password)
                .phoneNumber(phoneNumber)
                .role(role)
                .isNotBlocked(isNotBlocked)
                .createdAt(createdAt)
                .updatedAt(updatedAt)
                .build();
    }
}
