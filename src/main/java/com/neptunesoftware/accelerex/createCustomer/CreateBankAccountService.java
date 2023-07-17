package com.neptunesoftware.accelerex.createCustomer;

public interface CreateBankAccountService {
    CreateCustomerResponse createCustomer(CreateCustomerRequest request);

    CreateAccountResponse createDepositAccount(DepositAccountRequest depositAccountRequest);

}