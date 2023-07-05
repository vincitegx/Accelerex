package com.neptunesoftware.accelerex.user.repo;

import com.neptunesoftware.accelerex.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .id(rs.getInt("ID"))
                .fullName(rs.getString("FULL_NAME"))
                .emailAddress(rs.getString("EMAIL_ADDRESS"))
                .password(rs.getString("PASSWORD"))
                .phoneNumber(rs.getString("PHONE_NUMBER"))
//                .role((Role) rs.getObject("RN_"))
                .isNotBlocked(rs.getBoolean("IS_NOT_BLOCK"))
//                .isVerified(rs.getBoolean("is_verified"))
                .createdAt(rs.getTimestamp("CREATED_AT").toLocalDateTime())
                .updatedAt(rs.getTimestamp("UPDATED_AT").toLocalDateTime())
                .build();
    }
}