package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.data.account.BalanceEnquiryRequestData;
import com.neptunesoftware.accelerex.data.account.Balanceenquiry;
import com.neptunesoftware.accelerex.data.account.BalanceenquiryResponse;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.WebServiceException;
import org.springframework.ws.client.WebServiceIOException;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;
@Service
@RequiredArgsConstructor
@Log4j2
public class BalanceEnquiryService {
    private static final String PACKAGE_TO_SCAN = "com.neptunesoftware.accelerex.data.account";
    private final AccountServices accountService;
    @Value("${endpoint.accountWebservice}")
    private String ACCOUNT_WEB_SERVICE_END_POINT_PORT;

    public BalanceenquiryResponse balanceEnquiry(String accountNumber) {
//        validateAccount(accountNumber);
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());
        BalanceEnquiryRequestData balEnqRequest = buildRequest(accountNumber);
        Balanceenquiry balanceenquiry = new Balanceenquiry();
        balanceenquiry.setArg0(balEnqRequest);
        JAXBElement response;
        try {
            response = (JAXBElement) webServiceTemplate.marshalSendAndReceive(
                    "http://10.152.2.161:7001/supernovaws/AccountWebServiceEndPointPort?wsdl", balanceenquiry);
            log.info(response.getValue().toString());
        } catch (Exception e) {
            throw new BalanceEnquiryException("An error occurred while querying the account balance" + " for account " + accountNumber);
        }
        return (BalanceenquiryResponse) response.getValue();
    }

    private BalanceEnquiryRequestData buildRequest(String accountNumber) {
        BalanceEnquiryRequestData balEnqRequest = new BalanceEnquiryRequestData();
//        balEnqRequest.setSessionId(String.valueOf(System.currentTimeMillis()));
        balEnqRequest.setChannelCode("1");
        balEnqRequest.setTargetAccountNumber(accountNumber);

//        balEnqRequest.setDestinationInstitutionCode("");
//        balEnqRequest.setTargetBankVerificationNumber("");
//        balEnqRequest.setAuthorizationCode("");
//        balEnqRequest.setTargetAccountName("");
//        balEnqRequest.setTargetBankVerificationNumber("");

        return balEnqRequest;
    }
    public boolean isAccountSufficient(String sourceAccount, BigDecimal amount) {
//        validateAccount(sourceAccount);
        BalanceenquiryResponse response = balanceEnquiry(sourceAccount);
        return response.getReturn().getAvailableBalance().compareTo(amount) >= 0;
//        if (b) throw new BalanceEnquiryException("Account has insufficient balance");
//        return false;
    }

//    private void validateAccount(String accountNumber) {
//        accountService.nameInquiry(accountNumber);
//    }

    private Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setPackagesToScan(PACKAGE_TO_SCAN);
        return marshaller;
    }

}
