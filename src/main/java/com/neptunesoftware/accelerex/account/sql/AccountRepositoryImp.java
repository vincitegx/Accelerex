package com.neptunesoftware.accelerex.account.sql;

import com.neptunesoftware.accelerex.account.mapper.AccountRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.util.Strings;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.time.LocalDate;

import static com.neptunesoftware.accelerex.account.sql.SqlQueries.*;


@Repository
@RequiredArgsConstructor
@Log4j2
public class AccountRepositoryImp implements AccountRepository {
    
        private final JdbcTemplate jdbcTemplate;

    @Override
    public String findNameByAccountNumber(String accountNumber) {
        try {
            return String.valueOf(jdbcTemplate.queryForObject(ACCOUNT_NUMBER_ENQUIRY, new AccountRowMapper(), accountNumber));
        } catch (EmptyResultDataAccessException e) {
           return   Strings.EMPTY;
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
        jdbcTemplate.update(SAVE_SMS, phoneNumber, date);
    }
    @Override
    public String findUserIdByAccountNumber(String accountNumber) {
       try {
           return jdbcTemplate.query(SELECT_CUSTOMER_ID,(resultSet, i) -> resultSet.getString("acct_num")).toString();
       } catch (EmptyResultDataAccessException e) {
          return Strings.EMPTY;
       }
    }

}