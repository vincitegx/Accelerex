package com.neptunesoftware.accelerex.universal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class ApiResponse<N> {

    private String message;
    private Object data;


    public ApiResponse(String message) {
        this.message = message;
    }
}