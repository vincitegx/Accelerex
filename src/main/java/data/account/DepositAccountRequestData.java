//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 09:43:48 AM WAT 
//


package data.account;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for depositAccountRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="depositAccountRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="accountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="accountTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="campaignRefCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="campaignRefId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="countryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="fieldIdArray" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="fieldValueArr" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="openingReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="openningReasonId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="parentObjectCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parentObjectCountryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="parentObjectCountryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="parentObjectId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="primaryCustomerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="primaryCustomerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="relationshipOfficerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="relationshipOfficerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="riskClassCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="riskClassId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="screenTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="screenTypeDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sourceOfFundCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sourceOfFundId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="strOpeningDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strRewardStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subTypeDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subTypeId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "depositAccountRequestData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "accountId",
    "accountNo",
    "accountTitle",
    "campaignRefCode",
    "campaignRefId",
    "countryId",
    "fieldIdArray",
    "fieldValueArr",
    "openingReasonCode",
    "openningReasonId",
    "parentObjectCode",
    "parentObjectCountryId",
    "parentObjectCountryName",
    "parentObjectId",
    "primaryCustomerId",
    "primaryCustomerNumber",
    "productCode",
    "productId",
    "relationshipOfficerCode",
    "relationshipOfficerId",
    "riskClassCd",
    "riskClassId",
    "screenTypeCode",
    "screenTypeDescription",
    "sourceOfFundCode",
    "sourceOfFundId",
    "strOpeningDate",
    "strRewardStartDate",
    "subTypeDesc",
    "subTypeId"
})
@XmlSeeAlso({
    DepositAcctApplicationRequestData.class
})
public class DepositAccountRequestData
    extends XAPIRequestBaseObject
{

    protected Long accountId;
    protected String accountNo;
    protected String accountTitle;
    protected String campaignRefCode;
    protected Long campaignRefId;
    protected Long countryId;
    @XmlElement(nillable = true)
    protected List<String> fieldIdArray;
    @XmlElement(nillable = true)
    protected List<String> fieldValueArr;
    protected String openingReasonCode;
    protected Long openningReasonId;
    protected String parentObjectCode;
    protected Long parentObjectCountryId;
    protected String parentObjectCountryName;
    protected Long parentObjectId;
    protected Long primaryCustomerId;
    protected String primaryCustomerNumber;
    protected String productCode;
    protected Long productId;
    protected String relationshipOfficerCode;
    protected Long relationshipOfficerId;
    protected String riskClassCd;
    protected Long riskClassId;
    protected String screenTypeCode;
    protected String screenTypeDescription;
    protected String sourceOfFundCode;
    protected Long sourceOfFundId;
    protected String strOpeningDate;
    protected String strRewardStartDate;
    protected String subTypeDesc;
    protected String subTypeId;

    /**
     * Gets the value of the accountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountId() {
        return accountId;
    }

    /**
     * Sets the value of the accountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountId(Long value) {
        this.accountId = value;
    }

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
     * Gets the value of the accountTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountTitle() {
        return accountTitle;
    }

    /**
     * Sets the value of the accountTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountTitle(String value) {
        this.accountTitle = value;
    }

    /**
     * Gets the value of the campaignRefCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCampaignRefCode() {
        return campaignRefCode;
    }

    /**
     * Sets the value of the campaignRefCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCampaignRefCode(String value) {
        this.campaignRefCode = value;
    }

    /**
     * Gets the value of the campaignRefId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCampaignRefId() {
        return campaignRefId;
    }

    /**
     * Sets the value of the campaignRefId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCampaignRefId(Long value) {
        this.campaignRefId = value;
    }

    /**
     * Gets the value of the countryId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCountryId() {
        return countryId;
    }

    /**
     * Sets the value of the countryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCountryId(Long value) {
        this.countryId = value;
    }

    /**
     * Gets the value of the fieldIdArray property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fieldIdArray property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFieldIdArray().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFieldIdArray() {
        if (fieldIdArray == null) {
            fieldIdArray = new ArrayList<String>();
        }
        return this.fieldIdArray;
    }

    /**
     * Gets the value of the fieldValueArr property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fieldValueArr property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFieldValueArr().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getFieldValueArr() {
        if (fieldValueArr == null) {
            fieldValueArr = new ArrayList<String>();
        }
        return this.fieldValueArr;
    }

    /**
     * Gets the value of the openingReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpeningReasonCode() {
        return openingReasonCode;
    }

    /**
     * Sets the value of the openingReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpeningReasonCode(String value) {
        this.openingReasonCode = value;
    }

    /**
     * Gets the value of the openningReasonId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOpenningReasonId() {
        return openningReasonId;
    }

    /**
     * Sets the value of the openningReasonId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOpenningReasonId(Long value) {
        this.openningReasonId = value;
    }

    /**
     * Gets the value of the parentObjectCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentObjectCode() {
        return parentObjectCode;
    }

    /**
     * Sets the value of the parentObjectCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentObjectCode(String value) {
        this.parentObjectCode = value;
    }

    /**
     * Gets the value of the parentObjectCountryId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentObjectCountryId() {
        return parentObjectCountryId;
    }

    /**
     * Sets the value of the parentObjectCountryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentObjectCountryId(Long value) {
        this.parentObjectCountryId = value;
    }

    /**
     * Gets the value of the parentObjectCountryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentObjectCountryName() {
        return parentObjectCountryName;
    }

    /**
     * Sets the value of the parentObjectCountryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentObjectCountryName(String value) {
        this.parentObjectCountryName = value;
    }

    /**
     * Gets the value of the parentObjectId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentObjectId() {
        return parentObjectId;
    }

    /**
     * Sets the value of the parentObjectId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentObjectId(Long value) {
        this.parentObjectId = value;
    }

    /**
     * Gets the value of the primaryCustomerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrimaryCustomerId() {
        return primaryCustomerId;
    }

    /**
     * Sets the value of the primaryCustomerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrimaryCustomerId(Long value) {
        this.primaryCustomerId = value;
    }

    /**
     * Gets the value of the primaryCustomerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrimaryCustomerNumber() {
        return primaryCustomerNumber;
    }

    /**
     * Sets the value of the primaryCustomerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrimaryCustomerNumber(String value) {
        this.primaryCustomerNumber = value;
    }

    /**
     * Gets the value of the productCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Gets the value of the productId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Sets the value of the productId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProductId(Long value) {
        this.productId = value;
    }

    /**
     * Gets the value of the relationshipOfficerCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelationshipOfficerCode() {
        return relationshipOfficerCode;
    }

    /**
     * Sets the value of the relationshipOfficerCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelationshipOfficerCode(String value) {
        this.relationshipOfficerCode = value;
    }

    /**
     * Gets the value of the relationshipOfficerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRelationshipOfficerId() {
        return relationshipOfficerId;
    }

    /**
     * Sets the value of the relationshipOfficerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRelationshipOfficerId(Long value) {
        this.relationshipOfficerId = value;
    }

    /**
     * Gets the value of the riskClassCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRiskClassCd() {
        return riskClassCd;
    }

    /**
     * Sets the value of the riskClassCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRiskClassCd(String value) {
        this.riskClassCd = value;
    }

    /**
     * Gets the value of the riskClassId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRiskClassId() {
        return riskClassId;
    }

    /**
     * Sets the value of the riskClassId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRiskClassId(Long value) {
        this.riskClassId = value;
    }

    /**
     * Gets the value of the screenTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScreenTypeCode() {
        return screenTypeCode;
    }

    /**
     * Sets the value of the screenTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScreenTypeCode(String value) {
        this.screenTypeCode = value;
    }

    /**
     * Gets the value of the screenTypeDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getScreenTypeDescription() {
        return screenTypeDescription;
    }

    /**
     * Sets the value of the screenTypeDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setScreenTypeDescription(String value) {
        this.screenTypeDescription = value;
    }

    /**
     * Gets the value of the sourceOfFundCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceOfFundCode() {
        return sourceOfFundCode;
    }

    /**
     * Sets the value of the sourceOfFundCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceOfFundCode(String value) {
        this.sourceOfFundCode = value;
    }

    /**
     * Gets the value of the sourceOfFundId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSourceOfFundId() {
        return sourceOfFundId;
    }

    /**
     * Sets the value of the sourceOfFundId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSourceOfFundId(Long value) {
        this.sourceOfFundId = value;
    }

    /**
     * Gets the value of the strOpeningDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrOpeningDate() {
        return strOpeningDate;
    }

    /**
     * Sets the value of the strOpeningDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrOpeningDate(String value) {
        this.strOpeningDate = value;
    }

    /**
     * Gets the value of the strRewardStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrRewardStartDate() {
        return strRewardStartDate;
    }

    /**
     * Sets the value of the strRewardStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrRewardStartDate(String value) {
        this.strRewardStartDate = value;
    }

    /**
     * Gets the value of the subTypeDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubTypeDesc() {
        return subTypeDesc;
    }

    /**
     * Sets the value of the subTypeDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubTypeDesc(String value) {
        this.subTypeDesc = value;
    }

    /**
     * Gets the value of the subTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSubTypeId() {
        return subTypeId;
    }

    /**
     * Sets the value of the subTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSubTypeId(String value) {
        this.subTypeId = value;
    }

}