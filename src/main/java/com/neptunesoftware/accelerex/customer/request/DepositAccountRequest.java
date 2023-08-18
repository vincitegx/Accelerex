package com.neptunesoftware.accelerex.customer.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DepositAccountRequest {
    public String customerNo;
    public String customerId;
    public String customerName;
}