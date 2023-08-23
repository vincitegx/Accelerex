package com.neptunesoftware.accelerex.account.service;

import com.neptunesoftware.accelerex.account.response.BalanceResponse;
import com.neptunesoftware.accelerex.config.AccelerexCredentials;
import com.neptunesoftware.accelerex.data.account.BalanceEnquiryRequestData;
import com.neptunesoftware.accelerex.data.account.Balanceenquiry;
import com.neptunesoftware.accelerex.data.account.BalanceenquiryResponse;
import com.neptunesoftware.accelerex.exception.BalanceEnquiryException;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
@Log4j2
public class BalanceEnquiryService {

    private final AccelerexCredentials accelerexCredentials;

    public BalanceResponse balanceEnquiry(String accountNumber) {
        BalanceResponse response = new BalanceResponse();
        String availableBalance;
        String accountName;
        String accountNo;
        String responseCode;

        try {
            BalanceEnquiryRequestData balEnqRequest = buildRequest(accountNumber);
            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());

            Balanceenquiry balanceenquiry = new Balanceenquiry();
            balanceenquiry.setArg0(balEnqRequest);
            BalanceenquiryResponse balanceenquiryResponse;

            JAXBElement apiResponse = (JAXBElement) webServiceTemplate.marshalSendAndReceive(accelerexCredentials.getAccountWsdl(), balanceenquiry);
            balanceenquiryResponse = (BalanceenquiryResponse) apiResponse.getValue();

            availableBalance = String.valueOf(balanceenquiryResponse.getReturn().getAvailableBalance());
            responseCode = balanceenquiryResponse.getReturn().getResponseCode();
            accountName = balanceenquiryResponse.getReturn().getTargetAccountName();
            accountNo = balanceenquiryResponse.getReturn().getTargetAccountNumber();
            log.info(responseCode);
            if (!responseCode.equals("00")) {
                throw new BalanceEnquiryException(balanceenquiryResponse.getReturn().getResponseCode());

            } else {
                response.setAvailableBalance(availableBalance);
                response.setAccountName(accountName);
                response.setAccountNo(accountNo);
                response.setResponseCode(responseCode);
            }

        } catch (Exception e) {
            throw new BalanceEnquiryException(e.getMessage());
        }
        return response;
    }
    private BalanceEnquiryRequestData buildRequest(String accountNumber) {

        BalanceEnquiryRequestData balEnqRequest = new BalanceEnquiryRequestData();
        balEnqRequest.setChannelCode(String.valueOf(1));
        balEnqRequest.setTargetAccountNumber(accountNumber);
        return balEnqRequest;
    }
    private Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setPackagesToScan("com.neptunesoftware.accelerex.data.account");
        return marshaller;
    }
    public boolean isAccountSufficient(String accountNumber, BigDecimal amount) {
        validateAccount(accountNumber);
        BalanceResponse response = balanceEnquiry(accountNumber);
        boolean b = response.getAvailableBalance().compareTo(String.valueOf(amount)) >= 0;
        if (!b) {
            throw new BalanceEnquiryException("Account has insufficient balance");
        }
        return true;
    }
    private void validateAccount(String accountNumber) {
        balanceEnquiry(accountNumber);
    }
}