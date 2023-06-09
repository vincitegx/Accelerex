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

import java.math.BigDecimal;


/**
 * <p>Java class for chequeConfirmationOutputData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="chequeConfirmationOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="chequeNumber" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="payee" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strChequeDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chequeConfirmationOutputData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
        "accountNumber",
        "amount",
        "chequeNumber",
        "payee",
        "status",
        "strChequeDate"
})
public class ChequeConfirmationOutputData {

    protected String accountNumber;
    protected BigDecimal amount;
    protected Long chequeNumber;
    protected String payee;
    protected String status;
    protected String strChequeDate;

    /**
     * Gets the value of the accountNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the amount property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the chequeNumber property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getChequeNumber() {
        return chequeNumber;
    }

    /**
     * Sets the value of the chequeNumber property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setChequeNumber(Long value) {
        this.chequeNumber = value;
    }

    /**
     * Gets the value of the payee property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPayee() {
        return payee;
    }

    /**
     * Sets the value of the payee property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPayee(String value) {
        this.payee = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the strChequeDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrChequeDate() {
        return strChequeDate;
    }

    /**
     * Sets the value of the strChequeDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrChequeDate(String value) {
        this.strChequeDate = value;
    }

}
