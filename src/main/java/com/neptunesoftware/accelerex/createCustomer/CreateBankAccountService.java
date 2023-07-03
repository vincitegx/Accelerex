package com.neptunesoftware.accelerex.createCustomer;

import java.text.ParseException;

public interface CreateBankAccountService {
    CreateBankAccountResponse createCustomer(CreateBankAccountRequest request) throws ParseException;
}