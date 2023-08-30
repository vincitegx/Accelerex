package com.neptunesoftware.accelerex.account.mapper;

import com.neptunesoftware.accelerex.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CustomUserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {

        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        User user = new User();
        String dob  = rs.getString("BIRTH_DT");
        LocalDateTime dateTime = LocalDateTime.parse(dob, inputFormatter);
        user.setDataOfBirth(dateTime.format(outputFormatter));
        user.setFullName(rs.getString("CUST_NM"));
        user.setBvn(rs.getString("BVN"));
        user.setAccountNumber(rs.getString("ACCT_NO"));
        user.setEmailAddress(rs.getString("EMAIL"));
        user.setPhoneNumber(rs.getString("PHONE_NUMBER"));
        user.setAccountStatus(rs.getString("REC_ST"));
        return user;
    }
}
