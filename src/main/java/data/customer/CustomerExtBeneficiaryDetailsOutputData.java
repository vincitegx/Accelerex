//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 09:40:38 AM WAT 
//


package data.customer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for customerExtBeneficiaryDetailsOutputData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="customerExtBeneficiaryDetailsOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://data.customer.server.ws.supernova.neptunesoftware.com/}customerBasicInformation"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="beneficiaryAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddr1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddr2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddr3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddr4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBankTelNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBranchCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBranchCountry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBranchCountryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBranchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryTelNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="supplementaryInstr" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customerExtBeneficiaryDetailsOutputData", namespace = "http://data.customer.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "beneficiaryAccountNumber",
    "beneficiaryAddr1",
    "beneficiaryAddr2",
    "beneficiaryAddr3",
    "beneficiaryAddr4",
    "beneficiaryBankCode",
    "beneficiaryBankName",
    "beneficiaryBankTelNumber",
    "beneficiaryBranchCity",
    "beneficiaryBranchCountry",
    "beneficiaryBranchCountryId",
    "beneficiaryBranchName",
    "beneficiaryId",
    "beneficiaryName",
    "beneficiaryTelNumber",
    "customerId",
    "supplementaryInstr"
})
public class CustomerExtBeneficiaryDetailsOutputData
    extends CustomerBasicInformation
{

    protected String beneficiaryAccountNumber;
    protected String beneficiaryAddr1;
    protected String beneficiaryAddr2;
    protected String beneficiaryAddr3;
    protected String beneficiaryAddr4;
    protected String beneficiaryBankCode;
    protected String beneficiaryBankName;
    protected String beneficiaryBankTelNumber;
    protected String beneficiaryBranchCity;
    protected String beneficiaryBranchCountry;
    protected Long beneficiaryBranchCountryId;
    protected String beneficiaryBranchName;
    protected Long beneficiaryId;
    protected String beneficiaryName;
    protected String beneficiaryTelNumber;
    protected Long customerId;
    protected String supplementaryInstr;

    /**
     * Gets the value of the beneficiaryAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    /**
     * Sets the value of the beneficiaryAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAccountNumber(String value) {
        this.beneficiaryAccountNumber = value;
    }

    /**
     * Gets the value of the beneficiaryAddr1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddr1() {
        return beneficiaryAddr1;
    }

    /**
     * Sets the value of the beneficiaryAddr1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddr1(String value) {
        this.beneficiaryAddr1 = value;
    }

    /**
     * Gets the value of the beneficiaryAddr2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddr2() {
        return beneficiaryAddr2;
    }

    /**
     * Sets the value of the beneficiaryAddr2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddr2(String value) {
        this.beneficiaryAddr2 = value;
    }

    /**
     * Gets the value of the beneficiaryAddr3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddr3() {
        return beneficiaryAddr3;
    }

    /**
     * Sets the value of the beneficiaryAddr3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddr3(String value) {
        this.beneficiaryAddr3 = value;
    }

    /**
     * Gets the value of the beneficiaryAddr4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddr4() {
        return beneficiaryAddr4;
    }

    /**
     * Sets the value of the beneficiaryAddr4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddr4(String value) {
        this.beneficiaryAddr4 = value;
    }

    /**
     * Gets the value of the beneficiaryBankCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryBankCode() {
        return beneficiaryBankCode;
    }

    /**
     * Sets the value of the beneficiaryBankCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryBankCode(String value) {
        this.beneficiaryBankCode = value;
    }

    /**
     * Gets the value of the beneficiaryBankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryBankName() {
        return beneficiaryBankName;
    }

    /**
     * Sets the value of the beneficiaryBankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryBankName(String value) {
        this.beneficiaryBankName = value;
    }

    /**
     * Gets the value of the beneficiaryBankTelNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryBankTelNumber() {
        return beneficiaryBankTelNumber;
    }

    /**
     * Sets the value of the beneficiaryBankTelNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryBankTelNumber(String value) {
        this.beneficiaryBankTelNumber = value;
    }

    /**
     * Gets the value of the beneficiaryBranchCity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryBranchCity() {
        return beneficiaryBranchCity;
    }

    /**
     * Sets the value of the beneficiaryBranchCity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryBranchCity(String value) {
        this.beneficiaryBranchCity = value;
    }

    /**
     * Gets the value of the beneficiaryBranchCountry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryBranchCountry() {
        return beneficiaryBranchCountry;
    }

    /**
     * Sets the value of the beneficiaryBranchCountry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryBranchCountry(String value) {
        this.beneficiaryBranchCountry = value;
    }

    /**
     * Gets the value of the beneficiaryBranchCountryId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBeneficiaryBranchCountryId() {
        return beneficiaryBranchCountryId;
    }

    /**
     * Sets the value of the beneficiaryBranchCountryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBeneficiaryBranchCountryId(Long value) {
        this.beneficiaryBranchCountryId = value;
    }

    /**
     * Gets the value of the beneficiaryBranchName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryBranchName() {
        return beneficiaryBranchName;
    }

    /**
     * Sets the value of the beneficiaryBranchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryBranchName(String value) {
        this.beneficiaryBranchName = value;
    }

    /**
     * Gets the value of the beneficiaryId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBeneficiaryId() {
        return beneficiaryId;
    }

    /**
     * Sets the value of the beneficiaryId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBeneficiaryId(Long value) {
        this.beneficiaryId = value;
    }

    /**
     * Gets the value of the beneficiaryName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryName() {
        return beneficiaryName;
    }

    /**
     * Sets the value of the beneficiaryName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryName(String value) {
        this.beneficiaryName = value;
    }

    /**
     * Gets the value of the beneficiaryTelNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryTelNumber() {
        return beneficiaryTelNumber;
    }

    /**
     * Sets the value of the beneficiaryTelNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryTelNumber(String value) {
        this.beneficiaryTelNumber = value;
    }

    /**
     * Gets the value of the customerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCustomerId(Long value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the supplementaryInstr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSupplementaryInstr() {
        return supplementaryInstr;
    }

    /**
     * Sets the value of the supplementaryInstr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSupplementaryInstr(String value) {
        this.supplementaryInstr = value;
    }

}
