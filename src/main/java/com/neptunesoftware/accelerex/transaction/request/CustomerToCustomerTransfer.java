package com.neptunesoftware.accelerex.transaction.request;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

/**
 * <p>Java class for customerToCustomerTransfer complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="customerToCustomerTransfer"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="arg0" type="{http://data.transfer.server.ws.supernova.neptunesoftware.com/}fundsTransferRequestData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerToCustomerTransfer", propOrder = {
        "arg0"
})
@XmlRootElement
public class CustomerToCustomerTransfer {

    protected FundsTransferRequestData arg0;

    /**
     * Gets the value of the arg0 property.
     *
     * @return possible object is
     * {@link FundsTransferRequestData }
     */
    public FundsTransferRequestData getArg0() {
        return arg0;
    }

    /**
     * Sets the value of the arg0 property.
     *
     * @param value allowed object is
     *              {@link FundsTransferRequestData }
     */
    public void setArg0(FundsTransferRequestData value) {
        this.arg0 = value;
    }

}