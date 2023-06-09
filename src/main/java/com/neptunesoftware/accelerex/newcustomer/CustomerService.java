package com.neptunesoftware.accelerex.newcustomer;

import com.neptunesoftware.accelerex.newcustomer.dto.CreateCustomerRequest;
import com.neptunesoftware.accelerex.utils.GenericResponse;


public interface CustomerService {
    GenericResponse createCustomer(CreateCustomerRequest request);
}
