package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.account.response.ExternalTransferNameEnquiryResponse;
import com.neptunesoftware.accelerex.account.response.LinkBankAccountResponse;
import com.neptunesoftware.accelerex.account.response.NameEnquiryResponse;
import com.neptunesoftware.accelerex.account.response.VerifyTokenResponse;
import com.neptunesoftware.accelerex.config.AccelerexCredentials;
import com.neptunesoftware.accelerex.data.FundTransfer.ExternalAccountNameInquiry;
import com.neptunesoftware.accelerex.data.FundTransfer.NameInquiryRequestData;
import com.neptunesoftware.accelerex.data.FundTransfer.NameInquiryResponseData;
import com.neptunesoftware.accelerex.data.account.BalanceEnquiryRequestData;
import com.neptunesoftware.accelerex.data.account.Balanceenquiry;
import com.neptunesoftware.accelerex.data.account.BalanceenquiryResponse;
import com.neptunesoftware.accelerex.exception.AccountNotExistException;
import com.neptunesoftware.accelerex.exception.AccountServiceException;
import com.neptunesoftware.accelerex.exception.BalanceEnquiryException;
import com.neptunesoftware.accelerex.user.User;
import com.neptunesoftware.accelerex.user.UserRepository;
import com.neptunesoftware.accelerex.utils.ApiResponse;
import com.neptunesoftware.accelerex.utils.ResponseConstants;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import static com.neptunesoftware.accelerex.account.SqlQueries.UPDATE_USER_ID_WITH_ACCOUNT_NUMBER;
import static com.neptunesoftware.accelerex.utils.Cypher.deCypher;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccountServiceImpl implements AccountServices {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final AccelerexCredentials ACCELEREX_CREDENTIALS ;
    @Value("${endpoint.accountWebservice}")
    private String ACCOUNT_WEB_SERVICE_END_POINT_PORT;
    @Value("${endpoint.fundTransferWebservice}")
    private String FUND_TRANSFER_SERVICE_END_POINT;
    private final JdbcTemplate jdbcTemplate;
    //private final Jaxb2Marshaller marshaller;

    @Override
    public ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request) {

        LinkBankAccountResponse response = new LinkBankAccountResponse();
        String opt = generateOTP();
        boolean isAccountValid = validateBankAccount(request.getAccountNo());
        boolean existsByEmailAddress = userRepository.existsByEmailAddress(request.getEmail());
        boolean isOtpVerified = verifySmsToken(request.getAccountNo(), opt);

        if (existsByEmailAddress && isAccountValid) {
            sendOTP(request.getMobileNo(), opt);
            if (isOtpVerified) {
                String clientId = accountRepository.findUserIdByAccountNumber(request.getAccountNo());
                linkAccount(clientId, request.getAccountNo());
                String accountName = accountRepository.findNameByAccountNumber(request.getAccountNo());
                String accountNumber = accountRepository.findAccountByPhoneNumber(request.getMobileNo());
                if (request.getAccountNo().equals(accountNumber)) {
                    response.setAccountNo(accountRepository.findAccountByPhoneNumber(accountNumber));
                    response.setAccountName(accountName);
                }
            }
        }
     return  new ApiResponse<>(ResponseConstants.SUCCESS_MESSAGE,"Account Linked successfully",response);
    }


    @Override
    public BalanceenquiryResponse fetchAccountBalance(String accountNumber) {
        validateBankAccount(accountNumber);
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());
        BalanceEnquiryRequestData balEnqRequest = buildRequestForBalanceInquiry(accountNumber);
        Balanceenquiry balanceenquiry = new Balanceenquiry();
        balanceenquiry.setArg0(balEnqRequest);
        JAXBElement response;
        try {
            response = (JAXBElement) webServiceTemplate.marshalSendAndReceive(
                    ACCOUNT_WEB_SERVICE_END_POINT_PORT, balanceenquiry);
        } catch (Exception e) {
            throw new BalanceEnquiryException("An error occurred while querying the account balance "
                    + " for account " + accountNumber);
        }
        return (BalanceenquiryResponse) response.getValue();
    }


    @Override
    public ApiResponse<NameEnquiryResponse> nameEnquiry(String accountNumber) {
        String accountName = accountRepository.findNameByAccountNumber(accountNumber);
        if (accountName.equals(Strings.EMPTY)) {
            throw new AccountNotExistException("The specified account number does not exist " + accountNumber);
        }
        return new ApiResponse<>(ResponseConstants.SUCCESS_MESSAGE, "The account name is: ", NameEnquiryResponse.builder()
                .accountName(accountName).build());
    }


    public VerifyTokenResponse verifySmsToken(String smsToken) {
        User user = userRepository.findBySmsToken(smsToken).get();
        VerifyTokenResponse response = new VerifyTokenResponse();
        response.setAccountName(user.getFullName());
        response.setAccountNo(user.getPhoneNumber());
        response.setEmail(user.getEmailAddress());
        return response;
    }

    private boolean verifySmsToken(String accountNumber, String smsToken) {
        String token = accountRepository.findTokenByAccountNumber(accountNumber);
        if (!(token.equals(smsToken))) throw new AccountServiceException("Incorrect token" + " for account: " + accountNumber);
        return true;
    }

    private boolean validateBankAccount(String accountNumber) {
         String accountNum = accountRepository.findByAccountNumber(accountNumber);
         if (!(accountNum.equals(accountNumber))) {
             throw new AccountNotExistException("Account does not exist");
         }
        return true;
    }
    private void linkAccount(String clientId, String accountNumber) {
       jdbcTemplate.update(UPDATE_USER_ID_WITH_ACCOUNT_NUMBER,clientId,accountNumber);
    }

    @Override
    public ExternalTransferNameEnquiryResponse interBankNameEnquiry(String accountNumber) {
        ExternalTransferNameEnquiryResponse  responseData = new ExternalTransferNameEnquiryResponse();
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());
        NameInquiryRequestData requestData = buildRequestForNameInquiry(accountNumber);
        ExternalAccountNameInquiry nameEnquiryRequestData = new ExternalAccountNameInquiry();
        nameEnquiryRequestData.setArg0(requestData);
        NameInquiryResponseData nameInquiryResponseData;

        JAXBElement response;

        try {
            response = (JAXBElement)webServiceTemplate.marshalSendAndReceive(FUND_TRANSFER_SERVICE_END_POINT,nameEnquiryRequestData);
            nameInquiryResponseData = (NameInquiryResponseData) response.getValue();

            responseData.setAccountName(nameInquiryResponseData.getAccountName());
            responseData.setResponseCode(nameInquiryResponseData.getResponseCode());
            responseData.setResponseMessage(nameInquiryResponseData.getErrMsg());
            responseData.setSessionId(nameInquiryResponseData.getSessionId());

        } catch (Exception e) {
            throw new AccountNotExistException("An error occurred while querying Account name" + " for account number " + accountNumber);
        }

        return responseData;
    }

    @Override
    public String intraBankNameEnquiry(String accountNumber) {
        //Todo:
        return null;
    }
    private BalanceEnquiryRequestData buildRequestForBalanceInquiry(String accountNumber) {
        BalanceEnquiryRequestData balEnqRequest = new BalanceEnquiryRequestData();
        balEnqRequest.setSessionId(String.valueOf(System.currentTimeMillis()));
        balEnqRequest.setDestinationInstitutionCode("");
        balEnqRequest.setChannelCode(deCypher(ACCELEREX_CREDENTIALS.getChannelCode()));
        balEnqRequest.setAuthorizationCode("");
        balEnqRequest.setTargetAccountName("");
        balEnqRequest.setTargetBankVerificationNumber("");
        balEnqRequest.setTargetAccountNumber(accountNumber);
        return balEnqRequest;
    }

    private NameInquiryRequestData buildRequestForNameInquiry(String accountNumber) {
        NameInquiryRequestData nameInquiryRequestData = new NameInquiryRequestData();
        nameInquiryRequestData.setSessionId(String.valueOf(System.currentTimeMillis()));
        nameInquiryRequestData.setDestinationInstitutionCode("");
        nameInquiryRequestData.setChannelCode(deCypher(ACCELEREX_CREDENTIALS.getChannelCode()));
        nameInquiryRequestData.setBicCode("");
        nameInquiryRequestData.setAccountNumber(accountNumber);
        return nameInquiryRequestData;
    }

    private void validateAccount(String accountNumber) {
        nameEnquiry(accountNumber);
    }
    private Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this package must match the package in the <generatePackage> specified in
        // pom.xml
        marshaller.setPackagesToScan("");
        return marshaller;
    }

    public String generateOTP() {
        return RandomStringUtils.randomNumeric(4);
    }

    private void sendOTP(String mobileNumber, String otp) {
        // Todo: Implementation of SMS sending API
        // Send_Token: The OTP sent to the provided mobile number, is store and call verify token API verifyToken()
        accountRepository.updateOTP(mobileNumber,otp);
    }
}