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
        account.setAccountStatus(AccountStatus.PENDING);
        account.setTierLevel(Tier.LEVEL1);
        account.setUser(user);
        accountRepository.save(account);

        CreateBankAccountResponse response = new CreateBankAccountResponse();
        response.setAccountName(user.getFullName());
        response.setEmail(user.getEmailAddress());
        response.setMobileNo(user.getPhoneNumber());
        response.setAccountNumber(account.getAccountNumber());

        return new ApiResponse<>("Success", "Account created successfully", response);
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
        //Todo: Implementation of SMS seb
        // Send: the OTP to the provided mobile number
        return true;
    }

    private void linkBankAccountToWallet(String mobileNo) {
        User user = userRepository.findByPhoneNumber(mobileNo).get();
        Account account = accountRepository.findByUserId(user.getId());

        if (account==null) {
            throw new ValidationException("Something went wrong");
        }
        account.setUser(user);
        accountRepository.save(account);
    }

    //   Todo: I will create an API to validate the Otp {  verifySmsToken() }
    public String verifySmsToken(String smsToken) {
//        User user = userRepository.findBySmsToken(smsToken).get();
//        if (user.getSmsToken().equals(smsToken)) {
//            user.setVerified(true);
//            userRepository.save(user);
//        }
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