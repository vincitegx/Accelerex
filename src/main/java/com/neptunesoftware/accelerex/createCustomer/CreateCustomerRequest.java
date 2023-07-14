package com.neptunesoftware.accelerex.createCustomer;

import lombok.Data;

@Data
public class CreateCustomerRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String phone;
    private String dateOfBirth;
    private String image;
    private String signature;
    private String city;
    private String state;
    private String homeAddress;
    private String alternativeAddress;
    private String email;
    private String bvn;
}