package com.neptunesoftware.accelerex.createCustomer;

import com.neptunesoftware.accelerex.config.AccelerexCredentials;
import com.neptunesoftware.accelerex.data.account.CreateDepositAccount;
import com.neptunesoftware.accelerex.data.account.DepositAccountOutputData;
import com.neptunesoftware.accelerex.data.account.DepositAccountRequestData;
import com.neptunesoftware.accelerex.data.customer.*;
import com.neptunesoftware.accelerex.utils.AppUtils;
import com.neptunesoftware.accelerex.utils.ResponseConstants;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

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
    private final AppUtils utils;
    private final AccelerexCredentials accelerexCredentials;

    public CreateBankAccountResponse createCustomer(CreateCustRqTest request) {

        CreateBankAccountResponse response = new CreateBankAccountResponse();
        CustomerRequest customerRequestData = buildCustomerRequest1(request);
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());

        CreateCustomer createCustomer = new CreateCustomer();
        createCustomer.setArg0(customerRequestData);

        CreateCustomerResponse webserviceResponse;

        JAXBElement  apiResponse;
        String customerNumber = null;
        String customerId = null;

//        try {

        apiResponse  = (JAXBElement) webServiceTemplate.marshalSendAndReceive(accelerexCredentials.getCustomerWsdl(),createCustomer);

            webserviceResponse = (CreateCustomerResponse) apiResponse.getValue();

          log.info("ResponseCode: {}",webserviceResponse.getReturn().getReturnCode());

            if (webserviceResponse.getReturn().getCustomerNumber() != null) {

                customerId = String.valueOf(webserviceResponse.getReturn().getCustomerId());
                customerNumber = webserviceResponse.getReturn().getCustomerNumber();

                log.info("Customer created successfully {}, Customer number {}",customerId, customerNumber);

            } else {

                throw  new RuntimeException("Failed in creating customer");

            }

            response.setResponseCode(WEBSERVICE_RESPONSE_CODE);
            response.setResponseMessage(SUCCESS_MESSAGE);
            response.setCustomerId(customerId);
            response.setCustomerNo(customerNumber);

//        } catch (Exception e) {
//            e.printStackTrace();
//            response.setResponseMessage(WEBSERVICE_FAILED_RESPONSE_MESSAGE);
//            response.setResponseCode(WEBSERVICE_FAILED_RESPONSE_CODE);
////            if (e instanceof SoapFaultClientException soapException) {
////                String errorCode =soapException.getFaultCode().getLocalPart();
////                System.out.println("Error Code: " + errorCode);
////            }
//        }

        return response;
    }

    CustomerRequest buildCustomerRequest(CreateBankAccountRequest request) {
        CustomerRequest customerRequestData = new CustomerRequest();
        String customerName;

        if (request.getMiddleName() != null) {

            customerName = request.getFirstName() + " " + request.getMiddleName() + " " + request.getLastName();

        } else {
            customerName = request.getFirstName() + " " + request.getLastName();
        }

        customerRequestData.setXapiServiceCode("STC029");
        customerRequestData.setChannelCode(accelerexCredentials.getChannelCode());
        customerRequestData.setChannelId(Long.valueOf(accelerexCredentials.getChannelId()));
        customerRequestData.setCurrBUId(-99L);
        customerRequestData.setLocalCcyId(732L);
        customerRequestData.setOriginatorUserId(-100L);
        customerRequestData.setResponse(0);
        customerRequestData.setTransmissionTime(12345678L);
        customerRequestData.setUserId(-100L);
        customerRequestData.setUserLoginId(accelerexCredentials.getUserLoginId());
        customerRequestData.setUserAccessCode(accelerexCredentials.getUserAccessCode());
        customerRequestData.setUserPassword(accelerexCredentials.getUserPassword());

        customerRequestData.setUserLoginId("EXTUSER");
        customerRequestData.setUserRoleId(-100L);
        customerRequestData.setValidXapiRequest(true);
        customerRequestData.setAddressCity(request.getCity());
        customerRequestData.setAddressCountryId(682L);

        customerRequestData.setAddressLine1(request.getHomeAddress());
        customerRequestData.setCustomerName(customerName);
        customerRequestData.setAddressLine2(request.getAlternativeAddress());
        customerRequestData.setAddressPropertyTypeId(422L);
        customerRequestData.setAddressState(request.getState());
        customerRequestData.setAddressTypeCd("AT105");
        customerRequestData.setAddressTypeId(121L);
        customerRequestData.setBusinessUnitCodeId(-99L);
        customerRequestData.setCountryId(682L);


        List<CustomerContactInformation> contacts = new ArrayList<>();
        CustomerContactInformation custContact = new CustomerContactInformation();

        custContact.setContactDetails(request.getPhone());
        custContact.setContactMode("CM100");
        custContact.setContactModeCategoryCode("CM100");
        custContact.setContactModeTypeId(206L);
        custContact.setCustomerShortName(request.getFirstName());
        custContact.setStatus("A");
        contacts.add(custContact);

        if (!request.getEmail().isEmpty()) {
            custContact.setCustomerShortName(request.getFirstName());
            custContact.setContactDetails(request.getEmail());
            custContact.setContactMode("CM101");
            custContact.setContactModeCategoryCode("CM101");
            custContact.setContactModeTypeId(201L);
            custContact.setStatus("A");
            contacts.add(custContact);
        }

        customerRequestData.getContacts().addAll(contacts);
        customerRequestData.setCountryOfBirthCd("NGA");
        customerRequestData.setCountryOfBirthId(682L);
        customerRequestData.setCountryOfResidenceId(682L);
        customerRequestData.setCustCountryCd("NGA");
        customerRequestData.setCustShortName(request.getFirstName());
        customerRequestData.setCustomerCategory("PER");

        customerRequestData.setCustomerSegmentCd("CS107");
        customerRequestData.setCustomerSegmentId(424L);
        customerRequestData.setCustomerType(721L);
        customerRequestData.setCustomerTypeCd("CT100");
        customerRequestData.setEmploymentFlag(false);
        customerRequestData.setFirstName(request.getFirstName());
        customerRequestData.setGender(request.getGender());

        // Identification
        List<CustomerIdentificationInformation> identifications = new ArrayList<CustomerIdentificationInformation>();
        CustomerIdentificationInformation custIdInfo = new CustomerIdentificationInformation();

        if (request.getBvn() == null) {
            custIdInfo.setIdentityType("IT127");
            custIdInfo.setIdentityTypeId(512L);
            custIdInfo.setIdentityNumber(request.getBvn());
            custIdInfo.setCountryOfIssue("NGA");
            custIdInfo.setCountryOfIssueId(682L);
            custIdInfo.setVerifiedFlag(false);

            identifications.add(custIdInfo);
        }

        customerRequestData.getIdentifications().addAll(identifications);
        customerRequestData.setIndustryCd("SIC052");
        customerRequestData.setIndustryId(776L);
        customerRequestData.setLastName(request.getLastName());
        customerRequestData.setLocale("en_US");
        customerRequestData.setMainBusinessUnitCd("001");
        customerRequestData.setMainBusinessUnitId(-99L);
        customerRequestData.setMaritalStatus("S");

        customerRequestData.setMarketingCampaignCd("MC112");
        customerRequestData.setMarketingCampaignId(369L);
        customerRequestData.setMiddleName(request.getMiddleName());
        customerRequestData.setNationalityCd("N101");
        customerRequestData.setNationalityId(532L);
        customerRequestData.setNoOfDependents(0L);

        customerRequestData.setOpeningReasonCode("CC002");
        customerRequestData.setOpeningReasonId(702L);
        customerRequestData.setOperationCurrencyCd("NGA");
        customerRequestData.setOperationCurrencyId(732L);

        customerRequestData.setPreferredName(request.getFirstName());
        customerRequestData.setPrimaryAddress(true);
        customerRequestData.setPrimaryRelationshipOfficerCd("HSL1424-13");// <primaryRelationshipOfficerCd>HSL1424-13</primaryRelationshipOfficerCd>
        customerRequestData.setPrimaryRelationshipOfficerId(1059L);
        customerRequestData.setPrivacyLevel(3L);

        customerRequestData.setPrivacyLevelId(13L);
        customerRequestData.setPropertyTypeCd("PT107");
        customerRequestData.setRelationshipOfficerOneId(1059L);//(relatnshpMgr);// <relationshipOfficerOneId>1059</relationshipOfficerOneId>
        customerRequestData.setResidentCountryCd("NGA");
        customerRequestData.setResidentFlag(true);
        customerRequestData.setRiskCode("CUST105");
        customerRequestData.setRiskCountryCd("NGA");
        customerRequestData.setRiskId(745L);

        customerRequestData.setServiceLevel(400L);
        customerRequestData.setServiceLevelId(14L);
        customerRequestData.setSourceOfFundCd("SF014");
        customerRequestData.setSourceOfFundId(430L);


        LocalDate currentDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String dob = (request.getDateOfBirth());

        customerRequestData.setStatus("A");
        customerRequestData.setStrDate(currentDate.format(formatter));
        customerRequestData.setStrFromDate(currentDate.format(formatter));
        customerRequestData.setStrRegistrationDate(currentDate.format(formatter));
        // <startDateMm>09</startDateMm>
        // <startDateYyyy>2021</startDateYyyy>
        customerRequestData.setStrDateOfBirth(dob);

        customerRequestData.setSubmitFlag(true);
        customerRequestData.setTaxGroupCd("CTG105");
        customerRequestData.setTaxGroupId(442L);
        customerRequestData.setTitleCd("T114");
        customerRequestData.setTitleId(347L);

        /*
         * List<CustomerImageInformation> images = new
         * ArrayList<CustomerImageInformation>(); CustomerImageInformation custImage =
         * new CustomerImageInformation(); if (!request.getImage().isEmpty()) {
         *
         * byte[] image = Base64.encode(request.getImage());
         * custImage.setBinaryImage(image); custImage.setImageTypeCode("PHO");
         *
         * images.add(custImage); }
         *
         * if (!request.getImage().isEmpty()) {
         *
         * byte[] image = Base64.encode(request.getSignature());
         * custImage.setBinaryImage(image); custImage.setImageTypeCode("SIG");
         *
         * images.add(custImage); } customerRequestData.getImages().addAll(images);
         */
        log.info("************************************* REQUEST DATA ****************************");
        System.out.println(utils.ObjectToJsonString(customerRequestData));
           return customerRequestData;
    }


    private CreateBankAccountResponse createDepositAccountForCustomer(String custName, String custId, String custNo) {
        DepositAccountRequestData depositRequest = new DepositAccountRequestData();
        depositRequest.setAmount(new BigDecimal(0));
        depositRequest.setAccountTitle(custName);
        depositRequest.setPrimaryCustomerId(Long.parseLong(custId));
        depositRequest.setPrimaryCustomerNumber(custNo);

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
//      depositRequest.setRelationshipOfficerId(1058L);
//      depositRequest.setRelationshipOfficerCode(relatnshpMgr);


        depositRequest.setRiskClassCd("RC110");
        depositRequest.setRiskClassId(744L);
        depositRequest.setSourceOfFundCode("SF014");
        depositRequest.setSourceOfFundId(430L);
//      depositRequest.setStrOpeningDate(utils.convertDateFormatToString(dbConn.getProcessingDate(), "dd-MM-yyyy", "dd/MM/yyyy"));

        CreateDepositAccount createDepositAccount = new CreateDepositAccount();
        createDepositAccount.setArg0(depositRequest);

        JAXBElement webServiceResponse;
        DepositAccountOutputData depAcctResponseData;
        String generateAccountNumber = null;
        String accountId = null;
        WebServiceTemplate webServiceTemplateA = new WebServiceTemplate(marshaller());

        try {

            webServiceResponse = (JAXBElement) webServiceTemplateA.marshalSendAndReceive(accelerexCredentials.getAccountWsdl(), createDepositAccount);

            depAcctResponseData = (DepositAccountOutputData) webServiceResponse.getValue();
            System.out.println(depAcctResponseData);

        } catch (Exception e) {
            return new CreateBankAccountResponse(ResponseConstants.WEBSERVICE_UNAVAILABLE_CODE,
                    ResponseConstants.WEBSERVICE_UNAVAILABLE_MESSAGE,
                    custNo, custId, null, null);
        }

        if (!(depAcctResponseData.getPrimaryAccountNumber() == null)) {
            generateAccountNumber = depAcctResponseData.getPrimaryAccountNumber();
            accountId = String.valueOf(depAcctResponseData.getAccountId());
        }

        System.out.println("*********** REQUEST DATA ****************************");
        log.info("********************* Request Parameter *************************");
        log.info("Rubikon Request Parameter Create Account: " + utils.ObjectToJsonString(depositRequest));

        System.out.println("*********** RESPONSE DATA ****************************");
        log.info("**********************Response Parameter************************");
        log.info("Rubikon Response Parameter Create Account: {}", utils.ObjectToJsonString(depAcctResponseData));
        System.out.println("*******************************************************");


        return new CreateBankAccountResponse(ResponseConstants.WEBSERVICE_RESPONSE_CODE, SUCCESS_MESSAGE,
                custNo, custId, accountId, generateAccountNumber);
    }

    private Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        String packageToScan = "com.neptunesoftware.accelerex.data.customer";
        marshaller.setPackagesToScan(packageToScan);
        return marshaller;
    }


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

    CustomerRequest buildCustomerRequest1(CreateCustRqTest testRequest) {
        CustomerRequest customerRequestData = new CustomerRequest();

        customerRequestData.setXapiServiceCode("STC029");
        customerRequestData.setChannelCode("MAPP");
        customerRequestData.setChannelId(121L);
        customerRequestData.setCurrBUId(-99L);
        customerRequestData.setLocalCcyId(732L);
        customerRequestData.setOriginatorUserId(-100L);
        customerRequestData.setResponse(0);
        customerRequestData.setTransmissionTime(12345678L);
        customerRequestData.setUserId(-100L);
        customerRequestData.setUserLoginId("EXTUSER");
        customerRequestData.setUserRoleId(-100L);
        customerRequestData.setValidXapiRequest(true);
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
        customerRequestData.setStatus("A");
        customerRequestData.setStrDate("27/09/2021"); //*****
        customerRequestData.setStrFromDate("24/09/2021"); //***
//        customerRequestData.setStartDateMm("09");
//        customerRequestData.setStartDateYyyy("2021");
        customerRequestData.setStrDateOfBirth(testRequest.getDateOfBirth());
        customerRequestData.setSubmitFlag(true);
        customerRequestData.setTaxGroupCd("CTG105");
        customerRequestData.setTaxGroupId(442L);
        customerRequestData.setTitleCd("T114");
        customerRequestData.setTitleId(347L);

        return customerRequestData;
    }

}

