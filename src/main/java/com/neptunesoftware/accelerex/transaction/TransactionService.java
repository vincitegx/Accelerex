package com.neptunesoftware.accelerex.transaction;

import com.neptunesoftware.accelerex.account.AccountRepository;
import com.neptunesoftware.accelerex.account.AccountServices;
import com.neptunesoftware.accelerex.account.BalanceEnquiryService;
import com.neptunesoftware.accelerex.config.AccelerexCredentials;
import com.neptunesoftware.accelerex.data.fundstransfer.CustomerToCustomerTransfer;
import com.neptunesoftware.accelerex.data.fundstransfer.CustomerToCustomerTransferResponse;
import com.neptunesoftware.accelerex.data.fundstransfer.FundsTransferRequestData;
import com.neptunesoftware.accelerex.exception.FundTransferException;
import com.neptunesoftware.accelerex.transaction.request.*;
import com.neptunesoftware.accelerex.transaction.response.TransactionHistoryResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponse;
import com.neptunesoftware.accelerex.transaction.response.TransactionResponseStatus;

import jakarta.xml.bind.JAXBElement;
import lombok.extern.log4j.Log4j2;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

@Service
@Log4j2
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;
    private final BalanceEnquiryService balanceEnquiryService;
    private final AccelerexCredentials credentials;
    private static final Long LONG_VALUE_99= -99L;
    public static final String PACKAGE_TO_SCAN = "com.neptunesoftware.accelerex.data.fundstransfer";

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, AccountRepository accountRepository,
                              BalanceEnquiryService balanceEnquiryService, AccelerexCredentials credentials) {
        this.transactionRepository = transactionRepository;
        this.accountRepository = accountRepository;
        this.balanceEnquiryService = balanceEnquiryService;
        this.credentials = credentials;
    }
    public TransactionResponse transferFunds(TransactionRequest request){
        TransactionResponse txnResponse = null;
        try{
            if (isValidationChecksPassed(request)) {
                WebServiceTemplate webServiceTemplate = new WebServiceTemplate(marshaller());
                FundsTransferRequestData txnRequestData = buildRequestFrom(request);
                CustomerToCustomerTransfer customerToCustomerTransfer = new CustomerToCustomerTransfer();
                customerToCustomerTransfer.setArg0(txnRequestData);
                log.info("Initiating internal funds transfer of Amount: {} and reference: {} from source: {} to destination: {}", request.getAmount(), request.getReferenceNo(),
                        request.getSenderAccountNumber(), request.getReceiverAccountNumber());
                JAXBElement response = (JAXBElement) webServiceTemplate.marshalSendAndReceive(
                        this.credentials.getFundTransferWsdl(), customerToCustomerTransfer
                );
                CustomerToCustomerTransferResponse responseValue = (CustomerToCustomerTransferResponse) response.getValue();
                log.info("Response Code: {}", responseValue.getReturn().getResponseCode());
                if (!responseValue.getReturn().getResponseCode().equalsIgnoreCase("00")) {
                    log.error("Transaction failed !!!");
                    throw new FundTransferException("Transaction failed !!!");
                }else{
                    log.info("Transaction was successful !!!");
                }
                TransactionDetails details = TransactionDetails.builder()
                        .tranRef(responseValue.getReturn().getTxnReference())
                        .customerNo(request.getClientId().toString())
                        .fromAccountNumber(responseValue.getReturn().getFromAccountNumber())
                        .toAccountNumber(responseValue.getReturn().getToAccountNumber())
                        .amount(responseValue.getReturn().getTransactionAmount().toString())
                        .responseCode(responseValue.getReturn().getResponseCode())
                        .subTranRef("InternalFundTransfer")
                        .narration(request.getNarration())
                        .build();
                int transactionResponse = saveTransaction(details);
                if (transactionResponse != 1) {
                    log.error("Internal funds transfer of amount: "+
                            request.getAmount()+" and reference: "+
                            request.getReferenceNo()+" from source: "+
                            request.getSenderAccountNumber()+" to destination: "+
                            request.getReceiverAccountNumber()+" failed to save to database");
                }else{
                    log.info("Internal funds transfer of amount: "+
                            request.getAmount()+" and reference: "+
                            request.getReferenceNo()+" from source: "+
                            request.getSenderAccountNumber()+" to destination: "+
                            request.getReceiverAccountNumber()+" saved successfully to database");
                }
                txnResponse = new TransactionResponse(TransactionResponseStatus.SUCCESS, request.getReferenceNo());
            }else {
                txnResponse = new TransactionResponse(TransactionResponseStatus.FAIL, request.getReferenceNo());
            }
        } catch (FundTransferException e) {
            log.error(e.getMessage());
            throw new FundTransferException(e.getMessage());
        }
        return txnResponse;
    }
    private boolean isValidationChecksPassed(TransactionRequest request){
        BigDecimal amount = request.getAmount();
        String senderAccountNumber = request.getSenderAccountNumber();
        String receiverAccountNumber = request.getReceiverAccountNumber();
        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new FundTransferException("Transaction amount must be greater than 0");
        }
        if (senderAccountNumber.equals(receiverAccountNumber)) {
            throw new FundTransferException("Sender and Receiver account cannot be the same");
        }
        if (!isValidAccountNumber(senderAccountNumber)) {
            throw new FundTransferException("The sender account number is invalid: " + senderAccountNumber);
        }
        if (!isValidAccountNumber(receiverAccountNumber)) {
            throw new FundTransferException("The receiver account number is invalid: " + receiverAccountNumber);
        }
        if (!balanceEnquiryService.isAccountSufficient(senderAccountNumber, amount)) {
            throw new FundTransferException("Insufficient funds");
        }
        if (existsByReferenceNo(request.getReferenceNo())) {
            throw new FundTransferException("Reference Number already exists");
        }
        return true;
    }
    public TransactionResponse getTransactionStatus(String externalRefNo, String clientId) {
        try{
            log.info(">>>>>>> Initiating Transaction Status For ClientId {}, and ReferenceNo {} >>>>>>>", clientId, externalRefNo);
            TransactionResponse transactionResponse = transactionRepository.findByClientIdAndReferenceNo(clientId, externalRefNo);
            return transactionResponse;
        }catch (Exception ex){
            log.error(ex.getMessage());
            throw new FundTransferException(ex.getMessage());
        }
    }

//    public void reverseTransaction(String externalRefNo) {
//        Transaction transaction = transactionRepository.findByReferenceNo(externalRefNo).orElseThrow(()-> new TransactionNotFoundException("Transaction not found"));
//        Account receiverAccount = accountService.accountExistsAndIsActivated(transaction.getReceiverAccountNumber());
//        Account senderAccount = accountService.accountExistsAndIsActivated(transaction.getSenderAccountNumber());
//        accountService.debitAccount(receiverAccount, transaction.getAmount());
//        accountService.creditAccount(senderAccount, transaction.getAmount());
//        transaction.setStatus(TransactionStatus.SUCCESS);
//        transaction.setReversal('Y');
//        transactionRepository.saveAndFlush(transaction);
//    }
    private boolean isValidAccountNumber(String accountNumber) {
        return true;
//        return accountRepository.existsByAccountNumber(accountNumber);
    }
    private boolean existsByReferenceNo(String referenceNo){
        return transactionRepository.existsByReferenceNo(referenceNo);
    }
    public List<TransactionHistoryResponse> getTransactionHistory(TransactionHistoryRequest request) {
        log.info(">>>>>>> Initiating Transaction History For account {}, between {} and {} >>>>>>>", request.accountNumber(), request.startDateTime(), request.endDateTime());
        return transactionRepository.findAllByCreatedAtBetweenAndSenderAccountNumberOrReceiverAccountNumber(
                request.startDateTime(),
                request.endDateTime(),
                request.accountNumber(),
                request.accountNumber()
        );
    }

    private FundsTransferRequestData buildRequestFrom(TransactionRequest details) {
        FundsTransferRequestData txnRequestData = new FundsTransferRequestData();
        txnRequestData.setCurrBUId(LONG_VALUE_99);
        txnRequestData.setChannelId(Long.valueOf(this.credentials.getChannelId()));
        txnRequestData.setChannelCode(this.credentials.getChannelCode());
        txnRequestData.setXAPIServiceCode(this.credentials.getXapiServiceCode());
        txnRequestData.setLocalCcyId(732L);
        txnRequestData.setTransmissionTime(System.currentTimeMillis());
        txnRequestData.setFromAccountNumber(details.getSenderAccountNumber());
        txnRequestData.setFromCurrencyCode(details.getCurrencyCode());
        txnRequestData.setToAccountNumber(details.getReceiverAccountNumber());
        txnRequestData.setToCurrencyCode(details.getCurrencyCode());
        txnRequestData.setAmount(details.getAmount());
        txnRequestData.setTransactionAmount(details.getAmount());
        txnRequestData.setTxnDescription(details.getNarration());
        txnRequestData.setTxnDate(Date.from(Instant.now()).toString());
        txnRequestData.setReference(details.getReferenceNo());
        txnRequestData.setRetrievalReferenceNumber(details.getReferenceNo());
        txnRequestData.setReversalIndicator("N");
        txnRequestData.setReversal(false);
        txnRequestData.setUserAccessCode(this.credentials.getUserAccessCode());
        txnRequestData.setUserPassword(this.credentials.getUserPassword());
        txnRequestData.setUserId(LONG_VALUE_99);
        txnRequestData.setUserLoginId(this.credentials.getUserLoginId());
        txnRequestData.setUserRoleId(LONG_VALUE_99);
        txnRequestData.setUserBusinessRoleId(LONG_VALUE_99);
        txnRequestData.setOriginatorUserId(LONG_VALUE_99);
        return txnRequestData;
    }
    public int saveTransaction(TransactionDetails details) {
        return transactionRepository.saveTransaction(details);
    }
    private Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setPackagesToScan(PACKAGE_TO_SCAN);
        return marshaller;
    }
}