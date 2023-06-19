//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 09:43:48 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WFTransitionOutputData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WFTransitionOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="baseWorkFlowData" type="{http://data.workflow.server.ws.supernova.neptunesoftware.com/}wsBaseWorkFlowData" minOccurs="0"/&gt;
 *         &lt;element name="businessProcessId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="businessUnitId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="errorData" type="{http://common.ws.supernova.neptunesoftware.com/}XAPIErrorData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="itemClassName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="itemRefNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="originatorUserRoleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="subProcessId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="wfEventData" type="{http://data.workflow.server.ws.supernova.neptunesoftware.com/}wfEventOutputData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WFTransitionOutputData", namespace = "http://data.workflow.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "baseWorkFlowData",
    "businessProcessId",
    "businessUnitId",
    "customerId",
    "errorData",
    "itemClassName",
    "itemRefNo",
    "originatorUserRoleId",
    "subProcessId",
    "wfEventData"
})
public class WFTransitionOutputData {

    protected WsBaseWorkFlowData baseWorkFlowData;
    protected Long businessProcessId;
    protected Long businessUnitId;
    protected Long customerId;
    @XmlElement(nillable = true)
    protected List<XAPIErrorData> errorData;
    protected String itemClassName;
    protected String itemRefNo;
    protected Long originatorUserRoleId;
    protected Long subProcessId;
    @XmlElement(nillable = true)
    protected List<WfEventOutputData> wfEventData;

    /**
     * Gets the value of the baseWorkFlowData property.
     * 
     * @return
     *     possible object is
     *     {@link WsBaseWorkFlowData }
     *     
     */
    public WsBaseWorkFlowData getBaseWorkFlowData() {
        return baseWorkFlowData;
    }

    /**
     * Sets the value of the baseWorkFlowData property.
     * 
     * @param value
     *     allowed object is
     *     {@link WsBaseWorkFlowData }
     *     
     */
    public void setBaseWorkFlowData(WsBaseWorkFlowData value) {
        this.baseWorkFlowData = value;
    }

    /**
     * Gets the value of the businessProcessId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBusinessProcessId() {
        return businessProcessId;
    }

    /**
     * Sets the value of the businessProcessId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBusinessProcessId(Long value) {
        this.businessProcessId = value;
    }

    /**
     * Gets the value of the businessUnitId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBusinessUnitId() {
        return businessUnitId;
    }

    /**
     * Sets the value of the businessUnitId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBusinessUnitId(Long value) {
        this.businessUnitId = value;
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
     * Gets the value of the errorData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the errorData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getErrorData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link XAPIErrorData }
     * 
     * 
     */
    public List<XAPIErrorData> getErrorData() {
        if (errorData == null) {
            errorData = new ArrayList<XAPIErrorData>();
        }
        return this.errorData;
    }

    /**
     * Gets the value of the itemClassName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemClassName() {
        return itemClassName;
    }

    /**
     * Sets the value of the itemClassName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemClassName(String value) {
        this.itemClassName = value;
    }

    /**
     * Gets the value of the itemRefNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getItemRefNo() {
        return itemRefNo;
    }

    /**
     * Sets the value of the itemRefNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setItemRefNo(String value) {
        this.itemRefNo = value;
    }

    /**
     * Gets the value of the originatorUserRoleId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getOriginatorUserRoleId() {
        return originatorUserRoleId;
    }

    /**
     * Sets the value of the originatorUserRoleId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setOriginatorUserRoleId(Long value) {
        this.originatorUserRoleId = value;
    }

    /**
     * Gets the value of the subProcessId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSubProcessId() {
        return subProcessId;
    }

    /**
     * Sets the value of the subProcessId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSubProcessId(Long value) {
        this.subProcessId = value;
    }

    /**
     * Gets the value of the wfEventData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the wfEventData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWfEventData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WfEventOutputData }
     * 
     * 
     */
    public List<WfEventOutputData> getWfEventData() {
        if (wfEventData == null) {
            wfEventData = new ArrayList<WfEventOutputData>();
        }
        return this.wfEventData;
    }

}