//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.04 at 10:57:41 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for termDepositRolloverOutputData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="termDepositRolloverOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="rolloverId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="termDepositAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "termDepositRolloverOutputData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "rolloverId",
    "termDepositAccount"
})
public class TermDepositRolloverOutputData {

    protected Long rolloverId;
    protected String termDepositAccount;

    /**
     * Gets the value of the rolloverId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRolloverId() {
        return rolloverId;
    }

    /**
     * Sets the value of the rolloverId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRolloverId(Long value) {
        this.rolloverId = value;
    }

    /**
     * Gets the value of the termDepositAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermDepositAccount() {
        return termDepositAccount;
    }

    /**
     * Sets the value of the termDepositAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermDepositAccount(String value) {
        this.termDepositAccount = value;
    }

}
