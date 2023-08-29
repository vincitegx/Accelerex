//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.29 at 08:35:41 AM WAT 
//


package com.neptunesoftware.accelerex.data.transaction;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for baseServiceVouchersEnquiryOutputData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="baseServiceVouchersEnquiryOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="activationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="currency" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strBoughtDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="voucherNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "baseServiceVouchersEnquiryOutputData", namespace = "http://data.txnprocess.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "activationCode",
    "amount",
    "currency",
    "strBoughtDate",
    "voucherNo"
})
@XmlSeeAlso({
    ServiceVouchersEnquiryOutputData.class
})
public class BaseServiceVouchersEnquiryOutputData {

    protected String activationCode;
    protected BigDecimal amount;
    protected String currency;
    protected String strBoughtDate;
    protected String voucherNo;

    /**
     * Gets the value of the activationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getActivationCode() {
        return activationCode;
    }

    /**
     * Sets the value of the activationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setActivationCode(String value) {
        this.activationCode = value;
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
     * Gets the value of the strBoughtDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrBoughtDate() {
        return strBoughtDate;
    }

    /**
     * Sets the value of the strBoughtDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrBoughtDate(String value) {
        this.strBoughtDate = value;
    }

    /**
     * Gets the value of the voucherNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVoucherNo() {
        return voucherNo;
    }

    /**
     * Sets the value of the voucherNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVoucherNo(String value) {
        this.voucherNo = value;
    }

}
