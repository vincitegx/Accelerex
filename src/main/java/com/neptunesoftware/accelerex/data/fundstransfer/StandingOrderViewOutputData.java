//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.07 at 08:56:56 AM WAT 
//


package com.neptunesoftware.accelerex.data.fundstransfer;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for standingOrderViewOutputData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="standingOrderViewOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAcctNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddr1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddr3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddr4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBankBranch" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBankCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBranchCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryTelNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="currencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="custAcctNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="destinationServiceProviderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="expireDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="fundsXferTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fundsXferTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="insufficientFundOption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nextTranDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="nonBusinessDueDateOption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numberOfPayment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numberOfRetries" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="paymentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="repaymentFrequencyUnit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="repaymentFrequencyValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="serviceProviderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="standingOrderId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="standingOrderReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="standingOrderType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="supplementaryInstr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="supplementaryReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transferReasonCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "standingOrderViewOutputData", namespace = "http://data.transfer.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "accountNumber",
    "amount",
    "beneficiaryAcctNumber",
    "beneficiaryAddr1",
    "beneficiaryAddr2",
    "beneficiaryAddr3",
    "beneficiaryAddr4",
    "beneficiaryBankBranch",
    "beneficiaryBankCode",
    "beneficiaryBankCountry",
    "beneficiaryBankName",
    "beneficiaryBranchCity",
    "beneficiaryName",
    "beneficiaryTelNumber",
    "currencyCode",
    "custAcctNumber",
    "customerName",
    "description",
    "destinationServiceProviderId",
    "expireDate",
    "fundsXferTypeCd",
    "fundsXferTypeId",
    "insufficientFundOption",
    "nextTranDate",
    "nonBusinessDueDateOption",
    "numberOfPayment",
    "numberOfRetries",
    "paymentType",
    "repaymentFrequencyUnit",
    "repaymentFrequencyValue",
    "serviceProviderCode",
    "standingOrderId",
    "standingOrderReference",
    "standingOrderType",
    "status",
    "supplementaryInstr",
    "supplementaryReference",
    "transferReasonCd"
})
public class StandingOrderViewOutputData {

    protected String accountNumber;
    protected BigDecimal amount;
    protected String beneficiaryAcctNumber;
    protected String beneficiaryAddr1;
    protected String beneficiaryAddr2;
    protected String beneficiaryAddr3;
    protected String beneficiaryAddr4;
    protected String beneficiaryBankBranch;
    protected String beneficiaryBankCode;
    protected String beneficiaryBankCountry;
    protected String beneficiaryBankName;
    protected String beneficiaryBranchCity;
    protected String beneficiaryName;
    protected String beneficiaryTelNumber;
    protected String currencyCode;
    protected String custAcctNumber;
    protected String customerName;
    protected String description;
    protected Long destinationServiceProviderId;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expireDate;
    protected String fundsXferTypeCd;
    protected Long fundsXferTypeId;
    protected String insufficientFundOption;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar nextTranDate;
    protected String nonBusinessDueDateOption;
    protected String numberOfPayment;
    protected Long numberOfRetries;
    protected String paymentType;
    protected String repaymentFrequencyUnit;
    protected Long repaymentFrequencyValue;
    protected String serviceProviderCode;
    protected Long standingOrderId;
    protected String standingOrderReference;
    protected String standingOrderType;
    protected String status;
    protected String supplementaryInstr;
    protected String supplementaryReference;
    protected String transferReasonCd;

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
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the beneficiaryAcctNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAcctNumber() {
        return beneficiaryAcctNumber;
    }

    /**
     * Sets the value of the beneficiaryAcctNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAcctNumber(String value) {
        this.beneficiaryAcctNumber = value;
    }

    /**
     * Gets the value of the beneficiaryAddr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddr1() {
        return beneficiaryAddr1;
    }

    /**
     * Sets the value of the beneficiaryAddr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddr1(String value) {
        this.beneficiaryAddr1 = value;
    }

    /**
     * Gets the value of the beneficiaryAddr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddr2() {
        return beneficiaryAddr2;
    }

    /**
     * Sets the value of the beneficiaryAddr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddr2(String value) {
        this.beneficiaryAddr2 = value;
    }

    /**
     * Gets the value of the beneficiaryAddr3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddr3() {
        return beneficiaryAddr3;
    }

    /**
     * Sets the value of the beneficiaryAddr3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddr3(String value) {
        this.beneficiaryAddr3 = value;
    }

    /**
     * Gets the value of the beneficiaryAddr4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddr4() {
        return beneficiaryAddr4;
    }

    /**
     * Sets the value of the beneficiaryAddr4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddr4(String value) {
        this.beneficiaryAddr4 = value;
    }

    /**
     * Gets the value of the beneficiaryBankBranch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryBankBranch() {
        return beneficiaryBankBranch;
    }

    /**
     * Sets the value of the beneficiaryBankBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryBankBranch(String value) {
        this.beneficiaryBankBranch = value;
    }

    /**
     * Gets the value of the beneficiaryBankCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryBankCode() {
        return beneficiaryBankCode;
    }

    /**
     * Sets the value of the beneficiaryBankCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryBankCode(String value) {
        this.beneficiaryBankCode = value;
    }

    /**
     * Gets the value of the beneficiaryBankCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryBankCountry() {
        return beneficiaryBankCountry;
    }

    /**
     * Sets the value of the beneficiaryBankCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryBankCountry(String value) {
        this.beneficiaryBankCountry = value;
    }

    /**
     * Gets the value of the beneficiaryBankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryBankName() {
        return beneficiaryBankName;
    }

    /**
     * Sets the value of the beneficiaryBankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryBankName(String value) {
        this.beneficiaryBankName = value;
    }

    /**
     * Gets the value of the beneficiaryBranchCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryBranchCity() {
        return beneficiaryBranchCity;
    }

    /**
     * Sets the value of the beneficiaryBranchCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryBranchCity(String value) {
        this.beneficiaryBranchCity = value;
    }

    /**
     * Gets the value of the beneficiaryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    /**
     * Sets the value of the beneficiaryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryName(String value) {
        this.beneficiaryName = value;
    }

    /**
     * Gets the value of the beneficiaryTelNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryTelNumber() {
        return beneficiaryTelNumber;
    }

    /**
     * Sets the value of the beneficiaryTelNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryTelNumber(String value) {
        this.beneficiaryTelNumber = value;
    }

    /**
     * Gets the value of the currencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyCode() {
        return currencyCode;
    }

    /**
     * Sets the value of the currencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyCode(String value) {
        this.currencyCode = value;
    }

    /**
     * Gets the value of the custAcctNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustAcctNumber() {
        return custAcctNumber;
    }

    /**
     * Sets the value of the custAcctNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustAcctNumber(String value) {
        this.custAcctNumber = value;
    }

    /**
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the destinationServiceProviderId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDestinationServiceProviderId() {
        return destinationServiceProviderId;
    }

    /**
     * Sets the value of the destinationServiceProviderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDestinationServiceProviderId(Long value) {
        this.destinationServiceProviderId = value;
    }

    /**
     * Gets the value of the expireDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpireDate() {
        return expireDate;
    }

    /**
     * Sets the value of the expireDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpireDate(XMLGregorianCalendar value) {
        this.expireDate = value;
    }

    /**
     * Gets the value of the fundsXferTypeCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundsXferTypeCd() {
        return fundsXferTypeCd;
    }

    /**
     * Sets the value of the fundsXferTypeCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundsXferTypeCd(String value) {
        this.fundsXferTypeCd = value;
    }

    /**
     * Gets the value of the fundsXferTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFundsXferTypeId() {
        return fundsXferTypeId;
    }

    /**
     * Sets the value of the fundsXferTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFundsXferTypeId(Long value) {
        this.fundsXferTypeId = value;
    }

    /**
     * Gets the value of the insufficientFundOption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInsufficientFundOption() {
        return insufficientFundOption;
    }

    /**
     * Sets the value of the insufficientFundOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInsufficientFundOption(String value) {
        this.insufficientFundOption = value;
    }

    /**
     * Gets the value of the nextTranDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextTranDate() {
        return nextTranDate;
    }

    /**
     * Sets the value of the nextTranDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextTranDate(XMLGregorianCalendar value) {
        this.nextTranDate = value;
    }

    /**
     * Gets the value of the nonBusinessDueDateOption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNonBusinessDueDateOption() {
        return nonBusinessDueDateOption;
    }

    /**
     * Sets the value of the nonBusinessDueDateOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNonBusinessDueDateOption(String value) {
        this.nonBusinessDueDateOption = value;
    }

    /**
     * Gets the value of the numberOfPayment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumberOfPayment() {
        return numberOfPayment;
    }

    /**
     * Sets the value of the numberOfPayment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumberOfPayment(String value) {
        this.numberOfPayment = value;
    }

    /**
     * Gets the value of the numberOfRetries property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumberOfRetries() {
        return numberOfRetries;
    }

    /**
     * Sets the value of the numberOfRetries property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumberOfRetries(Long value) {
        this.numberOfRetries = value;
    }

    /**
     * Gets the value of the paymentType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentType() {
        return paymentType;
    }

    /**
     * Sets the value of the paymentType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentType(String value) {
        this.paymentType = value;
    }

    /**
     * Gets the value of the repaymentFrequencyUnit property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepaymentFrequencyUnit() {
        return repaymentFrequencyUnit;
    }

    /**
     * Sets the value of the repaymentFrequencyUnit property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepaymentFrequencyUnit(String value) {
        this.repaymentFrequencyUnit = value;
    }

    /**
     * Gets the value of the repaymentFrequencyValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRepaymentFrequencyValue() {
        return repaymentFrequencyValue;
    }

    /**
     * Sets the value of the repaymentFrequencyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRepaymentFrequencyValue(Long value) {
        this.repaymentFrequencyValue = value;
    }

    /**
     * Gets the value of the serviceProviderCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceProviderCode() {
        return serviceProviderCode;
    }

    /**
     * Sets the value of the serviceProviderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceProviderCode(String value) {
        this.serviceProviderCode = value;
    }

    /**
     * Gets the value of the standingOrderId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getStandingOrderId() {
        return standingOrderId;
    }

    /**
     * Sets the value of the standingOrderId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setStandingOrderId(Long value) {
        this.standingOrderId = value;
    }

    /**
     * Gets the value of the standingOrderReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandingOrderReference() {
        return standingOrderReference;
    }

    /**
     * Sets the value of the standingOrderReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandingOrderReference(String value) {
        this.standingOrderReference = value;
    }

    /**
     * Gets the value of the standingOrderType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStandingOrderType() {
        return standingOrderType;
    }

    /**
     * Sets the value of the standingOrderType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStandingOrderType(String value) {
        this.standingOrderType = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the supplementaryInstr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplementaryInstr() {
        return supplementaryInstr;
    }

    /**
     * Sets the value of the supplementaryInstr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplementaryInstr(String value) {
        this.supplementaryInstr = value;
    }

    /**
     * Gets the value of the supplementaryReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplementaryReference() {
        return supplementaryReference;
    }

    /**
     * Sets the value of the supplementaryReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplementaryReference(String value) {
        this.supplementaryReference = value;
    }

    /**
     * Gets the value of the transferReasonCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferReasonCd() {
        return transferReasonCd;
    }

    /**
     * Sets the value of the transferReasonCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferReasonCd(String value) {
        this.transferReasonCd = value;
    }

}
