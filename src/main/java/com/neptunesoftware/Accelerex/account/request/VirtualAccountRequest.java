package com.neptunesoftware.Accelerex.account.request;

import lombok.Data;

import java.util.Map;

@Data
public class VirtualAccountRequest {
    private String customerName;
    private String businessCategory;
    private Map<String, String> metadata;
}
