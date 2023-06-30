package com.neptunesoftware.accelerex.createCustomer;

import com.neptunesoftware.accelerex.account.AccountRepositoryImp;
import com.neptunesoftware.accelerex.utils.AppUtils;
import com.neptunesoftware.accelerex.utils.ResponseConstants;
import data.account.CreateDepositAccount;
import data.account.DepositAccountOutputData;
import data.account.DepositAccountRequestData;
import data.customer.CreateCustomer;
import data.customer.CustomerIdentificationInformation;
import data.customer.CustomerOutputData;
import data.customer.CustomerRequest;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import static com.neptunesoftware.accelerex.utils.ResponseConstants.SUCCESS_MESSAGE;

@Log4j2
@RequiredArgsConstructor
@Service
public class CreateCustomerAccountServiceImpl implements CreateCustomerAccountService{
    private final AppUtils utils;
    private final String PackageToScan= "com.neptunesoftware.accelerex.data.customer, com.neptunesoftware.accelerex.data.account";
    private final AccountRepositoryImp accountRepositoryImp;
    @Value("${endpoint.accountWebservice}")
    private String ACCOUNT_WEBSERVICE;
    @Value("${endpoint.customerWebService}")
    private String CUSTOMER_WEBSERVICE;

    public CreateAccountResponse createCustomer(CreateCustomerRequest request) throws ParseException {

        CustomerOutputData customerResponseData;

        CreateAccountResponse response = new CreateAccountResponse();

        CustomerRequest customerRequestData = new CustomerRequest();

        String customerName;
        String customerNumber;
        String customerId;
        String accountNumber = null;
        String accountId = null;

        if (request.getMiddleName() != null) {
            customerName = request.getFirstName() + " " + request.getMiddleName() + " " + request.getLastName();
        } else {
            customerName = request.getFirstName() + " " + request.getLastName();
        }

        customerRequestData.setXapiServiceCode("STC029");
        customerRequestData.setChannelCode("AGENT");
        customerRequestData.setChannelId(14L);
        customerRequestData.setCurrBUId(-99L);
        customerRequestData.setLocalCcyId(732L);
        customerRequestData.setOriginatorUserId(-100L);
        customerRequestData.setResponse(0);
        customerRequestData.setTransmissionTime(12345678L);
        customerRequestData.setUserId(-100L);
        customerRequestData.setUserLoginId("EXTUSER");
        customerRequestData.setUserRoleId(-100L);
        customerRequestData.setValidXapiRequest(true);
        customerRequestData.setAddressCity(request.getCity());
        customerRequestData.setAddressCountryId(682L);
        customerRequestData.setAddressLine1(request.getHomeAddress());
        customerRequestData.setCustomerName(customerName);
        customerRequestData.setAddressLine2("");
        customerRequestData.setAddressPropertyTypeId(422L);
        customerRequestData.setAddressState(request.getState());
        customerRequestData.setAddressTypeCd("AT105");
        customerRequestData.setAddressTypeId(121L);
        customerRequestData.setBusinessUnitCodeId(-99L);

        /*
         * // Contact List<CustomerContactInformation> contacts = new
         * ArrayList<CustomerContactInformation>(); CustomerContactInformation
         * custContact = new CustomerContactInformation();
         *
         * custContact.setContactDetails(request.getPhone());
         * custContact.setContactMode("CM100");
         * custContact.setContactModeCategoryCode("CM100");
         * custContact.setContactModeTypeId(206L);
         * custContact.setCustomerShortName(request.getFirstName());
         * custContact.setStatus("A"); contacts.add(custContact);
         *
         * if (!request.getEmail().isEmpty()) {
         * custContact.setCustomerShortName(request.getFirstName());
         * custContact.setContactDetails(request.getEmail());
         * custContact.setContactMode("CM101");
         * custContact.setContactModeCategoryCode("CM101");
         * custContact.setContactModeTypeId(201L); custContact.setStatus("A");
         *
         * contacts.add(custContact); }
         * customerRequestData.getContacts().addAll(contacts);
         */

        customerRequestData.setCountryId(682L);
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

        if (!request.getBvn().isEmpty()) {
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
        customerRequestData.setOperationCurrencyId(732l);
        customerRequestData.setPreferredName(request.getFirstName());
        customerRequestData.setPrimaryAddress(true);
//        customerRequestData.setPrimaryRelationshipOfficerCd(relatnshpMgr);// <primaryRelationshipOfficerCd>HSL1424-13</primaryRelationshipOfficerCd>
        customerRequestData.setPrimaryRelationshipOfficerId(1059L);
        customerRequestData.setPrivacyLevel(3L);
        customerRequestData.setPrivacyLevelId(13l);
        customerRequestData.setPropertyTypeCd("PT107");
        //customerRequestData.setRelationshipOfficerOneId(value);(relatnshpMgr);// <relationshipOfficerOneId>1059</relationshipOfficerOneId>
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
//        customerRequestData.setStrDate(newDate);
//        customerRequestData.setStrFromDate(newDate);
        // <startDateMm>09</startDateMm>
        // <startDateYyyy>2021</startDateYyyy>
        customerRequestData.setStrDateOfBirth(utils.convertDateFormatToString(request.getDateOfBirth(), "yyyy-MM-dd", "dd/MM/yyyy"));
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

        System.out.println("*********** REQUEST DATA ****************************");
        //CommonMethods.logContent("*****Request Parameter****** " + CommonMethods.objectToXml(customerRequestData));

        CreateCustomer createCustomer = new CreateCustomer();

        createCustomer.setArg0(customerRequestData);

        WebServiceTemplate customerWebservice = new WebServiceTemplate(marshaller());

        JAXBElement webServiceResponse;

        try {
             webServiceResponse = (JAXBElement) customerWebservice.marshalSendAndReceive(CUSTOMER_WEBSERVICE, createCustomer);

             customerResponseData = (CustomerOutputData) webServiceResponse.getValue();
             customerNumber = customerResponseData.getCustomerNumber();
             customerId = String.valueOf(customerResponseData.getCustomerId());

        } catch (Exception e) {
            log.info("Error in creating customer info {}", utils.ObjectToJsonString(customerRequestData));
            log.info("Error in creating customer info {}", HttpStatus.valueOf(401));
            return new CreateAccountResponse(ResponseConstants.WEBSERVICE_RESPONSE_CODE,
                    ResponseConstants.WEBSERVICE_UNAVAILABLE_MESSAGE,
                    null,null,null,null);
        }

        System.out.println("*********** RESPONSE DATA ***********************************");
        log.info("********************* Response Parameter********************************");
        log.info("Rubikon Response Parameter Create Customer: {}", utils.ObjectToJsonString(customerResponseData));
        System.out.println("****************************************************************");


        if (customerResponseData.getCustomerId() != null && customerResponseData.getCustomerNumber() != null) {

             accountNumber = createDepositAccountForCustomer(customerResponseData.getCustomerName(),
                    String.valueOf(customerResponseData.getCustomerId())
                    , customerResponseData.getCustomerNumber()).getAccountNumber();

            accountId = createDepositAccountForCustomer(customerResponseData.getCustomerName(),
                    String.valueOf(customerResponseData.getCustomerId())
                    , customerResponseData.getCustomerNumber()).getAccountNumber();
        }

        log.info("SUCCESS {}", HttpStatus.valueOf(200));

        response.setAccountId(accountId);
        response.setAccountNumber(accountNumber);
        response.setAccountId(customerId);
        response.setCustomerNo(customerNumber);
        response.setResponseCode(ResponseConstants.SUCCESS_CODE);
        response.setResponseMessage(SUCCESS_MESSAGE);

        return response;
    }

    private CreateAccountResponse createDepositAccountForCustomer(String custName, String custId, String custNo) {
            DepositAccountRequestData depositRequest = new DepositAccountRequestData();
            depositRequest.setAmount(new BigDecimal(0));
            depositRequest.setAccountTitle(custName);
            depositRequest.setPrimaryCustomerId(Long.parseLong(custId));
            depositRequest.setPrimaryCustomerNumber(custNo);

            depositRequest.setXAPIServiceCode("STA060");
            depositRequest.setChannelCode("MAPP");
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
            depositRequest.setCampaignRefId(369l);
            depositRequest.setCountryId(687L);
            depositRequest.setOpeningReasonCode("CC002");
            depositRequest.setOpenningReasonId(702L);
            depositRequest.setProductCode("205");
            depositRequest.setProductId(15L);
//            depositRequest.setRelationshipOfficerCode(relatnshpMgr);
            //DepositRequest.setRelationshipOfficerId(1058L);

            depositRequest.setRiskClassCd("RC110");
            depositRequest.setRiskClassId(744L);
            depositRequest.setSourceOfFundCode("SF014");
            depositRequest.setSourceOfFundId(430L);
//          depositRequest.setStrOpeningDate(utils.convertDateFormatToString(dbConn.getProcessingDate(), "dd-MM-yyyy", "dd/MM/yyyy"));

            CreateDepositAccount createDepositAccount = new CreateDepositAccount();
            createDepositAccount.setArg0(depositRequest);

            JAXBElement webServiceResponse;
            WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());
            DepositAccountOutputData depAcctResponseData;
            String generateAccountNumber = null;
            String accountId = null;

             try {

                 webServiceResponse = (JAXBElement) webServiceTemplate.marshalSendAndReceive(ACCOUNT_WEBSERVICE,createDepositAccount);

                 depAcctResponseData = (DepositAccountOutputData) webServiceResponse.getValue();

             } catch (Exception e) {
                 return new CreateAccountResponse(ResponseConstants.WEBSERVICE_UNAVAILABLE_CODE,
                         ResponseConstants.WEBSERVICE_UNAVAILABLE_MESSAGE,
                         custNo,custId,null,null);
             }

             if (!(depAcctResponseData.getPrimaryAccountNumber() == null)){
                 generateAccountNumber=  depAcctResponseData.getPrimaryAccountNumber();
                 accountId = String.valueOf(depAcctResponseData.getAccountId());
             }

            System.out.println("*********** REQUEST DATA ****************************");
            log.info("********************* Request Parameter *************************");
            log.info("Rubikon Request Parameter Create Account: " + utils.ObjectToJsonString(depositRequest));

            System.out.println("*********** RESPONSE DATA ****************************");
            log.info("**********************Response Parameter************************");
            log.info("Rubikon Response Parameter Create Account: {}", utils.ObjectToJsonString(depAcctResponseData));
            System.out.println("*******************************************************");


            return new CreateAccountResponse(ResponseConstants.WEBSERVICE_RESPONSE_CODE,SUCCESS_MESSAGE,
                    custNo, custId,accountId,generateAccountNumber);
    }

    private Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setPackagesToScan(PackageToScan);
        return marshaller;
    }
}
