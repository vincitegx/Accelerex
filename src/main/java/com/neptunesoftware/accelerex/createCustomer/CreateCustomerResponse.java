package com.neptunesoftware.accelerex.createCustomer;

import lombok.Data;

@Data
public class CreateCustomerResponse {

    private String responseCode;
    private String responseMessage;
    private String customerId;
    private String customerNo;
    private String status;

    public CreateCustomerResponse(String responseCode, String responseMessage, String customerNo, String customerId) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.customerNo = customerNo;
        this.customerId = customerId;
    }

    public CreateCustomerResponse(String responseCode, String responseMessage, String customerNo, String customerId, String status) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.customerNo = customerNo;
        this.customerId = customerId;
        this.status = status;
    }

    public CreateCustomerResponse() {

    }
}
