//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.01.31 at 02:19:01 PM WAT 
//


package com.neptunesoftware.accelerex.data.customer;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerDataRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="customerDataRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="answerDataField" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="answerDataType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="answerSrc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="answerSrcType" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="dataComponent" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="noOfCharacters" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="quizCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerDataRequest", namespace = "http://data.customer.server.ws.supernova.neptunesoftware.com/", propOrder = {
        "answerDataField",
        "answerDataType",
        "answerSrc",
        "answerSrcType",
        "customerId",
        "dataComponent",
        "noOfCharacters",
        "quizCode"
})
public class CustomerDataRequest
        extends XAPIRequestBaseObject {

    protected String answerDataField;
    protected String answerDataType;
    protected String answerSrc;
    protected Long answerSrcType;
    protected Long customerId;
    protected String dataComponent;
    protected Long noOfCharacters;
    protected String quizCode;

    /**
     * Gets the value of the answerDataField property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAnswerDataField() {
        return answerDataField;
    }

    /**
     * Sets the value of the answerDataField property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAnswerDataField(String value) {
        this.answerDataField = value;
    }

    /**
     * Gets the value of the answerDataType property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAnswerDataType() {
        return answerDataType;
    }

    /**
     * Sets the value of the answerDataType property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAnswerDataType(String value) {
        this.answerDataType = value;
    }

    /**
     * Gets the value of the answerSrc property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getAnswerSrc() {
        return answerSrc;
    }

    /**
     * Sets the value of the answerSrc property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setAnswerSrc(String value) {
        this.answerSrc = value;
    }

    /**
     * Gets the value of the answerSrcType property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getAnswerSrcType() {
        return answerSrcType;
    }

    /**
     * Sets the value of the answerSrcType property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setAnswerSrcType(Long value) {
        this.answerSrcType = value;
    }

    /**
     * Gets the value of the customerId property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setCustomerId(Long value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the dataComponent property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getDataComponent() {
        return dataComponent;
    }

    /**
     * Sets the value of the dataComponent property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setDataComponent(String value) {
        this.dataComponent = value;
    }

    /**
     * Gets the value of the noOfCharacters property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getNoOfCharacters() {
        return noOfCharacters;
    }

    /**
     * Sets the value of the noOfCharacters property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setNoOfCharacters(Long value) {
        this.noOfCharacters = value;
    }

    /**
     * Gets the value of the quizCode property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getQuizCode() {
        return quizCode;
    }

    /**
     * Sets the value of the quizCode property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setQuizCode(String value) {
        this.quizCode = value;
    }

}
