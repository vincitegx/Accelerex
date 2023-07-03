//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 09:43:48 AM WAT 
//


package data.account;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for chequeBookRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="chequeBookRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chequeBookType" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="chequeBookTypeCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerAddressId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="customerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deliveryAddressId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="deliveryInstruction" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="deliveryMethodId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noOfChequeBooks" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="productChequeBookId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="reorderLevelId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chequeBookRequest", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "accountNumber",
    "chequeBookType",
    "chequeBookTypeCd",
    "customerAddressId",
    "customerName",
    "customerNumber",
    "deliveryAddressId",
    "deliveryInstruction",
    "deliveryMethodId",
    "noOfChequeBooks",
    "productChequeBookId",
    "reorderLevelId",
    "status"
})
public class ChequeBookRequest
    extends XAPIRequestBaseObject
{

    protected String accountNumber;
    protected long chequeBookType;
    protected String chequeBookTypeCd;
    protected Long customerAddressId;
    protected String customerName;
    protected String customerNumber;
    protected Long deliveryAddressId;
    protected String deliveryInstruction;
    protected String deliveryMethodId;
    protected int noOfChequeBooks;
    protected Long productChequeBookId;
    protected String reorderLevelId;
    protected String status;

    /**
     * Gets the value of the accountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the value of the accountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountNumber(String value) {
        this.accountNumber = value;
    }

    /**
     * Gets the value of the chequeBookType property.
     * 
     */
    public long getChequeBookType() {
        return chequeBookType;
    }

    /**
     * Sets the value of the chequeBookType property.
     * 
     */
    public void setChequeBookType(long value) {
        this.chequeBookType = value;
    }

    /**
     * Gets the value of the chequeBookTypeCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChequeBookTypeCd() {
        return chequeBookTypeCd;
    }

    /**
     * Sets the value of the chequeBookTypeCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChequeBookTypeCd(String value) {
        this.chequeBookTypeCd = value;
    }

    /**
     * Gets the value of the customerAddressId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomerAddressId() {
        return customerAddressId;
    }

    /**
     * Sets the value of the customerAddressId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomerAddressId(Long value) {
        this.customerAddressId = value;
    }

    /**
     * Gets the value of the customerName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the value of the customerName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerName(String value) {
        this.customerName = value;
    }

    /**
     * Gets the value of the customerNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerNumber() {
        return customerNumber;
    }

    /**
     * Sets the value of the customerNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerNumber(String value) {
        this.customerNumber = value;
    }

    /**
     * Gets the value of the deliveryAddressId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDeliveryAddressId() {
        return deliveryAddressId;
    }

    /**
     * Sets the value of the deliveryAddressId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDeliveryAddressId(Long value) {
        this.deliveryAddressId = value;
    }

    /**
     * Gets the value of the deliveryInstruction property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryInstruction() {
        return deliveryInstruction;
    }

    /**
     * Sets the value of the deliveryInstruction property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryInstruction(String value) {
        this.deliveryInstruction = value;
    }

    /**
     * Gets the value of the deliveryMethodId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeliveryMethodId() {
        return deliveryMethodId;
    }

    /**
     * Sets the value of the deliveryMethodId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeliveryMethodId(String value) {
        this.deliveryMethodId = value;
    }

    /**
     * Gets the value of the noOfChequeBooks property.
     * 
     */
    public int getNoOfChequeBooks() {
        return noOfChequeBooks;
    }

    /**
     * Sets the value of the noOfChequeBooks property.
     * 
     */
    public void setNoOfChequeBooks(int value) {
        this.noOfChequeBooks = value;
    }

    /**
     * Gets the value of the productChequeBookId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProductChequeBookId() {
        return productChequeBookId;
    }

    /**
     * Sets the value of the productChequeBookId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProductChequeBookId(Long value) {
        this.productChequeBookId = value;
    }

    /**
     * Gets the value of the reorderLevelId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReorderLevelId() {
        return reorderLevelId;
    }

    /**
     * Sets the value of the reorderLevelId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReorderLevelId(String value) {
        this.reorderLevelId = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

}
