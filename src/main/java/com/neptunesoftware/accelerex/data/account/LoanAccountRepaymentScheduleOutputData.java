//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.08 at 11:33:52 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for loanAccountRepaymentScheduleOutputData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="loanAccountRepaymentScheduleOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="allowMultiplePayments" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="disbursements" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="feeAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="finalRepaymentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="firstRepaymentDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="interestAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="repaymentAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="repaymentFrequency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="repaymentMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="repaymentSchedule" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loanAccountRepaymentScheduleOutputData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "accountNumber",
    "allowMultiplePayments",
    "customerName",
    "customerNumber",
    "disbursements",
    "feeAccount",
    "finalRepaymentDate",
    "firstRepaymentDate",
    "interestAccount",
    "paymentType",
    "repaymentAccount",
    "repaymentFrequency",
    "repaymentMethod",
    "repaymentSchedule"
})
public class LoanAccountRepaymentScheduleOutputData {

    protected String accountNumber;
    protected String allowMultiplePayments;
    protected String customerName;
    protected String customerNumber;
    protected String disbursements;
    protected String feeAccount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar finalRepaymentDate;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar firstRepaymentDate;
    protected String interestAccount;
    protected String paymentType;
    protected String repaymentAccount;
    protected String repaymentFrequency;
    protected String repaymentMethod;
    protected String repaymentSchedule;

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
     * Gets the value of the allowMultiplePayments property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAllowMultiplePayments() {
        return allowMultiplePayments;
    }

    /**
     * Sets the value of the allowMultiplePayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAllowMultiplePayments(String value) {
        this.allowMultiplePayments = value;
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
     * Gets the value of the customerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the value of the customerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerNumber(String value) {
        this.customerNumber = value;
    }

    /**
     * Gets the value of the disbursements property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisbursements() {
        return disbursements;
    }

    /**
     * Sets the value of the disbursements property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisbursements(String value) {
        this.disbursements = value;
    }

    /**
     * Gets the value of the feeAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFeeAccount() {
        return feeAccount;
    }

    /**
     * Sets the value of the feeAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFeeAccount(String value) {
        this.feeAccount = value;
    }

    /**
     * Gets the value of the finalRepaymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFinalRepaymentDate() {
        return finalRepaymentDate;
    }

    /**
     * Sets the value of the finalRepaymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFinalRepaymentDate(XMLGregorianCalendar value) {
        this.finalRepaymentDate = value;
    }

    /**
     * Gets the value of the firstRepaymentDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFirstRepaymentDate() {
        return firstRepaymentDate;
    }

    /**
     * Sets the value of the firstRepaymentDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFirstRepaymentDate(XMLGregorianCalendar value) {
        this.firstRepaymentDate = value;
    }

    /**
     * Gets the value of the interestAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterestAccount() {
        return interestAccount;
    }

    /**
     * Sets the value of the interestAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterestAccount(String value) {
        this.interestAccount = value;
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
     * Gets the value of the repaymentAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepaymentAccount() {
        return repaymentAccount;
    }

    /**
     * Sets the value of the repaymentAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepaymentAccount(String value) {
        this.repaymentAccount = value;
    }

    /**
     * Gets the value of the repaymentFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepaymentFrequency() {
        return repaymentFrequency;
    }

    /**
     * Sets the value of the repaymentFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepaymentFrequency(String value) {
        this.repaymentFrequency = value;
    }

    /**
     * Gets the value of the repaymentMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepaymentMethod() {
        return repaymentMethod;
    }

    /**
     * Sets the value of the repaymentMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepaymentMethod(String value) {
        this.repaymentMethod = value;
    }

    /**
     * Gets the value of the repaymentSchedule property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepaymentSchedule() {
        return repaymentSchedule;
    }

    /**
     * Sets the value of the repaymentSchedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepaymentSchedule(String value) {
        this.repaymentSchedule = value;
    }

}
