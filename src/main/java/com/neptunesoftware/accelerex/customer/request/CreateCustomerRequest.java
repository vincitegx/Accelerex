package com.neptunesoftware.accelerex.customer.request;

import lombok.Data;

@Data
public class CreateCustomerRequest {
    private String userName;
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String phone;
    private String email;
    private String dateOfBirth;
    private String city;
    private String state;
    private String homeAddress;
    private String bvn;
    private String image;
     private String signature;
}