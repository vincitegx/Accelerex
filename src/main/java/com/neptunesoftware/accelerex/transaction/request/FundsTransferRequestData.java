package com.neptunesoftware.accelerex.transaction.request;

import com.neptunesoftware.accelerex.data.fundstransfer.InterBankTransferByAcctRequestData;
import com.neptunesoftware.accelerex.data.fundstransfer.XAPIRequestBaseObject;
import jakarta.xml.bind.annotation.*;

import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigDecimal;

/**
 * <p>Java class for fundsTransferRequestData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="fundsTransferRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acquiringInstitutionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chargeReversal" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="eventCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="eventId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="forwardingInstitutionCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fromAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fromCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fromCurrencyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="isoCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="localTransactionTime" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="processCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="processingCode" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="retrievalReferenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="reversal" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="sessionId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="toAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="toCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="toCurrencyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="track2Data" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="txnDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="utilityAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "fundsTransferRequestData", namespace = "http://data.transfer.server.ws.supernova.neptunesoftware.com/", propOrder = {
        "acquiringInstitutionCode",
        "chargeReversal",
        "eventCode",
        "eventId",
        "forwardingInstitutionCode",
        "fromAccountNumber",
        "fromCurrencyCode",
        "fromCurrencyId",
        "isoCurrencyCode",
        "localTransactionTime",
        "processCode",
        "processingCode",
        "retrievalReferenceNumber",
        "reversal",
        "sessionId",
        "toAccountNumber",
        "toCurrencyCode",
        "toCurrencyId",
        "transactionAmount",
        "track2Data",
        "txnDescription",
        "utilityAccountNo"
})
@XmlSeeAlso({
        InterBankTransferByAcctRequestData.class
})
@XmlRootElement
public class FundsTransferRequestData
        extends XAPIRequestBaseObject {

    protected String acquiringInstitutionCode;
    protected boolean chargeReversal;
    protected String eventCode;
    protected Long eventId;
    protected String forwardingInstitutionCode;
    protected String fromAccountNumber;
    protected String fromCurrencyCode;
    protected Long fromCurrencyId;
    protected String isoCurrencyCode;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar localTransactionTime;
    protected String processCode;
    protected Long processingCode;
    protected String retrievalReferenceNumber;
    protected boolean reversal;
    protected String sessionId;
    protected String toAccountNumber;
    protected String toCurrencyCode;
    protected Long toCurrencyId;
    protected String track2Data;
    protected BigDecimal transactionAmount;
    protected String txnDescription;
    protected String utilityAccountNo;

    /**
     * Gets the value of the acquiringInstitutionCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAcquiringInstitutionCode() {
        return acquiringInstitutionCode;
    }

    /**
     * Sets the value of the acquiringInstitutionCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAcquiringInstitutionCode(String value) {
        this.acquiringInstitutionCode = value;
    }

    /**
     * Gets the value of the chargeReversal property.
     */
    public boolean isChargeReversal() {
        return chargeReversal;
    }

    /**
     * Sets the value of the chargeReversal property.
     */
    public void setChargeReversal(boolean value) {
        this.chargeReversal = value;
    }

    /**
     * Gets the value of the eventCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getEventCode() {
        return eventCode;
    }

    /**
     * Sets the value of the eventCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setEventCode(String value) {
        this.eventCode = value;
    }

    /**
     * Gets the value of the eventId property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getEventId() {
        return eventId;
    }

    /**
     * Sets the value of the eventId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setEventId(Long value) {
        this.eventId = value;
    }

    /**
     * Gets the value of the forwardingInstitutionCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getForwardingInstitutionCode() {
        return forwardingInstitutionCode;
    }

    /**
     * Sets the value of the forwardingInstitutionCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setForwardingInstitutionCode(String value) {
        this.forwardingInstitutionCode = value;
    }

    /**
     * Gets the value of the fromAccountNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFromAccountNumber() {
        return fromAccountNumber;
    }

    /**
     * Sets the value of the fromAccountNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFromAccountNumber(String value) {
        this.fromAccountNumber = value;
    }

    /**
     * Gets the value of the fromCurrencyCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getFromCurrencyCode() {
        return fromCurrencyCode;
    }

    /**
     * Sets the value of the fromCurrencyCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setFromCurrencyCode(String value) {
        this.fromCurrencyCode = value;
    }

    /**
     * Gets the value of the fromCurrencyId property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getFromCurrencyId() {
        return fromCurrencyId;
    }

    /**
     * Sets the value of the fromCurrencyId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setFromCurrencyId(Long value) {
        this.fromCurrencyId = value;
    }

    /**
     * Gets the value of the isoCurrencyCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getIsoCurrencyCode() {
        return isoCurrencyCode;
    }

    /**
     * Sets the value of the isoCurrencyCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setIsoCurrencyCode(String value) {
        this.isoCurrencyCode = value;
    }

    /**
     * Gets the value of the localTransactionTime property.
     *
     * @return possible object is
     * {@link XMLGregorianCalendar }
     */
    public XMLGregorianCalendar getLocalTransactionTime() {
        return localTransactionTime;
    }

    /**
     * Sets the value of the localTransactionTime property.
     *
     * @param value allowed object is
     *              {@link XMLGregorianCalendar }
     */
    public void setLocalTransactionTime(XMLGregorianCalendar value) {
        this.localTransactionTime = value;
    }

    /**
     * Gets the value of the processCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getProcessCode() {
        return processCode;
    }

    /**
     * Sets the value of the processCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setProcessCode(String value) {
        this.processCode = value;
    }

    /**
     * Gets the value of the processingCode property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getProcessingCode() {
        return processingCode;
    }

    /**
     * Sets the value of the processingCode property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setProcessingCode(Long value) {
        this.processingCode = value;
    }

    /**
     * Gets the value of the retrievalReferenceNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getRetrievalReferenceNumber() {
        return retrievalReferenceNumber;
    }

    /**
     * Sets the value of the retrievalReferenceNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setRetrievalReferenceNumber(String value) {
        this.retrievalReferenceNumber = value;
    }

    /**
     * Gets the value of the reversal property.
     */
    public boolean isReversal() {
        return reversal;
    }

    /**
     * Sets the value of the reversal property.
     */
    public void setReversal(boolean value) {
        this.reversal = value;
    }

    /**
     * Gets the value of the sessionId property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * Sets the value of the sessionId property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSessionId(String value) {
        this.sessionId = value;
    }

    /**
     * Gets the value of the toAccountNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getToAccountNumber() {
        return toAccountNumber;
    }

    /**
     * Sets the value of the toAccountNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setToAccountNumber(String value) {
        this.toAccountNumber = value;
    }

    /**
     * Gets the value of the toCurrencyCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getToCurrencyCode() {
        return toCurrencyCode;
    }

    /**
     * Sets the value of the toCurrencyCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setToCurrencyCode(String value) {
        this.toCurrencyCode = value;
    }

    /**
     * Gets the value of the toCurrencyId property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getToCurrencyId() {
        return toCurrencyId;
    }

    /**
     * Sets the value of the toCurrencyId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setToCurrencyId(Long value) {
        this.toCurrencyId = value;
    }

    /**
     * Gets the value of the track2Data property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTrack2Data() {
        return track2Data;
    }

    /**
     * Sets the value of the track2Data property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTrack2Data(String value) {
        this.track2Data = value;
    }

    /**
     * Gets the value of the amount property.
     *
     * @return possible object is
     * {@link BigDecimal }
     */
    public BigDecimal getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the value of the amount property.
     *
     * @param value allowed object is
     *              {@link BigDecimal }
     */
    public void setTransactionAmount(BigDecimal value) {
        this.transactionAmount = value;
    }

    /**
     * Gets the value of the txnDescription property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getTxnDescription() {
        return txnDescription;
    }

    /**
     * Sets the value of the txnDescription property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setTxnDescription(String value) {
        this.txnDescription = value;
    }

    /**
     * Gets the value of the utilityAccountNo property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getUtilityAccountNo() {
        return utilityAccountNo;
    }

    /**
     * Sets the value of the utilityAccountNo property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setUtilityAccountNo(String value) {
        this.utilityAccountNo = value;
    }

}
