package com.neptunesoftware.accelerex.newcustomer.impl;

import com.neptunesoftware.accelerex.data.account.CustomerContactInformation;
import com.neptunesoftware.accelerex.data.account.CustomerIdentificationInformation;
import com.neptunesoftware.accelerex.data.account.CustomerRequest;
import com.neptunesoftware.accelerex.newcustomer.CustomerService;
import com.neptunesoftware.accelerex.newcustomer.dto.CreateCustomerRequest;
import com.neptunesoftware.accelerex.utils.GenericResponse;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final String addressState = "N025";

    @Override
    public GenericResponse createCustomer(CreateCustomerRequest request) {

        CustomerRequest customerRequestData = new CustomerRequest();
        String customerName = request.getLastName() + " " + request.getFirstName();
        if (request.getMiddleName() != null)
            customerName = request.getLastName() + " " + request.getMiddleName() + " " + request.getFirstName();

        // <!--DEFAULT VALUES:-->
        customerRequestData.setXapiServiceCode("STC029"); // <XAPIServiceCode>STC029</XAPIServiceCode>
        customerRequestData.setChannelCode("MBANK"); // <channelCode>RMT</channelCode>
        customerRequestData.setChannelId(13L); // <channelId>121</channelId>
        customerRequestData.setCurrBUId(-99L); // <currBUId>-99</currBUId>
        customerRequestData.setLocalCcyId(732L); // <localCcyId>732</localCcyId>
        customerRequestData.setOriginatorUserId(-99L); // <originatorUserId>-99</originatorUserId>
        customerRequestData.setResponse("0"); // <response>0</response>
        customerRequestData.setTransmissionTime(System.currentTimeMillis()); // <transmissionTime>12345678</transmissionTime>
        customerRequestData.setUserId(-99L); // <userId>-99</userId>
        customerRequestData.setUserLoginId("SYSTEM"); // <userLoginId>SYSTEM</userLoginId>
        customerRequestData.setUserRoleId(-99L); // <userRoleId>-99</userRoleId>
        customerRequestData.setValidXapiRequest(true); // <validXapiRequest>Y</validXapiRequest>
        customerRequestData.setBusinessUnitCodeId(-99L); // <businessUnitCodeId>-99</businessUnitCodeId>
        // <!--BASIC INFO:-->
        customerRequestData.setCustShortName(request.getFirstName()); // <custShortName>OGUNMAKIN</custShortName>
        customerRequestData.setCustomerName(customerName);
        customerRequestData.setEmploymentFlag(false); // <employmentFlag>N</employmentFlag>
        customerRequestData.setFirstName(request.getFirstName()); // <firstName>OGUNMAKIN</firstName>
        customerRequestData.setLastName(request.getLastName()); // <lastName>CLARK</lastName>
        customerRequestData.setGender(request.getGender()); // <gender>M</gender>
        // <!--ADDRESS DETAIL:-->
        customerRequestData.setAddressCity("1361"); // <addressCity>LAGOS</addressCity>
        customerRequestData.setAddressCountryId(667L); // <addressCountryId>682</addressCountryId>
        customerRequestData
                .setAddressLine1(request.getHomeAddress().length() > 100 ? request.getHomeAddress().substring(0, 99)
                        : request.getHomeAddress()); // <addressLine1>4C CONNAL ROAD</addressLine1>
        customerRequestData.setAddressLine2(
                request.getHomeAddress().length() > 100 ? request.getHomeAddress().substring(99) : null); //
        customerRequestData.setAddressPropertyTypeId(013L); // <addressPropertyTypeId>422</addressPropertyTypeId>
        customerRequestData.setAddressState(addressState); // <addressState>LAGOS</addressState>
        customerRequestData.setAddressTypeCd("006"); // <addressTypeCd>AT100</addressTypeCd>
        customerRequestData.setAddressTypeId(51L); // <addressTypeId>11</addressTypeId>

        // <!--CONTACT DETAIL:-->

        // List<CustomerContactInformation> contacts = new
        // ArrayList<CustomerContactInformation>();
        CustomerContactInformation custContact = new CustomerContactInformation();

        custContact.setContactDetails(request.getPhone());
        custContact.setContactMode("700");
        custContact.setContactModeCategoryCode("MOBPHONE");
        custContact.setContactModeTypeId(237L);
        custContact.setCustomerShortName(request.getFirstName());
        custContact.setStatus("A");
        // contacts.add(custContact);
        customerRequestData.getContacts().add(custContact);
        if (!request.getEmail().isEmpty()) {
            CustomerContactInformation custContact2 = new CustomerContactInformation();
            custContact2.setContactDetails(request.getEmail());
            custContact2.setContactMode("500");
            custContact2.setContactModeCategoryCode("EMAIL");
            custContact2.setContactModeTypeId(235L);
            custContact2.setCustomerShortName(request.getFirstName());
            custContact2.setStatus("A");
            // contacts.add(custContact2);
            customerRequestData.getContacts().add(custContact2);
        }
        // CustomerContactInformation[] contactData = contacts.toArray(new
        // CustomerContactInformation[contacts.size()]);
        // customerrequestData.setContacts(contactData);
        customerRequestData.setCreditRatingAgencyId(11L); // <creditRatingAgencyId>11</creditRatingAgencyId>

        // <!--COUNTRY:-->
        customerRequestData.setCountryId(667L); // <countryId>682</countryId>
        customerRequestData.setCountryOfBirthCd("NGA"); // <countryOfBirthCd>NGA</countryOfBirthCd>
        customerRequestData.setCountryOfBirthId(667L); // <countryOfBirthId>682</countryOfBirthId>
        customerRequestData.setCountryOfResidenceId(67L); // <countryOfResidenceId>682</countryOfResidenceId>
        customerRequestData.setCustCountryCd("NGA"); // <custCountryCd>NGA</custCountryCd>
        customerRequestData.setResidentCountryCd("NGA"); // <residentCountryCd>NGA</residentCountryCd>
        customerRequestData.setResidentFlag(true); // <residentFlag>true</residentFlag>

        // <!--CUSTOMER TYPE INFO:-->
        customerRequestData.setCustomerSegmentCd("101"); // <customerSegmentCd>CS107</customerSegmentCd>
        customerRequestData.setCustomerTypeCd("112"); // <customerTypeCd>CT101</customerTypeCd>
        customerRequestData.setCustomerCategory("PER"); // <customerCategory>PER</customerCategory>

        // <!--IDENTIFICATION INFO:-->
        // List<CustomerIdentificationInformation> identifications = new
        // ArrayList<CustomerIdentificationInformation>();
        CustomerIdentificationInformation custIdInfo = new CustomerIdentificationInformation();

        if (!request.getBvn().isEmpty() || request.getBvn() == "") {
            custIdInfo.setIdentityType("110");
            custIdInfo.setIdentityTypeId(471L);
            custIdInfo.setIdentityNumber(request.getBvn());
            custIdInfo.setCountryOfIssue("NGA");
            custIdInfo.setCityOfIssue("1361");
            custIdInfo.setCustomerName(customerName);
            custIdInfo.setCountryOfIssueId(667L);
            custIdInfo.setVerifiedFlag(true);
            // custIdInfo.setIssueDate(CommonMethods.getCalendar(dbConn.getProcessingDate()));
            // identifications.add(custIdInfo);
        }
        customerRequestData.getIdentifications().add(custIdInfo);
        // CustomerIdentificationInformation[] identData = identifications.toArray(new
        // CustomerIdentificationInformation[identifications.size()]);
        // customerrequestData.setIdentifications(identData);
        // <!--OTHERS-->
        customerRequestData.setIndustryCd("40180"); // <industryCd>IND12</industryCd>
        customerRequestData.setIndustryId(5700L); // <industryId>883</industryId>
        customerRequestData.setLocale("en_US"); // <locale>en_US</locale>
        customerRequestData.setMainBusinessUnitCd("001"); // <mainBusinessUnitCd>001</mainBusinessUnitCd>
        customerRequestData.setMainBusinessUnitId(-99L); // <mainBusinessUnitId>-99</mainBusinessUnitId>
        customerRequestData.setMaritalStatus("S"); // <maritalStatus>S</maritalStatus>
        customerRequestData.setMarketingCampaignCd("015"); // <marketingCampaignCd>MC112</marketingCampaignCd>
        customerRequestData.setMarketingCampaignId(335L); // <marketingCampaignId>369</marketingCampaignId>
        customerRequestData.setMiddleName(request.getMiddleName().equals(null) ? "" : request.getMiddleName()); // <middleName>KARIM</middleName>
        customerRequestData.setNationalityCd("010"); // <nationalityCd>N101</nationalityCd>
        customerRequestData.setNationalityId(267L); // <nationalityId>532</nationalityId>
        customerRequestData.setNoOfDependents(0L); // <noOfDependents>0</noOfDependents>
        customerRequestData.setOpeningReasonCode("CUC06"); // <openingReasonCode>CC002</openingReasonCode>
        customerRequestData.setOpeningReasonId(803L); // <openingReasonId>702</openingReasonId>
        customerRequestData.setOperationCurrencyCd("NGN"); // <operationCurrencyCd>NGN</operationCurrencyCd>
        customerRequestData.setOperationCurrencyId(732L); // <operationCurrencyId>732</operationCurrencyId>
        customerRequestData.setPreferredName(request.getLastName()); // <preferredName>OGUNMAKIN</preferredName>
        customerRequestData.setPrimaryAddress(true); // <primaryAddress>true</primaryAddress>
        customerRequestData.setPrimaryRelationshipOfficerCd("JACOBB"); // <primaryRelationshipOfficerCd>OGONNA</primaryRelationshipOfficerCd>
        customerRequestData.setPropertyTypeCd("013"); // <propertyTypeCd>PT107</propertyTypeCd>
        // customerrequestData.setPrimaryRelationshipOfficerId(1059L); //
        // <relationshipOfficerOneId>1059</relationshipOfficerOneId>

        customerRequestData.setRiskCode("600"); // <riskCode>CUST105</riskCode>
        customerRequestData.setRiskCountryCd("NGA"); // <riskCountryCd>NGA</riskCountryCd>
        customerRequestData.setRiskId(581L); // <riskId>745</riskId>
        customerRequestData.setServiceLevel(400L); // <serviceLevel>400</serviceLevel>
        customerRequestData.setServiceLevelId(14L); // <serviceLevelId>14</serviceLevelId>
        customerRequestData.setSourceOfFundCd("023"); // <sourceOfFundCd>SF014</sourceOfFundCd>
        customerRequestData.setSourceOfFundId(283L); // <sourceOfFundId>430</sourceOfFundId>
        customerRequestData.setStatus("S"); // <status>S</status>

        return null;
    }
}
