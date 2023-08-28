package com.neptunesoftware.accelerex.account.sql;

import com.neptunesoftware.accelerex.account.mapper.AgentRowMapper;
import com.neptunesoftware.accelerex.account.mapper.CustomUserRowMapper;
import com.neptunesoftware.accelerex.exception.ResourceNotFoundException;
import com.neptunesoftware.accelerex.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import static com.neptunesoftware.accelerex.account.sql.SqlQueries.*;


@Repository
@RequiredArgsConstructor
@Log4j2
public class AccountRepositoryImp implements AccountRepository {

    private final JdbcTemplate jdbcTemplate;

    @Override
    public User findByAccountNumber(String accountNumber) {
        User user;
        try {
            user = jdbcTemplate.queryForObject(FIND_AGENT_DETAILS_WITH_ACCOUNT_NUMBER, new CustomUserRowMapper(), accountNumber);
        } catch (DataAccessException e) {
            throw new ResourceNotFoundException("INVALID ACCOUNT NUMBER");
        }
        return user;
    }

    @Override
    public boolean findByPhoneAndDateOfBirth(String phoneNumber,String dob) {
        try {
            jdbcTemplate.queryForObject(FIND_AGENT_DETAILS_WITH_ACCOUNT_NUMBER, new CustomUserRowMapper(), phoneNumber, dob);
            return true;
        } catch (DataAccessException e) {
            return false;
        }
    }
    @Override
    public void linkExistingAccountToAgentProfile(User user, String userName) {
        try {
            jdbcTemplate.update(SAVE_REGISTRATION_DETAILS,
                    userName,
                    user.getFullName(),
                    user.getEmailAddress(),
                    user.getPhoneNumber(),
                    user.getDataOfBirth(),
                    user.getAccountNumber());
        } catch (DataAccessException e) {
            log.error("Error Saving Record To DB");
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
    @Override
    public boolean findByUserName(String username) {
        try {
            jdbcTemplate.queryForObject(SELECT_BY_USERNAME, new AgentRowMapper(), username);
            return true;
        } catch (EmptyResultDataAccessException ex) {
            return false; 
        }
    }
}