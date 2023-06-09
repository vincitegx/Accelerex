package com.neptunesoftware.accelerex.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GenericResponse {

    private String responseCode;

    private String responseMessage;

}
