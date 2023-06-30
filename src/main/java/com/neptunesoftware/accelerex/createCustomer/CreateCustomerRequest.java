package com.neptunesoftware.accelerex.createCustomer;

import lombok.Data;

@Data
public class CreateCustomerRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String phone;
    private String image;
    private String dateOfBirth;
    private String city;
    private String state;
//    private String signatureType;
//    private String signature;
//    private String imageType;
    private String homeAddress;
    private String email;
    private String bvn;
}