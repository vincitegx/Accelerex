package com.neptunesoftware.accelerex.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public final class Credentials {
    @Value("${endpoint.fundTransferWebservice}")
    private String fundTransferWsdl;
    @Value("${endpoint.accountWebservice}")
    private String accountWsdl;
    @Value("${rubikon.channelId}")
    private String channelId;
    @Value("${rubikon.channelCode}")
    private String channelCode;
    @Value("${rubikon.xapiServiceCode}")
    private String xapiServiceCode;
    @Value("${rubikon.userAccessCode}")
    private String userAccessCode;
    @Value("${rubikon.userLoginId}")
    private String userLoginId;
    @Value("${rubikon.userPassword}")
    private String userPassword;
}
