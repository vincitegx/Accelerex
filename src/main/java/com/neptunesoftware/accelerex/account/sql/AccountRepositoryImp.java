package com.neptunesoftware.accelerex.account.sql;

import com.neptunesoftware.accelerex.account.mapper.CustomUserRowMapper;
import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.user.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.neptunesoftware.accelerex.account.sql.SqlQueries.*;


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
    @Override
    public void linkExistingAccountToAgentProfile(LinkBankAccountRequest linkBankAccountRequest) {
        try {
            jdbcTemplate.update(LINK_DETAILS_AGENT_DETAILS,
                    linkBankAccountRequest.getUserName(),
                    linkBankAccountRequest.getAccountName(),
                    linkBankAccountRequest.getEmail(),
                    linkBankAccountRequest.getMobileNo(),
                    linkBankAccountRequest.getAccountNo());
        } catch (DataAccessException e) {
            log.error("Error Saving Record To DB");
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}