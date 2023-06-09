package com.neptunesoftware.accelerex.newcustomer.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateCustomerRequest {

    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;

    private String homeAddress;
    private String phone;
    private String email;
    private String bvn;
}
