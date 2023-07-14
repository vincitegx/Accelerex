package com.neptunesoftware.accelerex.createCustomer;

import com.neptunesoftware.accelerex.account.response.BalanceResponse;
import com.neptunesoftware.accelerex.config.AccelerexCredentials;
import com.neptunesoftware.accelerex.data.account.*;
import com.neptunesoftware.accelerex.data.customer.CreateCustomer;
import com.neptunesoftware.accelerex.data.customer.CustomerContactInformation;
import com.neptunesoftware.accelerex.data.customer.CustomerImageInformation;
import com.neptunesoftware.accelerex.data.customer.CustomerRequest;
import com.neptunesoftware.accelerex.exception.BalanceEnquiryException;
import com.neptunesoftware.accelerex.exception.ValidationException;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
import org.springframework.ws.soap.client.SoapFaultClientException;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.neptunesoftware.accelerex.utils.ResponseConstants.*;

@Log4j2
@RequiredArgsConstructor
@Service
public class CreateBankAccountServiceImpl implements CreateBankAccountService {

    private final AccelerexCredentials accelerexCredentials;

    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {

        CreateCustomerResponse response = new CreateCustomerResponse();

        String customerNumber;
        String customerId;
        String accountStatus;
        String customerName;

        try {
    
        CustomerRequest customerRequestData = buildCustomerRequest(request);
        log.info("Customer Request Date {}",customerRequestData);

        customerName = customerRequestData.getCustomerName();
        log.info("Customer Name {}", customerName);

        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(createCustomerMarshaller());

        CreateCustomer createCustomer = new CreateCustomer();
        createCustomer.setArg0(customerRequestData);

        com.neptunesoftware.accelerex.data.customer.CreateCustomerResponse webserviceResponse;

        JAXBElement  apiResponse;

        apiResponse  = (JAXBElement) webServiceTemplate.marshalSendAndReceive(accelerexCredentials.getCustomerWsdl(),createCustomer);

            webserviceResponse = (com.neptunesoftware.accelerex.data.customer.CreateCustomerResponse) apiResponse.getValue();

            if (webserviceResponse.getReturn().getCustomerNumber() != null) {

                customerId = String.valueOf(webserviceResponse.getReturn().getCustomerId());
                customerNumber = webserviceResponse.getReturn().getCustomerNumber();
                accountStatus = webserviceResponse.getReturn().getStatus();

                log.info("ResponseCode {}, Reference {}", webserviceResponse.getReturn().getReturnCode(), webserviceResponse.getReturn().getReferenceNo());
                log.info("Error Message {}", webserviceResponse.getReturn().getErrorMsg());
                log.info("AccountStatus: {}", accountStatus);
                log.info("Customer Name From Webservice call: {}", webserviceResponse.getReturn().getCustomerName());
                log.info("HttpStatus {}", HttpStatus.valueOf(200));
                log.info("Customer Created Successfully ");
                log.info("Customer Id {}, Customer Number {}, AccountStatus: {}", customerId, customerNumber, accountStatus);

                response.setResponseCode(SUCCESS_CODE);
                response.setResponseMessage(SUCCESS_MESSAGE);
                response.setCustomerNo(customerNumber);
                response.setCustomerId(customerId);
                response.setStatus(accountStatus);

//                CustomerRequest submitRequest = buildCustomerRequestSub(request,customerNumber,customerId);
//
//                SubmitCustomer submitCustomer = new SubmitCustomer();
//                submitCustomer.setArg0(submitRequest);
//
//
//                SubmitCustomerResponse submitWebResponse;
//
//                WebServiceTemplate webServiceTemplate1 = new WebServiceTemplate(createCustomerMarshaller());
//
//                JAXBElement submitResponse;
//
//                submitResponse = (JAXBElement) webServiceTemplate1.marshalSendAndReceive(accelerexCredentials.getCustomerWsdl(),submitCustomer);
//                submitWebResponse = (SubmitCustomerResponse) submitResponse.getValue();
//                if (submitWebResponse.getReturn().getCustomerNumber().isEmpty()) {
//                    throw new CustomerFailedException("Error submitting customer");
//                }
//
//                log.info("Customer Status {}, CustomerId {}, CustomerName {}, CustomerNumber {}",
//                        submitWebResponse.getReturn().getStatus(),
//                        submitWebResponse.getReturn().getCustomerId(),
//                        submitWebResponse.getReturn().getCustomerName(),
//                        submitWebResponse.getReturn().getCustomerNumber());
//
//            } else {
//
//                throw  new CustomerFailedException("Failed to customer");
//            }

                log.info("******************Create Bank Account Starts here *********************");

                                 //Todo: Create bank account
                /**
                the method at this point creates the customer with an inactive status(accountStatus= I),
                 customerNumber and customerId which are the parameters for creating the bankAccount.
                Trying to use the above parameter from the said method would throw a xapiErrorCode of 0064, ie customer status inactive
                 */
            }
            
        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseMessage(WEBSERVICE_FAILED_RESPONSE_MESSAGE);
            response.setResponseCode(WEBSERVICE_FAILED_RESPONSE_CODE);

            if (e instanceof SoapFaultClientException soapException) {

                String errorCode =soapException.getFaultCode().getLocalPart();
                System.out.println("Error Code: " + errorCode);
           }
     }
        return response;
    }

//    public BalanceResponse balanceEnquiry(String accountNumber) {
//        BalanceResponse response = new BalanceResponse();
//        String availableBalance;
//        String accountName;
//        String accountNo;
//        String responseCode;
//
//        try {
//
//            BalanceEnquiryRequestData balEnqRequest = buildRequest(accountNumber);
//            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshallerB());
//
//            Balanceenquiry balanceenquiry = new Balanceenquiry();
//            balanceenquiry.setArg0(balEnqRequest);
//
//            BalanceenquiryResponse balanceenquiryResponse;
//            JAXBElement apiResponse;
//
//            apiResponse = (JAXBElement) webServiceTemplate.marshalSendAndReceive(accelerexCredentials.getAccountWsdl(), balanceenquiry);
//
//            balanceenquiryResponse = (BalanceenquiryResponse) apiResponse.getValue();
//            availableBalance = String.valueOf(balanceenquiryResponse.getReturn().getAvailableBalance());
//            responseCode = balanceenquiryResponse.getReturn().getResponseCode();
//            accountName = balanceenquiryResponse.getReturn().getTargetAccountName();
//            accountNo = balanceenquiryResponse.getReturn().getTargetAccountNumber();
//
//            log.info("Available Balance {}", availableBalance);
//            log.info("ResponseCode {}", responseCode);
//
//            if (!responseCode.equals("00")) {
//                throw  new BalanceEnquiryException("There was an error querying Balance for accountNumber " +accountNumber);
//            }
//
//        } catch (Exception e) {
//            throw new BalanceEnquiryException(WEBSERVICE_FAILED_RESPONSE_MESSAGE);
//        }
//
//        response.setAvailableBalance(availableBalance);
//        response.setAccountName(accountName);
//        response.setAccountNo(accountNo);
//        response.setResponseCode(responseCode);
//        response.setResponseMessage(SUCCESS_MESSAGE);
//
//        log.info("HttpStatus {}", HttpStatus.OK);
//
//        return response;
//    }

    public CreateAccountResponse createDepositAccount(DepositAccountRequest depositAccountRequest) {
        CreateAccountResponse response = new CreateAccountResponse();
        String generateAccountNumber;
        String accountId;

        try {
            
            DepositAccountRequestData depositRequest = buildDepositAccountRequest(depositAccountRequest);
            WebServiceTemplate webServiceTemplateA = new WebServiceTemplate(createAccountMarshaller());

            CreateDepositAccount createDepositAccount = new CreateDepositAccount();
            createDepositAccount.setArg0(depositRequest);

            JAXBElement webServiceResponse;
            CreateDepositAccountResponse createDepositAccountResponse;

            webServiceResponse = (JAXBElement) webServiceTemplateA.marshalSendAndReceive(accelerexCredentials.getAccountWsdl(), createDepositAccount);

            createDepositAccountResponse = (CreateDepositAccountResponse) webServiceResponse.getValue();
            System.out.println(createDepositAccountResponse.getReturn().getAccountId());
            log.info("Account number {}", createDepositAccountResponse.getReturn().getPrimaryAccountNumber());

            if (!(createDepositAccountResponse.getReturn().getPrimaryAccountNumber() == null)) {
                generateAccountNumber = createDepositAccountResponse.getReturn().getPrimaryAccountNumber();
                accountId = String.valueOf(createDepositAccountResponse.getReturn().getAccountId());

                response.setAccountId(accountId);
                response.setAccountNo(generateAccountNumber);
                response.setAccountStatus(createDepositAccountResponse.getReturn().getAccountStatus());

            } else {
                throw new ValidationException("Error creating Account");
            }

        } catch (Exception e) {
            e.printStackTrace();
            response.setResponseMessage(WEBSERVICE_FAILED_RESPONSE_MESSAGE);
            response.setResponseCode(WEBSERVICE_FAILED_RESPONSE_CODE);

            if (e instanceof SoapFaultClientException soapException) {

                String errorCode =soapException.getFaultCode().getLocalPart();
                System.out.println("Error Code: " + errorCode);
            }
        }

        return response;
    }


    private CustomerRequest buildCustomerRequest(CreateCustomerRequest testRequest) throws IOException {
        CustomerRequest customerRequestData = new CustomerRequest();
        String customerName;

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        if (testRequest.getMiddleName().isEmpty() ) {
            customerName = testRequest.getFirstName()+" "+ testRequest.getLastName();
        } else {
            customerName = testRequest.getFirstName()+" "+testRequest.getMiddleName()+" "+testRequest.getLastName();
        }
        customerRequestData.setXapiServiceCode("STC029");
        customerRequestData.setChannelCode("AGENCY");
        customerRequestData.setChannelId(17L);
        customerRequestData.setCurrBUId(-99L);
        customerRequestData.setLocalCcyId(732L);
        customerRequestData.setOriginatorUserId(-100L);
        customerRequestData.setResponse(0);
        customerRequestData.setTransmissionTime(12345678L);
        customerRequestData.setUserId(-100L);
        customerRequestData.setUserLoginId("EXTUSER");
        customerRequestData.setUserRoleId(-100L);
        customerRequestData.setValidXapiRequest(true);

        //Contact Details
        List<CustomerContactInformation> contacts = new ArrayList<>();
        CustomerContactInformation custContact = new CustomerContactInformation();



        if (!testRequest.getEmail().isEmpty()) {
            custContact.setCustomerShortName(testRequest.getFirstName());
            custContact.setContactDetails(testRequest.getEmail());
            custContact.setContactMode("CM101");
            custContact.setContactModeCategoryCode("CM101");
            custContact.setContactModeTypeId(201L);
            custContact.setStatus("A");
            contacts.add(custContact);
        }
        else {
            custContact.setContactDetails(testRequest.getPhone());
            custContact.setContactMode("CM100");
            custContact.setContactModeCategoryCode("CM100");
            custContact.setContactModeTypeId(206L);
            custContact.setCustomerShortName(testRequest.getFirstName());
            custContact.setStatus("S");
            contacts.add(custContact);
        }

        customerRequestData.getContacts().addAll(contacts);

        customerRequestData.setAddressCity(testRequest.getCity());
        customerRequestData.setAddressCountryId(682L);
        customerRequestData.setAddressLine1(testRequest.getHomeAddress());
        customerRequestData.setAddressLine2(testRequest.getAlternativeAddress());
        customerRequestData.setAddressPropertyTypeId(422L);
        customerRequestData.setAddressState(testRequest.getState());
        customerRequestData.setAddressTypeCd("AT105");
        customerRequestData.setAddressTypeId(121L);
        customerRequestData.setBusinessUnitCodeId(-99L);
        customerRequestData.setCountryId(682L);
        customerRequestData.setCountryOfBirthCd("NGA");
        customerRequestData.setCountryOfBirthId(682L);
        customerRequestData.setCountryOfResidenceId(682L);
        customerRequestData.setCustCountryCd("NGA");
        customerRequestData.setCustShortName("ADE");
        customerRequestData.setCustomerCategory("PER");
        customerRequestData.setCustomerSegmentCd("CS107");
        customerRequestData.setCustomerSegmentId(424L);
        customerRequestData.setCustomerType(721L);
        customerRequestData.setCustomerTypeCd("CT100");
        customerRequestData.setEmploymentFlag(false);
        customerRequestData.setCustomerName(customerName);
        customerRequestData.setFirstName(testRequest.getFirstName());
        customerRequestData.setGender("M");
        customerRequestData.setIndustryCd("SIC052");
        customerRequestData.setIndustryId(776L);
        customerRequestData.setLastName(testRequest.getLastName());
        customerRequestData.setLocale("en_US");
        customerRequestData.setMainBusinessUnitCd("001");
        customerRequestData.setMainBusinessUnitId(-99L);
        customerRequestData.setMaritalStatus("S");
        customerRequestData.setMarketingCampaignCd("MC112");
        customerRequestData.setMarketingCampaignId(369L);
        customerRequestData.setMiddleName(testRequest.getMiddleName());
        customerRequestData.setNationalityCd("N101");
        customerRequestData.setNationalityId(532L);
        customerRequestData.setNoOfDependents(0L);
        customerRequestData.setOpeningReasonCode("CC002");
        customerRequestData.setOpeningReasonId(702L);
        customerRequestData.setOperationCurrencyCd("NGN");
        customerRequestData.setOperationCurrencyId(732L);
        customerRequestData.setPreferredName(testRequest.getFirstName());
        customerRequestData.setPrimaryAddress(true);
        customerRequestData.setPrimaryRelationshipOfficerCd("HSL1424-13");
        customerRequestData.setPrimaryRelationshipOfficerId(1059L);
        customerRequestData.setPrivacyLevel(3L);
        customerRequestData.setPrivacyLevelId(13L);
        customerRequestData.setPropertyTypeCd("PT107");
        customerRequestData.setRelationshipOfficerOneId(1059L);
        customerRequestData.setResidentCountryCd("NGA");
        customerRequestData.setResidentFlag(true);
        customerRequestData.setRiskCode("CUST105");
        customerRequestData.setRiskCountryCd("NGA");
        customerRequestData.setRiskId(745L);
        customerRequestData.setServiceLevel(400L);
        customerRequestData.setServiceLevelId(14L);
        customerRequestData.setSourceOfFundCd("SF014");
        customerRequestData.setSourceOfFundId(430L);
        customerRequestData.setStatus("S");
        customerRequestData.setStrDate("07/03/2023");
        customerRequestData.setStrFromDate("07/03/2023");

//        customerRequestData.setStartDateMm("09");
//        customerRequestData.setStartDateYyyy("2021");
        customerRequestData.setStrDateOfBirth(testRequest.getDateOfBirth());
        customerRequestData.setSubmitFlag(true);
        customerRequestData.setTaxGroupCd("CTG105");
        customerRequestData.setTaxGroupId(442L);
        customerRequestData.setTitleCd("T114");
        customerRequestData.setTitleId(347L);



//         List<CustomerImageInformation> images = new ArrayList<>();
//         CustomerImageInformation custImage = new CustomerImageInformation();
//
//       byte[] image;
//         if (!testRequest.getImage().isEmpty()) {
//
//         image = java.util.Base64.getEncoder().encodeToString(testRequest.getImage().getBytes()).getBytes();
//         custImage.setBinaryImage(image); custImage.setImageTypeCode("PHO");
//
//         images.add(custImage);
//
//         }  else {
//
//       image = Base64.getEncoder().encodeToString(testRequest.getSignature().getBytes()).getBytes();
//         custImage.setBinaryImage(image); custImage.setImageTypeCode("SIG");
//
//         images.add(custImage);
//         }
//
//         customerRequestData.getImages().addAll(images);
//
//
        return customerRequestData;
    }

    private CustomerRequest buildCustomerRequestSub(CreateCustomerRequest testRequest, String custNo, String custId) {
        CustomerRequest customerRequestData = new CustomerRequest();
        String customerName;

        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        if (testRequest.getMiddleName().isEmpty()) {
            customerName = testRequest.getFirstName() + " " + testRequest.getLastName();
        } else {
            customerName = testRequest.getFirstName() + " " + testRequest.getMiddleName() + " " + testRequest.getLastName();
        }
        customerRequestData.setCustomerNumber(custNo);
        customerRequestData.setCustomerId(Long.valueOf(custId));
        customerRequestData.setXapiServiceCode("STC029");
        customerRequestData.setChannelCode("AGENCY");
        customerRequestData.setChannelId(17L);
        customerRequestData.setCurrBUId(-99L);
        customerRequestData.setLocalCcyId(732L);
        customerRequestData.setOriginatorUserId(-100L);
        customerRequestData.setResponse(0);
        customerRequestData.setTransmissionTime(12345678L);
        customerRequestData.setUserId(-100L);
        customerRequestData.setUserLoginId("EXTUSER");
        customerRequestData.setUserRoleId(-100L);
        customerRequestData.setValidXapiRequest(true);

        // Contact Details
        List<CustomerContactInformation> contacts = new ArrayList<>();
        CustomerContactInformation custContact = new CustomerContactInformation();

        custContact.setContactDetails(testRequest.getPhone());
        custContact.setContactMode("CM100");
        custContact.setContactModeCategoryCode("CM100");
        custContact.setContactModeTypeId(206L);
        custContact.setCustomerShortName(testRequest.getFirstName());
        custContact.setStatus("S");
        contacts.add(custContact);

        if (!testRequest.getEmail().isEmpty()) {
            CustomerContactInformation emailContact = new CustomerContactInformation();
            emailContact.setCustomerShortName(testRequest.getFirstName());
            emailContact.setContactDetails(testRequest.getEmail());
            emailContact.setContactMode("CM101");
            emailContact.setContactModeCategoryCode("CM101");
            emailContact.setContactModeTypeId(201L);
            emailContact.setStatus("A");
            contacts.add(emailContact);
        }

        customerRequestData.getContacts().addAll(contacts);

        customerRequestData.setAddressCity(testRequest.getCity());
        customerRequestData.setAddressCountryId(682L);
        customerRequestData.setAddressLine1(testRequest.getHomeAddress());
        customerRequestData.setAddressLine2(testRequest.getAlternativeAddress());
        customerRequestData.setAddressPropertyTypeId(422L);
        customerRequestData.setAddressState(testRequest.getState());
        customerRequestData.setAddressTypeCd("AT105");
        customerRequestData.setAddressTypeId(121L);
        customerRequestData.setBusinessUnitCodeId(-99L);
        customerRequestData.setCountryId(682L);
        customerRequestData.setCountryOfBirthCd("NGA");
        customerRequestData.setCountryOfBirthId(682L);
        customerRequestData.setCountryOfResidenceId(682L);
        customerRequestData.setCustCountryCd("NGA");
        customerRequestData.setCustShortName("ADE");
        customerRequestData.setCustomerCategory("PER");
        customerRequestData.setCustomerSegmentCd("CS107");
        customerRequestData.setCustomerSegmentId(424L);
        customerRequestData.setCustomerType(721L);
        customerRequestData.setCustomerTypeCd("CT100");
        customerRequestData.setEmploymentFlag(false);
        customerRequestData.setCustomerName(customerName);
        customerRequestData.setFirstName(testRequest.getFirstName());
        customerRequestData.setGender("M");
        customerRequestData.setIndustryCd("SIC052");
        customerRequestData.setIndustryId(776L);
        customerRequestData.setLastName(testRequest.getLastName());
        customerRequestData.setLocale("en_US");
        customerRequestData.setMainBusinessUnitCd("001");
        customerRequestData.setMainBusinessUnitId(-99L);
        customerRequestData.setMaritalStatus("S");
        customerRequestData.setMarketingCampaignCd("MC112");
        customerRequestData.setMarketingCampaignId(369L);
        customerRequestData.setMiddleName(testRequest.getMiddleName());
        customerRequestData.setNationalityCd("N101");
        customerRequestData.setNationalityId(532L);
        customerRequestData.setNoOfDependents(0L);
        customerRequestData.setOpeningReasonCode("CC002");
        customerRequestData.setOpeningReasonId(702L);
        customerRequestData.setOperationCurrencyCd("NGN");
        customerRequestData.setOperationCurrencyId(732L);
        customerRequestData.setPreferredName(testRequest.getFirstName());
        customerRequestData.setPrimaryAddress(true);
        customerRequestData.setPrimaryRelationshipOfficerCd("HSL1424-13");
        customerRequestData.setPrimaryRelationshipOfficerId(1059L);
        customerRequestData.setPrivacyLevel(3L);
        customerRequestData.setPrivacyLevelId(13L);
        customerRequestData.setPropertyTypeCd("PT107");
        customerRequestData.setRelationshipOfficerOneId(1059L);
        customerRequestData.setResidentCountryCd("NGA");
        customerRequestData.setResidentFlag(true);
        customerRequestData.setRiskCode("CUST105");
        customerRequestData.setRiskCountryCd("NGA");
        customerRequestData.setRiskId(745L);
        customerRequestData.setServiceLevel(400L);
        customerRequestData.setServiceLevelId(14L);
        customerRequestData.setSourceOfFundCd("SF014");
        customerRequestData.setSourceOfFundId(430L);
        customerRequestData.setStatus("S");
        customerRequestData.setStrDate(currentDate.format(formatter));
        customerRequestData.setStrFromDate(currentDate.format(formatter));
        customerRequestData.setStrDateOfBirth(testRequest.getDateOfBirth());
        customerRequestData.setSubmitFlag(true);
        customerRequestData.setTaxGroupCd("CTG105");
        customerRequestData.setTaxGroupId(442L);
        customerRequestData.setTitleCd("T114");
        customerRequestData.setTitleId(347L);

        List<CustomerImageInformation> images = new ArrayList<>();
        CustomerImageInformation custImage = new CustomerImageInformation();

        byte[] image;
        if (!testRequest.getImage().isEmpty()) {
            image = java.util.Base64.getEncoder().encode(testRequest.getImage().getBytes());
            custImage.setBinaryImage(image);
            custImage.setImageTypeCode("PHO");
            images.add(custImage);
        } else if (!testRequest.getSignature().isEmpty()) {
            image = java.util.Base64.getEncoder().encode(testRequest.getSignature().getBytes());
            custImage.setBinaryImage(image);
            custImage.setImageTypeCode("SIG");
            images.add(custImage);
        }

        customerRequestData.getImages().addAll(images);

        return customerRequestData;
    }


    private DepositAccountRequestData buildDepositAccountRequest(DepositAccountRequest request) {
        DepositAccountRequestData depositRequest = new DepositAccountRequestData();
        depositRequest.setAmount(new BigDecimal(0));
        depositRequest.setAccountTitle(request.getCustomerName());
        depositRequest.setPrimaryCustomerId(Long.parseLong(request.getCustomerId()));
        depositRequest.setPrimaryCustomerNumber(request.getCustomerNo());

        depositRequest.setXAPIServiceCode("STA060");
        depositRequest.setChannelCode("AGENCY");
        depositRequest.setChannelId(121L);

        depositRequest.setOriginatorUserId(-100L);
        depositRequest.setUserId(-100L);
        depositRequest.setUserLoginId("EXTUSER");
        depositRequest.setUserRoleId(-100L);

        depositRequest.setCurrBUId(-99L);
        depositRequest.setLocalCcyId(732L);
        depositRequest.setTransmissionTime(123456789L);
        depositRequest.setValidXapiRequest(true);
        depositRequest.setCampaignRefCode("MC112");
        depositRequest.setCampaignRefId(369L);
        depositRequest.setCountryId(687L);
        depositRequest.setOpeningReasonCode("CC002");
        depositRequest.setOpenningReasonId(702L);
        depositRequest.setProductCode("205");
        depositRequest.setProductId(15L);
        depositRequest.setRelationshipOfficerId(1058L);
        depositRequest.setRelationshipOfficerCode("HSL1424-13");


        depositRequest.setRiskClassCd("RC110");
        depositRequest.setRiskClassId(744L);
        depositRequest.setSourceOfFundCode("SF014");
        depositRequest.setSourceOfFundId(430L);
        depositRequest.setStrOpeningDate("");

        return depositRequest;
    }

    private BalanceEnquiryRequestData buildRequest(String accountNumber) {

        BalanceEnquiryRequestData balEnqRequest = new BalanceEnquiryRequestData();
        balEnqRequest.setChannelCode(String.valueOf(1));
        balEnqRequest.setTargetAccountNumber(accountNumber);
        return balEnqRequest;
    }

    private Jaxb2Marshaller createCustomerMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        String packageToScan = "com.neptunesoftware.accelerex.data.customer";
        marshaller.setPackagesToScan(packageToScan);
        return marshaller;
    }

    private Jaxb2Marshaller createAccountMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        String packageToScan = "com.neptunesoftware.accelerex.data.account";
        marshaller.setPackagesToScan(packageToScan);
        return marshaller;
    }

    private Marshaller marshallerB() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setPackagesToScan("com.neptunesoftware.accelerex.data.account");
        return marshaller;
    }
}
//                    "responseCode": "00",
//                            "responseMessage": "Successful",
//                            "customerId": "351539",
//                            "customerNo": "0000101294",
//                            "status": "I"
//                            }



//        System.out.println("****************************************************************");
//        if (customerResponseData.getCustomerId() != null && customerResponseData.getCustomerNumber() != null) {
//
//            accountNumber = createDepositAccountForCustomer(customerResponseData.getCustomerName(),
//                    String.valueOf(customerResponseData.getCustomerId())
//                    , customerResponseData.getCustomerNumber()).getAccountNumber();
//
//            accountId = createDepositAccountForCustomer(customerResponseData.getCustomerName(),
//                    String.valueOf(customerResponseData.getCustomerId())
//                    , customerResponseData.getCustomerNumber()).getAccountNumber();
//
//            response.setAccountId(accountId);
//            response.setAccountNumber(accountNumber);
//
//            log.info("SUCCESS {}", HttpStatus.valueOf(200));
//
//            response.setResponseCode(ResponseConstants.SUCCESS_CODE);
//            response.setResponseMessage(SUCCESS_MESSAGE);
//
//            log.info("*********Bank Account Created Successfully***************");
//        }
//
//
//        log.info("Account Details {}", response);
