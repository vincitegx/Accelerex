package com.neptunesoftware.accelerex.createCustomer;

import com.neptunesoftware.accelerex.account.request.NewCustomerAccountRequest;
import com.neptunesoftware.accelerex.account.response.CreateAccountResponse;

public interface CreateCustomerAccountService {
    CreateAccountResponse creatNewCustomer(NewCustomerAccountRequest request);
}