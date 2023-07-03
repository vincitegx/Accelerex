package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet rs, int rowNum) throws SQLException {
        int userId = rs.getInt("id");
        String fullName = rs.getString("fullName");
        String email = rs.getString("email");
        String password = rs.getString("password");
        boolean isBlocked = rs.getBoolean(String.valueOf("false"));
        User user = new User(userId,fullName,email,password,isBlocked);

        int id = rs.getInt("id");
        int cardId = rs.getInt("card_id");
        String name = rs.getString("name");
        double balance = rs.getDouble("balance");
        boolean isActive = rs.getBoolean("is_active");
        BigDecimal totalAmount = rs.getBigDecimal("total_amount");
        
        return new Account(user);

    }

}
