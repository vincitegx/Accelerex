package com.neptunesoftware.Accelerex.account.request;

import lombok.Data;

import java.util.Map;

@Data
public class FetchAccountBalanceRequest {

    private String bankCode;
    private String accountNo;
    private Map<String,String>apiKey;

//    The APIkey includes the secreteKey and clientIdAPI { Client Id and  API Secret key}
}
