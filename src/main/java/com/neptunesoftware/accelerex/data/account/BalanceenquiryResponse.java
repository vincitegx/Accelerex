//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.06 at 09:12:24 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import jakarta.xml.bind.annotation.*;


/**
 * <p>Java class for balanceenquiryResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="balanceenquiryResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://data.account.server.ws.supernova.neptunesoftware.com/}balanceEnquiryResponseData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "balanceenquiryResponse", propOrder = {
        "_return"
})
@XmlRootElement
public class BalanceenquiryResponse {

    @XmlElement(name = "return")
    protected BalanceEnquiryResponseData _return;

    /**
     * Gets the value of the return property.
     *
     * @return possible object is
     * {@link BalanceEnquiryResponseData }
     */
    public BalanceEnquiryResponseData getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     *
     * @param value allowed object is
     *              {@link BalanceEnquiryResponseData }
     */
    public void setReturn(BalanceEnquiryResponseData value) {
        this._return = value;
    }

}
