//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 02:48:50 PM WAT 
//


package data.FundTransfer;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for sweepFundsTransferRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sweepFundsTransferRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountSweepId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="bankCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="bankName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddrLine1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddrLine2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddrLine3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryAddrLine4" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryBranchCity" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="beneficiaryName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="branchName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="externalAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fundTransferType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="glAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="maxBalance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="minimumBalance" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="minimumXferAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="recipientType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="serviceProvider" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sourceAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strNextTransferDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sweepAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sweepEndDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="sweepFrequencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="sweepFrequencyValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="sweepStartDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="sweepTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="toAccountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="transferReason" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="xapiServiceCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sweepFundsTransferRequestData", namespace = "http://data.transfer.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "accountSweepId",
    "bankCode",
    "bankName",
    "beneficiaryAddrLine1",
    "beneficiaryAddrLine2",
    "beneficiaryAddrLine3",
    "beneficiaryAddrLine4",
    "beneficiaryBranchCity",
    "beneficiaryName",
    "branchName",
    "externalAccountNo",
    "fundTransferType",
    "glAccountNumber",
    "maxBalance",
    "minimumBalance",
    "minimumXferAmount",
    "recipientType",
    "serviceProvider",
    "sourceAccountNo",
    "status",
    "strNextTransferDate",
    "sweepAccountNumber",
    "sweepEndDate",
    "sweepFrequencyCode",
    "sweepFrequencyValue",
    "sweepStartDate",
    "sweepTypeCode",
    "toAccountNumber",
    "transferReason",
    "xapiServiceCode"
})
public class SweepFundsTransferRequestData
    extends XAPIRequestBaseObject
{

    protected Long accountSweepId;
    protected String bankCode;
    protected String bankName;
    protected String beneficiaryAddrLine1;
    protected String beneficiaryAddrLine2;
    protected String beneficiaryAddrLine3;
    protected String beneficiaryAddrLine4;
    protected String beneficiaryBranchCity;
    protected String beneficiaryName;
    protected String branchName;
    protected String externalAccountNo;
    protected String fundTransferType;
    protected String glAccountNumber;
    protected BigDecimal maxBalance;
    protected BigDecimal minimumBalance;
    protected BigDecimal minimumXferAmount;
    protected String recipientType;
    protected String serviceProvider;
    protected String sourceAccountNo;
    protected String status;
    protected String strNextTransferDate;
    protected String sweepAccountNumber;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar sweepEndDate;
    protected String sweepFrequencyCode;
    protected Long sweepFrequencyValue;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar sweepStartDate;
    protected String sweepTypeCode;
    protected String toAccountNumber;
    protected String transferReason;
    protected String xapiServiceCode;

    /**
     * Gets the value of the accountSweepId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getAccountSweepId() {
        return accountSweepId;
    }

    /**
     * Sets the value of the accountSweepId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setAccountSweepId(Long value) {
        this.accountSweepId = value;
    }

    /**
     * Gets the value of the bankCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankCode() {
        return bankCode;
    }

    /**
     * Sets the value of the bankCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankCode(String value) {
        this.bankCode = value;
    }

    /**
     * Gets the value of the bankName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * Sets the value of the bankName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankName(String value) {
        this.bankName = value;
    }

    /**
     * Gets the value of the beneficiaryAddrLine1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddrLine1() {
        return beneficiaryAddrLine1;
    }

    /**
     * Sets the value of the beneficiaryAddrLine1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddrLine1(String value) {
        this.beneficiaryAddrLine1 = value;
    }

    /**
     * Gets the value of the beneficiaryAddrLine2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddrLine2() {
        return beneficiaryAddrLine2;
    }

    /**
     * Sets the value of the beneficiaryAddrLine2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddrLine2(String value) {
        this.beneficiaryAddrLine2 = value;
    }

    /**
     * Gets the value of the beneficiaryAddrLine3 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddrLine3() {
        return beneficiaryAddrLine3;
    }

    /**
     * Sets the value of the beneficiaryAddrLine3 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddrLine3(String value) {
        this.beneficiaryAddrLine3 = value;
    }

    /**
     * Gets the value of the beneficiaryAddrLine4 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAddrLine4() {
        return beneficiaryAddrLine4;
    }

    /**
     * Sets the value of the beneficiaryAddrLine4 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAddrLine4(String value) {
        this.beneficiaryAddrLine4 = value;
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
     * Gets the value of the branchName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBranchName() {
        return branchName;
    }

    /**
     * Sets the value of the branchName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBranchName(String value) {
        this.branchName = value;
    }

    /**
     * Gets the value of the externalAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExternalAccountNo() {
        return externalAccountNo;
    }

    /**
     * Sets the value of the externalAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExternalAccountNo(String value) {
        this.externalAccountNo = value;
    }

    /**
     * Gets the value of the fundTransferType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFundTransferType() {
        return fundTransferType;
    }

    /**
     * Sets the value of the fundTransferType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFundTransferType(String value) {
        this.fundTransferType = value;
    }

    /**
     * Gets the value of the glAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlAccountNumber() {
        return glAccountNumber;
    }

    /**
     * Sets the value of the glAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlAccountNumber(String value) {
        this.glAccountNumber = value;
    }

    /**
     * Gets the value of the maxBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMaxBalance() {
        return maxBalance;
    }

    /**
     * Sets the value of the maxBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMaxBalance(BigDecimal value) {
        this.maxBalance = value;
    }

    /**
     * Gets the value of the minimumBalance property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    /**
     * Sets the value of the minimumBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinimumBalance(BigDecimal value) {
        this.minimumBalance = value;
    }

    /**
     * Gets the value of the minimumXferAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getMinimumXferAmount() {
        return minimumXferAmount;
    }

    /**
     * Sets the value of the minimumXferAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setMinimumXferAmount(BigDecimal value) {
        this.minimumXferAmount = value;
    }

    /**
     * Gets the value of the recipientType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRecipientType() {
        return recipientType;
    }

    /**
     * Sets the value of the recipientType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRecipientType(String value) {
        this.recipientType = value;
    }

    /**
     * Gets the value of the serviceProvider property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getServiceProvider() {
        return serviceProvider;
    }

    /**
     * Sets the value of the serviceProvider property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setServiceProvider(String value) {
        this.serviceProvider = value;
    }

    /**
     * Gets the value of the sourceAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceAccountNo() {
        return sourceAccountNo;
    }

    /**
     * Sets the value of the sourceAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceAccountNo(String value) {
        this.sourceAccountNo = value;
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

    /**
     * Gets the value of the strNextTransferDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNextTransferDate() {
        return strNextTransferDate;
    }

    /**
     * Sets the value of the strNextTransferDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNextTransferDate(String value) {
        this.strNextTransferDate = value;
    }

    /**
     * Gets the value of the sweepAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSweepAccountNumber() {
        return sweepAccountNumber;
    }

    /**
     * Sets the value of the sweepAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSweepAccountNumber(String value) {
        this.sweepAccountNumber = value;
    }

    /**
     * Gets the value of the sweepEndDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSweepEndDate() {
        return sweepEndDate;
    }

    /**
     * Sets the value of the sweepEndDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSweepEndDate(XMLGregorianCalendar value) {
        this.sweepEndDate = value;
    }

    /**
     * Gets the value of the sweepFrequencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSweepFrequencyCode() {
        return sweepFrequencyCode;
    }

    /**
     * Sets the value of the sweepFrequencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSweepFrequencyCode(String value) {
        this.sweepFrequencyCode = value;
    }

    /**
     * Gets the value of the sweepFrequencyValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getSweepFrequencyValue() {
        return sweepFrequencyValue;
    }

    /**
     * Sets the value of the sweepFrequencyValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setSweepFrequencyValue(Long value) {
        this.sweepFrequencyValue = value;
    }

    /**
     * Gets the value of the sweepStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSweepStartDate() {
        return sweepStartDate;
    }

    /**
     * Sets the value of the sweepStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSweepStartDate(XMLGregorianCalendar value) {
        this.sweepStartDate = value;
    }

    /**
     * Gets the value of the sweepTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSweepTypeCode() {
        return sweepTypeCode;
    }

    /**
     * Sets the value of the sweepTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSweepTypeCode(String value) {
        this.sweepTypeCode = value;
    }

    /**
     * Gets the value of the toAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToAccountNumber() {
        return toAccountNumber;
    }

    /**
     * Sets the value of the toAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToAccountNumber(String value) {
        this.toAccountNumber = value;
    }

    /**
     * Gets the value of the transferReason property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferReason() {
        return transferReason;
    }

    /**
     * Sets the value of the transferReason property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferReason(String value) {
        this.transferReason = value;
    }

    /**
     * Gets the value of the xapiServiceCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getXapiServiceCode() {
        return xapiServiceCode;
    }

    /**
     * Sets the value of the xapiServiceCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setXapiServiceCode(String value) {
        this.xapiServiceCode = value;
    }

}
