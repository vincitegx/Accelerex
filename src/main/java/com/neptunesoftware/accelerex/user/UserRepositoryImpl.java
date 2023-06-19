package com.neptunesoftware.accelerex.user;

import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import static com.neptunesoftware.accelerex.user.SqlQueries.FIND_BY_EMAIL;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public boolean existsByEmailAddress(String emailAddress) {
          try {
            Integer count = jdbcTemplate.queryForObject(FIND_BY_EMAIL,Integer.class, emailAddress);
            return count != null && count > 0;
        }   catch (EmptyResultDataAccessException e) {
            return false;
        }
    }

    @Override
    public Optional<User> findBySmsToken(String smsToken) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByPhoneNumber(String mobileNumber) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findByEmailAddress(String email) {
        return Optional.empty();
    }

    @Override
    public String findByEmail(String email) {
        return null;
    }
}
