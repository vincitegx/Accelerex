//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 09:43:48 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for accountBalanceOutputData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountBalanceOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="availableBalance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="clearedBalance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="crInterestAccrued" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="creditInterestRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="currencyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="debitInterestRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="ledgerBalance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="overDraftRate" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="overdraftLimit" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="transactionToday" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="transmissionTime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="unclearEffort" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountBalanceOutputData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "accountNo",
    "availableBalance",
    "clearedBalance",
    "crInterestAccrued",
    "creditInterestRate",
    "currencyId",
    "debitInterestRate",
    "ledgerBalance",
    "overDraftRate",
    "overdraftLimit",
    "transactionToday",
    "transmissionTime",
    "unclearEffort"
})
@XmlSeeAlso({
    AccountSummaryOutputData.class
})
public class AccountBalanceOutputData {

    protected String accountNo;
    protected BigDecimal availableBalance;
    protected BigDecimal clearedBalance;
    protected BigDecimal crInterestAccrued;
    protected BigDecimal creditInterestRate;
    protected Long currencyId;
    protected BigDecimal debitInterestRate;
    protected BigDecimal ledgerBalance;
    protected BigDecimal overDraftRate;
    protected BigDecimal overdraftLimit;
    protected BigDecimal transactionToday;
    protected Long transmissionTime;
    protected BigDecimal unclearEffort;

    /**
     * Gets the value of the accountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * Sets the value of the accountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNo(String value) {
        this.accountNo = value;
    }

    /**
     * Gets the value of the availableBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAvailableBalance() {
        return availableBalance;
    }

    /**
     * Sets the value of the availableBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAvailableBalance(BigDecimal value) {
        this.availableBalance = value;
    }

    /**
     * Gets the value of the clearedBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getClearedBalance() {
        return clearedBalance;
    }

    /**
     * Sets the value of the clearedBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setClearedBalance(BigDecimal value) {
        this.clearedBalance = value;
    }

    /**
     * Gets the value of the crInterestAccrued property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCrInterestAccrued() {
        return crInterestAccrued;
    }

    /**
     * Sets the value of the crInterestAccrued property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCrInterestAccrued(BigDecimal value) {
        this.crInterestAccrued = value;
    }

    /**
     * Gets the value of the creditInterestRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCreditInterestRate() {
        return creditInterestRate;
    }

    /**
     * Sets the value of the creditInterestRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCreditInterestRate(BigDecimal value) {
        this.creditInterestRate = value;
    }

    /**
     * Gets the value of the currencyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCurrencyId() {
        return currencyId;
    }

    /**
     * Sets the value of the currencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCurrencyId(Long value) {
        this.currencyId = value;
    }

    /**
     * Gets the value of the debitInterestRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDebitInterestRate() {
        return debitInterestRate;
    }

    /**
     * Sets the value of the debitInterestRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDebitInterestRate(BigDecimal value) {
        this.debitInterestRate = value;
    }

    /**
     * Gets the value of the ledgerBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLedgerBalance() {
        return ledgerBalance;
    }

    /**
     * Sets the value of the ledgerBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLedgerBalance(BigDecimal value) {
        this.ledgerBalance = value;
    }

    /**
     * Gets the value of the overDraftRate property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOverDraftRate() {
        return overDraftRate;
    }

    /**
     * Sets the value of the overDraftRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOverDraftRate(BigDecimal value) {
        this.overDraftRate = value;
    }

    /**
     * Gets the value of the overdraftLimit property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getOverdraftLimit() {
        return overdraftLimit;
    }

    /**
     * Sets the value of the overdraftLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setOverdraftLimit(BigDecimal value) {
        this.overdraftLimit = value;
    }

    /**
     * Gets the value of the transactionToday property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTransactionToday() {
        return transactionToday;
    }

    /**
     * Sets the value of the transactionToday property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTransactionToday(BigDecimal value) {
        this.transactionToday = value;
    }

    /**
     * Gets the value of the transmissionTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTransmissionTime() {
        return transmissionTime;
    }

    /**
     * Sets the value of the transmissionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTransmissionTime(Long value) {
        this.transmissionTime = value;
    }

    /**
     * Gets the value of the unclearEffort property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getUnclearEffort() {
        return unclearEffort;
    }

    /**
     * Sets the value of the unclearEffort property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setUnclearEffort(BigDecimal value) {
        this.unclearEffort = value;
    }

}
