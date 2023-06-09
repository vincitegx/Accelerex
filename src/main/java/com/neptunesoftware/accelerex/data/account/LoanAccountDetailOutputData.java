//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.06 at 09:12:24 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for loanAccountDetailOutputData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="loanAccountDetailOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://data.account.server.ws.supernova.neptunesoftware.com/}accountSummaryOutputData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="displayDisbursementLimit" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayLastPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayLastPaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayLateFeeRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayNextPaymentAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="displayNextPaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="initialLoanAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="repayFrequencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strArrearsAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strFeeRepaymentAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strInstalmentAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strInterestRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strInterestRepaymentAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strLastRepaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strMaturityDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strNxtRepaymentDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strPayOffAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strPrincipalRepaymentAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strRepayAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strRepayFrequencyValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strRepaymentFrequency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strTermValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strTotalArrears" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strTotalDisbursment" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="termCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "loanAccountDetailOutputData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
        "displayDisbursementLimit",
        "displayLastPaymentAmount",
        "displayLastPaymentDate",
        "displayLateFeeRate",
        "displayNextPaymentAmount",
        "displayNextPaymentDate",
        "initialLoanAmount",
        "repayFrequencyCode",
        "strArrearsAmount",
        "strFeeRepaymentAccount",
        "strInstalmentAmount",
        "strInterestRate",
        "strInterestRepaymentAccount",
        "strLastRepaymentDate",
        "strMaturityDate",
        "strNxtRepaymentDate",
        "strPayOffAmount",
        "strPrincipalRepaymentAccount",
        "strRepayAccountNumber",
        "strRepayFrequencyValue",
        "strRepaymentFrequency",
        "strStartDate",
        "strTermValue",
        "strTotalArrears",
        "strTotalDisbursment",
        "termCode"
})
public class LoanAccountDetailOutputData
        extends AccountSummaryOutputData {

    protected String displayDisbursementLimit;
    protected String displayLastPaymentAmount;
    protected String displayLastPaymentDate;
    protected String displayLateFeeRate;
    protected String displayNextPaymentAmount;
    protected String displayNextPaymentDate;
    protected String initialLoanAmount;
    protected String repayFrequencyCode;
    protected String strArrearsAmount;
    protected String strFeeRepaymentAccount;
    protected String strInstalmentAmount;
    protected String strInterestRate;
    protected String strInterestRepaymentAccount;
    protected String strLastRepaymentDate;
    protected String strMaturityDate;
    protected String strNxtRepaymentDate;
    protected String strPayOffAmount;
    protected String strPrincipalRepaymentAccount;
    protected String strRepayAccountNumber;
    protected String strRepayFrequencyValue;
    protected String strRepaymentFrequency;
    protected String strStartDate;
    protected String strTermValue;
    protected String strTotalArrears;
    protected String strTotalDisbursment;
    protected String termCode;

    /**
     * Gets the value of the displayDisbursementLimit property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDisplayDisbursementLimit() {
        return displayDisbursementLimit;
    }

    /**
     * Sets the value of the displayDisbursementLimit property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDisplayDisbursementLimit(String value) {
        this.displayDisbursementLimit = value;
    }

    /**
     * Gets the value of the displayLastPaymentAmount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDisplayLastPaymentAmount() {
        return displayLastPaymentAmount;
    }

    /**
     * Sets the value of the displayLastPaymentAmount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDisplayLastPaymentAmount(String value) {
        this.displayLastPaymentAmount = value;
    }

    /**
     * Gets the value of the displayLastPaymentDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDisplayLastPaymentDate() {
        return displayLastPaymentDate;
    }

    /**
     * Sets the value of the displayLastPaymentDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDisplayLastPaymentDate(String value) {
        this.displayLastPaymentDate = value;
    }

    /**
     * Gets the value of the displayLateFeeRate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDisplayLateFeeRate() {
        return displayLateFeeRate;
    }

    /**
     * Sets the value of the displayLateFeeRate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDisplayLateFeeRate(String value) {
        this.displayLateFeeRate = value;
    }

    /**
     * Gets the value of the displayNextPaymentAmount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDisplayNextPaymentAmount() {
        return displayNextPaymentAmount;
    }

    /**
     * Sets the value of the displayNextPaymentAmount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDisplayNextPaymentAmount(String value) {
        this.displayNextPaymentAmount = value;
    }

    /**
     * Gets the value of the displayNextPaymentDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDisplayNextPaymentDate() {
        return displayNextPaymentDate;
    }

    /**
     * Sets the value of the displayNextPaymentDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDisplayNextPaymentDate(String value) {
        this.displayNextPaymentDate = value;
    }

    /**
     * Gets the value of the initialLoanAmount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getInitialLoanAmount() {
        return initialLoanAmount;
    }

    /**
     * Sets the value of the initialLoanAmount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setInitialLoanAmount(String value) {
        this.initialLoanAmount = value;
    }

    /**
     * Gets the value of the repayFrequencyCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRepayFrequencyCode() {
        return repayFrequencyCode;
    }

    /**
     * Sets the value of the repayFrequencyCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRepayFrequencyCode(String value) {
        this.repayFrequencyCode = value;
    }

    /**
     * Gets the value of the strArrearsAmount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrArrearsAmount() {
        return strArrearsAmount;
    }

    /**
     * Sets the value of the strArrearsAmount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrArrearsAmount(String value) {
        this.strArrearsAmount = value;
    }

    /**
     * Gets the value of the strFeeRepaymentAccount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrFeeRepaymentAccount() {
        return strFeeRepaymentAccount;
    }

    /**
     * Sets the value of the strFeeRepaymentAccount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrFeeRepaymentAccount(String value) {
        this.strFeeRepaymentAccount = value;
    }

    /**
     * Gets the value of the strInstalmentAmount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrInstalmentAmount() {
        return strInstalmentAmount;
    }

    /**
     * Sets the value of the strInstalmentAmount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrInstalmentAmount(String value) {
        this.strInstalmentAmount = value;
    }

    /**
     * Gets the value of the strInterestRate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrInterestRate() {
        return strInterestRate;
    }

    /**
     * Sets the value of the strInterestRate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrInterestRate(String value) {
        this.strInterestRate = value;
    }

    /**
     * Gets the value of the strInterestRepaymentAccount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrInterestRepaymentAccount() {
        return strInterestRepaymentAccount;
    }

    /**
     * Sets the value of the strInterestRepaymentAccount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrInterestRepaymentAccount(String value) {
        this.strInterestRepaymentAccount = value;
    }

    /**
     * Gets the value of the strLastRepaymentDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrLastRepaymentDate() {
        return strLastRepaymentDate;
    }

    /**
     * Sets the value of the strLastRepaymentDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrLastRepaymentDate(String value) {
        this.strLastRepaymentDate = value;
    }

    /**
     * Gets the value of the strMaturityDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrMaturityDate() {
        return strMaturityDate;
    }

    /**
     * Sets the value of the strMaturityDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrMaturityDate(String value) {
        this.strMaturityDate = value;
    }

    /**
     * Gets the value of the strNxtRepaymentDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrNxtRepaymentDate() {
        return strNxtRepaymentDate;
    }

    /**
     * Sets the value of the strNxtRepaymentDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrNxtRepaymentDate(String value) {
        this.strNxtRepaymentDate = value;
    }

    /**
     * Gets the value of the strPayOffAmount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrPayOffAmount() {
        return strPayOffAmount;
    }

    /**
     * Sets the value of the strPayOffAmount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrPayOffAmount(String value) {
        this.strPayOffAmount = value;
    }

    /**
     * Gets the value of the strPrincipalRepaymentAccount property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrPrincipalRepaymentAccount() {
        return strPrincipalRepaymentAccount;
    }

    /**
     * Sets the value of the strPrincipalRepaymentAccount property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrPrincipalRepaymentAccount(String value) {
        this.strPrincipalRepaymentAccount = value;
    }

    /**
     * Gets the value of the strRepayAccountNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrRepayAccountNumber() {
        return strRepayAccountNumber;
    }

    /**
     * Sets the value of the strRepayAccountNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrRepayAccountNumber(String value) {
        this.strRepayAccountNumber = value;
    }

    /**
     * Gets the value of the strRepayFrequencyValue property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrRepayFrequencyValue() {
        return strRepayFrequencyValue;
    }

    /**
     * Sets the value of the strRepayFrequencyValue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrRepayFrequencyValue(String value) {
        this.strRepayFrequencyValue = value;
    }

    /**
     * Gets the value of the strRepaymentFrequency property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrRepaymentFrequency() {
        return strRepaymentFrequency;
    }

    /**
     * Sets the value of the strRepaymentFrequency property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrRepaymentFrequency(String value) {
        this.strRepaymentFrequency = value;
    }

    /**
     * Gets the value of the strStartDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrStartDate() {
        return strStartDate;
    }

    /**
     * Sets the value of the strStartDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrStartDate(String value) {
        this.strStartDate = value;
    }

    /**
     * Gets the value of the strTermValue property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrTermValue() {
        return strTermValue;
    }

    /**
     * Sets the value of the strTermValue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrTermValue(String value) {
        this.strTermValue = value;
    }

    /**
     * Gets the value of the strTotalArrears property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrTotalArrears() {
        return strTotalArrears;
    }

    /**
     * Sets the value of the strTotalArrears property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrTotalArrears(String value) {
        this.strTotalArrears = value;
    }

    /**
     * Gets the value of the strTotalDisbursment property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrTotalDisbursment() {
        return strTotalDisbursment;
    }

    /**
     * Sets the value of the strTotalDisbursment property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrTotalDisbursment(String value) {
        this.strTotalDisbursment = value;
    }

    /**
     * Gets the value of the termCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTermCode() {
        return termCode;
    }

    /**
     * Sets the value of the termCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTermCode(String value) {
        this.termCode = value;
    }

}
