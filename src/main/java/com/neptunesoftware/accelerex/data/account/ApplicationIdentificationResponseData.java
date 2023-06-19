//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 09:43:48 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for applicationIdentificationResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="applicationIdentificationResponseData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="applIdentificationId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="channelParamValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cityOfIssue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="countryList" type="{http://data.refglobal.server.ws.supernova.neptunesoftware.com/}genericPickListOutputData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="countryOfIssue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="identificationType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="identificationTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificationTypeDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="identificationTypeList" type="{http://data.refglobal.server.ws.supernova.neptunesoftware.com/}genericPickListOutputData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="identityNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="issueCountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parentObjectReference" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="parentObjectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parentObjectTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strIssueDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="verifiedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "applicationIdentificationResponseData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "applIdentificationId",
    "channelParamValue",
    "cityOfIssue",
    "countryList",
    "countryOfIssue",
    "identificationType",
    "identificationTypeCd",
    "identificationTypeDesc",
    "identificationTypeList",
    "identityNumber",
    "issueCountryName",
    "parentObjectReference",
    "parentObjectType",
    "parentObjectTypeId",
    "status",
    "strExpiryDate",
    "strIssueDate",
    "verifiedFlag"
})
public class ApplicationIdentificationResponseData {

    protected Long applIdentificationId;
    protected String channelParamValue;
    protected String cityOfIssue;
    @XmlElement(nillable = true)
    protected List<GenericPickListOutputData> countryList;
    protected Long countryOfIssue;
    protected Long identificationType;
    protected String identificationTypeCd;
    protected String identificationTypeDesc;
    @XmlElement(nillable = true)
    protected List<GenericPickListOutputData> identificationTypeList;
    protected String identityNumber;
    protected String issueCountryName;
    protected Long parentObjectReference;
    protected String parentObjectType;
    protected Long parentObjectTypeId;
    protected String status;
    protected String strExpiryDate;
    protected String strIssueDate;
    protected Boolean verifiedFlag;

    /**
     * Gets the value of the applIdentificationId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getApplIdentificationId() {
        return applIdentificationId;
    }

    /**
     * Sets the value of the applIdentificationId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setApplIdentificationId(Long value) {
        this.applIdentificationId = value;
    }

    /**
     * Gets the value of the channelParamValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelParamValue() {
        return channelParamValue;
    }

    /**
     * Sets the value of the channelParamValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelParamValue(String value) {
        this.channelParamValue = value;
    }

    /**
     * Gets the value of the cityOfIssue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCityOfIssue() {
        return cityOfIssue;
    }

    /**
     * Sets the value of the cityOfIssue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCityOfIssue(String value) {
        this.cityOfIssue = value;
    }

    /**
     * Gets the value of the countryList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the countryList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCountryList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericPickListOutputData }
     * 
     * 
     */
    public List<GenericPickListOutputData> getCountryList() {
        if (countryList == null) {
            countryList = new ArrayList<GenericPickListOutputData>();
        }
        return this.countryList;
    }

    /**
     * Gets the value of the countryOfIssue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCountryOfIssue() {
        return countryOfIssue;
    }

    /**
     * Sets the value of the countryOfIssue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCountryOfIssue(Long value) {
        this.countryOfIssue = value;
    }

    /**
     * Gets the value of the identificationType property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getIdentificationType() {
        return identificationType;
    }

    /**
     * Sets the value of the identificationType property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setIdentificationType(Long value) {
        this.identificationType = value;
    }

    /**
     * Gets the value of the identificationTypeCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationTypeCd() {
        return identificationTypeCd;
    }

    /**
     * Sets the value of the identificationTypeCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationTypeCd(String value) {
        this.identificationTypeCd = value;
    }

    /**
     * Gets the value of the identificationTypeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentificationTypeDesc() {
        return identificationTypeDesc;
    }

    /**
     * Sets the value of the identificationTypeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentificationTypeDesc(String value) {
        this.identificationTypeDesc = value;
    }

    /**
     * Gets the value of the identificationTypeList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the identificationTypeList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIdentificationTypeList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericPickListOutputData }
     * 
     * 
     */
    public List<GenericPickListOutputData> getIdentificationTypeList() {
        if (identificationTypeList == null) {
            identificationTypeList = new ArrayList<GenericPickListOutputData>();
        }
        return this.identificationTypeList;
    }

    /**
     * Gets the value of the identityNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentityNumber() {
        return identityNumber;
    }

    /**
     * Sets the value of the identityNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentityNumber(String value) {
        this.identityNumber = value;
    }

    /**
     * Gets the value of the issueCountryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIssueCountryName() {
        return issueCountryName;
    }

    /**
     * Sets the value of the issueCountryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIssueCountryName(String value) {
        this.issueCountryName = value;
    }

    /**
     * Gets the value of the parentObjectReference property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentObjectReference() {
        return parentObjectReference;
    }

    /**
     * Sets the value of the parentObjectReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentObjectReference(Long value) {
        this.parentObjectReference = value;
    }

    /**
     * Gets the value of the parentObjectType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentObjectType() {
        return parentObjectType;
    }

    /**
     * Sets the value of the parentObjectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentObjectType(String value) {
        this.parentObjectType = value;
    }

    /**
     * Gets the value of the parentObjectTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentObjectTypeId() {
        return parentObjectTypeId;
    }

    /**
     * Sets the value of the parentObjectTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentObjectTypeId(Long value) {
        this.parentObjectTypeId = value;
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
     * Gets the value of the strExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrExpiryDate() {
        return strExpiryDate;
    }

    /**
     * Sets the value of the strExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrExpiryDate(String value) {
        this.strExpiryDate = value;
    }

    /**
     * Gets the value of the strIssueDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrIssueDate() {
        return strIssueDate;
    }

    /**
     * Sets the value of the strIssueDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrIssueDate(String value) {
        this.strIssueDate = value;
    }

    /**
     * Gets the value of the verifiedFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isVerifiedFlag() {
        return verifiedFlag;
    }

    /**
     * Sets the value of the verifiedFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setVerifiedFlag(Boolean value) {
        this.verifiedFlag = value;
    }

}
