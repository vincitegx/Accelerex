package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.*;
import com.neptunesoftware.accelerex.account.response.*;
import com.neptunesoftware.accelerex.config.JWTService;
import com.neptunesoftware.accelerex.exception.ValidationException;
import com.neptunesoftware.accelerex.general.ClientRepo;
import com.neptunesoftware.accelerex.user.User;
import com.neptunesoftware.accelerex.user.UserRepository;
import com.neptunesoftware.accelerex.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccountServiceImpl implements AccountServices {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;
    private final ClientRepo clientRepo;
    private static Map<String, String> apiCredentials;
    private final JWTService jwtService;
    

    @Override
    public ApiResponse<LinkBankAccountResponse> linkBankAccountToAgent(LinkBankAccountRequest request) {
        boolean isAccountValid = validateBankAccount(request.getMobileNo());

        String otp;

        if (isAccountValid) {
            otp = generateOTP();
            boolean isOtpValid = sendOTP(request.getMobileNo(), otp);

            if (!isOtpValid) {

                throw new ValidationException("Invalid Otp");
            }
            linkBankAccountToWallet(request.getMobileNo());
            User user = userRepository.findByPhoneNumber(request.getMobileNo()).get();
            Account account = accountRepository.findByUserId(user.getId());

            LinkBankAccountResponse response = new LinkBankAccountResponse();
            response.setAccountNo(account.getAccountNumber());
            response.setMobileNo(user.getPhoneNumber());
            response.setEmail(user.getEmailAddress());
            response.setAccountName(user.getFullName());

            return new ApiResponse<>("Success", "Bank account linked successfully.", response);
        }
            return new ApiResponse<>("Failed", "Failed to link Bank Account", null);
    }


    public ApiResponse<CreateBankAccountResponse> createBankAccount(CreateBankAccountRequest bankAccountRequest) {


        if ( userRepository.findByEmailAddress(bankAccountRequest.getEmail()).isPresent())
            throw new ValidationException("User with Email already exist");
        if (userRepository.findByPhoneNumber(bankAccountRequest.getMobileNo()).isPresent())
            throw new ValidationException("User with Phone number Already exist");

        User user = new User();
        user.setFullName(bankAccountRequest.getAccountName());
        user.setEmailAddress(bankAccountRequest.getEmail());
        user.setPhoneNumber(bankAccountRequest.getMobileNo());
        user.setPassword(bankAccountRequest.getPassword());
        userRepository.save(user);

        Account account = new Account();
        account.setAccountNumber(generateAccountNumber());

        while(accountRepository.findByAccountNumber(account.getAccountNumber()).isPresent()) {
              generateAccountNumber();

        }
        account.setAccountStatus(AccountStatus.PENDING);
        account.setTierLevel(Tier.LEVEL1);
        account.setUser(user);
        accountRepository.save(account);

        CreateBankAccountResponse response = new CreateBankAccountResponse();
        response.setAccountName(user.getFullName());
        response.setEmail(user.getEmailAddress());
        response.setMobileNo(user.getPhoneNumber());
        response.setAccountNumber(account.getAccountNumber());
        response.setAccountNumber(account.getAccountNumber());

        return new ApiResponse<>("Success", "Account created successfully", response);
    }

    @Override
    public ApiResponse<VerifyTokenResponse> createVirtualAccount(VirtualAccountRequest request) {
        return null;
    }

    @Override
    public ApiResponse<FetchAccountBalanceResponse> fetchAccountBalance(FetchAccountBalanceRequest request) {

        if (authenticate(request.getClientId(), request.getSecretKey())) {
            Account account = accountRepository.findByAccountNumber(request.getAccountNo()).get();
            FetchAccountBalanceResponse response = new FetchAccountBalanceResponse();
            response.setAccountName(account.getAccountNumber());
            response.setCurrencyCode(account.getCurrencyCode());
            response.setAvailableBalance(String.valueOf(account.getAccountBalance()));
            response.setAccountStatus(account.getAccountStatus());

            return new ApiResponse<>("Success","Your Account Balance is: "+ account.getAccountBalance(),response);
        }
        return new ApiResponse<>("Failed","Failed to retrieve Account details",null);
    }

    public boolean authenticate(String clientId, String secretKey) {
            if (userRepository.findByEmailAddress(clientId).isPresent()) {
                if (jwtService.extractUsername(secretKey) == clientId) {

                    apiCredentials = new HashMap<>();
                    apiCredentials.put(clientId, secretKey);
                }
            }
        return apiCredentials.containsKey(clientId) && apiCredentials.get(clientId).equals(secretKey);
    }

    @Override
    public ApiResponse<NameInquiryResponse> nameInquiry(NameInquiryRequest nameInquiryRequest) {
        return null;
    }

    private boolean validateBankAccount(String mobileNo) {
        return userRepository.findByPhoneNumber(mobileNo).isPresent();
    }

    public String generateOTP() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            otp.append(random.nextInt(10));
        }
        return otp.toString();
    }

    private boolean sendOTP(String mobileNumber, String otp) {
        User user = userRepository.findByPhoneNumber(mobileNumber).get();

        //Todo: Implementation of SMS seb
        // Send: The OTP to the provided mobile number and call verify token API =>verifyToken()
//        if (verifySmsToken(otp).getMobileNo().equals(user.getPhoneNumber())) {
//            user.setVerified(true);
//            userRepository.save(user);
//            return true;
//        }
//        throw new ValidationException("Invalid Token");
        return true;
    }

    private void linkBankAccountToWallet(String mobileNo) {
        User user = userRepository.findByPhoneNumber(mobileNo).get();
        Account account = accountRepository.findByUserId(user.getId());

        if (account==null) {
            throw new ValidationException("No such account associated with user");
        }
        account.setUser(user);
        accountRepository.save(account);
    }


    public VerifyTokenResponse verifySmsToken(String smsToken) {
        User user = userRepository.findBySmsToken(smsToken).get();
        VerifyTokenResponse response = new VerifyTokenResponse();
        response.setAccountName(user.getFullName());
        response.setAccountNo(user.getPhoneNumber());
        response.setEmail(user.getEmailAddress());
      return response;
    }
    public String generateAccountNumber() {
        Random random = new Random();
        StringBuilder otp = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            otp.append(random.nextInt(4, 10));
        }
        return otp.toString();
    }

    
}