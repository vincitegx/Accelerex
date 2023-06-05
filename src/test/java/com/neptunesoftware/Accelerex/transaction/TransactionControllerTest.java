package com.neptunesoftware.Accelerex.transaction;

import com.neptunesoftware.Accelerex.transaction.request.TransactionRequest;
import com.neptunesoftware.Accelerex.transaction.response.TransactionResponse;
import com.neptunesoftware.Accelerex.user.UserRepository;
import com.neptunesoftware.Accelerex.user.UserService;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.math.BigDecimal;

import static org.assertj.core.api.Java6Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class TransactionControllerTest {

    private TransactionController transactionController;
    @Mock
    private TransactionService transactionService;
    @Mock
    private UserRepository userRepository;
    @Mock
    private UserService userService;

    @BeforeEach
    void setUp() {
        this.transactionController = new TransactionController(transactionService);
    }

    @Test
    void transferFunds_successful() {
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

        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        //when
        ResponseEntity<TransactionResponse> responseEntity = transactionController.transferFunds(transactionRequest);
        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void postBulkTransactions() {
    }

    @Test
    void getTransactionStatus() {
    }

    @Test
    void reverseTransaction() {
    }

    @Test
    void generateTransactionHistory() {
    }
}