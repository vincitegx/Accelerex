package com.neptunesoftware.accelerex.createNewCustomer;

import com.neptunesoftware.accelerex.account.request.CreateAccountRequest;
import com.neptunesoftware.accelerex.account.response.CreateAccountResponse;

public interface CreateCustomerAccountService {
    CreateAccountResponse creatNewCustomer(CreateAccountRequest request);
}