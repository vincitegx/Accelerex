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
 * <p>Java class for accountReviewRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountReviewRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="cautionReasonId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="cautionTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="currentAccountStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="details" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="newAccountRiskClassId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="newAccountStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="nextReviewDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/&gt;
 *         &lt;element name="reasonCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reasonId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="reviewChargeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="reviewDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountReviewRequestData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "accountNo",
    "cautionReasonId",
    "cautionTypeId",
    "currentAccountStatus",
    "details",
    "newAccountRiskClassId",
    "newAccountStatus",
    "nextReviewDate",
    "reasonCd",
    "reasonId",
    "reviewChargeId",
    "reviewDate"
})
public class AccountReviewRequestData
    extends XAPIRequestBaseObject
{

    protected String accountNo;
    protected Long cautionReasonId;
    protected Long cautionTypeId;
    protected String currentAccountStatus;
    protected String details;
    protected Long newAccountRiskClassId;
    protected String newAccountStatus;
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar nextReviewDate;
    protected String reasonCd;
    protected Long reasonId;
    protected Long reviewChargeId;
    protected String reviewDate;

    /**
     * Gets the value of the accountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * Sets the value of the accountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNo(String value) {
        this.accountNo = value;
    }

    /**
     * Gets the value of the cautionReasonId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCautionReasonId() {
        return cautionReasonId;
    }

    /**
     * Sets the value of the cautionReasonId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCautionReasonId(Long value) {
        this.cautionReasonId = value;
    }

    /**
     * Gets the value of the cautionTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCautionTypeId() {
        return cautionTypeId;
    }

    /**
     * Sets the value of the cautionTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCautionTypeId(Long value) {
        this.cautionTypeId = value;
    }

    /**
     * Gets the value of the currentAccountStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrentAccountStatus() {
        return currentAccountStatus;
    }

    /**
     * Sets the value of the currentAccountStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrentAccountStatus(String value) {
        this.currentAccountStatus = value;
    }

    /**
     * Gets the value of the details property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDetails() {
        return details;
    }

    /**
     * Sets the value of the details property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDetails(String value) {
        this.details = value;
    }

    /**
     * Gets the value of the newAccountRiskClassId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNewAccountRiskClassId() {
        return newAccountRiskClassId;
    }

    /**
     * Sets the value of the newAccountRiskClassId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNewAccountRiskClassId(Long value) {
        this.newAccountRiskClassId = value;
    }

    /**
     * Gets the value of the newAccountStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewAccountStatus() {
        return newAccountStatus;
    }

    /**
     * Sets the value of the newAccountStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewAccountStatus(String value) {
        this.newAccountStatus = value;
    }

    /**
     * Gets the value of the nextReviewDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getNextReviewDate() {
        return nextReviewDate;
    }

    /**
     * Sets the value of the nextReviewDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setNextReviewDate(XMLGregorianCalendar value) {
        this.nextReviewDate = value;
    }

    /**
     * Gets the value of the reasonCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReasonCd() {
        return reasonCd;
    }

    /**
     * Sets the value of the reasonCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReasonCd(String value) {
        this.reasonCd = value;
    }

    /**
     * Gets the value of the reasonId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReasonId() {
        return reasonId;
    }

    /**
     * Sets the value of the reasonId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReasonId(Long value) {
        this.reasonId = value;
    }

    /**
     * Gets the value of the reviewChargeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getReviewChargeId() {
        return reviewChargeId;
    }

    /**
     * Sets the value of the reviewChargeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setReviewChargeId(Long value) {
        this.reviewChargeId = value;
    }

    /**
     * Gets the value of the reviewDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewDate() {
        return reviewDate;
    }

    /**
     * Sets the value of the reviewDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewDate(String value) {
        this.reviewDate = value;
    }

}