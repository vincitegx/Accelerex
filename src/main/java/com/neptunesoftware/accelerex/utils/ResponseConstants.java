package com.neptunesoftware.accelerex.utils;

public class ResponseConstants {
    public static final String CUSTOMER_EXIST_CODE ="";
    public static final String CUSTOMER_EXIST_MASSAGE ="Customer already exist";
    public static final String SUCCESS_CODE ="00";
    public static final String SUCCESS_MESSAGE ="Successful";
    public static final String CUSTOMER_EXIST_MESSAGE ="";
    public static final String WRONG_IMAGE_CODE ="";
    public static final String WEBSERVICE_UNAVAILABLE_MESSAGE ="Service unreachable";
    public static final String WEBSERVICE_UNAVAILABLE_CODE ="02";
    public static final String WEBSERVICE_RESPONSE_CODE ="03";
    public static final String WEBSERVICE_FAILED_RESPONSE_CODE = "04";
    public static final String WEBSERVICE_FAILED_RESPONSE_MESSAGE = "Failed to get response from webservice";
    public static final String BVN_EXIST_CODE ="05";
    public static final String MANDATORY_CODE ="09";
    public static final String MANDATORY_MESSAGE ="A mandatory parameter has not been passed: ";
    public static final String WRONG_IMAGE_MESSAGE ="";
    public static final String BVN_EXIST_MESSAGE ="Record already exist";
    public static final String EXCEPTION_CODE ="";
    public static final String EXCEPTION_MESSAGE ="";
    public static final String UNMARSHAL_CODE = "08";
    public static final String UNMARSHAL_MESSAGE = "Unmarshalling/Deserialize error: Could not convert String to class object."
            + "\n Check xml/json String to object class created";

    private ResponseConstants() {
        
    }
}
