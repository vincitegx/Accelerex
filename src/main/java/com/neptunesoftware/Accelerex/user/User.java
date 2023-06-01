package com.neptunesoftware.Accelerex.user;

import com.neptunesoftware.Accelerex.account.Account;
import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "User_tbl")
public class User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String mobileNumber;
    @Column(unique = true)
    private String email;
    private String password;
    private String smsToken;
    private boolean isVerified;
}
