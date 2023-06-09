//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.31 at 02:19:01 PM WAT 
//


package com.neptunesoftware.accelerex.data.customer;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerIdentificationRequestData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="customerIdentificationRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="cityOfIssue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="countryOfIssue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="customerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="identityNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identityType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="identityTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strIssueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="verifiedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerIdentificationRequestData", namespace = "http://data.customer.server.ws.supernova.neptunesoftware.com/", propOrder = {
        "cityOfIssue",
        "countryOfIssue",
        "customerNumber",
        "identificationId",
        "identityNumber",
        "identityType",
        "identityTypeCd",
        "status",
        "strExpiryDate",
        "strIssueDate",
        "verifiedFlag"
})
public class CustomerIdentificationRequestData
        extends XAPIRequestBaseObject {

    protected String cityOfIssue;
    protected Long countryOfIssue;
    protected String customerNumber;
    protected Long identificationId;
    protected String identityNumber;
    protected Long identityType;
    protected String identityTypeCd;
    protected String status;
    protected String strExpiryDate;
    protected String strIssueDate;
    protected Boolean verifiedFlag;

    /**
     * Gets the value of the cityOfIssue property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCityOfIssue() {
        return cityOfIssue;
    }

    /**
     * Sets the value of the cityOfIssue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCityOfIssue(String value) {
        this.cityOfIssue = value;
    }

    /**
     * Gets the value of the countryOfIssue property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getCountryOfIssue() {
        return countryOfIssue;
    }

    /**
     * Sets the value of the countryOfIssue property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setCountryOfIssue(Long value) {
        this.countryOfIssue = value;
    }

    /**
     * Gets the value of the customerNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the value of the customerNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCustomerNumber(String value) {
        this.customerNumber = value;
    }

    /**
     * Gets the value of the identificationId property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getIdentificationId() {
        return identificationId;
    }

    /**
     * Sets the value of the identificationId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setIdentificationId(Long value) {
        this.identificationId = value;
    }

    /**
     * Gets the value of the identityNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIdentityNumber() {
        return identityNumber;
    }

    /**
     * Sets the value of the identityNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIdentityNumber(String value) {
        this.identityNumber = value;
    }

    /**
     * Gets the value of the identityType property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getIdentityType() {
        return identityType;
    }

    /**
     * Sets the value of the identityType property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setIdentityType(Long value) {
        this.identityType = value;
    }

    /**
     * Gets the value of the identityTypeCd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIdentityTypeCd() {
        return identityTypeCd;
    }

    /**
     * Sets the value of the identityTypeCd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIdentityTypeCd(String value) {
        this.identityTypeCd = value;
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
     * Gets the value of the strExpiryDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrExpiryDate() {
        return strExpiryDate;
    }

    /**
     * Sets the value of the strExpiryDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrExpiryDate(String value) {
        this.strExpiryDate = value;
    }

    /**
     * Gets the value of the strIssueDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrIssueDate() {
        return strIssueDate;
    }

    /**
     * Sets the value of the strIssueDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrIssueDate(String value) {
        this.strIssueDate = value;
    }

    /**
     * Gets the value of the verifiedFlag property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isVerifiedFlag() {
        return verifiedFlag;
    }

    /**
     * Sets the value of the verifiedFlag property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setVerifiedFlag(Boolean value) {
        this.verifiedFlag = value;
    }

}
