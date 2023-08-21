package com.neptunesoftware.accelerex.customer.request;

import lombok.Data;

@Data
public class CreateBankAccountRequest {
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String phone;
    private String dateOfBirth;
    private String city;
    private String state;
    private String homeAddress;
    private String email;
    private String bvn;
}