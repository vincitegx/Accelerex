//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.04 at 10:57:41 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for applicationImageResponseData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="applicationImageResponseData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="availableImagetypesListOutputArrayData" type="{http://data.refglobal.server.ws.supernova.neptunesoftware.com/}genericPickListOutputData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="binaryImage" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0"/&gt;
 *         &lt;element name="channelParamValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="imageDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="imageId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="imageTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="imageTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="imageXrefListOutputArrayData" type="{http://data.refglobal.server.ws.supernova.neptunesoftware.com/}genericPickListOutputData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *         &lt;element name="parentObjectReference" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="parentObjectType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "applicationImageResponseData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "availableImagetypesListOutputArrayData",
    "binaryImage",
    "channelParamValue",
    "imageDescription",
    "imageId",
    "imageTypeCode",
    "imageTypeId",
    "imageXrefListOutputArrayData",
    "parentObjectReference",
    "parentObjectType",
    "status"
})
public class ApplicationImageResponseData {

    @XmlElement(nillable = true)
    protected List<GenericPickListOutputData> availableImagetypesListOutputArrayData;
    protected byte[] binaryImage;
    protected String channelParamValue;
    protected String imageDescription;
    protected Long imageId;
    protected String imageTypeCode;
    protected Long imageTypeId;
    @XmlElement(nillable = true)
    protected List<GenericPickListOutputData> imageXrefListOutputArrayData;
    protected Long parentObjectReference;
    protected String parentObjectType;
    protected String status;

    /**
     * Gets the value of the availableImagetypesListOutputArrayData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the availableImagetypesListOutputArrayData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAvailableImagetypesListOutputArrayData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericPickListOutputData }
     * 
     * 
     */
    public List<GenericPickListOutputData> getAvailableImagetypesListOutputArrayData() {
        if (availableImagetypesListOutputArrayData == null) {
            availableImagetypesListOutputArrayData = new ArrayList<GenericPickListOutputData>();
        }
        return this.availableImagetypesListOutputArrayData;
    }

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
     * Gets the value of the channelParamValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChannelParamValue() {
        return channelParamValue;
    }

    /**
     * Sets the value of the channelParamValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChannelParamValue(String value) {
        this.channelParamValue = value;
    }

    /**
     * Gets the value of the imageDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageDescription() {
        return imageDescription;
    }

    /**
     * Sets the value of the imageDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageDescription(String value) {
        this.imageDescription = value;
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

    /**
     * Gets the value of the imageTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getImageTypeId() {
        return imageTypeId;
    }

    /**
     * Sets the value of the imageTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setImageTypeId(Long value) {
        this.imageTypeId = value;
    }

    /**
     * Gets the value of the imageXrefListOutputArrayData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the imageXrefListOutputArrayData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImageXrefListOutputArrayData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link GenericPickListOutputData }
     * 
     * 
     */
    public List<GenericPickListOutputData> getImageXrefListOutputArrayData() {
        if (imageXrefListOutputArrayData == null) {
            imageXrefListOutputArrayData = new ArrayList<GenericPickListOutputData>();
        }
        return this.imageXrefListOutputArrayData;
    }

    /**
     * Gets the value of the parentObjectReference property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getParentObjectReference() {
        return parentObjectReference;
    }

    /**
     * Sets the value of the parentObjectReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setParentObjectReference(Long value) {
        this.parentObjectReference = value;
    }

    /**
     * Gets the value of the parentObjectType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParentObjectType() {
        return parentObjectType;
    }

    /**
     * Sets the value of the parentObjectType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParentObjectType(String value) {
        this.parentObjectType = value;
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
