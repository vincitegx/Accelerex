//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 02:48:50 PM WAT 
//


package data.FundTransfer;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for mobileRechargeRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="mobileRechargeRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://data.account.server.ws.supernova.neptunesoftware.com/}accountRequest"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acquiringInstitutionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="forwardingInstitutionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fromAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fromCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="groupType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="isoCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="localTransactionTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="processingCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="retrievalReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="toAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="toCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="track2Data" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transactionAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "mobileRechargeRequestData", namespace = "http://data.transfer.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "acquiringInstitutionCode",
    "forwardingInstitutionCode",
    "fromAccountNumber",
    "fromCurrencyCode",
    "groupType",
    "isoCurrencyCode",
    "localTransactionTime",
    "processingCode",
    "retrievalReferenceNumber",
    "toAccountNumber",
    "toCurrencyCode",
    "track2Data",
    "transactionAmount"
})
public class MobileRechargeRequestData
    extends AccountRequest
{

    protected String acquiringInstitutionCode;
    protected String forwardingInstitutionCode;
    protected String fromAccountNumber;
    protected String fromCurrencyCode;
    protected String groupType;
    protected String isoCurrencyCode;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar localTransactionTime;
    protected Long processingCode;
    protected String retrievalReferenceNumber;
    protected String toAccountNumber;
    protected String toCurrencyCode;
    protected String track2Data;
    protected BigDecimal transactionAmount;

    /**
     * Gets the value of the acquiringInstitutionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcquiringInstitutionCode() {
        return acquiringInstitutionCode;
    }

    /**
     * Sets the value of the acquiringInstitutionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcquiringInstitutionCode(String value) {
        this.acquiringInstitutionCode = value;
    }

    /**
     * Gets the value of the forwardingInstitutionCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getForwardingInstitutionCode() {
        return forwardingInstitutionCode;
    }

    /**
     * Sets the value of the forwardingInstitutionCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setForwardingInstitutionCode(String value) {
        this.forwardingInstitutionCode = value;
    }

    /**
     * Gets the value of the fromAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    /**
     * Sets the value of the fromAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromAccountNumber(String value) {
        this.fromAccountNumber = value;
    }

    /**
     * Gets the value of the fromCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFromCurrencyCode() {
        return fromCurrencyCode;
    }

    /**
     * Sets the value of the fromCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFromCurrencyCode(String value) {
        this.fromCurrencyCode = value;
    }

    /**
     * Gets the value of the groupType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroupType() {
        return groupType;
    }

    /**
     * Sets the value of the groupType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroupType(String value) {
        this.groupType = value;
    }

    /**
     * Gets the value of the isoCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIsoCurrencyCode() {
        return isoCurrencyCode;
    }

    /**
     * Sets the value of the isoCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIsoCurrencyCode(String value) {
        this.isoCurrencyCode = value;
    }

    /**
     * Gets the value of the localTransactionTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLocalTransactionTime() {
        return localTransactionTime;
    }

    /**
     * Sets the value of the localTransactionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLocalTransactionTime(XMLGregorianCalendar value) {
        this.localTransactionTime = value;
    }

    /**
     * Gets the value of the processingCode property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProcessingCode() {
        return processingCode;
    }

    /**
     * Sets the value of the processingCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProcessingCode(Long value) {
        this.processingCode = value;
    }

    /**
     * Gets the value of the retrievalReferenceNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetrievalReferenceNumber() {
        return retrievalReferenceNumber;
    }

    /**
     * Sets the value of the retrievalReferenceNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetrievalReferenceNumber(String value) {
        this.retrievalReferenceNumber = value;
    }

    /**
     * Gets the value of the toAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToAccountNumber() {
        return toAccountNumber;
    }

    /**
     * Sets the value of the toAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToAccountNumber(String value) {
        this.toAccountNumber = value;
    }

    /**
     * Gets the value of the toCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToCurrencyCode() {
        return toCurrencyCode;
    }

    /**
     * Sets the value of the toCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToCurrencyCode(String value) {
        this.toCurrencyCode = value;
    }

    /**
     * Gets the value of the track2Data property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTrack2Data() {
        return track2Data;
    }

    /**
     * Sets the value of the track2Data property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTrack2Data(String value) {
        this.track2Data = value;
    }

    /**
     * Gets the value of the transactionAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the value of the transactionAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setTransactionAmount(BigDecimal value) {
        this.transactionAmount = value;
    }

}
