package com.neptunesoftware.accelerex.customer.service;

import com.neptunesoftware.accelerex.config.AccelerexCredentials;
import com.neptunesoftware.accelerex.customer.request.CreateCustomerRequest;
import com.neptunesoftware.accelerex.customer.request.DepositAccountRequest;
import com.neptunesoftware.accelerex.customer.response.CreateAccountResponse;
import com.neptunesoftware.accelerex.customer.response.CreateCustomerResponse;
import com.neptunesoftware.accelerex.data.account.CreateDepositAccount;
import com.neptunesoftware.accelerex.data.account.CreateDepositAccountResponse;
import com.neptunesoftware.accelerex.data.account.DepositAccountRequestData;
import com.neptunesoftware.accelerex.data.customer.CreateCustomer;
import com.neptunesoftware.accelerex.data.customer.CustomerContactInformation;
import com.neptunesoftware.accelerex.data.customer.CustomerRequest;
import com.neptunesoftware.accelerex.exception.ValidationException;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.neptunesoftware.accelerex.account.sql.SqlQueries.UPDATE_CUSTOMER_STATUS;
import static com.neptunesoftware.accelerex.utils.ResponseConstants.*;

@Log4j2
@RequiredArgsConstructor
@Service
public class CreateBankAccountService  {

    private final AccelerexCredentials accelerexCredentials;
    private final JdbcTemplate jdbcTemplate;
    public CreateCustomerResponse createCustomer(CreateCustomerRequest request) {
        CreateAccountResponse accountResponse = null;
        String customerId = null;
        String customerNumber = null;
        try {
        CustomerRequest customerRequestData = buildCustomerRequest(request);
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(createCustomerMarshaller());
        CreateCustomer createCustomer = new CreateCustomer();
        createCustomer.setArg0(customerRequestData);
        com.neptunesoftware.accelerex.data.customer.CreateCustomerResponse webserviceResponse;

        JAXBElement  apiResponse  = (JAXBElement) webServiceTemplate
                .marshalSendAndReceive(accelerexCredentials.getCustomerWsdl(), createCustomer);
        webserviceResponse = (com.neptunesoftware.accelerex.data.customer.CreateCustomerResponse) apiResponse.getValue();
        customerId = String.valueOf(webserviceResponse.getReturn().getCustomerId());
        customerNumber = webserviceResponse.getReturn().getCustomerNumber();
        log.info("CustomerName {}",customerRequestData.getCustomerName());
        if (customerNumber != null) {
            updateTransaction(customerNumber);
            accountResponse =  createDepositAccount(
                    new DepositAccountRequest(customerNumber,customerId,customerRequestData.getCustomerName()));
        } else {
            log.info("Failed to create customer");
        }

        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCustomerResponse(WEBSERVICE_FAILED_RESPONSE_CODE,WEBSERVICE_FAILED_RESPONSE_CODE
                    ,customerId,customerNumber,null,null);
     }
        assert accountResponse != null;
        return new CreateCustomerResponse(SUCCESS_CODE,SUCCESS_MESSAGE,customerId,customerNumber,
                accountResponse.getAccountStatus(),accountResponse.getAccountNo());
    }
    private CreateAccountResponse createDepositAccount(DepositAccountRequest depositAccountRequest) {
        CreateAccountResponse response = new CreateAccountResponse();
        String generateAccountNumber;
        String accountStatus;
        try {
            DepositAccountRequestData depositRequest = buildDepositAccountRequest(depositAccountRequest);
            WebServiceTemplate webServiceTemplateA = new WebServiceTemplate(createAccountMarshaller());
            CreateDepositAccount createDepositAccount = new CreateDepositAccount();
            createDepositAccount.setArg0(depositRequest);

            JAXBElement webServiceResponse;
            CreateDepositAccountResponse createDepositAccountResponse;
            webServiceResponse = (JAXBElement) webServiceTemplateA.marshalSendAndReceive(accelerexCredentials.getAccountWsdl(), createDepositAccount);
            createDepositAccountResponse = (CreateDepositAccountResponse) webServiceResponse.getValue();

            log.info("AccountNumber {}", createDepositAccountResponse.getReturn().getPrimaryAccountNumber());

            if (!(createDepositAccountResponse.getReturn().getPrimaryAccountNumber() == null)) {
                generateAccountNumber = createDepositAccountResponse.getReturn().getPrimaryAccountNumber();
                accountStatus = createDepositAccountResponse.getReturn().getAccountStatus();
                response.setAccountNo(generateAccountNumber);
                response.setAccountStatus(accountStatus);
            } else {
                throw new ValidationException("Error creating Account");
            }
        } catch (Exception e) {
            e.printStackTrace();
         throw new RuntimeException("");
        }
        return response;
    }
    private CustomerRequest buildCustomerRequest(CreateCustomerRequest createCustomerRequest) {
        CustomerRequest customerRequestData = new CustomerRequest();
        String customerName;
        if (createCustomerRequest.getMiddleName() == null || createCustomerRequest.getMiddleName().isEmpty()) {
            customerName = createCustomerRequest.getFirstName()+" "+ createCustomerRequest.getLastName();
        } else {
            customerName = createCustomerRequest.getFirstName()+" "+createCustomerRequest.getMiddleName()+" "+createCustomerRequest.getLastName();
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

        if (!createCustomerRequest.getEmail().isEmpty()) {
            custContact.setCustomerShortName(createCustomerRequest.getFirstName());
            custContact.setContactDetails(createCustomerRequest.getEmail());
            custContact.setContactMode("CM101");
            custContact.setContactModeCategoryCode("CM101");
            custContact.setContactModeTypeId(201L);
            custContact.setStatus("A");
            contacts.add(custContact);
        }
        else {
            custContact.setContactDetails(createCustomerRequest.getPhone());
            custContact.setContactMode("CM100");
            custContact.setContactModeCategoryCode("CM100");
            custContact.setContactModeTypeId(206L);
            custContact.setCustomerShortName(createCustomerRequest.getFirstName());
            custContact.setStatus("S");
            contacts.add(custContact);
        }
//        customerRequestData.getContacts().add(custContact);
        customerRequestData.getContacts().addAll(contacts);
        customerRequestData.setAddressCity(createCustomerRequest.getCity());
        customerRequestData.setAddressCountryId(682L);
        customerRequestData.setAddressLine1(createCustomerRequest.getHomeAddress());
        customerRequestData.setAddressPropertyTypeId(422L);
        customerRequestData.setAddressState(createCustomerRequest.getState());
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
        customerRequestData.setCustomerType(904L);
        customerRequestData.setCustomerTypeCd("CT100");
        customerRequestData.setEmploymentFlag(false);
        customerRequestData.setCustomerName(customerName);
        customerRequestData.setFirstName(createCustomerRequest.getFirstName());
        customerRequestData.setGender("M");
        customerRequestData.setIndustryCd("SIC052");
        customerRequestData.setIndustryId(776L);
        customerRequestData.setLastName(createCustomerRequest.getLastName());
        customerRequestData.setLocale("en_US");
        customerRequestData.setMainBusinessUnitCd("001");
        customerRequestData.setMainBusinessUnitId(-99L);
        customerRequestData.setMaritalStatus("S");
        customerRequestData.setMarketingCampaignCd("MC112");
        customerRequestData.setMarketingCampaignId(369L);
        customerRequestData.setMiddleName(createCustomerRequest.getMiddleName());
        customerRequestData.setNationalityCd("N101");
        customerRequestData.setNationalityId(532L);
        customerRequestData.setNoOfDependents(0L);
        customerRequestData.setOpeningReasonCode("CC002");
        customerRequestData.setOpeningReasonId(702L);
        customerRequestData.setOperationCurrencyCd("NGN");
        customerRequestData.setOperationCurrencyId(732L);
        customerRequestData.setPreferredName(createCustomerRequest.getFirstName());
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
        customerRequestData.setStrDate(formatDate(LocalDate.now()));
        customerRequestData.setStrFromDate(formatDate(LocalDate.now()));
        customerRequestData.setStrDateOfBirth(createCustomerRequest.getDateOfBirth());
        customerRequestData.setSubmitFlag(true);
        customerRequestData.setTaxGroupCd("CTG105");
        customerRequestData.setTaxGroupId(442L);
        customerRequestData.setTitleCd("T114");
        customerRequestData.setTitleId(347L);

//         List<CustomerImageInformation> images = new ArrayList<>();
//         CustomerImageInformation custImage = new CustomerImageInformation();
//
//        byte[] image;
//        if (createCustomerRequest.getImage() != null && !createCustomerRequest.getImage().isEmpty()){
//            image = java.util.Base64.getEncoder().encodeToString(createCustomerRequest.getImage().getBytes()).getBytes();
//             custImage.setBinaryImage(image);
//             custImage.setImageTypeCode("PHO");
//             custImage.setBinaryImage(image);
//             images.add(custImage);
//         }
//        if (createCustomerRequest.getSignature() != null && !createCustomerRequest.getSignature().isEmpty()) {
//            image = java.util.Base64.getEncoder().encodeToString(createCustomerRequest.getSignature().getBytes()).getBytes();
//            custImage.setImageTypeCode("SIG");
//            custImage.setBinaryImage(image);
//         images.add(custImage);
//         }
//         customerRequestData.getImages().addAll(images);
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
        depositRequest.setChannelId(17L);
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
        depositRequest.setProductCode("304");
        depositRequest.setProductId(25L);
        depositRequest.setRelationshipOfficerCode("HSL1319-12");
        depositRequest.setRiskClassCd("RC110");
        depositRequest.setRiskClassId(744L);
        depositRequest.setSourceOfFundCode("SF014");
        depositRequest.setSourceOfFundId(430L);
        depositRequest.setStrOpeningDate("11/12/2021");
        return depositRequest;
    }

    private static String formatDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return date.format(formatter);
    }

    private Jaxb2Marshaller createCustomerMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in pom.xml
        String packageToScan = "com.neptunesoftware.accelerex.data.customer";
        marshaller.setPackagesToScan(packageToScan);
        return marshaller;
    }
    private Jaxb2Marshaller createAccountMarshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in pom.xml
        String packageToScan = "com.neptunesoftware.accelerex.data.account";
        marshaller.setPackagesToScan(packageToScan);
        return marshaller;
    }
    private void updateTransaction(String customerId) {
        try {
            jdbcTemplate.update(UPDATE_CUSTOMER_STATUS, customerId);
        } catch (DataAccessException e) {
            log.error("Error updating transaction in the database");
            log.error(e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }
}










//    private BalanceEnquiryRequestData buildRequest(String accountNumber) {
//
//        BalanceEnquiryRequestData balEnqRequest = new BalanceEnquiryRequestData();
//        balEnqRequest.setChannelCode(String.valueOf(1));
//        balEnqRequest.setTargetAccountNumber(accountNumber);
//        return balEnqRequest;
//    }

//
//    private CustomerRequest buildCustomerRequestSub(CreateCustomerRequest testRequest, String custNo, String custId) {
//        CustomerRequest customerRequestData = new CustomerRequest();
//        String customerName;
//
//        LocalDate currentDate = LocalDate.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
//
//        if (testRequest.getMiddleName().isEmpty()) {
//            customerName = testRequest.getFirstName() + " " + testRequest.getLastName();
//        } else {
//            customerName = testRequest.getFirstName() + " " + testRequest.getMiddleName() + " " + testRequest.getLastName();
//        }
//        customerRequestData.setCustomerNumber(custNo);
//        customerRequestData.setCustomerId(Long.valueOf(custId));
//        customerRequestData.setXapiServiceCode("STC029");
//        customerRequestData.setChannelCode("AGENCY");
//        customerRequestData.setChannelId(17L);
//        customerRequestData.setCurrBUId(-99L);
//        customerRequestData.setLocalCcyId(732L);
//        customerRequestData.setOriginatorUserId(-100L);
//        customerRequestData.setResponse(0);
//        customerRequestData.setTransmissionTime(12345678L);
//        customerRequestData.setUserId(-100L);
//        customerRequestData.setUserLoginId("EXTUSER");
//        customerRequestData.setUserRoleId(-100L);
//        customerRequestData.setValidXapiRequest(true);
//        // Contact Details
//        List<CustomerContactInformation> contacts = new ArrayList<>();
//        CustomerContactInformation custContact = new CustomerContactInformation();
//        custContact.setContactDetails(testRequest.getPhone());
//        custContact.setContactMode("CM100");
//        custContact.setContactModeCategoryCode("CM100");
//        custContact.setContactModeTypeId(206L);
//        custContact.setCustomerShortName(testRequest.getFirstName());
//        custContact.setStatus("S");
//        contacts.add(custContact);
//
//        //Email Details
//        String email = "";
//        if (testRequest.getEmail() != null) {
//            CustomerContactInformation emailContact = new CustomerContactInformation();
//            emailContact.setCustomerShortName(testRequest.getFirstName());
//            emailContact.setContactDetails(testRequest.getEmail());
//            emailContact.setContactMode("CM101");
//            emailContact.setContactModeCategoryCode("CM101");
//            emailContact.setContactModeTypeId(201L);
//            emailContact.setStatus("A");
//            contacts.add(emailContact);
//        }
//
//        customerRequestData.getContacts().addAll(contacts);
//        customerRequestData.setAddressCity(testRequest.getCity());
//        customerRequestData.setAddressCountryId(682L);
//        customerRequestData.setAddressLine1(testRequest.getHomeAddress());
//        customerRequestData.setAddressLine2(testRequest.getAlternativeAddress());
//        customerRequestData.setAddressPropertyTypeId(422L);
//        customerRequestData.setAddressState(testRequest.getState());
//        customerRequestData.setAddressTypeCd("AT105");
//        customerRequestData.setAddressTypeId(121L);
//        customerRequestData.setBusinessUnitCodeId(-99L);
//        customerRequestData.setCountryId(682L);
//        customerRequestData.setCountryOfBirthCd("NGA");
//        customerRequestData.setCountryOfBirthId(682L);
//        customerRequestData.setCountryOfResidenceId(682L);
//        customerRequestData.setCustCountryCd("NGA");
//        customerRequestData.setCustShortName("ADE");
//        customerRequestData.setCustomerCategory("PER");
//        customerRequestData.setCustomerSegmentCd("CS107");
//        customerRequestData.setCustomerSegmentId(424L);
//        customerRequestData.setCustomerType(721L);
//        customerRequestData.setCustomerTypeCd("CT100");
//        customerRequestData.setEmploymentFlag(false);
//        customerRequestData.setCustomerName(customerName);
//        customerRequestData.setFirstName(testRequest.getFirstName());
//        customerRequestData.setGender("M");
//        customerRequestData.setIndustryCd("SIC052");
//        customerRequestData.setIndustryId(776L);
//        customerRequestData.setLastName(testRequest.getLastName());
//        customerRequestData.setLocale("en_US");
//        customerRequestData.setMainBusinessUnitCd("001");
//        customerRequestData.setMainBusinessUnitId(-99L);
//        customerRequestData.setMaritalStatus("S");
//        customerRequestData.setMarketingCampaignCd("MC112");
//        customerRequestData.setMarketingCampaignId(369L);
//        customerRequestData.setMiddleName(testRequest.getMiddleName());
//        customerRequestData.setNationalityCd("N101");
//        customerRequestData.setNationalityId(532L);
//        customerRequestData.setNoOfDependents(0L);
//        customerRequestData.setOpeningReasonCode("CC002");
//        customerRequestData.setOpeningReasonId(702L);
//        customerRequestData.setOperationCurrencyCd("NGN");
//        customerRequestData.setOperationCurrencyId(732L);
//        customerRequestData.setPreferredName(testRequest.getFirstName());
//        customerRequestData.setPrimaryAddress(true);
//        customerRequestData.setPrimaryRelationshipOfficerCd("HSL1424-13");
//        customerRequestData.setPrimaryRelationshipOfficerId(1059L);
//        customerRequestData.setPrivacyLevel(3L);
//        customerRequestData.setPrivacyLevelId(13L);
//        customerRequestData.setPropertyTypeCd("PT107");
//        customerRequestData.setRelationshipOfficerOneId(1059L);
//        customerRequestData.setResidentCountryCd("NGA");
//        customerRequestData.setResidentFlag(true);
//        customerRequestData.setRiskCode("CUST105");
//        customerRequestData.setRiskCountryCd("NGA");
//        customerRequestData.setRiskId(745L);
//        customerRequestData.setServiceLevel(400L);
//        customerRequestData.setServiceLevelId(14L);
//        customerRequestData.setSourceOfFundCd("SF014");
//        customerRequestData.setSourceOfFundId(430L);
//        customerRequestData.setStatus("S");
//        customerRequestData.setStrDate(currentDate.format(formatter));
//        customerRequestData.setStrFromDate(currentDate.format(formatter));
//        customerRequestData.setStrDateOfBirth(testRequest.getDateOfBirth());
//        customerRequestData.setSubmitFlag(true);
//        customerRequestData.setTaxGroupCd("CTG105");
//        customerRequestData.setTaxGroupId(442L);
//        customerRequestData.setTitleCd("T114");
//        customerRequestData.setTitleId(347L);
//
//        List<CustomerImageInformation> images = new ArrayList<>();
//        CustomerImageInformation custImage = new CustomerImageInformation();
//
//        byte[] image;
//        if (!testRequest.getImage().isEmpty()) {
//            image = java.util.Base64.getEncoder().encode(testRequest.getImage().getBytes());
//            custImage.setBinaryImage(image);
//            custImage.setImageTypeCode("PHO");
//            images.add(custImage);
//        } else if (!testRequest.getSignature().isEmpty()) {
//            image = java.util.Base64.getEncoder().encode(testRequest.getSignature().getBytes());
//            custImage.setBinaryImage(image);
//            custImage.setImageTypeCode("SIG");
//            images.add(custImage);
//        }
//
//        customerRequestData.getImages().addAll(images);
//
//        return customerRequestData;
//    }