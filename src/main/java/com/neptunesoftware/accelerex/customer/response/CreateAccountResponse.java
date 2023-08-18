package com.neptunesoftware.accelerex.customer.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountResponse {
    public String accountNo;
    public String accountId;
    public String accountStatus;
}
