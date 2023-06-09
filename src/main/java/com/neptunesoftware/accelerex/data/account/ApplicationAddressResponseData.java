//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.06 at 09:12:24 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for applicationAddressResponseData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="applicationAddressResponseData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="addressLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressLine3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressLine4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="addressTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressTypeListOutputArrayData" type="{http://data.refglobal.server.ws.supernova.neptunesoftware.com/}genericPickListOutputData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="applAddressId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="channelParamValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cityList" type="{http://data.refglobal.server.ws.supernova.neptunesoftware.com/}genericPickListOutputData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="countryList" type="{http://data.refglobal.server.ws.supernova.neptunesoftware.com/}genericPickListOutputData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="countryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="custCountry" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="custCountryCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerStateCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parentObjectReference" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="parentObjectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="postCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="primaryAddress" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="propertyType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="propertyTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="propertyTypeListOutputArrayData" type="{http://data.refglobal.server.ws.supernova.neptunesoftware.com/}genericPickListOutputData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="stateList" type="{http://data.refglobal.server.ws.supernova.neptunesoftware.com/}genericPickListOutputData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strFromDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strToDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "applicationAddressResponseData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
        "addressLine1",
        "addressLine2",
        "addressLine3",
        "addressLine4",
        "addressType",
        "addressTypeCd",
        "addressTypeListOutputArrayData",
        "applAddressId",
        "channelParamValue",
        "cityList",
        "countryList",
        "countryName",
        "custCountry",
        "custCountryCd",
        "customerCity",
        "customerState",
        "customerStateCd",
        "parentObjectReference",
        "parentObjectType",
        "postCode",
        "primaryAddress",
        "propertyType",
        "propertyTypeCd",
        "propertyTypeListOutputArrayData",
        "stateList",
        "status",
        "strFromDate",
        "strToDate"
})
public class ApplicationAddressResponseData {

    protected String addressLine1;
    protected String addressLine2;
    protected String addressLine3;
    protected String addressLine4;
    protected Long addressType;
    protected String addressTypeCd;
    @XmlElement(nillable = true)
    protected List<GenericPickListOutputData> addressTypeListOutputArrayData;
    protected Long applAddressId;
    protected String channelParamValue;
    @XmlElement(nillable = true)
    protected List<GenericPickListOutputData> cityList;
    @XmlElement(nillable = true)
    protected List<GenericPickListOutputData> countryList;
    protected String countryName;
    protected Long custCountry;
    protected String custCountryCd;
    protected String customerCity;
    protected String customerState;
    protected String customerStateCd;
    protected Long parentObjectReference;
    protected String parentObjectType;
    protected String postCode;
    protected Boolean primaryAddress;
    protected Long propertyType;
    protected String propertyTypeCd;
    @XmlElement(nillable = true)
    protected List<GenericPickListOutputData> propertyTypeListOutputArrayData;
    @XmlElement(nillable = true)
    protected List<GenericPickListOutputData> stateList;
    protected String status;
    protected String strFromDate;
    protected String strToDate;

    /**
     * Gets the value of the addressLine1 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAddressLine1() {
        return addressLine1;
    }

    /**
     * Sets the value of the addressLine1 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddressLine1(String value) {
        this.addressLine1 = value;
    }

    /**
     * Gets the value of the addressLine2 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAddressLine2() {
        return addressLine2;
    }

    /**
     * Sets the value of the addressLine2 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddressLine2(String value) {
        this.addressLine2 = value;
    }

    /**
     * Gets the value of the addressLine3 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAddressLine3() {
        return addressLine3;
    }

    /**
     * Sets the value of the addressLine3 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddressLine3(String value) {
        this.addressLine3 = value;
    }

    /**
     * Gets the value of the addressLine4 property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAddressLine4() {
        return addressLine4;
    }

    /**
     * Sets the value of the addressLine4 property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddressLine4(String value) {
        this.addressLine4 = value;
    }

    /**
     * Gets the value of the addressType property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getAddressType() {
        return addressType;
    }

    /**
     * Sets the value of the addressType property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setAddressType(Long value) {
        this.addressType = value;
    }

    /**
     * Gets the value of the addressTypeCd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAddressTypeCd() {
        return addressTypeCd;
    }

    /**
     * Sets the value of the addressTypeCd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAddressTypeCd(String value) {
        this.addressTypeCd = value;
    }

    /**
     * Gets the value of the addressTypeListOutputArrayData property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the addressTypeListOutputArrayData property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAddressTypeListOutputArrayData().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericPickListOutputData }
     */
    public List<GenericPickListOutputData> getAddressTypeListOutputArrayData() {
        if (addressTypeListOutputArrayData == null) {
            addressTypeListOutputArrayData = new ArrayList<GenericPickListOutputData>();
        }
        return this.addressTypeListOutputArrayData;
    }

    /**
     * Gets the value of the applAddressId property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getApplAddressId() {
        return applAddressId;
    }

    /**
     * Sets the value of the applAddressId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setApplAddressId(Long value) {
        this.applAddressId = value;
    }

    /**
     * Gets the value of the channelParamValue property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getChannelParamValue() {
        return channelParamValue;
    }

    /**
     * Sets the value of the channelParamValue property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setChannelParamValue(String value) {
        this.channelParamValue = value;
    }

    /**
     * Gets the value of the cityList property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the cityList property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getCityList().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericPickListOutputData }
     */
    public List<GenericPickListOutputData> getCityList() {
        if (cityList == null) {
            cityList = new ArrayList<GenericPickListOutputData>();
        }
        return this.cityList;
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
     */
    public List<GenericPickListOutputData> getCountryList() {
        if (countryList == null) {
            countryList = new ArrayList<GenericPickListOutputData>();
        }
        return this.countryList;
    }

    /**
     * Gets the value of the countryName property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the value of the countryName property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCountryName(String value) {
        this.countryName = value;
    }

    /**
     * Gets the value of the custCountry property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getCustCountry() {
        return custCountry;
    }

    /**
     * Sets the value of the custCountry property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setCustCountry(Long value) {
        this.custCountry = value;
    }

    /**
     * Gets the value of the custCountryCd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCustCountryCd() {
        return custCountryCd;
    }

    /**
     * Sets the value of the custCountryCd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCustCountryCd(String value) {
        this.custCountryCd = value;
    }

    /**
     * Gets the value of the customerCity property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCustomerCity() {
        return customerCity;
    }

    /**
     * Sets the value of the customerCity property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCustomerCity(String value) {
        this.customerCity = value;
    }

    /**
     * Gets the value of the customerState property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCustomerState() {
        return customerState;
    }

    /**
     * Sets the value of the customerState property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCustomerState(String value) {
        this.customerState = value;
    }

    /**
     * Gets the value of the customerStateCd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCustomerStateCd() {
        return customerStateCd;
    }

    /**
     * Sets the value of the customerStateCd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCustomerStateCd(String value) {
        this.customerStateCd = value;
    }

    /**
     * Gets the value of the parentObjectReference property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getParentObjectReference() {
        return parentObjectReference;
    }

    /**
     * Sets the value of the parentObjectReference property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setParentObjectReference(Long value) {
        this.parentObjectReference = value;
    }

    /**
     * Gets the value of the parentObjectType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getParentObjectType() {
        return parentObjectType;
    }

    /**
     * Sets the value of the parentObjectType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setParentObjectType(String value) {
        this.parentObjectType = value;
    }

    /**
     * Gets the value of the postCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * Sets the value of the postCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPostCode(String value) {
        this.postCode = value;
    }

    /**
     * Gets the value of the primaryAddress property.
     *
     * @return possible object is
     * {@link Boolean }
     */
    public Boolean isPrimaryAddress() {
        return primaryAddress;
    }

    /**
     * Sets the value of the primaryAddress property.
     *
     * @param value allowed object is
     *              {@link Boolean }
     */
    public void setPrimaryAddress(Boolean value) {
        this.primaryAddress = value;
    }

    /**
     * Gets the value of the propertyType property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getPropertyType() {
        return propertyType;
    }

    /**
     * Sets the value of the propertyType property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setPropertyType(Long value) {
        this.propertyType = value;
    }

    /**
     * Gets the value of the propertyTypeCd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getPropertyTypeCd() {
        return propertyTypeCd;
    }

    /**
     * Sets the value of the propertyTypeCd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setPropertyTypeCd(String value) {
        this.propertyTypeCd = value;
    }

    /**
     * Gets the value of the propertyTypeListOutputArrayData property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the propertyTypeListOutputArrayData property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getPropertyTypeListOutputArrayData().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericPickListOutputData }
     */
    public List<GenericPickListOutputData> getPropertyTypeListOutputArrayData() {
        if (propertyTypeListOutputArrayData == null) {
            propertyTypeListOutputArrayData = new ArrayList<GenericPickListOutputData>();
        }
        return this.propertyTypeListOutputArrayData;
    }

    /**
     * Gets the value of the stateList property.
     *
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the stateList property.
     *
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStateList().add(newItem);
     * </pre>
     *
     *
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericPickListOutputData }
     */
    public List<GenericPickListOutputData> getStateList() {
        if (stateList == null) {
            stateList = new ArrayList<GenericPickListOutputData>();
        }
        return this.stateList;
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
     * Gets the value of the strFromDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrFromDate() {
        return strFromDate;
    }

    /**
     * Sets the value of the strFromDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrFromDate(String value) {
        this.strFromDate = value;
    }

    /**
     * Gets the value of the strToDate property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStrToDate() {
        return strToDate;
    }

    /**
     * Sets the value of the strToDate property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStrToDate(String value) {
        this.strToDate = value;
    }

}
