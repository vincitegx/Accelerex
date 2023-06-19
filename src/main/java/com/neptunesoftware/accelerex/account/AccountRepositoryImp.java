package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

import static com.neptunesoftware.accelerex.account.SqlQueries.*;


@Repository
@RequiredArgsConstructor
@Log4j2
public class AccountRepositoryImp implements AccountRepository {
    
        private final JdbcTemplate jdbcTemplate;

    @Override
    public Optional<Account> findAccountByUser(User user) {
        return Optional.empty();
    }

    @Override
    public Optional<Account> findAccountByAccountNumber(String accountNumber) {
        return Optional.empty();
    }

    @Override
    public String findByAccountNumber(String accountNumber) {
        try {
           return jdbcTemplate.queryForObject(IS_ACCOUNT_EXISTING,String.class,accountNumber);
        } catch (EmptyResultDataAccessException e) {
            return Strings.EMPTY;
        }
    }

    @Override
    public String findNameByAccountNumber(String accountNumber) {
        try {
            return jdbcTemplate.queryForObject(NAME_ENQUIRY, String.class, accountNumber);
        } catch (EmptyResultDataAccessException e) {
            return Strings.EMPTY;
        }
    }
    @Override
    public String findAccountByPhoneNumber(String mobilePhoneNumber) {
        try{
            return jdbcTemplate.queryForObject(SELECT_PHONE_NUM,String.class,mobilePhoneNumber);
        } catch (EmptyResultDataAccessException e) {
            return Strings.EMPTY;
        }
    }
    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        try {
            Integer count = jdbcTemplate.queryForObject(IS_ACCOUNT_EXISTING,Integer.class, accountNumber);
            return count != null && count > 0;
        }   catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public String findTokenByAccountNumber(String accountNumber) {
        try {
            return jdbcTemplate.queryForObject(TOKEN, String.class, accountNumber);
        } catch (EmptyResultDataAccessException e) {
            return Strings.EMPTY;
        }
    }

    @Override
    public void updateOTP(String phoneNumber, String otp) {
        Date date = Date.valueOf(LocalDate.now());

        jdbcTemplate.update(SAVE_OTP, phoneNumber, otp);
        String message = "Kindly use this OTP: " + otp + " to complete your mobile App setup.";
        jdbcTemplate.update(SAVE_SMS, message, phoneNumber, date);
    }

    @Override
    public String findUserIdByAccountNumber(String accountNumber) {
       try {
           return jdbcTemplate.query(SELECT_CUSTOMER_ID,(resultSet, i) -> resultSet.getString("acct_num")).toString();
       } catch (EmptyResultDataAccessException e) {
          return Strings.EMPTY;
       }
    }
    @Override
    public String findBvnByAccountNum(String accountNumber) {
        try {
            return jdbcTemplate.queryForObject(SELECT_BVN, String.class, accountNumber);
        } catch (EmptyResultDataAccessException e) {
            return Strings.EMPTY;
        }
    }
}