package com.neptunesoftware.accelerex.account.model;

import com.neptunesoftware.accelerex.account.enums.AccountStatus;
import com.neptunesoftware.accelerex.account.enums.Tier;
import com.neptunesoftware.accelerex.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
public class Account {

    private Integer id;
    private User user;

    private String accountName;
    private String accountNumber;
    private BigDecimal accountBalance;
    private AccountStatus accountStatus;

    private Integer customerId;
    private Integer mainBranchId;

    private String currencyCode;
    private Tier tierLevel;
    private String transactionPin;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("d/M/yyyy HH:mm:ss");

    public Account(User user){
        this.setUser(user);
        this.createdAt = LocalDateTime.parse(
                DATE_TIME_FORMATTER.format(LocalDateTime.now()),
                DATE_TIME_FORMATTER);
        this.updatedAt = createdAt;
        this.setAccountBalance(new BigDecimal(0));
    }
    public Account(){
        this.createdAt = LocalDateTime.parse(
                DATE_TIME_FORMATTER.format(LocalDateTime.now()),
                DATE_TIME_FORMATTER);
        this.updatedAt = createdAt;
        this.setAccountBalance(new BigDecimal(0));
    }

    public Account(User user, BigDecimal accountBalance, AccountStatus accountStatus, String accountNumber, Tier tierLevel, String transactionPin) {
        this.user = user;
        this.accountBalance = accountBalance;
        this.accountStatus = accountStatus;
        this.accountNumber = accountNumber;
        this.tierLevel = tierLevel;
        this.transactionPin = transactionPin;
        this.createdAt = LocalDateTime.parse(
                DATE_TIME_FORMATTER.format(LocalDateTime.now()),
                DATE_TIME_FORMATTER);
        this.updatedAt = createdAt;
    }
}