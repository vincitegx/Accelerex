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
 * <p>Java class for customerImageInformation complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerImageInformation"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="binaryImage" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="biometricImage" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="customerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="imageId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="imageType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="imageTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerImageInformation", namespace = "http://data.customer.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "binaryImage",
    "biometricImage",
    "customerName",
    "customerNumber",
    "imageId",
    "imageType",
    "imageTypeCode"
})
public class CustomerImageInformation {

    protected byte[] binaryImage;
    protected byte[] biometricImage;
    protected String customerName;
    protected String customerNumber;
    protected Long imageId;
    protected String imageType;
    protected String imageTypeCode;

    /**
     * Gets the value of the binaryImage property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBinaryImage() {
        return binaryImage;
    }

    /**
     * Sets the value of the binaryImage property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBinaryImage(byte[] value) {
        this.binaryImage = value;
    }

    /**
     * Gets the value of the biometricImage property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getBiometricImage() {
        return biometricImage;
    }

    /**
     * Sets the value of the biometricImage property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setBiometricImage(byte[] value) {
        this.biometricImage = value;
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
     * Gets the value of the imageId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getImageId() {
        return imageId;
    }

    /**
     * Sets the value of the imageId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setImageId(Long value) {
        this.imageId = value;
    }

    /**
     * Gets the value of the imageType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageType() {
        return imageType;
    }

    /**
     * Sets the value of the imageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageType(String value) {
        this.imageType = value;
    }

    /**
     * Gets the value of the imageTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageTypeCode() {
        return imageTypeCode;
    }

    /**
     * Sets the value of the imageTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageTypeCode(String value) {
        this.imageTypeCode = value;
    }

}
