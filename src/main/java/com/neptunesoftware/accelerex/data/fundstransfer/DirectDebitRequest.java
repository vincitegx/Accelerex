//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.07 at 08:56:56 AM WAT 
//


package com.neptunesoftware.accelerex.data.fundstransfer;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for directDebitRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="directDebitRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://data.account.server.ws.supernova.neptunesoftware.com/}accountRequest"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="bankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddress" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryPhone" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="externAcctName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="firstPayDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="mandateType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="numOfPayments" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="origReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="payAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="payFrequency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="paymentType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="scheduleType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strEndNextDueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strStartNextDueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="supplInstructions" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transferMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "directDebitRequest", namespace = "http://data.transfer.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "bankCode",
    "beneficiaryAddress",
    "beneficiaryId",
    "beneficiaryPhone",
    "currency",
    "externAcctName",
    "firstPayDate",
    "mandateType",
    "numOfPayments",
    "origReference",
    "payAmount",
    "payFrequency",
    "paymentType",
    "scheduleType",
    "strEndNextDueDate",
    "strStartNextDueDate",
    "supplInstructions",
    "transferMethod"
})
public class DirectDebitRequest
    extends AccountRequest
{

    protected String bankCode;
    protected String beneficiaryAddress;
    protected Long beneficiaryId;
    protected String beneficiaryPhone;
    protected String currency;
    protected String externAcctName;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar firstPayDate;
    protected String mandateType;
    protected Long numOfPayments;
    protected String origReference;
    protected BigDecimal payAmount;
    protected String payFrequency;
    protected String paymentType;
    protected String scheduleType;
    protected String strEndNextDueDate;
    protected String strStartNextDueDate;
    protected String supplInstructions;
    protected String transferMethod;

    /**
     * Gets the value of the bankCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * Sets the value of the bankCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCode(String value) {
        this.bankCode = value;
    }

    /**
     * Gets the value of the beneficiaryAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddress() {
        return beneficiaryAddress;
    }

    /**
     * Sets the value of the beneficiaryAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddress(String value) {
        this.beneficiaryAddress = value;
    }

    /**
     * Gets the value of the beneficiaryId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    /**
     * Sets the value of the beneficiaryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBeneficiaryId(Long value) {
        this.beneficiaryId = value;
    }

    /**
     * Gets the value of the beneficiaryPhone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryPhone() {
        return beneficiaryPhone;
    }

    /**
     * Sets the value of the beneficiaryPhone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryPhone(String value) {
        this.beneficiaryPhone = value;
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
     * Gets the value of the externAcctName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternAcctName() {
        return externAcctName;
    }

    /**
     * Sets the value of the externAcctName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternAcctName(String value) {
        this.externAcctName = value;
    }

    /**
     * Gets the value of the firstPayDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFirstPayDate() {
        return firstPayDate;
    }

    /**
     * Sets the value of the firstPayDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFirstPayDate(XMLGregorianCalendar value) {
        this.firstPayDate = value;
    }

    /**
     * Gets the value of the mandateType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMandateType() {
        return mandateType;
    }

    /**
     * Sets the value of the mandateType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMandateType(String value) {
        this.mandateType = value;
    }

    /**
     * Gets the value of the numOfPayments property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNumOfPayments() {
        return numOfPayments;
    }

    /**
     * Sets the value of the numOfPayments property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNumOfPayments(Long value) {
        this.numOfPayments = value;
    }

    /**
     * Gets the value of the origReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrigReference() {
        return origReference;
    }

    /**
     * Sets the value of the origReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrigReference(String value) {
        this.origReference = value;
    }

    /**
     * Gets the value of the payAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPayAmount() {
        return payAmount;
    }

    /**
     * Sets the value of the payAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPayAmount(BigDecimal value) {
        this.payAmount = value;
    }

    /**
     * Gets the value of the payFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPayFrequency() {
        return payFrequency;
    }

    /**
     * Sets the value of the payFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPayFrequency(String value) {
        this.payFrequency = value;
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
     * Gets the value of the scheduleType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScheduleType() {
        return scheduleType;
    }

    /**
     * Sets the value of the scheduleType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScheduleType(String value) {
        this.scheduleType = value;
    }

    /**
     * Gets the value of the strEndNextDueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrEndNextDueDate() {
        return strEndNextDueDate;
    }

    /**
     * Sets the value of the strEndNextDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrEndNextDueDate(String value) {
        this.strEndNextDueDate = value;
    }

    /**
     * Gets the value of the strStartNextDueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrStartNextDueDate() {
        return strStartNextDueDate;
    }

    /**
     * Sets the value of the strStartNextDueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrStartNextDueDate(String value) {
        this.strStartNextDueDate = value;
    }

    /**
     * Gets the value of the supplInstructions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplInstructions() {
        return supplInstructions;
    }

    /**
     * Sets the value of the supplInstructions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplInstructions(String value) {
        this.supplInstructions = value;
    }

    /**
     * Gets the value of the transferMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferMethod() {
        return transferMethod;
    }

    /**
     * Sets the value of the transferMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferMethod(String value) {
        this.transferMethod = value;
    }

}
