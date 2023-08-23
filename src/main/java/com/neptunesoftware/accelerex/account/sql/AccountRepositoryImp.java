package com.neptunesoftware.accelerex.account.sql;

import com.neptunesoftware.accelerex.account.mapper.CustomUserRowMapper;
import com.neptunesoftware.accelerex.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.neptunesoftware.accelerex.account.sql.SqlQueries.SELECT_USER_BY_PHONE_NUMBER_EMAIL_DOB;


@Repository
@RequiredArgsConstructor
@Log4j2
public class AccountRepositoryImp implements AccountRepository {

    private final JdbcTemplate jdbcTemplate;
    @Override
    public boolean findAccountByPhoneAndAccountNumber(String mobilePhoneNumber, String accountNumber) {
        List<User> users = jdbcTemplate.query(SELECT_USER_BY_PHONE_NUMBER_EMAIL_DOB,
                new Object[]{mobilePhoneNumber, accountNumber}, new CustomUserRowMapper());
        return !users.isEmpty();
    }

//    @Override
//    public void linkedAccount(String userName, String phoneNumber, String email, String generatedAccountNumber) {
//        try {
//            jdbcTemplate.update(LINK_DETAILS, userName, email, phoneNumber, generatedAccountNumber);
//        } catch (DataAccessException e) {
//            log.error("Error Updating DB Record");
//            log.error(e.getMessage());
//            throw new RuntimeException(e.getMessage());
//        }
//    }
}