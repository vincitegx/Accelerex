package com.neptunesoftware.accelerex.user;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@Builder
public class User{

    private Integer id;
    private String fullName;
    private String emailAddress;
    private String password;
    private String phoneNumber;
    private String smsToken;
    private boolean isNotBlocked;
    private boolean isVerified;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("d/M/yyyy HH:mm:ss");

//    public User(String fullName, String emailAddress, String password, boolean isNotBlocked, String phoneNumber) {
//        this.fullName = fullName;
//        this.emailAddress = emailAddress;
//        this.password = password;
//        this.createdAt = LocalDateTime.parse(
//                DATE_TIME_FORMATTER.format(LocalDateTime.now()),
//                DATE_TIME_FORMATTER);
//        this.updatedAt = createdAt;
//        this.isNotBlocked = isNotBlocked;
//        this.phoneNumber= phoneNumber;
//    }
}