//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.29 at 08:35:41 AM WAT 
//


package com.neptunesoftware.accelerex.data.transaction;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for wsBaseWorkFlowData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="wsBaseWorkFlowData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="itemTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="uriAuth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="wfParticipatorClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="wfParticipatorDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="wfParticipatorItemId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="wfParticipatorItemTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="wfParticipatorRefNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "wsBaseWorkFlowData", namespace = "http://data.workflow.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "itemTypeId",
    "uriAuth",
    "wfParticipatorClassName",
    "wfParticipatorDesc",
    "wfParticipatorItemId",
    "wfParticipatorItemTypeId",
    "wfParticipatorRefNo"
})
@XmlSeeAlso({
    TxnProcessOutputData.class,
    GroupCashTransactionOutputData.class
})
public abstract class WsBaseWorkFlowData {

    protected Long itemTypeId;
    protected String uriAuth;
    protected String wfParticipatorClassName;
    protected String wfParticipatorDesc;
    protected Long wfParticipatorItemId;
    protected Long wfParticipatorItemTypeId;
    protected String wfParticipatorRefNo;

    /**
     * Gets the value of the itemTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getItemTypeId() {
        return itemTypeId;
    }

    /**
     * Sets the value of the itemTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setItemTypeId(Long value) {
        this.itemTypeId = value;
    }

    /**
     * Gets the value of the uriAuth property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUriAuth() {
        return uriAuth;
    }

    /**
     * Sets the value of the uriAuth property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUriAuth(String value) {
        this.uriAuth = value;
    }

    /**
     * Gets the value of the wfParticipatorClassName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWfParticipatorClassName() {
        return wfParticipatorClassName;
    }

    /**
     * Sets the value of the wfParticipatorClassName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWfParticipatorClassName(String value) {
        this.wfParticipatorClassName = value;
    }

    /**
     * Gets the value of the wfParticipatorDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWfParticipatorDesc() {
        return wfParticipatorDesc;
    }

    /**
     * Sets the value of the wfParticipatorDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWfParticipatorDesc(String value) {
        this.wfParticipatorDesc = value;
    }

    /**
     * Gets the value of the wfParticipatorItemId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWfParticipatorItemId() {
        return wfParticipatorItemId;
    }

    /**
     * Sets the value of the wfParticipatorItemId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWfParticipatorItemId(Long value) {
        this.wfParticipatorItemId = value;
    }

    /**
     * Gets the value of the wfParticipatorItemTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getWfParticipatorItemTypeId() {
        return wfParticipatorItemTypeId;
    }

    /**
     * Sets the value of the wfParticipatorItemTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setWfParticipatorItemTypeId(Long value) {
        this.wfParticipatorItemTypeId = value;
    }

    /**
     * Gets the value of the wfParticipatorRefNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWfParticipatorRefNo() {
        return wfParticipatorRefNo;
    }

    /**
     * Sets the value of the wfParticipatorRefNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWfParticipatorRefNo(String value) {
        this.wfParticipatorRefNo = value;
    }

}
