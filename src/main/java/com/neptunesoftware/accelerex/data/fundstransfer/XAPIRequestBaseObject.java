//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.07 at 08:56:56 AM WAT 
//


package com.neptunesoftware.accelerex.data.fundstransfer;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for XAPIRequestBaseObject complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="XAPIRequestBaseObject"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="XAPIServiceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="agencyFee" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="agencyFeeAcctNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="agentAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="agentCrncyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="agentCrncyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="agentTxnDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="cardNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="channelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="channelId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="channelRefNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="code" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="currBUId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="customerFeeAcctNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deviceCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="globalCharges" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="internalChannelCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="localCcyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="messageContent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="originatorUserId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="reference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="requestDetails" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="response" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *         &lt;element name="reversalIndicator" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="smsRequired" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="switchId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sysUserId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="terminalNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transmissionTime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="userAccessCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userBusinessRoleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="userId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="userLoginId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="userRoleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="validXapiRequest" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="xapiChargeAmt" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "XAPIRequestBaseObject", namespace = "http://common.ws.supernova.neptunesoftware.com/", propOrder = {
    "xapiServiceCode",
    "agencyFee",
    "agencyFeeAcctNo",
    "agentAccountNumber",
    "agentCrncyCode",
    "agentCrncyId",
    "agentTxnDesc",
    "amount",
    "cardNumber",
    "channelCode",
    "channelId",
    "channelRefNo",
    "code",
    "currBUId",
    "customerFeeAcctNo",
    "deviceCd",
    "globalCharges",
    "internalChannelCode",
    "localCcyId",
    "messageContent",
    "originatorUserId",
    "reference",
    "requestDetails",
    "response",
    "reversalIndicator",
    "smsRequired",
    "switchId",
    "sysUserId",
    "terminalNumber",
    "transmissionTime",
    "userAccessCode",
    "userBusinessRoleId",
    "userId",
    "userLoginId",
    "userPassword",
    "userRoleId",
    "validXapiRequest",
    "xapiChargeAmt"
})
@XmlSeeAlso({
    FundsTransferRequestData.class,
    SweepFundsTransferRequestData.class,
    DirectDebitMandateRequest.class,
    InwardFundTransferRequestData.class,
    StandingOrderRequestData.class,
    NameInquiryRequestData.class,
    StandingOrderAmendmentRequestData.class,
    AccountRequest.class,
    XAPIBaseTxnRequestData.class
})
public class XAPIRequestBaseObject {

    @XmlElement(name = "XAPIServiceCode")
    protected String xapiServiceCode;
    protected BigDecimal agencyFee;
    protected String agencyFeeAcctNo;
    protected String agentAccountNumber;
    protected String agentCrncyCode;
    protected Long agentCrncyId;
    protected String agentTxnDesc;
    protected BigDecimal amount;
    protected String cardNumber;
    protected String channelCode;
    protected Long channelId;
    protected String channelRefNo;
    protected String code;
    protected Long currBUId;
    protected String customerFeeAcctNo;
    protected String deviceCd;
    protected BigDecimal globalCharges;
    protected String internalChannelCode;
    protected Long localCcyId;
    protected String messageContent;
    protected Long originatorUserId;
    protected String reference;
    protected Object requestDetails;
    protected Object response;
    protected String reversalIndicator;
    protected boolean smsRequired;
    protected String switchId;
    protected Long sysUserId;
    protected String terminalNumber;
    protected Long transmissionTime;
    protected String userAccessCode;
    protected Long userBusinessRoleId;
    protected Long userId;
    protected String userLoginId;
    protected String userPassword;
    protected Long userRoleId;
    protected boolean validXapiRequest;
    protected BigDecimal xapiChargeAmt;

    /**
     * Gets the value of the xapiServiceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXAPIServiceCode() {
        return xapiServiceCode;
    }

    /**
     * Sets the value of the xapiServiceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXAPIServiceCode(String value) {
        this.xapiServiceCode = value;
    }

    /**
     * Gets the value of the agencyFee property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAgencyFee() {
        return agencyFee;
    }

    /**
     * Sets the value of the agencyFee property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAgencyFee(BigDecimal value) {
        this.agencyFee = value;
    }

    /**
     * Gets the value of the agencyFeeAcctNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgencyFeeAcctNo() {
        return agencyFeeAcctNo;
    }

    /**
     * Sets the value of the agencyFeeAcctNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgencyFeeAcctNo(String value) {
        this.agencyFeeAcctNo = value;
    }

    /**
     * Gets the value of the agentAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentAccountNumber() {
        return agentAccountNumber;
    }

    /**
     * Sets the value of the agentAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentAccountNumber(String value) {
        this.agentAccountNumber = value;
    }

    /**
     * Gets the value of the agentCrncyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentCrncyCode() {
        return agentCrncyCode;
    }

    /**
     * Sets the value of the agentCrncyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentCrncyCode(String value) {
        this.agentCrncyCode = value;
    }

    /**
     * Gets the value of the agentCrncyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAgentCrncyId() {
        return agentCrncyId;
    }

    /**
     * Sets the value of the agentCrncyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAgentCrncyId(Long value) {
        this.agentCrncyId = value;
    }

    /**
     * Gets the value of the agentTxnDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAgentTxnDesc() {
        return agentTxnDesc;
    }

    /**
     * Sets the value of the agentTxnDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAgentTxnDesc(String value) {
        this.agentTxnDesc = value;
    }

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setAmount(BigDecimal value) {
        this.amount = value;
    }

    /**
     * Gets the value of the cardNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Sets the value of the cardNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCardNumber(String value) {
        this.cardNumber = value;
    }

    /**
     * Gets the value of the channelCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelCode() {
        return channelCode;
    }

    /**
     * Sets the value of the channelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelCode(String value) {
        this.channelCode = value;
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
     * Gets the value of the channelRefNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelRefNo() {
        return channelRefNo;
    }

    /**
     * Sets the value of the channelRefNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelRefNo(String value) {
        this.channelRefNo = value;
    }

    /**
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

    /**
     * Gets the value of the currBUId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCurrBUId() {
        return currBUId;
    }

    /**
     * Sets the value of the currBUId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCurrBUId(Long value) {
        this.currBUId = value;
    }

    /**
     * Gets the value of the customerFeeAcctNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerFeeAcctNo() {
        return customerFeeAcctNo;
    }

    /**
     * Sets the value of the customerFeeAcctNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerFeeAcctNo(String value) {
        this.customerFeeAcctNo = value;
    }

    /**
     * Gets the value of the deviceCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeviceCd() {
        return deviceCd;
    }

    /**
     * Sets the value of the deviceCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeviceCd(String value) {
        this.deviceCd = value;
    }

    /**
     * Gets the value of the globalCharges property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getGlobalCharges() {
        return globalCharges;
    }

    /**
     * Sets the value of the globalCharges property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setGlobalCharges(BigDecimal value) {
        this.globalCharges = value;
    }

    /**
     * Gets the value of the internalChannelCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInternalChannelCode() {
        return internalChannelCode;
    }

    /**
     * Sets the value of the internalChannelCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInternalChannelCode(String value) {
        this.internalChannelCode = value;
    }

    /**
     * Gets the value of the localCcyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLocalCcyId() {
        return localCcyId;
    }

    /**
     * Sets the value of the localCcyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLocalCcyId(Long value) {
        this.localCcyId = value;
    }

    /**
     * Gets the value of the messageContent property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageContent() {
        return messageContent;
    }

    /**
     * Sets the value of the messageContent property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageContent(String value) {
        this.messageContent = value;
    }

    /**
     * Gets the value of the originatorUserId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOriginatorUserId() {
        return originatorUserId;
    }

    /**
     * Sets the value of the originatorUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOriginatorUserId(Long value) {
        this.originatorUserId = value;
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Gets the value of the requestDetails property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getRequestDetails() {
        return requestDetails;
    }

    /**
     * Sets the value of the requestDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setRequestDetails(Object value) {
        this.requestDetails = value;
    }

    /**
     * Gets the value of the response property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public Object getResponse() {
        return response;
    }

    /**
     * Sets the value of the response property.
     * 
     * @param value
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setResponse(Object value) {
        this.response = value;
    }

    /**
     * Gets the value of the reversalIndicator property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReversalIndicator() {
        return reversalIndicator;
    }

    /**
     * Sets the value of the reversalIndicator property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReversalIndicator(String value) {
        this.reversalIndicator = value;
    }

    /**
     * Gets the value of the smsRequired property.
     * 
     */
    public boolean isSmsRequired() {
        return smsRequired;
    }

    /**
     * Sets the value of the smsRequired property.
     * 
     */
    public void setSmsRequired(boolean value) {
        this.smsRequired = value;
    }

    /**
     * Gets the value of the switchId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwitchId() {
        return switchId;
    }

    /**
     * Sets the value of the switchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwitchId(String value) {
        this.switchId = value;
    }

    /**
     * Gets the value of the sysUserId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSysUserId() {
        return sysUserId;
    }

    /**
     * Sets the value of the sysUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSysUserId(Long value) {
        this.sysUserId = value;
    }

    /**
     * Gets the value of the terminalNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTerminalNumber() {
        return terminalNumber;
    }

    /**
     * Sets the value of the terminalNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTerminalNumber(String value) {
        this.terminalNumber = value;
    }

    /**
     * Gets the value of the transmissionTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTransmissionTime() {
        return transmissionTime;
    }

    /**
     * Sets the value of the transmissionTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTransmissionTime(Long value) {
        this.transmissionTime = value;
    }

    /**
     * Gets the value of the userAccessCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserAccessCode() {
        return userAccessCode;
    }

    /**
     * Sets the value of the userAccessCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserAccessCode(String value) {
        this.userAccessCode = value;
    }

    /**
     * Gets the value of the userBusinessRoleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUserBusinessRoleId() {
        return userBusinessRoleId;
    }

    /**
     * Sets the value of the userBusinessRoleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUserBusinessRoleId(Long value) {
        this.userBusinessRoleId = value;
    }

    /**
     * Gets the value of the userId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * Sets the value of the userId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUserId(Long value) {
        this.userId = value;
    }

    /**
     * Gets the value of the userLoginId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUserLoginId() {
        return userLoginId;
    }

    /**
     * Sets the value of the userLoginId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUserLoginId(String value) {
        this.userLoginId = value;
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
     * Gets the value of the userRoleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getUserRoleId() {
        return userRoleId;
    }

    /**
     * Sets the value of the userRoleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setUserRoleId(Long value) {
        this.userRoleId = value;
    }

    /**
     * Gets the value of the validXapiRequest property.
     * 
     */
    public boolean isValidXapiRequest() {
        return validXapiRequest;
    }

    /**
     * Sets the value of the validXapiRequest property.
     * 
     */
    public void setValidXapiRequest(boolean value) {
        this.validXapiRequest = value;
    }

    /**
     * Gets the value of the xapiChargeAmt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getXapiChargeAmt() {
        return xapiChargeAmt;
    }

    /**
     * Sets the value of the xapiChargeAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setXapiChargeAmt(BigDecimal value) {
        this.xapiChargeAmt = value;
    }

}
