package com.neptunesoftware.Accelerex.account;

import com.neptunesoftware.Accelerex.account.request.CreateBankAccountRequest;
import com.neptunesoftware.Accelerex.account.request.LinkBankAccountRequest;
import com.neptunesoftware.Accelerex.account.response.CreateBankAccountResponse;
import com.neptunesoftware.Accelerex.account.response.LinkBankAccountResponse;
import com.neptunesoftware.Accelerex.exception.ValidationException;
import com.neptunesoftware.Accelerex.user.User;
import com.neptunesoftware.Accelerex.user.UserRepository;
import com.neptunesoftware.Accelerex.utils.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@RequiredArgsConstructor
@Log4j2
public class AccountServiceImpl implements AccountServices {

    private final UserRepository userRepository;
    private final AccountRepository accountRepository;

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
            linkBankAccountToWallet(request.getAccountNo(), request.getAccountName(), request.getMobileNo(), request.getEmail());
            User user = userRepository.findByMobileNumber(request.getMobileNo()).get();
            Account account = accountRepository.findByUserId(user.getUserId());

            LinkBankAccountResponse response = new LinkBankAccountResponse();
            response.setAccountName(account.getAccountName());
            response.setMobileNo(user.getMobileNumber());
            response.setEmail(user.getEmail());

            return new ApiResponse<>("Success", "Bank account linked successfully.", response);
        }
            return new ApiResponse<>("Failed", "Failed to link Bank Account", null);
    }


    public ApiResponse<CreateBankAccountResponse> createBankAccount(CreateBankAccountRequest bankAccountRequest) {


        if ( userRepository.findByEmail(bankAccountRequest.getEmail()).isPresent())
            throw new ValidationException("User with Email already exist");
        if (userRepository.findByMobileNumber(bankAccountRequest.getMobileNo()).isPresent())
            throw new ValidationException("User with Phone number Already exist");

        User user = new User();


        user.setEmail(bankAccountRequest.getEmail());
        user.setMobileNumber(bankAccountRequest.getMobileNo());
        user.setPassword(bankAccountRequest.getPassword());
        user.setSmsToken(generateOTP());
        userRepository.save(user);
        
        Account account = new Account();
         account.setAccountNumber("556788998767");
        account.setAccountName(bankAccountRequest.getAccountName());
        account.setUserId(user.getUserId());
        accountRepository.save(account);

        CreateBankAccountResponse response = new CreateBankAccountResponse();
        response.setAccountName(account.getAccountName());
        response.setEmail(user.getEmail());
        response.setMobileNo(user.getMobileNumber());
        response.setAccountNumber(account.getAccountNumber());

        return new ApiResponse<>("Success", "Account created successfully", response);
    }

    private boolean validateBankAccount(String mobileNo) {
        return userRepository.findByMobileNumber(mobileNo).isPresent();
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
        //Todo: Implementation of SMS seb
        // Send: the OTP to the provided mobile number
        return true;
    }

    private void linkBankAccountToWallet(String accountNumber, String accountName, String mobileNo, String email) {
        User user = userRepository.findByMobileNumber(mobileNo).get();
        Account account = accountRepository.findByUserId(user.getUserId());

        if (account==null) {
            throw new ValidationException("Something went wrong");
        }
        account.setUserId(user.getUserId());
        log.info("User found from DB {}",account.getUserId());
        account.setAccountName(accountName);
        account.setAccountNumber(accountNumber);
        accountRepository.save(account);
    }

    //   Todo: I will create an API to validate the Otp {  verifySmsToken() }
    public String verifySmsToken(String smsToken) {
        User user = userRepository.findBySmsToken(smsToken).get();
        if (user.getSmsToken().equals(smsToken)) {
            user.setVerified(true);
            userRepository.save(user);
        }
        return "Successful";
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