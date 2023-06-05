package com.neptunesoftware.accelerex.transaction;

import com.neptunesoftware.accelerex.account.Account;
import com.neptunesoftware.accelerex.account.AccountService;
import com.neptunesoftware.accelerex.account.AccountStatus;
import com.neptunesoftware.accelerex.account.Tier;
import com.neptunesoftware.accelerex.transaction.mapper.TransactionMapper;
import com.neptunesoftware.accelerex.transaction.request.TransactionHistoryRequest;
import com.neptunesoftware.accelerex.transaction.request.TransactionRequest;
import com.neptunesoftware.accelerex.user.User;
import com.neptunesoftware.accelerex.user.UserService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {
    @Mock
    private TransactionRepository transactionRepository;
    @Mock
    private AccountService accountService;
    @Mock
    private UserService userService;
    @InjectMocks
    private TransactionService transactionService;

    private final TransactionMapper transactionMapper = new TransactionMapper();

    @BeforeEach
    void setUp() {
        transactionService = new TransactionService(transactionRepository, accountService, userService, transactionMapper);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void canSuccessfullyTransferFunds()  {
        //given
        TransactionRequest transactionRequest = new TransactionRequest(
                1,
                "12345678",
                "David",
                "23456789",
                "L",
                "123",
                new BigDecimal(200),
                "NGN",
                new BigDecimal(200),
                TransactionType.CREDIT,
                "test transfer");
        User user = new User(1, "David", "david@gmail.com", "david", false);
        Account senderAccount = new Account(user,new BigDecimal(200), AccountStatus.ACTIVATED,"986562737", Tier.LEVEL1,"$2a$10$j4ogRjGJWnPUrmdE82Mq5ueybC9SxGTCgQkvzzE7uSbYXoKqIMKxa");
        Account receiverAccount = new Account(user,new BigDecimal(0), AccountStatus.ACTIVATED,"165568799", Tier.LEVEL1,"$2a$10$j4ogRjGJWnPUrmdE82Mq5ueybC9SxGTCgQkvzzE7uSbYXoKqIMKxa");

        User senderUser = new User(1, "test Name 1", "test1@mail.com", userService.encodePassword("12345"), true);
        User reveiverUser = new User(2, "test Name 2", "test2@mail.com", userService.encodePassword("12345"), true);

        given(accountService.accountExistsAndIsActivated("986562737")).willReturn(senderAccount);
        given(accountService.accountExistsAndIsActivated("165568799")).willReturn(receiverAccount);
        given(userService.getUserById(1)).willReturn(senderUser);
        given(userService.getUserById(2)).willReturn(reveiverUser);

        //when
        transactionService.transferFunds(transactionRequest);

        //then
        verify(accountService, times(1)).debitAccount(senderAccount, transactionRequest.amount());
        verify(accountService, times(1)).creditAccount(receiverAccount, transactionRequest.amount());
    }

    @Test
    void getTransactionStatus() {
    }

    @Test
    void will_Throw_IllegalArgumentException_For_TransferFunds_When_SenderAndReceiverAccountNumberIsTheSame(){
        //given
        TransactionRequest transactionRequest = new TransactionRequest(
                1,
                "12345678",
                "David",
                "23456789",
                "Tega",
                "123",
                new BigDecimal(200),
                "NGN",
                new BigDecimal(200),
                TransactionType.CREDIT,
                "test transfer");
        User user = new User(1, "test Name 1", "test1@mail.com", userService.encodePassword("12345"), true);

        Account senderAccount = new Account(user,new BigDecimal(200), AccountStatus.ACTIVATED,"165568799", Tier.LEVEL1,"$2a$10$j4ogRjGJWnPUrmdE82Mq5ueybC9SxGTCgQkvzzE7uSbYXoKqIMKxa");

        //when
        //then
        assertThatThrownBy(()-> transactionService.transferFunds(transactionRequest))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("sender account cannot be recipient account");
    }

    @Test
    void reverseTransaction() {
    }

    @Test
    void getTransactionHistory() {
        User user = new User(1, "test Name 1", "test1@mail.com", userService.encodePassword("12345"), true);
        Account senderAccount = new Account(user,new BigDecimal(200), AccountStatus.ACTIVATED,"986562737", Tier.LEVEL1,"$2a$10$j4ogRjGJWnPUrmdE82Mq5ueybC9SxGTCgQkvzzE7uSbYXoKqIMKxa");
    }

    void can_generate_transaction_history_when_all_params_are_valid() {
        //given
        User user = new User(1, "test Name 1", "test1@mail.com", userService.encodePassword("12345"), true);
        Account senderAccount = new Account(user, new BigDecimal(200), AccountStatus.ACTIVATED, "986562737", Tier.LEVEL1, "$2a$10$j4ogRjGJWnPUrmdE82Mq5ueybC9SxGTCgQkvzzE7uSbYXoKqIMKxa");
    }
    @Test
    void can_Generate_Transaction_History_Between_Dates_by_userId(){
        //given
        int userId = 1;
        User user = new User(1, "test Name 1", "test1@mail.com", userService.encodePassword("12345"), true);
        Account userAccount = new Account(user,new BigDecimal(200), AccountStatus.ACTIVATED,"986562737", Tier.LEVEL1,"$2a$10$j4ogRjGJWnPUrmdE82Mq5ueybC9SxGTCgQkvzzE7uSbYXoKqIMKxa");
        Page<Transaction> transactions =
                new PageImpl<>(List.of(new Transaction(user,"878676790", "765362789", new BigDecimal("500"), "testRefNum", "testTransaction", new BigDecimal("500"), "testSender", "testReceiver", "testReceiver", TransactionStatus.SUCCESS, TransactionType.CREDIT)));

        TransactionHistoryRequest request = new TransactionHistoryRequest(userAccount.getAccountNumber(),LocalDateTime.now(),LocalDateTime.now().plusHours(2L));

        given(accountService.getAccountByUserId(userId)).willReturn(userAccount);
        given(transactionRepository.findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
                request.startDateTime(),
                request.endDateTime(),
                "986562737",
                "986562737",
                PageRequest.of(1,1)
        )).willReturn(transactions);

    }

    @Test
    void can_Throw_ResourceNotFoundException_When_Transaction_Is_Empty_When_Generating_Transaction_History_Between_Dates_by_userId(){
        //given
        int userId = 1;
        User user = new User(1, "test Name 1", "test1@mail.com", userService.encodePassword("12345"), true);
        Account userAccount = new Account(user,new BigDecimal(200), AccountStatus.ACTIVATED,"986562737", Tier.LEVEL1,"$2a$10$j4ogRjGJWnPUrmdE82Mq5ueybC9SxGTCgQkvzzE7uSbYXoKqIMKxa");
        Page<Transaction> transactions = new PageImpl<>(List.of());

        TransactionHistoryRequest request = new TransactionHistoryRequest("2348499900",LocalDateTime.now(),LocalDateTime.now().plusHours(2L));

        given(accountService.getAccountByUserId(userId)).willReturn(userAccount);
        given(transactionRepository.findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
                request.startDateTime(),
                request.endDateTime(),
                "986562737",
                "986562737",
                PageRequest.of(1,1)
        )).willReturn(transactions);
    }
}