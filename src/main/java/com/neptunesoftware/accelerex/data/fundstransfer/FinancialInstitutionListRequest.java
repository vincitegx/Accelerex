//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.07 at 08:56:56 AM WAT 
//


package com.neptunesoftware.accelerex.data.fundstransfer;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FinancialInstitutionListRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FinancialInstitutionListRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="header" type="{http://data.transfer.server.ws.supernova.neptunesoftware.com/}financialInstitutionListHeader" minOccurs="0"/&gt;
 *         &lt;element name="record" type="{http://data.transfer.server.ws.supernova.neptunesoftware.com/}financialInstitutionListRecord" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FinancialInstitutionListRequest", namespace = "http://data.transfer.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "header",
    "record"
})
public class FinancialInstitutionListRequest {

    protected FinancialInstitutionListHeader header;
    @XmlElement(nillable = true)
    protected List<FinancialInstitutionListRecord> record;

    /**
     * Gets the value of the header property.
     * 
     * @return
     *     possible object is
     *     {@link FinancialInstitutionListHeader }
     *     
     */
    public FinancialInstitutionListHeader getHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     * @param value
     *     allowed object is
     *     {@link FinancialInstitutionListHeader }
     *     
     */
    public void setHeader(FinancialInstitutionListHeader value) {
        this.header = value;
    }

    /**
     * Gets the value of the record property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the record property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRecord().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FinancialInstitutionListRecord }
     * 
     * 
     */
    public List<FinancialInstitutionListRecord> getRecord() {
        if (record == null) {
            record = new ArrayList<FinancialInstitutionListRecord>();
        }
        return this.record;
    }

}
