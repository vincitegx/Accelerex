package com.neptunesoftware.Accelerex.account;

import com.neptunesoftware.Accelerex.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private Integer userId;
    private String accountNumber;
    private String accountName;
    private BigDecimal accountBalance;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_updated")
    private Date updatedAt;

    public Account() {
        accountBalance = new BigDecimal("0.0");
    }

    @PrePersist
    public void createdAt() {

        this.createdAt = new Date();
    }

    @PreUpdate
    public void updatedAt() {

        this.updatedAt = new Date();
    }

}