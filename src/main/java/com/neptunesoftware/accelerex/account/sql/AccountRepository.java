package com.neptunesoftware.accelerex.account.sql;

public interface AccountRepository  {
    boolean findAccountByPhoneAndAccountNumber(String phoneNum,String accountNumber);
//    public void  linkedAccount(String userName, String phoneNumber, String email, String accountNumber);
}