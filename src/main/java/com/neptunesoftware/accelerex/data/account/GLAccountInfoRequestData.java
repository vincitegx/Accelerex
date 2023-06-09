//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.06 at 09:12:24 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GLAccountInfoRequestData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GLAccountInfoRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="buCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="categoryCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GLAccountInfoRequestData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
        "buCode",
        "categoryCode"
})
public class GLAccountInfoRequestData
        extends XAPIRequestBaseObject {

    protected String buCode;
    protected String categoryCode;

    /**
     * Gets the value of the buCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getBuCode() {
        return buCode;
    }

    /**
     * Sets the value of the buCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setBuCode(String value) {
        this.buCode = value;
    }

    /**
     * Gets the value of the categoryCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getCategoryCode() {
        return categoryCode;
    }

    /**
     * Sets the value of the categoryCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setCategoryCode(String value) {
        this.categoryCode = value;
    }

}
