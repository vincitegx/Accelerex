package com.neptunesoftware.accelerex.user.repo;

import com.neptunesoftware.accelerex.user.Role;
import com.neptunesoftware.accelerex.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .id(rs.getInt("id"))
                .fullName(rs.getString("full_name"))
                .emailAddress(rs.getString("email_address"))
                .password(rs.getString("password"))
                .phoneNumber(rs.getString("phone_number"))
                .role(Role.valueOf(rs.getString("role")))
//                .smsToken(rs.getString("sms_token"))
                .isNotBlocked(rs.getBoolean("is_not_blocked"))
                .isVerified(rs.getBoolean("is_verified"))
                .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                .build();
    }
}
