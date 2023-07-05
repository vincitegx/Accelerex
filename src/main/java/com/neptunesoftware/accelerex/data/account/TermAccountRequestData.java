//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.04 at 10:57:41 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for termAccountRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="termAccountRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="accountTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="alternateNumberCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="alternateNumberFlag" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/&gt;
 *         &lt;element name="campaignRefCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="campaignRefId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="chargeSettlementAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chargeSettlementMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="intSettlementMthd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="interestPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="interestSettlementAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="interestSettlementBicId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="maturitySettlementAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="maturitySettlementMthd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noticeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="openningReasonCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="openningReasonId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="primaryCustomerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="primaryCustomerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="principalPercent" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="relationshipOfficerCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="relationshipOfficerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="rolloverOptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="skipSubmit" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="sourceOfFundId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strMaturityDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="term" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="termCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "termAccountRequestData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "accountNumber",
    "accountTitle",
    "alternateNumberCode",
    "alternateNumberFlag",
    "campaignRefCode",
    "campaignRefId",
    "chargeSettlementAccountNo",
    "chargeSettlementMethod",
    "intSettlementMthd",
    "interestPercent",
    "interestSettlementAccountNo",
    "interestSettlementBicId",
    "maturitySettlementAccountNo",
    "maturitySettlementMthd",
    "noticeAmount",
    "openningReasonCode",
    "openningReasonId",
    "primaryCustomerId",
    "primaryCustomerNumber",
    "principalPercent",
    "productCode",
    "productId",
    "relationshipOfficerCode",
    "relationshipOfficerId",
    "rolloverOptCode",
    "skipSubmit",
    "sourceOfFundId",
    "status",
    "strMaturityDate",
    "strStartDate",
    "term",
    "termCode"
})
@XmlSeeAlso({
    TermDepositApplicationRequestData.class
})
public class TermAccountRequestData
    extends XAPIRequestBaseObject
{

    protected String accountNumber;
    protected String accountTitle;
    protected String alternateNumberCode;
    protected Boolean alternateNumberFlag;
    protected String campaignRefCode;
    protected Long campaignRefId;
    protected String chargeSettlementAccountNo;
    protected String chargeSettlementMethod;
    protected String intSettlementMthd;
    protected BigDecimal interestPercent;
    protected String interestSettlementAccountNo;
    protected Long interestSettlementBicId;
    protected String maturitySettlementAccountNo;
    protected String maturitySettlementMthd;
    protected BigDecimal noticeAmount;
    protected String openningReasonCode;
    protected Long openningReasonId;
    protected Long primaryCustomerId;
    protected String primaryCustomerNumber;
    protected BigDecimal principalPercent;
    protected String productCode;
    protected Long productId;
    protected String relationshipOfficerCode;
    protected Long relationshipOfficerId;
    protected String rolloverOptCode;
    protected boolean skipSubmit;
    protected Long sourceOfFundId;
    protected String status;
    protected String strMaturityDate;
    protected String strStartDate;
    protected Long term;
    protected String termCode;

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
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
     * Gets the value of the alternateNumberCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternateNumberCode() {
        return alternateNumberCode;
    }

    /**
     * Sets the value of the alternateNumberCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternateNumberCode(String value) {
        this.alternateNumberCode = value;
    }

    /**
     * Gets the value of the alternateNumberFlag property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isAlternateNumberFlag() {
        return alternateNumberFlag;
    }

    /**
     * Sets the value of the alternateNumberFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setAlternateNumberFlag(Boolean value) {
        this.alternateNumberFlag = value;
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
     * Gets the value of the chargeSettlementAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeSettlementAccountNo() {
        return chargeSettlementAccountNo;
    }

    /**
     * Sets the value of the chargeSettlementAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeSettlementAccountNo(String value) {
        this.chargeSettlementAccountNo = value;
    }

    /**
     * Gets the value of the chargeSettlementMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeSettlementMethod() {
        return chargeSettlementMethod;
    }

    /**
     * Sets the value of the chargeSettlementMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeSettlementMethod(String value) {
        this.chargeSettlementMethod = value;
    }

    /**
     * Gets the value of the intSettlementMthd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIntSettlementMthd() {
        return intSettlementMthd;
    }

    /**
     * Sets the value of the intSettlementMthd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIntSettlementMthd(String value) {
        this.intSettlementMthd = value;
    }

    /**
     * Gets the value of the interestPercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInterestPercent() {
        return interestPercent;
    }

    /**
     * Sets the value of the interestPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInterestPercent(BigDecimal value) {
        this.interestPercent = value;
    }

    /**
     * Gets the value of the interestSettlementAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterestSettlementAccountNo() {
        return interestSettlementAccountNo;
    }

    /**
     * Sets the value of the interestSettlementAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterestSettlementAccountNo(String value) {
        this.interestSettlementAccountNo = value;
    }

    /**
     * Gets the value of the interestSettlementBicId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInterestSettlementBicId() {
        return interestSettlementBicId;
    }

    /**
     * Sets the value of the interestSettlementBicId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInterestSettlementBicId(Long value) {
        this.interestSettlementBicId = value;
    }

    /**
     * Gets the value of the maturitySettlementAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaturitySettlementAccountNo() {
        return maturitySettlementAccountNo;
    }

    /**
     * Sets the value of the maturitySettlementAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaturitySettlementAccountNo(String value) {
        this.maturitySettlementAccountNo = value;
    }

    /**
     * Gets the value of the maturitySettlementMthd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaturitySettlementMthd() {
        return maturitySettlementMthd;
    }

    /**
     * Sets the value of the maturitySettlementMthd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaturitySettlementMthd(String value) {
        this.maturitySettlementMthd = value;
    }

    /**
     * Gets the value of the noticeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getNoticeAmount() {
        return noticeAmount;
    }

    /**
     * Sets the value of the noticeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setNoticeAmount(BigDecimal value) {
        this.noticeAmount = value;
    }

    /**
     * Gets the value of the openningReasonCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOpenningReasonCode() {
        return openningReasonCode;
    }

    /**
     * Sets the value of the openningReasonCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOpenningReasonCode(String value) {
        this.openningReasonCode = value;
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
     * Gets the value of the principalPercent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrincipalPercent() {
        return principalPercent;
    }

    /**
     * Sets the value of the principalPercent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrincipalPercent(BigDecimal value) {
        this.principalPercent = value;
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
     * Gets the value of the rolloverOptCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRolloverOptCode() {
        return rolloverOptCode;
    }

    /**
     * Sets the value of the rolloverOptCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRolloverOptCode(String value) {
        this.rolloverOptCode = value;
    }

    /**
     * Gets the value of the skipSubmit property.
     * 
     */
    public boolean isSkipSubmit() {
        return skipSubmit;
    }

    /**
     * Sets the value of the skipSubmit property.
     * 
     */
    public void setSkipSubmit(boolean value) {
        this.skipSubmit = value;
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
     * Gets the value of the strMaturityDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrMaturityDate() {
        return strMaturityDate;
    }

    /**
     * Sets the value of the strMaturityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrMaturityDate(String value) {
        this.strMaturityDate = value;
    }

    /**
     * Gets the value of the strStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrStartDate() {
        return strStartDate;
    }

    /**
     * Sets the value of the strStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrStartDate(String value) {
        this.strStartDate = value;
    }

    /**
     * Gets the value of the term property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTerm() {
        return term;
    }

    /**
     * Sets the value of the term property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTerm(Long value) {
        this.term = value;
    }

    /**
     * Gets the value of the termCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermCode() {
        return termCode;
    }

    /**
     * Sets the value of the termCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermCode(String value) {
        this.termCode = value;
    }

}
