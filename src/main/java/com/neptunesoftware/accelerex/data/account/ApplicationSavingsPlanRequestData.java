//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 09:43:48 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for applicationSavingsPlanRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="applicationSavingsPlanRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="applSavingsPlanId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="depositAccountAppId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="fundingAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="fundingAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fundingMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="installmentAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="installmentFrequencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="installmentFrequencyVal" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="maturityDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="planDurationCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="planDurationVal" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "applicationSavingsPlanRequestData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "applSavingsPlanId",
    "depositAccountAppId",
    "fundingAccountId",
    "fundingAccountNo",
    "fundingMethod",
    "installmentAmount",
    "installmentFrequencyCode",
    "installmentFrequencyVal",
    "maturityDate",
    "planDurationCode",
    "planDurationVal",
    "startDate"
})
public class ApplicationSavingsPlanRequestData
    extends XAPIRequestBaseObject
{

    protected Long applSavingsPlanId;
    protected Long depositAccountAppId;
    protected Long fundingAccountId;
    protected String fundingAccountNo;
    protected String fundingMethod;
    protected BigDecimal installmentAmount;
    protected String installmentFrequencyCode;
    protected Long installmentFrequencyVal;
    protected String maturityDate;
    protected String planDurationCode;
    protected Long planDurationVal;
    protected String startDate;

    /**
     * Gets the value of the applSavingsPlanId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getApplSavingsPlanId() {
        return applSavingsPlanId;
    }

    /**
     * Sets the value of the applSavingsPlanId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setApplSavingsPlanId(Long value) {
        this.applSavingsPlanId = value;
    }

    /**
     * Gets the value of the depositAccountAppId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDepositAccountAppId() {
        return depositAccountAppId;
    }

    /**
     * Sets the value of the depositAccountAppId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDepositAccountAppId(Long value) {
        this.depositAccountAppId = value;
    }

    /**
     * Gets the value of the fundingAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFundingAccountId() {
        return fundingAccountId;
    }

    /**
     * Sets the value of the fundingAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFundingAccountId(Long value) {
        this.fundingAccountId = value;
    }

    /**
     * Gets the value of the fundingAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundingAccountNo() {
        return fundingAccountNo;
    }

    /**
     * Sets the value of the fundingAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundingAccountNo(String value) {
        this.fundingAccountNo = value;
    }

    /**
     * Gets the value of the fundingMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundingMethod() {
        return fundingMethod;
    }

    /**
     * Sets the value of the fundingMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundingMethod(String value) {
        this.fundingMethod = value;
    }

    /**
     * Gets the value of the installmentAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInstallmentAmount() {
        return installmentAmount;
    }

    /**
     * Sets the value of the installmentAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInstallmentAmount(BigDecimal value) {
        this.installmentAmount = value;
    }

    /**
     * Gets the value of the installmentFrequencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInstallmentFrequencyCode() {
        return installmentFrequencyCode;
    }

    /**
     * Sets the value of the installmentFrequencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInstallmentFrequencyCode(String value) {
        this.installmentFrequencyCode = value;
    }

    /**
     * Gets the value of the installmentFrequencyVal property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInstallmentFrequencyVal() {
        return installmentFrequencyVal;
    }

    /**
     * Sets the value of the installmentFrequencyVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInstallmentFrequencyVal(Long value) {
        this.installmentFrequencyVal = value;
    }

    /**
     * Gets the value of the maturityDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaturityDate() {
        return maturityDate;
    }

    /**
     * Sets the value of the maturityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaturityDate(String value) {
        this.maturityDate = value;
    }

    /**
     * Gets the value of the planDurationCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPlanDurationCode() {
        return planDurationCode;
    }

    /**
     * Sets the value of the planDurationCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPlanDurationCode(String value) {
        this.planDurationCode = value;
    }

    /**
     * Gets the value of the planDurationVal property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPlanDurationVal() {
        return planDurationVal;
    }

    /**
     * Sets the value of the planDurationVal property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPlanDurationVal(Long value) {
        this.planDurationVal = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
    }

}
