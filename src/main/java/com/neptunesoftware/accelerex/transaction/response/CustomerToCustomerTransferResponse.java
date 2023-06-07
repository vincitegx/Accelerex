package com.neptunesoftware.accelerex.transaction.response;

import com.neptunesoftware.accelerex.data.fundstransfer.FundsTransferOutputData;
import jakarta.xml.bind.annotation.*;

/**
 * <p>Java class for customerToCustomerTransferResponse complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="customerToCustomerTransferResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="return" type="{http://data.transfer.server.ws.supernova.neptunesoftware.com/}fundsTransferOutputData" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerToCustomerTransferResponse", propOrder = {
        "_return"
})
@XmlRootElement
public class CustomerToCustomerTransferResponse {

    @XmlElement(name = "return")
    protected FundsTransferOutputData _return;

    /**
     * Gets the value of the return property.
     *
     * @return possible object is
     * {@link FundsTransferOutputData }
     */
    public FundsTransferOutputData getReturn() {
        return _return;
    }

    /**
     * Sets the value of the return property.
     *
     * @param value allowed object is
     *              {@link com.neptunesoftware.accelerex.data.fundstransfer.FundsTransferOutputData }
     */
    public void setReturn(FundsTransferOutputData value) {
        this._return = value;
    }

}
