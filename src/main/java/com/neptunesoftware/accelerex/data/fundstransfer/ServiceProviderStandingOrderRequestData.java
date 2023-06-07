//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.07 at 08:56:56 AM WAT 
//


package com.neptunesoftware.accelerex.data.fundstransfer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for serviceProviderStandingOrderRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="serviceProviderStandingOrderRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://data.transfer.server.ws.supernova.neptunesoftware.com/}standingOrderRequestData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="serviceProvider" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="serviceProviderCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "serviceProviderStandingOrderRequestData", namespace = "http://data.transfer.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "serviceProvider",
    "serviceProviderCode"
})
public class ServiceProviderStandingOrderRequestData
    extends StandingOrderRequestData
{

    protected Long serviceProvider;
    protected String serviceProviderCode;

    /**
     * Gets the value of the serviceProvider property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getServiceProvider() {
        return serviceProvider;
    }

    /**
     * Sets the value of the serviceProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setServiceProvider(Long value) {
        this.serviceProvider = value;
    }

    /**
     * Gets the value of the serviceProviderCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceProviderCode() {
        return serviceProviderCode;
    }

    /**
     * Sets the value of the serviceProviderCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceProviderCode(String value) {
        this.serviceProviderCode = value;
    }

}