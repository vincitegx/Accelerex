//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.08 at 11:33:52 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import java.math.BigDecimal;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for termAccountLiquidationResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="termAccountLiquidationResponseData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="dueInterestAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="interestAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="interestForfeitureAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="penaltyChargeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="principalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="tdLiquidationStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="termAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "termAccountLiquidationResponseData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "dueInterestAmount",
    "interestAmount",
    "interestForfeitureAmount",
    "penaltyChargeAmount",
    "principalAmount",
    "tdLiquidationStatus",
    "termAccountNo"
})
public class TermAccountLiquidationResponseData {

    protected BigDecimal dueInterestAmount;
    protected BigDecimal interestAmount;
    protected BigDecimal interestForfeitureAmount;
    protected BigDecimal penaltyChargeAmount;
    protected BigDecimal principalAmount;
    protected String tdLiquidationStatus;
    protected String termAccountNo;

    /**
     * Gets the value of the dueInterestAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDueInterestAmount() {
        return dueInterestAmount;
    }

    /**
     * Sets the value of the dueInterestAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDueInterestAmount(BigDecimal value) {
        this.dueInterestAmount = value;
    }

    /**
     * Gets the value of the interestAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    /**
     * Sets the value of the interestAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInterestAmount(BigDecimal value) {
        this.interestAmount = value;
    }

    /**
     * Gets the value of the interestForfeitureAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInterestForfeitureAmount() {
        return interestForfeitureAmount;
    }

    /**
     * Sets the value of the interestForfeitureAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInterestForfeitureAmount(BigDecimal value) {
        this.interestForfeitureAmount = value;
    }

    /**
     * Gets the value of the penaltyChargeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPenaltyChargeAmount() {
        return penaltyChargeAmount;
    }

    /**
     * Sets the value of the penaltyChargeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPenaltyChargeAmount(BigDecimal value) {
        this.penaltyChargeAmount = value;
    }

    /**
     * Gets the value of the principalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrincipalAmount() {
        return principalAmount;
    }

    /**
     * Sets the value of the principalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrincipalAmount(BigDecimal value) {
        this.principalAmount = value;
    }

    /**
     * Gets the value of the tdLiquidationStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTdLiquidationStatus() {
        return tdLiquidationStatus;
    }

    /**
     * Sets the value of the tdLiquidationStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTdLiquidationStatus(String value) {
        this.tdLiquidationStatus = value;
    }

    /**
     * Gets the value of the termAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermAccountNo() {
        return termAccountNo;
    }

    /**
     * Sets the value of the termAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermAccountNo(String value) {
        this.termAccountNo = value;
    }

}
