package com.neptunesoftware.accelerex.account.response;

import lombok.Data;

@Data
public class CreateAccountResponse {

    private String responseCode;
    private String responseMessage;
    private String custNo;
    private String accountNumber;

    public String getResponseCode() {
        return responseCode;
    }
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }
    public String getResponseMessage() {
        return responseMessage;
    }
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }
    public String getCustNo() {
        return custNo;
    }
    public void setCustNo(String custNo) {
        this.custNo = custNo;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public CreateAccountResponse(String responseCode, String responseMessage, String custNo, String accountNumber) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.custNo = custNo;
        this.accountNumber = accountNumber;
    }


}
