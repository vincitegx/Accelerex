package com.neptunesoftware.accelerex.account.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepositToGLResponse {
    private String responseCode;
    private  DepositToGlResponseData depositToGlResponseData;
}
