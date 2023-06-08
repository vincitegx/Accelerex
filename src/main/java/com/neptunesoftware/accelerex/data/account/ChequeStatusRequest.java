//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.08 at 11:33:52 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for chequeStatusRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="chequeStatusRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="acctNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="acqInstnCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chequeEndingNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="chequeStartingNo" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="fwdInstnCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="localTxnDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="localTxnTime" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="msgTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="procCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="retrievalRefNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chequeStatusRequest", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "acctNo",
    "acqInstnCode",
    "chequeEndingNo",
    "chequeStartingNo",
    "fwdInstnCode",
    "localTxnDate",
    "localTxnTime",
    "msgTypeCode",
    "procCode",
    "retrievalRefNo"
})
public class ChequeStatusRequest
    extends XAPIRequestBaseObject
{

    protected String acctNo;
    protected String acqInstnCode;
    protected Long chequeEndingNo;
    protected Long chequeStartingNo;
    protected String fwdInstnCode;
    protected Long localTxnDate;
    protected Long localTxnTime;
    protected String msgTypeCode;
    protected String procCode;
    protected String retrievalRefNo;

    /**
     * Gets the value of the acctNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcctNo() {
        return acctNo;
    }

    /**
     * Sets the value of the acctNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcctNo(String value) {
        this.acctNo = value;
    }

    /**
     * Gets the value of the acqInstnCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAcqInstnCode() {
        return acqInstnCode;
    }

    /**
     * Sets the value of the acqInstnCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAcqInstnCode(String value) {
        this.acqInstnCode = value;
    }

    /**
     * Gets the value of the chequeEndingNo property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChequeEndingNo() {
        return chequeEndingNo;
    }

    /**
     * Sets the value of the chequeEndingNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChequeEndingNo(Long value) {
        this.chequeEndingNo = value;
    }

    /**
     * Gets the value of the chequeStartingNo property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChequeStartingNo() {
        return chequeStartingNo;
    }

    /**
     * Sets the value of the chequeStartingNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChequeStartingNo(Long value) {
        this.chequeStartingNo = value;
    }

    /**
     * Gets the value of the fwdInstnCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFwdInstnCode() {
        return fwdInstnCode;
    }

    /**
     * Sets the value of the fwdInstnCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFwdInstnCode(String value) {
        this.fwdInstnCode = value;
    }

    /**
     * Gets the value of the localTxnDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLocalTxnDate() {
        return localTxnDate;
    }

    /**
     * Sets the value of the localTxnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLocalTxnDate(Long value) {
        this.localTxnDate = value;
    }

    /**
     * Gets the value of the localTxnTime property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getLocalTxnTime() {
        return localTxnTime;
    }

    /**
     * Sets the value of the localTxnTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setLocalTxnTime(Long value) {
        this.localTxnTime = value;
    }

    /**
     * Gets the value of the msgTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMsgTypeCode() {
        return msgTypeCode;
    }

    /**
     * Sets the value of the msgTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMsgTypeCode(String value) {
        this.msgTypeCode = value;
    }

    /**
     * Gets the value of the procCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcCode() {
        return procCode;
    }

    /**
     * Sets the value of the procCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcCode(String value) {
        this.procCode = value;
    }

    /**
     * Gets the value of the retrievalRefNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRetrievalRefNo() {
        return retrievalRefNo;
    }

    /**
     * Sets the value of the retrievalRefNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRetrievalRefNo(String value) {
        this.retrievalRefNo = value;
    }

}
