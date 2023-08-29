//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.08.29 at 08:35:41 AM WAT 
//


package com.neptunesoftware.accelerex.data.transaction;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for txnProcessBatchItemResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="txnProcessBatchItemResponseData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="batchItemNumber" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="batchItemReference" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="batchItemStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "txnProcessBatchItemResponseData", namespace = "http://data.txnprocess.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "batchItemNumber",
    "batchItemReference",
    "batchItemStatus"
})
public class TxnProcessBatchItemResponseData {

    protected long batchItemNumber;
    protected String batchItemReference;
    protected String batchItemStatus;

    /**
     * Gets the value of the batchItemNumber property.
     * 
     */
    public long getBatchItemNumber() {
        return batchItemNumber;
    }

    /**
     * Sets the value of the batchItemNumber property.
     * 
     */
    public void setBatchItemNumber(long value) {
        this.batchItemNumber = value;
    }

    /**
     * Gets the value of the batchItemReference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchItemReference() {
        return batchItemReference;
    }

    /**
     * Sets the value of the batchItemReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchItemReference(String value) {
        this.batchItemReference = value;
    }

    /**
     * Gets the value of the batchItemStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchItemStatus() {
        return batchItemStatus;
    }

    /**
     * Sets the value of the batchItemStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchItemStatus(String value) {
        this.batchItemStatus = value;
    }

}
