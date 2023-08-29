package com.neptunesoftware.accelerex.account.response;

import lombok.Data;

@Data
public class AccountInfoResponseDto {
    private String accountNumber;
    private String accountName;
    private String phoneNumber;
    private String email;
    private String dob;
    private AccountInfoResponseDto accountInfoResponseDto;

    public AccountInfoResponseDto(AccountInfoResponseDto accountInfoResponseDto) {
        this.accountInfoResponseDto = accountInfoResponseDto;
    }
}
