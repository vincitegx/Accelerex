package com.neptunesoftware.accelerex.createCustomer;

import lombok.Data;

@Data
public class DepositAccountRequest {
    public String customerNo;
    public String customerId;
    public String customerName;
}