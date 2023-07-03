package com.neptunesoftware.accelerex.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public final class AccelerexCredentials {
    @Value("${accelerex.channelCode}")
    private String channelCode;
    @Value("${accelerex.channelId}")
    private String channelId;
    @Value("${endpoint.fundTransferWebservice}")
    private String fundTransferWsdl;
    @Value("${endpoint.accountWebservice}")
    private String accountWsdl;
    @Value("${accelerex.xapiServiceCode}")
    private String xapiServiceCode;
    @Value("${accelerex.userAccessCode}")
    private String userAccessCode;
    @Value("${accelerex.userLoginId}")
    private String userLoginId;
    @Value("${accelerex.userPassword}")
    private String userPassword;
}
