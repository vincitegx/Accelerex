//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 02:48:50 PM WAT 
//


package com.neptunesoftware.accelerex.data.FundTransfer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for internalStandingOrderRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="internalStandingOrderRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://data.transfer.server.ws.supernova.neptunesoftware.com/}standingOrderRequestData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="destinationAccountno" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "internalStandingOrderRequestData", namespace = "http://data.transfer.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "destinationAccountno"
})
public class InternalStandingOrderRequestData
    extends StandingOrderRequestData
{

    protected String destinationAccountno;

    /**
     * Gets the value of the destinationAccountno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDestinationAccountno() {
        return destinationAccountno;
    }

    /**
     * Sets the value of the destinationAccountno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDestinationAccountno(String value) {
        this.destinationAccountno = value;
    }

}
