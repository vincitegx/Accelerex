package com.neptunesoftware.accelerex.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User implements UserDetails {
    @JsonIgnore
    private Integer id;
    private String fullName;
    private String userName;
    private String emailAddress;
    private String dataOfBirth;
    @JsonIgnore
    private String password;
    private String phoneNumber;
    private Role role;
    private boolean isNotBlocked;
    private boolean isVerified;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    @JsonIgnore
    private String authority;
    private String bvn;
    private String accountNumber;
    private String accountStatus;
    private static final DateTimeFormatter DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("d/M/yyyy HH:mm:ss");

    public User(String fullName, String emailAddress, String password, boolean isNotBlocked, String phoneNumber) {
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.createdAt = LocalDateTime.parse(
                DATE_TIME_FORMATTER.format(LocalDateTime.now()),
                DATE_TIME_FORMATTER);
        this.updatedAt = createdAt;
        this.isNotBlocked = isNotBlocked;
        this.phoneNumber = phoneNumber;
    }

    /**
     * This constructor is for test purpose. Id must always be auto generated
     */
    public User(Integer id, String fullName, String emailAddress, String password, boolean isNotBlocked) {
        this.id = id;
        this.fullName = fullName;
        this.emailAddress = emailAddress;
        this.password = password;
        this.createdAt = LocalDateTime.parse(
                DATE_TIME_FORMATTER.format(LocalDateTime.now()),
                DATE_TIME_FORMATTER);
        this.updatedAt = createdAt;
        this.isNotBlocked = isNotBlocked;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isNotBlocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", password='" + password + '\'' +
                ", isNotBlocked=" + isNotBlocked +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return isNotBlocked == user.isNotBlocked && Objects.equals(id, user.id) && Objects.equals(fullName, user.fullName) && Objects.equals(emailAddress, user.emailAddress) && Objects.equals(password, user.password) && Objects.equals(createdAt, user.createdAt) && Objects.equals(updatedAt, user.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fullName, emailAddress, password, isNotBlocked, createdAt, updatedAt);
    }
}