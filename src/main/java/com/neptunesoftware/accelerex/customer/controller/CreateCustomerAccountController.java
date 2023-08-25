package com.neptunesoftware.accelerex.customer.controller;

import com.neptunesoftware.accelerex.account.mapper.CustomUserRowMapper;
import com.neptunesoftware.accelerex.customer.request.CreateCustomerRequest;
import com.neptunesoftware.accelerex.customer.response.CreateCustomerResponse;
import com.neptunesoftware.accelerex.customer.service.CreateBankAccountService;
import com.neptunesoftware.accelerex.user.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import static com.neptunesoftware.accelerex.account.sql.SqlQueries.FIND_AGENT_DETAILS_WITH_ACCOUNT_NUMBER;

@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("api/v1/customer")
@Tag(name = "Customer")
@Log4j2
public class CreateCustomerAccountController {
    private final CreateBankAccountService customerAccountService;
    private final JdbcTemplate jdbcTemplate;
    @PostMapping("create")
    public ResponseEntity<CreateCustomerResponse> createCustomer(@RequestBody CreateCustomerRequest request) {
        return ResponseEntity.status(HttpStatus.OK).body(customerAccountService.createCustomer(request));
    }
    @GetMapping("/findUser")
    @ResponseStatus(HttpStatus.OK)
    public User findUser(@RequestParam String accountNumber) {
       User user = jdbcTemplate.queryForObject(FIND_AGENT_DETAILS_WITH_ACCOUNT_NUMBER, new CustomUserRowMapper(),accountNumber);
        assert user != null;
        log.info(user.getPhoneNumber());
        return  user;
//        return jdbcTemplate.queryForObject(FIND_AGENT_DETAILS_WITH_ACCOUNT_NUMBER, new Object[]{accountNumber}, new CustomUserRowMapper());
    }
}