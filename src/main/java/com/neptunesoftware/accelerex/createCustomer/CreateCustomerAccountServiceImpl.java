package com.neptunesoftware.accelerex.createCustomer;

import com.neptunesoftware.accelerex.account.AccountRepositoryImp;
import com.neptunesoftware.accelerex.account.request.CreateAccountRequest;
import com.neptunesoftware.accelerex.account.response.CreateAccountResponse;
import data.account.*;
import data.customer.CustomerOutputData;
import com.neptunesoftware.accelerex.exception.ValidationException;
import com.neptunesoftware.accelerex.utils.AppUtils;
import com.neptunesoftware.accelerex.utils.ResponseConstants;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Log4j2
@RequiredArgsConstructor
@Service
public class CreateCustomerAccountServiceImpl implements CreateCustomerAccountService {

    private final AppUtils utils;
    private final AccountRepositoryImp accountRepositoryImp;
    @Value("${endpoint.accountWebservice}")
    private String ACCOUNT_WEBSERVICE;
    @Value("${endpoint.customerWebService}")
    private String CUSTOMER_WEBSERVICE;



    public CreateAccountResponse creatNewCustomer(CreateAccountRequest request) {
        CustomerRequest customerRequest = new CustomerRequest();
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());
//        CreateCustomer createCustomer = new CreateCustomer();
        CreateAccountResponse output  = null;

        //Variables To Hold Response From Each Call
        String acctNumber= null;
        String custNumber= null;
        String custExist;
        Long custId;

        try {
            System.out.println("***************** IN CREATE DEPOSIT ACCOUNT SERVICE  **********************");
            log.info("***************** CREATE DEPOSIT ACCOUNT SERVICE STARTS HERE  **********************");

            log.info("*******************************Request Parameter**************************************");
             log.info("Request Parameter {}", utils.ObjectToJsonString(request));


            //When BVN is Supplied Check To See If Customer Exist
            if (request.getBvn() != null) {
                custId = validateBVN(request.getBvn());
                if (custId > 0){
                    output = new CreateAccountResponse(ResponseConstants.BVN_EXIST_CODE,
                            ResponseConstants.BVN_EXIST_MESSAGE, null, null);
                    log.info("*********** Deposit Account Creation Successful **********");
                    log.info("Success Response: "+ utils.ObjectToJsonString(output));
                      return output;
                }
            }

            //Check if customer Exist Using Phone Number And D.O.B
                custExist = checkCustomerPhoneNumber(request.getPhone(), request.getFirstName(), request.getDateOfBirth());

            if (!custExist.isEmpty()) {
                output = new CreateAccountResponse(ResponseConstants.CUSTOMER_EXIST_CODE,
                        ResponseConstants.CUSTOMER_EXIST_MESSAGE, null, null);

                log.info("Response : "+ utils.ObjectToJsonString(output));
                log.info("***************** CREATE DEPOSIT ACCOUNT SERVICE ENDS HERE  **********************");
                return  output;
            }

            //CHECK SUPPLIED PARAMETERS
            if (!(request.getImageType().equalsIgnoreCase("JPEG") || request.getImageType().equalsIgnoreCase("JPG") || request.getSignatureType().equalsIgnoreCase("JPEG") || request.getSignatureType().equalsIgnoreCase("JPG"))) {
                output = new CreateAccountResponse(ResponseConstants.WRONG_IMAGE_CODE, ResponseConstants.WRONG_IMAGE_MESSAGE, null, null);
                log.info("Wrong Image Type!.: "+ request.getSignatureType());
                log.info("***************** CREATE DEPOSIT ACCOUNT SERVICE ENDS HERE  **********************");
                 return output;
            }

            if (request.getImage().length() < 20  || request.getSignature().length() < 20 ) {
                output = new CreateAccountResponse(ResponseConstants.WRONG_IMAGE_CODE,
                        ResponseConstants.WRONG_IMAGE_MESSAGE, null, null);
                log.info("Wrong Image !.: "+ request.getImage());
                log.info("***************** CREATE DEPOSIT ACCOUNT SERVICE ENDS HERE  **********************");
                return output;
            }

            if(request.getCity() == null || request.getDateOfBirth() == null || request.getEmail() == null || request.getFirstName() == null || request.getGender() == null || request.getHomeAddress() == null || request.getLastName() == null ||  request.getPhone() == null || request.getState() == null) {
                output = new CreateAccountResponse(ResponseConstants.MANDATORY_CODE, ResponseConstants.MANDATORY_MESSAGE, null, null);
                log.info("Incomplete Parameter Passed.: "+ utils.ObjectToJsonString(output));
                log.info("***************** CREATE DEPOSIT ACCOUNT SERVICE ENDS HERE  **********************");
                return output;
            }

            try {

//              customerRequest = (CustomerRequest) getCommonRequest(customerRequest);
                getCommonRequest(customerRequest);

                String customerName = request.getLastName() + " " + request.getFirstName();
                if (request.getMiddleName() != null)
                    customerName = request.getLastName() + " " + request.getMiddleName() + " " + request.getFirstName();


                //Customer Creation
                customerRequest.setCustomerId(25618L);    //Get value to be used here
                customerRequest.setCustomerType(816L);    //Get value to be used here
                customerRequest.setCustomerCategory("PER");
                customerRequest.setCustomerType(721L);    //Get value to be used here
                customerRequest.setResidentFlag(true);
                customerRequest.setIndustryId(776L);    //Get value to be used here
                customerRequest.setTaxGroupId(351L);    //Get value to be used here

                customerRequest.setCustomerName(customerName);
                customerRequest.setStrDateOfBirth(request.getDateOfBirth());
                customerRequest.setGender(request.getGender());
                customerRequest.setFirstName(request.getFirstName());
                customerRequest.setLastName(request.getLastName());
                customerRequest.setMiddleName(request.getMiddleName());
                customerRequest.setCustShortName(customerName.substring(0,6));
                customerRequest.setCountryOfResidenceId(682L);
                customerRequest.setRiskId(745L);
                customerRequest.setAddressLine1(request.getHomeAddress());

                customerRequest.setContactModeId(201L);    //Get value to be used here
                customerRequest.setCustContactModeId(201L);    //Get value to be used here

                customerRequest.setChannelCode("AGENCY");
                customerRequest.setChannelId(14L);    //Get value to be used here
                customerRequest.setTransmissionTime(123L);    //Get value to be used here
                customerRequest.setUserId(-99L);    //Get value to be used here
                customerRequest.setUserLoginId("EXTUSER");
                customerRequest.setUserRoleId(-99L);    //Get value to be used here


                log.info("******************** REQUEST DATA ************************************");
                log.info("REQUEST DATA {}",utils.ObjectToJsonString(customerRequest));
                System.out.println("**************************************************************");
//                createCustomer.setArg0(customerRequest);

                CustomerOutputData customerResponse = (CustomerOutputData) webServiceTemplate
                        .marshalSendAndReceive(CUSTOMER_WEBSERVICE, customerRequest);

                //Create Deposit Account Application (custreq);
                log.info("********************** RESPONSE DATA *************************************");
                log.info("RESPONSE DATA {} ", customerResponse);
                System.out.println("***************************************");

                if (!(customerResponse.getCustomerNumber().equals(null))) {
                    custNumber = customerResponse.getCustomerNumber();

                    DepositAcctApplicationRequestData depositAccountAppl = new DepositAcctApplicationRequestData ();
                    depositAccountAppl = (DepositAcctApplicationRequestData) getCommonRequest(depositAccountAppl);

                    ApplicationAddressRequestData addressData = new ApplicationAddressRequestData();
                    getCommonRequest(addressData);

                    ApplicationContactInfoRequestData contactData = new ApplicationContactInfoRequestData();
                    contactData = (ApplicationContactInfoRequestData) getCommonRequest(contactData);

                    ApplicationContactInfoRequestData contactData1 = new ApplicationContactInfoRequestData();
                    contactData1 = (ApplicationContactInfoRequestData) getCommonRequest(contactData1);

//                    ApplicationImageRequestData imageData = new ApplicationImageRequestData();
//                    imageData = (ApplicationImageRequestData) getCommonRequest(imageData);

                    depositAccountAppl.setNationality(267L);
                    depositAccountAppl.setCustomerCategory("PER");
                    depositAccountAppl.setCustomerType(721L);
                    depositAccountAppl.setCustomerTypeCd("CT100");
                    depositAccountAppl.setCrncyId(732L);
                    depositAccountAppl.setResidentCountryCd("NGA");
                    depositAccountAppl.setBirthDate(utils.convertDateFormatToString(request.getDateOfBirth(), "yyyy-MM-dd", "dd/MM/yyyy"));
                    depositAccountAppl.setGender(request.getGender());
                    depositAccountAppl.setFirstName(request.getFirstName().toUpperCase());
                    depositAccountAppl.setSurName(request.getLastName().toUpperCase());
                    depositAccountAppl.setMiddleName(request.getMiddleName());
                    depositAccountAppl.setMaritalStatus("S");
                    depositAccountAppl.setTitle(250L);

                    depositAccountAppl.setChannelCode("AGENCY");
                    depositAccountAppl.setXAPIServiceCode("STC029");
                    depositAccountAppl.setChannelId(14L);
                    depositAccountAppl.setTransmissionTime(12345L);
                    depositAccountAppl.setUserId(-99L);
                    depositAccountAppl.setUserLoginId("EXTUSER");
                    depositAccountAppl.setUserRoleId(-99L);
                    depositAccountAppl.isValidXapiRequest();

                    //Address Information

                    addressData.setCustCountry(667L);
                    addressData.setAddressLine1(request.getHomeAddress());
                    addressData.setAddressStatus("A");
                    addressData.setAddressType(40L);
                    addressData.setCustomerCity(request.getCity());
                    addressData.setCustomerState(request.getState());
                    addressData.setStrFromDate("");

                    addressData.setChannelCode("AGENCY");
                    addressData.setChannelId(14L);
                    addressData.setTransmissionTime(123L);
                    addressData.setUserId(-99L);
                    addressData.setUserLoginId("EXTUSER");
                    addressData.setUserRoleId(-99L);
                    depositAccountAppl.setApplAddressData(addressData);

                    //Phone Number
                    contactData.setContactModeId(203L);
                    contactData.setCustContactModeId(203L);
                    contactData.setContactDetails(request.getPhone());

                    contactData.setChannelCode("AGENCY");
                    contactData.setChannelId(14L);
                    contactData.setTransmissionTime(12345L);
                    contactData.setUserId(-99L);
                    contactData.setUserLoginId("EXTUSER");
                    contactData.setUserRoleId(-99L);
                    depositAccountAppl.setApplContactData(contactData);

                    //Email
                    contactData1.setContactModeId(201L);
                    contactData1.setCustContactModeId(201L);
                    contactData1.setContactDetails(request.getEmail());

                    contactData1.setChannelCode("AGENCY");
                    contactData1.setChannelId(14L);
                    contactData1.setUserId(-99L);
                    contactData1.setUserLoginId("EXTUSER");
                    contactData1.setUserRoleId(-99L);
                    depositAccountAppl.setApplContactData(contactData1);

                    System.out.println("*********** REQUEST DATA ****************************");
                    System.out.println(utils.ObjectToJsonString(depositAccountAppl));
                    System.out.println("***************************************");

                    DepositAcctApplicationOutputData depositresponse;
                    try {
                        depositresponse  = (DepositAcctApplicationOutputData) webServiceTemplate
                                .marshalSendAndReceive(ACCOUNT_WEBSERVICE,depositAccountAppl);

                        acctNumber = depositresponse.getAcctNumber();
                        custNumber = customerResponse.getCustomerNumber();
                        output = new CreateAccountResponse(ResponseConstants.WEBSERVICE_RESPONSE_CODE,ResponseConstants.SUCCESS_MESSAGE,custNumber,acctNumber);
                        output.setAccountNumber(acctNumber);
                        output.setCustNo(custNumber);


                    } catch (Exception e) {
                        output = new CreateAccountResponse(ResponseConstants.WEBSERVICE_UNAVAILABLE_CODE,
                                ResponseConstants.WEBSERVICE_UNAVAILABLE_MESSAGE,
                                null, null);
                        log.info("Error  Response For Webservice call: {}", utils.ObjectToJsonString(output));
                        return output;
                    }

                    System.out.println("*********** RESPONSE DATA ****************************");
                    System.out.println(depositresponse);
                    System.out.println("******************************************************");


                    log.info("*****************Response After successful Account creation of Account ********************************");
                    log.info("Customer number {}", custNumber);
                    log.info("Customer Account Number {}", acctNumber);
                }

                if (acctNumber != null && custNumber != null) {
                    output = new CreateAccountResponse(ResponseConstants.SUCCESS_CODE,
                            ResponseConstants.SUCCESS_MESSAGE,
                            custNumber, acctNumber);
                }

            }catch(Exception Ex) {
                output = new CreateAccountResponse(ResponseConstants.WEBSERVICE_UNAVAILABLE_CODE,
                        ResponseConstants.WEBSERVICE_UNAVAILABLE_MESSAGE,
                        null, null);
                log.info("Error  Response For Db: "+ utils.ObjectToJsonString(output));
                return output;
            }

        }catch(Exception Ex) {
             output = new CreateAccountResponse(ResponseConstants.EXCEPTION_CODE,
                    ResponseConstants.EXCEPTION_MESSAGE,
                    null, null);
            log.info("Error  Response For Db: "+ utils.ObjectToJsonString(output));
            return output;
        }
        return output;
    }

    private String checkCustomerPhoneNumber(String phone, String firstName, String dateOfBirth) {
        //Todo: API call will be made, not validating against database as the data are domicile with the webservice
        String account =accountRepositoryImp.findAccountByPhoneNumber(phone);
        if (account != null){
            return account;
        }
        throw new ValidationException("");
    }

    private static XAPIRequestBaseObject getCommonRequest(XAPIRequestBaseObject requestData) {
        requestData.setCardNumber("");
        requestData.setChannelId(17L);
        requestData.setChannelCode("AGENT");
        requestData.setResponse("00");

        requestData.setTransmissionTime(System.currentTimeMillis());
        requestData.setReference("");
        requestData.setTerminalNumber("123");
        requestData.setOriginatorUserId(-99L);

        requestData.setUserLoginId("NEPTUNE");
        requestData.setUserId(-99L);
        return requestData;
    }

    public Long validateBVN(String bvn) {
        //Todo:
       return 1L;
    }

    private Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setPackagesToScan("com.neptunesoftware.accelerex.data.customer","com.neptunesoftware.accelerex.data.account");
        return marshaller;
    }
}