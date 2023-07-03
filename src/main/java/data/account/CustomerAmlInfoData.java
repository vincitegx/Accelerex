//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 09:43:48 AM WAT 
//


package data.account;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerAmlInfoData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerAmlInfoData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="amlServiceId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="businessActivityId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="cautionCandId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="nationalityId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="nextReviewDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="politicallyExposedFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="relationshipLength" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="residentCountryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="reviewDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reviewerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="riskRatingId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="weightedRiskScore" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerAmlInfoData", namespace = "http://data.customer.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "amlServiceId",
    "businessActivityId",
    "cautionCandId",
    "customerId",
    "nationalityId",
    "nextReviewDate",
    "politicallyExposedFlag",
    "relationshipLength",
    "residentCountryId",
    "reviewDate",
    "reviewerName",
    "riskRatingId",
    "weightedRiskScore"
})
public class CustomerAmlInfoData
    extends XAPIRequestBaseObject
{

    protected Long amlServiceId;
    protected Long businessActivityId;
    protected Long cautionCandId;
    protected Long customerId;
    protected Long nationalityId;
    protected String nextReviewDate;
    protected boolean politicallyExposedFlag;
    protected Long relationshipLength;
    protected Long residentCountryId;
    protected String reviewDate;
    protected String reviewerName;
    protected Long riskRatingId;
    protected BigDecimal weightedRiskScore;

    /**
     * Gets the value of the amlServiceId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAmlServiceId() {
        return amlServiceId;
    }

    /**
     * Sets the value of the amlServiceId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAmlServiceId(Long value) {
        this.amlServiceId = value;
    }

    /**
     * Gets the value of the businessActivityId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBusinessActivityId() {
        return businessActivityId;
    }

    /**
     * Sets the value of the businessActivityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBusinessActivityId(Long value) {
        this.businessActivityId = value;
    }

    /**
     * Gets the value of the cautionCandId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCautionCandId() {
        return cautionCandId;
    }

    /**
     * Sets the value of the cautionCandId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCautionCandId(Long value) {
        this.cautionCandId = value;
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
     * Gets the value of the nationalityId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getNationalityId() {
        return nationalityId;
    }

    /**
     * Sets the value of the nationalityId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setNationalityId(Long value) {
        this.nationalityId = value;
    }

    /**
     * Gets the value of the nextReviewDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNextReviewDate() {
        return nextReviewDate;
    }

    /**
     * Sets the value of the nextReviewDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNextReviewDate(String value) {
        this.nextReviewDate = value;
    }

    /**
     * Gets the value of the politicallyExposedFlag property.
     * 
     */
    public boolean isPoliticallyExposedFlag() {
        return politicallyExposedFlag;
    }

    /**
     * Sets the value of the politicallyExposedFlag property.
     * 
     */
    public void setPoliticallyExposedFlag(boolean value) {
        this.politicallyExposedFlag = value;
    }

    /**
     * Gets the value of the relationshipLength property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRelationshipLength() {
        return relationshipLength;
    }

    /**
     * Sets the value of the relationshipLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRelationshipLength(Long value) {
        this.relationshipLength = value;
    }

    /**
     * Gets the value of the residentCountryId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getResidentCountryId() {
        return residentCountryId;
    }

    /**
     * Sets the value of the residentCountryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setResidentCountryId(Long value) {
        this.residentCountryId = value;
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

    /**
     * Gets the value of the reviewerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReviewerName() {
        return reviewerName;
    }

    /**
     * Sets the value of the reviewerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReviewerName(String value) {
        this.reviewerName = value;
    }

    /**
     * Gets the value of the riskRatingId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRiskRatingId() {
        return riskRatingId;
    }

    /**
     * Sets the value of the riskRatingId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRiskRatingId(Long value) {
        this.riskRatingId = value;
    }

    /**
     * Gets the value of the weightedRiskScore property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getWeightedRiskScore() {
        return weightedRiskScore;
    }

    /**
     * Sets the value of the weightedRiskScore property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setWeightedRiskScore(BigDecimal value) {
        this.weightedRiskScore = value;
    }

}
