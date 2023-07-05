package com.neptunesoftware.accelerex.user.repo;

import com.neptunesoftware.accelerex.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Objects;
import java.util.Optional;

import static com.neptunesoftware.accelerex.user.SqlQueries.*;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {
    private final JdbcTemplate jdbcTemplate;
    @Override
    public boolean existsByEmailAddress(String emailAddress) {
          try {
            Integer count = Objects.requireNonNull(jdbcTemplate.queryForObject(FIND_BY_EMAIL, new UserRowMapper(), emailAddress)).getId();
            return count != null && count > 0;
        }   catch (EmptyResultDataAccessException e) {
            return false;
        }
    }
    
    @Override
    public Optional<User> findByPhoneNumber(String mobileNumber) {
      try {
          return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_PHONE_NUMBER, new UserRowMapper(), mobileNumber));
      } catch (Exception e) {
          throw new RuntimeException("");
      }
    }

    @Override
    public Optional<User> findByEmailAddress(String email) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(FIND_BY_EMAIL, new UserRowMapper(), email));
        } catch (Exception e) {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public User findUserByAccountNumber(String accountNumber) {
        return null;
    }

    @Override
    public void saveRegistrationDetails(User user) {
            jdbcTemplate.update(SAVE_REGISTRATION_DETAILS,
                    user.getFullName(),
                    user.getEmailAddress(),
                    user.getPassword(),
                    user.getPhoneNumber(),
                    user.isNotBlocked(),
                    user.getCreatedAt(),
                    user.getUpdatedAt(), new UserRowMapper());
    }
}
