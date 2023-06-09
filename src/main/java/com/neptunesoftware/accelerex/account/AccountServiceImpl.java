package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.CreateBankAccountRequest;
import com.neptunesoftware.accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.config.AccelerexCredentials;
import com.neptunesoftware.accelerex.data.account.BalanceEnquiryRequestData;
import com.neptunesoftware.accelerex.data.account.Balanceenquiry;
import com.neptunesoftware.accelerex.data.account.BalanceenquiryResponse;
import com.neptunesoftware.accelerex.exception.AccountNotExistException;
import com.neptunesoftware.accelerex.exception.AccountServiceException;
import com.neptunesoftware.accelerex.exception.BalanceEnquiryException;
import com.neptunesoftware.accelerex.exception.ValidationException;
import com.neptunesoftware.accelerex.user.User;
import com.neptunesoftware.accelerex.user.UserRepository;
import com.neptunesoftware.accelerex.utils.ApiResponse;
import com.neptunesoftware.accelerex.utils.AppUtils;
import jakarta.xml.bind.JAXBElement;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import static com.neptunesoftware.accelerex.utils.Cypher.deCypher;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccountServiceImpl implements AccountServices {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final AccelerexCredentials ACCELEREX_CREDENTIALS ;
    @Value("${package.packageToScan}")
    private  String PACKAGE_TO_SCAN;
    @Value("${endpoint.accountWebservice}")
    private String ACCOUNT_WEB_SERVICE_END_POINT_PORT;
    private final AppUtils appUtils;

    @Override
    public ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request) {

        boolean isAccountValid = validateBankAccount(request.getAccountNo());
        String opt = generateOTP();
        if (isAccountValid){
            sendOTP(request.getMobileNo(),opt);
          boolean isOtpVerified =  verifyToken(request.getAccountNo(),opt);
            if (isOtpVerified) {
                String agentId = accountRepository.findUserIdByAccountNumber(request.getAccountNo());
            }
        }
     return  null;
    }


    public ApiResponse<CreateBankAccountResponse> createBankAccount(CreateBankAccountRequest bankAccountRequest) {

        if (userRepository.findByEmailAddress(bankAccountRequest.getEmail()).isPresent())
            throw new ValidationException("User with Email already exist");
        if (userRepository.findByPhoneNumber(bankAccountRequest.getMobileNo()).isPresent())
            throw new ValidationException("User with Phone number Already exist");

        User user = new User();
        user.setFullName(bankAccountRequest.getAccountName());
        user.setEmailAddress(bankAccountRequest.getEmail());
        user.setPhoneNumber(bankAccountRequest.getMobileNo());
        user.setPassword(bankAccountRequest.getPassword());
//        userRepository.save(user);

        Account account = new Account();
        account.setAccountNumber(appUtils.generateAccountNumber());

        account.setAccountStatus(AccountStatus.PENDING);
        account.setTierLevel(Tier.LEVEL1);
        account.setUser(user);
//        accountRepository.save(account);

        CreateBankAccountResponse response = new CreateBankAccountResponse();
        response.setAccountName(user.getFullName());
        response.setEmail(user.getEmailAddress());
        response.setMobileNo(user.getPhoneNumber());
        response.setAccountNumber(account.getAccountNumber());
        response.setAccountNumber(account.getAccountNumber());

        return new ApiResponse<>("Success", "Account created successfully", response);
    }


    @Override
    public BalanceenquiryResponse fetchAccountBalance(String accountNumber) {
        validateBankAccount(accountNumber);
        WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());
        BalanceEnquiryRequestData balEnqRequest = buildRequest(accountNumber);

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
        return new ApiResponse<>("Success", "The account name is: ", NameEnquiryResponse.builder()
                .accountName(accountName).build());
    }

    public String generateOTP() {
        return RandomStringUtils.randomNumeric(4);
    }

    private void sendOTP(String mobileNumber, String otp) {
        /**
         *  Todo: Implementation of SMS sending API
         *  Send_Token: The OTP sent to the provided mobile number, is store and call verify token API verifyToken()
         */
        accountRepository.updateOTP(mobileNumber,otp);
    }

    private void linkBankAccountToWallet(String mobileNo) {
        User user = userRepository.findByPhoneNumber(mobileNo).get();
        Account account = accountRepository.findAccountByUser(user).get();

        if (account.getUser().getPhoneNumber().equals(Strings.EMPTY)) {
            throw new ValidationException("No such account associated with user");
        }
        account.setUser(user);
//        accountRepository.save(account);
    }

    public VerifyTokenResponse verifySmsToken(String smsToken) {
        User user = userRepository.findBySmsToken(smsToken).get();
        VerifyTokenResponse response = new VerifyTokenResponse();
        response.setAccountName(user.getFullName());
        response.setAccountNo(user.getPhoneNumber());
        response.setEmail(user.getEmailAddress());
        return response;
    }
    

    private Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        /**
         *  This package must match the package in the <generatePackage> specified in
         *          pom.xml
          */
        marshaller.setPackagesToScan(PACKAGE_TO_SCAN);
        return marshaller;
    }
    private BalanceEnquiryRequestData buildRequest(String accountNumber) {
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

    private boolean verifyToken(String accountNumber, String smsToken) {
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
}