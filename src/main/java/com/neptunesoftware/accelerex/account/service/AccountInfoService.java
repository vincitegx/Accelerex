//package com.neptunesoftware.accelerex.account.service;
//
//import com.neptunesoftware.accelerex.account.request.InfoRequest;
//import com.neptunesoftware.accelerex.account.response.AccountInfoResponseDto;
//import com.neptunesoftware.accelerex.config.AccelerexCredentials;
//import com.neptunesoftware.accelerex.data.account.AccountInquiryInfo;
//import com.neptunesoftware.accelerex.data.account.AccountRequest;
//import jakarta.xml.bind.JAXBElement;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//import org.springframework.stereotype.Service;
//import org.springframework.ws.client.core.WebServiceTemplate;
//
//@Service
//@RequiredArgsConstructor
//@Log4j2
//public class AccountInfoService {
//    private static final String ACCOUNT_PACKAGE_TO_SCAN = "com.neptunesoftware.accelerex.data.account";
//    private final AccelerexCredentials accelerexCredentials;
//
//    public AccountInfoResponseDto getAccountInformation(InfoRequest infoRequest) {
//        AccountInfoResponseDto accountInfoResponseDto;
//        try {
//            AccountRequest accountRequest = buildAccountRequestData(infoRequest);
//            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(createCustomerMarshaller());
//            AccountInquiryInfo accountInquiryInfo = new AccountInquiryInfo();
//            accountInquiryInfo.setArg0(accountRequest);
////             AccountInfoResponseDto accountInfoResponseDto;
//
//            JAXBElement apiResponse = (JAXBElement) webServiceTemplate
//                    .marshalSendAndReceive(accelerexCredentials.getAccountWsdl(), accountInquiryInfo);
//            accountInfoResponseDto = (AccountInfoResponseDto) apiResponse.getValue();
//            log.info(accountInfoResponseDto);
//        } catch (Exception e) {
//            throw new RuntimeException(e.getMessage());
//        }
//        return new AccountInfoResponseDto(accountInfoResponseDto);
//    }
//    public AccountRequest buildAccountRequestData(InfoRequest infoRequest) {
//        AccountRequest accountRequest = new AccountRequest();
//        accountRequest.setAccountNumber(infoRequest.getAccountNumber());
////        accountRequest.setCustomerPhoneNo(infoRequest.getPhoneNumber());
//        accountRequest.setAccountTitle(infoRequest.getAccountName());
////        accountRequest.setPrimaryCustomerId(Long.parseLong(request.getCustomerId()));
//        accountRequest.setXAPIServiceCode("STA060");
//        accountRequest.setChannelCode("AGENCY");
//        accountRequest.setChannelId(17L);
//        accountRequest.setOriginatorUserId(-100L);
//        accountRequest.setUserId(-100L);
//        accountRequest.setUserLoginId("EXTUSER");
//        accountRequest.setUserRoleId(-100L);
//        accountRequest.setCurrBUId(-99L);
//        accountRequest.setLocalCcyId(732L);
//        accountRequest.setTransmissionTime(123456789L);
//        accountRequest.setValidXapiRequest(true);
//        accountRequest.setProductId(25L);
//         return accountRequest;
//    }
//    private Jaxb2Marshaller createCustomerMarshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        marshaller.setPackagesToScan(ACCOUNT_PACKAGE_TO_SCAN);
//        return marshaller;
//    }
//}
