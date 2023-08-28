package com.neptunesoftware.accelerex.customer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CustomerData {
    private String userName;
    private String accountName;
    private String accountNumber;
    private String phoneNumber;
    private String emailAddress;
    private String dateOfBirth;
}
