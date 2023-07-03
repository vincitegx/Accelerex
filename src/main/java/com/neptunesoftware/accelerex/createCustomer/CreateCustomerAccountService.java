package com.neptunesoftware.accelerex.createCustomer;

import java.text.ParseException;

public interface CreateCustomerAccountService {
    CreateAccountResponse createCustomer(CreateCustomerRequest request) throws ParseException;
}