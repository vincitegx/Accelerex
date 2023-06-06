package com.neptunesoftware.accelerex.account;

import com.neptunesoftware.accelerex.account.request.AccountTransactionPinUpdateModel;
import com.neptunesoftware.accelerex.account.response.AccountOverviewResponse;
import com.neptunesoftware.accelerex.exception.AccountNotActivatedException;
import com.neptunesoftware.accelerex.exception.AccountNotClearedException;
import com.neptunesoftware.accelerex.exception.InsufficientBalanceException;
import com.neptunesoftware.accelerex.exception.ResourceNotFoundException;
import com.neptunesoftware.accelerex.user.User;
import com.neptunesoftware.accelerex.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    private final UserService userService;
    private static final BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public AccountService(AccountRepository accountRepository, UserService userService) {
        this.accountRepository = accountRepository;
        this.userService = userService;
    }

    @Async
    public void createAccount(Account account) {
        account.setAccountNumber(generateUniqueAccountNumber());
        account.setTierLevel(Tier.LEVEL1);
        account.setAccountStatus(AccountStatus.ACTIVATED);
        accountRepository.save(account);
    }

    /**
     * This method generates random 10 digit values and convert to string
     * for use as account number for accounts
     */
    private String generateUniqueAccountNumber() {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int accountNumber;
        boolean exists;
        do {
            accountNumber = random.nextInt(1_000_000_000);
            exists = accountRepository.existsByAccountNumber(String.format("%09d", accountNumber));
        } while (exists);
        return String.format("%09d", accountNumber);
    }

    public Account getAccountByUserId(Integer userId) {
        User user = userService.getUserById(userId);
        Optional<Account> account = accountRepository.findAccountByUser(user);
        if(account.isEmpty()){
            throw new ResourceNotFoundException("account not found");
        }
        return account.get();
    }

    public Account getAccountByNumber(String number) {
        Optional<Account> account = accountRepository.findAccountByAccountNumber(number);
        if(account.isEmpty()){
            throw new ResourceNotFoundException("account not found");
        }
        return account.get();
    }

    /**
     *Generates basic account overview (i.e. balance, accountNumber, tierLevel, accountStatus)of the user and receives userId
     */
    public AccountOverviewResponse generateAccountOverviewByUserId(Integer userId){
        Account userAccount = getAccountByUserId(userId);
        return new AccountOverviewResponse(
                userAccount.getAccountBalance(),
                userAccount.getAccountNumber(),
                userAccount.getTierLevel().name(),
                userAccount.getAccountStatus().name()
        );
    }

    public void updateAccount(Account existingAccount) {
        existingAccount.setUpdatedAt(LocalDateTime.now());
        accountRepository.save(existingAccount);
    }

    /**
     * This method closes the account by getting the userId from the JWT and the relieving reason
     * from the request body
     */
    public void closeAccount(Integer userId){
        Account userAccount = getAccountByUserId(userId);
        if(!noPendingOrAvailableFundInTheAccount(userAccount)) {
            throw new AccountNotClearedException("confirm there is no pending or available balance in the account");
        }
        userAccount.setAccountStatus(AccountStatus.CLOSED);
        updateAccount(userAccount);
    }

    private boolean noPendingOrAvailableFundInTheAccount(Account account){
        return account.getAccountBalance().equals(BigDecimal.ZERO);
    }

    /**
     * This confirms the pin is 4-digits, more pin standards can be set here
     */
    private boolean pinConformsToStandard(String transactionPin){
        return transactionPin.length() == 4;
    }

    public void updateAccountTransactionPin(int userId, AccountTransactionPinUpdateModel pinUpdateModel){
        Account userAccount = getAccountByUserId(userId);
        if(!pinConformsToStandard(pinUpdateModel.transactionPin())){
            throw new IllegalArgumentException("Bad transaction pin format");
        }
        userAccount.setTransactionPin(bCryptPasswordEncoder.encode(pinUpdateModel.transactionPin()));
        updateAccount(userAccount);
    }
    public void creditAccount(Account receiverAccount,BigDecimal amount) {
        receiverAccount.setAccountBalance(receiverAccount.getAccountBalance().add(amount));
        updateAccount(receiverAccount);
    }
    public Account accountExistsAndIsActivated(String accountNumber){
        Optional<Account> exitingAccount = accountRepository.findAccountByAccountNumber(accountNumber);
        if(exitingAccount.isPresent()){
            if(exitingAccount.get().getAccountStatus().equals(AccountStatus.ACTIVATED)){
                return exitingAccount.get();
            }
            throw new AccountNotActivatedException("Account not activated");
        }
        throw new ResourceNotFoundException("Account not found");
    }
    public void debitAccount(Account senderAccount, BigDecimal amount) {

        if(senderAccount.getAccountBalance().compareTo(amount)<=0) {
            throw new InsufficientBalanceException("Insufficient funds");
        }
        senderAccount.setAccountBalance(senderAccount.getAccountBalance().subtract(amount));
        updateAccount(senderAccount);
    }
}
