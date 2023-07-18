//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 09:40:38 AM WAT 
//


package data.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerChannelUserOutputData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerChannelUserOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accessCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="accessDurationCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="accessDurationValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="accessInfoDelivery" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="accessName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="addressTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="amendmentReasonCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amendmentReasonId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="channelCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="channelId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="channelSchemeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="channelSchemeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="channelUserCustomerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="channelUserCustomerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="channelUserCustomerNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="contactModeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="customerChannelId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="customerChannelUserId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="customerChannelUsrHistId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="effectiveDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="primaryDeviceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="pwdResetFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="reasonDetail" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userCategoryCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerChannelUserOutputData", namespace = "http://data.channeladmin.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "accessCode",
    "accessDurationCd",
    "accessDurationValue",
    "accessInfoDelivery",
    "accessName",
    "addressTypeId",
    "amendmentReasonCd",
    "amendmentReasonId",
    "channelCd",
    "channelId",
    "channelSchemeCd",
    "channelSchemeId",
    "channelUserCustomerId",
    "channelUserCustomerName",
    "channelUserCustomerNo",
    "contactModeId",
    "customerChannelId",
    "customerChannelUserId",
    "customerChannelUsrHistId",
    "customerId",
    "effectiveDate",
    "expiryDate",
    "primaryDeviceId",
    "pwdResetFlag",
    "reasonDetail",
    "userCategoryCd",
    "userPassword",
    "userStatus"
})
public class CustomerChannelUserOutputData {

    protected String accessCode;
    protected String accessDurationCd;
    protected Long accessDurationValue;
    protected String accessInfoDelivery;
    protected String accessName;
    protected Long addressTypeId;
    protected String amendmentReasonCd;
    protected Long amendmentReasonId;
    protected String channelCd;
    protected Long channelId;
    protected String channelSchemeCd;
    protected Long channelSchemeId;
    protected Long channelUserCustomerId;
    protected String channelUserCustomerName;
    protected String channelUserCustomerNo;
    protected Long contactModeId;
    protected Long customerChannelId;
    protected Long customerChannelUserId;
    protected Long customerChannelUsrHistId;
    protected Long customerId;
    protected String effectiveDate;
    protected String expiryDate;
    protected Long primaryDeviceId;
    protected Boolean pwdResetFlag;
    protected String reasonDetail;
    protected String userCategoryCd;
    protected String userPassword;
    protected String userStatus;

    /**
     * Gets the value of the accessCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessCode() {
        return accessCode;
    }

    /**
     * Sets the value of the accessCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessCode(String value) {
        this.accessCode = value;
    }

    /**
     * Gets the value of the accessDurationCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessDurationCd() {
        return accessDurationCd;
    }

    /**
     * Sets the value of the accessDurationCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessDurationCd(String value) {
        this.accessDurationCd = value;
    }

    /**
     * Gets the value of the accessDurationValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccessDurationValue() {
        return accessDurationValue;
    }

    /**
     * Sets the value of the accessDurationValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccessDurationValue(Long value) {
        this.accessDurationValue = value;
    }

    /**
     * Gets the value of the accessInfoDelivery property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessInfoDelivery() {
        return accessInfoDelivery;
    }

    /**
     * Sets the value of the accessInfoDelivery property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessInfoDelivery(String value) {
        this.accessInfoDelivery = value;
    }

    /**
     * Gets the value of the accessName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccessName() {
        return accessName;
    }

    /**
     * Sets the value of the accessName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccessName(String value) {
        this.accessName = value;
    }

    /**
     * Gets the value of the addressTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAddressTypeId() {
        return addressTypeId;
    }

    /**
     * Sets the value of the addressTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAddressTypeId(Long value) {
        this.addressTypeId = value;
    }

    /**
     * Gets the value of the amendmentReasonCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendmentReasonCd() {
        return amendmentReasonCd;
    }

    /**
     * Sets the value of the amendmentReasonCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendmentReasonCd(String value) {
        this.amendmentReasonCd = value;
    }

    /**
     * Gets the value of the amendmentReasonId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAmendmentReasonId() {
        return amendmentReasonId;
    }

    /**
     * Sets the value of the amendmentReasonId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAmendmentReasonId(Long value) {
        this.amendmentReasonId = value;
    }

    /**
     * Gets the value of the channelCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelCd() {
        return channelCd;
    }

    /**
     * Sets the value of the channelCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelCd(String value) {
        this.channelCd = value;
    }

    /**
     * Gets the value of the channelId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChannelId() {
        return channelId;
    }

    /**
     * Sets the value of the channelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChannelId(Long value) {
        this.channelId = value;
    }

    /**
     * Gets the value of the channelSchemeCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelSchemeCd() {
        return channelSchemeCd;
    }

    /**
     * Sets the value of the channelSchemeCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelSchemeCd(String value) {
        this.channelSchemeCd = value;
    }

    /**
     * Gets the value of the channelSchemeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChannelSchemeId() {
        return channelSchemeId;
    }

    /**
     * Sets the value of the channelSchemeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChannelSchemeId(Long value) {
        this.channelSchemeId = value;
    }

    /**
     * Gets the value of the channelUserCustomerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChannelUserCustomerId() {
        return channelUserCustomerId;
    }

    /**
     * Sets the value of the channelUserCustomerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChannelUserCustomerId(Long value) {
        this.channelUserCustomerId = value;
    }

    /**
     * Gets the value of the channelUserCustomerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelUserCustomerName() {
        return channelUserCustomerName;
    }

    /**
     * Sets the value of the channelUserCustomerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelUserCustomerName(String value) {
        this.channelUserCustomerName = value;
    }

    /**
     * Gets the value of the channelUserCustomerNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelUserCustomerNo() {
        return channelUserCustomerNo;
    }

    /**
     * Sets the value of the channelUserCustomerNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelUserCustomerNo(String value) {
        this.channelUserCustomerNo = value;
    }

    /**
     * Gets the value of the contactModeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getContactModeId() {
        return contactModeId;
    }

    /**
     * Sets the value of the contactModeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setContactModeId(Long value) {
        this.contactModeId = value;
    }

    /**
     * Gets the value of the customerChannelId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomerChannelId() {
        return customerChannelId;
    }

    /**
     * Sets the value of the customerChannelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomerChannelId(Long value) {
        this.customerChannelId = value;
    }

    /**
     * Gets the value of the customerChannelUserId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomerChannelUserId() {
        return customerChannelUserId;
    }

    /**
     * Sets the value of the customerChannelUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomerChannelUserId(Long value) {
        this.customerChannelUserId = value;
    }

    /**
     * Gets the value of the customerChannelUsrHistId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomerChannelUsrHistId() {
        return customerChannelUsrHistId;
    }

    /**
     * Sets the value of the customerChannelUsrHistId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomerChannelUsrHistId(Long value) {
        this.customerChannelUsrHistId = value;
    }

    /**
     * Gets the value of the customerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomerId(Long value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the effectiveDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * Sets the value of the effectiveDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEffectiveDate(String value) {
        this.effectiveDate = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExpiryDate(String value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the primaryDeviceId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryDeviceId() {
        return primaryDeviceId;
    }

    /**
     * Sets the value of the primaryDeviceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryDeviceId(Long value) {
        this.primaryDeviceId = value;
    }

    /**
     * Gets the value of the pwdResetFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isPwdResetFlag() {
        return pwdResetFlag;
    }

    /**
     * Sets the value of the pwdResetFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setPwdResetFlag(Boolean value) {
        this.pwdResetFlag = value;
    }

    /**
     * Gets the value of the reasonDetail property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonDetail() {
        return reasonDetail;
    }

    /**
     * Sets the value of the reasonDetail property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonDetail(String value) {
        this.reasonDetail = value;
    }

    /**
     * Gets the value of the userCategoryCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserCategoryCd() {
        return userCategoryCd;
    }

    /**
     * Sets the value of the userCategoryCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserCategoryCd(String value) {
        this.userCategoryCd = value;
    }

    /**
     * Gets the value of the userPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * Sets the value of the userPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserPassword(String value) {
        this.userPassword = value;
    }

    /**
     * Gets the value of the userStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * Sets the value of the userStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserStatus(String value) {
        this.userStatus = value;
    }

}