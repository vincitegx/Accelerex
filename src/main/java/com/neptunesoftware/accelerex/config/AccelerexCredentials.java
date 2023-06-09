package com.neptunesoftware.accelerex.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Getter
public final class AccelerexCredentials {
    @Value("${accelerex.chanelCode}")
    private String channelCode;
    @Value("${accelerex.channelId}")
    private String channelId;
}
