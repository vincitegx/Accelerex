package com.neptunesoftware.accelerex.customer.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateAccountResponse {
    private String responseCode;
    private CustomerData customerData;
}
