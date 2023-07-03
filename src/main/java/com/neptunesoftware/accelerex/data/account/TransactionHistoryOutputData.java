//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.08 at 11:33:52 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for transactionHistoryOutputData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transactionHistoryOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contraAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="displayAcctCcyEq" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayAcctCcyIsoCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayChqNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayDrCrFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayExchgRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayStmtBal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayTotalCharge" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayTxnAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayTxnDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayValueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displaycontCcyISOCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="drcrFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="eventCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="eventDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="exchangeRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="strProdCategory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="txnAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="txnCcyISOCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="txnChequeNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="txnDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="txnDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="txnJournalId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="txnReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="txnServiceChannelId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="txnTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transactionHistoryOutputData", namespace = "http://data.transaction.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "accountId",
    "accountNumber",
    "contraAccountNo",
    "currency",
    "customerId",
    "displayAcctCcyEq",
    "displayAcctCcyIsoCode",
    "displayChqNo",
    "displayDrCrFlag",
    "displayExchgRate",
    "displayStmtBal",
    "displayTotalCharge",
    "displayTxnAmount",
    "displayTxnDate",
    "displayValueDate",
    "displaycontCcyISOCode",
    "drcrFlag",
    "eventCode",
    "eventDesc",
    "exchangeRate",
    "strProdCategory",
    "txnAmount",
    "txnCcyISOCode",
    "txnChequeNumber",
    "txnDate",
    "txnDescription",
    "txnJournalId",
    "txnReference",
    "txnServiceChannelId",
    "txnTypeId"
})
@XmlSeeAlso({
    DepositTxnOutputData.class
})
public class TransactionHistoryOutputData {

    protected Long accountId;
    protected String accountNumber;
    protected String contraAccountNo;
    protected String currency;
    protected Long customerId;
    protected String displayAcctCcyEq;
    protected String displayAcctCcyIsoCode;
    protected String displayChqNo;
    protected String displayDrCrFlag;
    protected String displayExchgRate;
    protected String displayStmtBal;
    protected String displayTotalCharge;
    protected String displayTxnAmount;
    protected String displayTxnDate;
    protected String displayValueDate;
    protected String displaycontCcyISOCode;
    protected String drcrFlag;
    protected String eventCode;
    protected String eventDesc;
    protected BigDecimal exchangeRate;
    protected String strProdCategory;
    protected BigDecimal txnAmount;
    protected String txnCcyISOCode;
    protected Long txnChequeNumber;
    protected Long txnDate;
    protected String txnDescription;
    protected Long txnJournalId;
    protected String txnReference;
    protected String txnServiceChannelId;
    protected Long txnTypeId;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountId(Long value) {
        this.accountId = value;
    }

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the contraAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContraAccountNo() {
        return contraAccountNo;
    }

    /**
     * Sets the value of the contraAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContraAccountNo(String value) {
        this.contraAccountNo = value;
    }

    /**
     * Gets the value of the currency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the value of the currency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrency(String value) {
        this.currency = value;
    }

    /**
     * Gets the value of the customerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomerId(Long value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the displayAcctCcyEq property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayAcctCcyEq() {
        return displayAcctCcyEq;
    }

    /**
     * Sets the value of the displayAcctCcyEq property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayAcctCcyEq(String value) {
        this.displayAcctCcyEq = value;
    }

    /**
     * Gets the value of the displayAcctCcyIsoCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayAcctCcyIsoCode() {
        return displayAcctCcyIsoCode;
    }

    /**
     * Sets the value of the displayAcctCcyIsoCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayAcctCcyIsoCode(String value) {
        this.displayAcctCcyIsoCode = value;
    }

    /**
     * Gets the value of the displayChqNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayChqNo() {
        return displayChqNo;
    }

    /**
     * Sets the value of the displayChqNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayChqNo(String value) {
        this.displayChqNo = value;
    }

    /**
     * Gets the value of the displayDrCrFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayDrCrFlag() {
        return displayDrCrFlag;
    }

    /**
     * Sets the value of the displayDrCrFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayDrCrFlag(String value) {
        this.displayDrCrFlag = value;
    }

    /**
     * Gets the value of the displayExchgRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayExchgRate() {
        return displayExchgRate;
    }

    /**
     * Sets the value of the displayExchgRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayExchgRate(String value) {
        this.displayExchgRate = value;
    }

    /**
     * Gets the value of the displayStmtBal property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayStmtBal() {
        return displayStmtBal;
    }

    /**
     * Sets the value of the displayStmtBal property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayStmtBal(String value) {
        this.displayStmtBal = value;
    }

    /**
     * Gets the value of the displayTotalCharge property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayTotalCharge() {
        return displayTotalCharge;
    }

    /**
     * Sets the value of the displayTotalCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayTotalCharge(String value) {
        this.displayTotalCharge = value;
    }

    /**
     * Gets the value of the displayTxnAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayTxnAmount() {
        return displayTxnAmount;
    }

    /**
     * Sets the value of the displayTxnAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayTxnAmount(String value) {
        this.displayTxnAmount = value;
    }

    /**
     * Gets the value of the displayTxnDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayTxnDate() {
        return displayTxnDate;
    }

    /**
     * Sets the value of the displayTxnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayTxnDate(String value) {
        this.displayTxnDate = value;
    }

    /**
     * Gets the value of the displayValueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayValueDate() {
        return displayValueDate;
    }

    /**
     * Sets the value of the displayValueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayValueDate(String value) {
        this.displayValueDate = value;
    }

    /**
     * Gets the value of the displaycontCcyISOCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplaycontCcyISOCode() {
        return displaycontCcyISOCode;
    }

    /**
     * Sets the value of the displaycontCcyISOCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplaycontCcyISOCode(String value) {
        this.displaycontCcyISOCode = value;
    }

    /**
     * Gets the value of the drcrFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrcrFlag() {
        return drcrFlag;
    }

    /**
     * Sets the value of the drcrFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrcrFlag(String value) {
        this.drcrFlag = value;
    }

    /**
     * Gets the value of the eventCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventCode() {
        return eventCode;
    }

    /**
     * Sets the value of the eventCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventCode(String value) {
        this.eventCode = value;
    }

    /**
     * Gets the value of the eventDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventDesc() {
        return eventDesc;
    }

    /**
     * Sets the value of the eventDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventDesc(String value) {
        this.eventDesc = value;
    }

    /**
     * Gets the value of the exchangeRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getExchangeRate() {
        return exchangeRate;
    }

    /**
     * Sets the value of the exchangeRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setExchangeRate(BigDecimal value) {
        this.exchangeRate = value;
    }

    /**
     * Gets the value of the strProdCategory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrProdCategory() {
        return strProdCategory;
    }

    /**
     * Sets the value of the strProdCategory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrProdCategory(String value) {
        this.strProdCategory = value;
    }

    /**
     * Gets the value of the txnAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTxnAmount() {
        return txnAmount;
    }

    /**
     * Sets the value of the txnAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTxnAmount(BigDecimal value) {
        this.txnAmount = value;
    }

    /**
     * Gets the value of the txnCcyISOCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnCcyISOCode() {
        return txnCcyISOCode;
    }

    /**
     * Sets the value of the txnCcyISOCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnCcyISOCode(String value) {
        this.txnCcyISOCode = value;
    }

    /**
     * Gets the value of the txnChequeNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTxnChequeNumber() {
        return txnChequeNumber;
    }

    /**
     * Sets the value of the txnChequeNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTxnChequeNumber(Long value) {
        this.txnChequeNumber = value;
    }

    /**
     * Gets the value of the txnDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTxnDate() {
        return txnDate;
    }

    /**
     * Sets the value of the txnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTxnDate(Long value) {
        this.txnDate = value;
    }

    /**
     * Gets the value of the txnDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnDescription() {
        return txnDescription;
    }

    /**
     * Sets the value of the txnDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnDescription(String value) {
        this.txnDescription = value;
    }

    /**
     * Gets the value of the txnJournalId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTxnJournalId() {
        return txnJournalId;
    }

    /**
     * Sets the value of the txnJournalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTxnJournalId(Long value) {
        this.txnJournalId = value;
    }

    /**
     * Gets the value of the txnReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnReference() {
        return txnReference;
    }

    /**
     * Sets the value of the txnReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnReference(String value) {
        this.txnReference = value;
    }

    /**
     * Gets the value of the txnServiceChannelId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnServiceChannelId() {
        return txnServiceChannelId;
    }

    /**
     * Sets the value of the txnServiceChannelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnServiceChannelId(String value) {
        this.txnServiceChannelId = value;
    }

    /**
     * Gets the value of the txnTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTxnTypeId() {
        return txnTypeId;
    }

    /**
     * Sets the value of the txnTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTxnTypeId(Long value) {
        this.txnTypeId = value;
    }

}
