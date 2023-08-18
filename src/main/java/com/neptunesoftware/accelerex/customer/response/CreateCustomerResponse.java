package com.neptunesoftware.accelerex.customer.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
public class CreateCustomerResponse {
    private String responseCode;
    private String responseMessage;
    private String customerId;
    private String customerNo;
    private String accountStatus;
    private String accountNumber;

}
