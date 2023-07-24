package com.neptunesoftware.accelerex.account.mapper;

import com.neptunesoftware.accelerex.account.Account;
import com.neptunesoftware.accelerex.account.AccountStatus;
import com.neptunesoftware.accelerex.account.Tier;
import com.neptunesoftware.accelerex.user.Role;
import com.neptunesoftware.accelerex.user.User;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class AccountRowMapper implements RowMapper<Account> {
    @Override
    public Account mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Integer id = resultSet.getInt("id");
        User user = getUserFromResultSet(resultSet);
        String accountName = resultSet.getString("accountname");
        Integer mainBranchId = resultSet.getInt("mainbranchid");
        Integer customerId = resultSet.getInt("customerid");
        BigDecimal accountBalance = resultSet.getBigDecimal("accountbalance");
        AccountStatus accountStatus = AccountStatus.valueOf(resultSet.getString("accountstatus"));
        String currencyCode = resultSet.getString("currencycode");
        String accountNumber = resultSet.getString("accountnumber");
        Tier tierLevel = Tier.valueOf(resultSet.getString("tierlevel"));
        String transactionPin = resultSet.getString("transactionpin");
        LocalDateTime createdAt = resultSet.getTimestamp("createdat").toLocalDateTime();
        LocalDateTime updatedAt = resultSet.getTimestamp("updatedat").toLocalDateTime();

        return new Account(id, user, accountName, accountNumber, accountBalance, accountStatus,
                customerId, mainBranchId, currencyCode, tierLevel, transactionPin,
                createdAt, updatedAt);


    }

    private User getUserFromResultSet(ResultSet resultSet) throws SQLException {
        Integer id = resultSet.getInt("userid");
        String fullName = resultSet.getString("fullname");
        String emailAddress = resultSet.getString("emailaddress");
        String password = resultSet.getString("password");
        String phoneNumber = resultSet.getString("phonenumber");
        Role role = Role.valueOf(resultSet.getString("role"));
        boolean isNotBlocked = resultSet.getBoolean("isnotblocked");
        LocalDateTime createdAt = resultSet.getTimestamp("usercreatedat").toLocalDateTime();
        LocalDateTime updatedAt = resultSet.getTimestamp("userupdatedat").toLocalDateTime();

        return User.builder()
                .id(id)
                .fullName(fullName)
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
