//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.06.19 at 09:43:48 AM WAT 
//


package data.account;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for creditFacilityApplnRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="creditFacilityApplnRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="applAvailableAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="applicationDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="applnAddressData" type="{http://data.account.server.ws.supernova.neptunesoftware.com/}applicationAddressRequestData" minOccurs="0"/&gt;
 *         &lt;element name="applnContactData" type="{http://data.account.server.ws.supernova.neptunesoftware.com/}applicationContactInfoRequestData" minOccurs="0"/&gt;
 *         &lt;element name="applnDocumentData" type="{http://data.account.server.ws.supernova.neptunesoftware.com/}applicationDocumentRequestData" minOccurs="0"/&gt;
 *         &lt;element name="applnIdenticationData" type="{http://data.account.server.ws.supernova.neptunesoftware.com/}applicationIdentificationRequestData" minOccurs="0"/&gt;
 *         &lt;element name="applnImageData" type="{http://data.account.server.ws.supernova.neptunesoftware.com/}applicationImageRequestData" minOccurs="0"/&gt;
 *         &lt;element name="approvedAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="approvedCrncyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="approvedCurrencyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="approvedTermCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="approvedTermValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="bankOfficerCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="bankOfficerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="buId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="creditPortfolioId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="creditReasonCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="creditTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="creditTypeId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="creditUtilMethodCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="crncyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="currencyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="customerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="depositAcctId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="portFolioCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="processType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="productCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="productCombinationOption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="productId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="purposeOfCreditId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="repayAcctNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="repaySourceAcctId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="requiredAmtCrncyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="requiredDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strApplicationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strApprovedStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strRequiredDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="termCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="termValue" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "creditFacilityApplnRequestData", namespace = "http://data.creditapp.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "applAvailableAmount",
    "applicationDate",
    "applnAddressData",
    "applnContactData",
    "applnDocumentData",
    "applnIdenticationData",
    "applnImageData",
    "approvedAmount",
    "approvedCrncyCd",
    "approvedCurrencyId",
    "approvedTermCode",
    "approvedTermValue",
    "bankOfficerCd",
    "bankOfficerId",
    "buId",
    "creditPortfolioId",
    "creditReasonCd",
    "creditTypeCode",
    "creditTypeId",
    "creditUtilMethodCode",
    "crncyCd",
    "currencyId",
    "customerId",
    "customerNumber",
    "depositAcctId",
    "portFolioCd",
    "processType",
    "productCode",
    "productCombinationOption",
    "productId",
    "purposeOfCreditId",
    "repayAcctNo",
    "repaySourceAcctId",
    "requiredAmtCrncyCd",
    "requiredDate",
    "status",
    "strApplicationDate",
    "strApprovedStartDate",
    "strExpiryDate",
    "strRequiredDate",
    "termCode",
    "termValue"
})
public class CreditFacilityApplnRequestData
    extends XAPIRequestBaseObject
{

    protected BigDecimal applAvailableAmount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar applicationDate;
    protected ApplicationAddressRequestData applnAddressData;
    protected ApplicationContactInfoRequestData applnContactData;
    protected ApplicationDocumentRequestData applnDocumentData;
    protected ApplicationIdentificationRequestData applnIdenticationData;
    protected ApplicationImageRequestData applnImageData;
    protected BigDecimal approvedAmount;
    protected String approvedCrncyCd;
    protected Long approvedCurrencyId;
    protected String approvedTermCode;
    protected Long approvedTermValue;
    protected String bankOfficerCd;
    protected Long bankOfficerId;
    protected Long buId;
    protected Long creditPortfolioId;
    protected String creditReasonCd;
    protected String creditTypeCode;
    protected Long creditTypeId;
    protected String creditUtilMethodCode;
    protected String crncyCd;
    protected Long currencyId;
    protected Long customerId;
    protected String customerNumber;
    protected Long depositAcctId;
    protected String portFolioCd;
    protected String processType;
    protected String productCode;
    protected String productCombinationOption;
    protected Long productId;
    protected Long purposeOfCreditId;
    protected String repayAcctNo;
    protected Long repaySourceAcctId;
    protected String requiredAmtCrncyCd;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar requiredDate;
    protected String status;
    protected String strApplicationDate;
    protected String strApprovedStartDate;
    protected String strExpiryDate;
    protected String strRequiredDate;
    protected String termCode;
    protected Long termValue;

    /**
     * Gets the value of the applAvailableAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getApplAvailableAmount() {
        return applAvailableAmount;
    }

    /**
     * Sets the value of the applAvailableAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setApplAvailableAmount(BigDecimal value) {
        this.applAvailableAmount = value;
    }

    /**
     * Gets the value of the applicationDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getApplicationDate() {
        return applicationDate;
    }

    /**
     * Sets the value of the applicationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setApplicationDate(XMLGregorianCalendar value) {
        this.applicationDate = value;
    }

    /**
     * Gets the value of the applnAddressData property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationAddressRequestData }
     *     
     */
    public ApplicationAddressRequestData getApplnAddressData() {
        return applnAddressData;
    }

    /**
     * Sets the value of the applnAddressData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationAddressRequestData }
     *     
     */
    public void setApplnAddressData(ApplicationAddressRequestData value) {
        this.applnAddressData = value;
    }

    /**
     * Gets the value of the applnContactData property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationContactInfoRequestData }
     *     
     */
    public ApplicationContactInfoRequestData getApplnContactData() {
        return applnContactData;
    }

    /**
     * Sets the value of the applnContactData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationContactInfoRequestData }
     *     
     */
    public void setApplnContactData(ApplicationContactInfoRequestData value) {
        this.applnContactData = value;
    }

    /**
     * Gets the value of the applnDocumentData property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationDocumentRequestData }
     *     
     */
    public ApplicationDocumentRequestData getApplnDocumentData() {
        return applnDocumentData;
    }

    /**
     * Sets the value of the applnDocumentData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationDocumentRequestData }
     *     
     */
    public void setApplnDocumentData(ApplicationDocumentRequestData value) {
        this.applnDocumentData = value;
    }

    /**
     * Gets the value of the applnIdenticationData property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationIdentificationRequestData }
     *     
     */
    public ApplicationIdentificationRequestData getApplnIdenticationData() {
        return applnIdenticationData;
    }

    /**
     * Sets the value of the applnIdenticationData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationIdentificationRequestData }
     *     
     */
    public void setApplnIdenticationData(ApplicationIdentificationRequestData value) {
        this.applnIdenticationData = value;
    }

    /**
     * Gets the value of the applnImageData property.
     * 
     * @return
     *     possible object is
     *     {@link ApplicationImageRequestData }
     *     
     */
    public ApplicationImageRequestData getApplnImageData() {
        return applnImageData;
    }

    /**
     * Sets the value of the applnImageData property.
     * 
     * @param value
     *     allowed object is
     *     {@link ApplicationImageRequestData }
     *     
     */
    public void setApplnImageData(ApplicationImageRequestData value) {
        this.applnImageData = value;
    }

    /**
     * Gets the value of the approvedAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getApprovedAmount() {
        return approvedAmount;
    }

    /**
     * Sets the value of the approvedAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setApprovedAmount(BigDecimal value) {
        this.approvedAmount = value;
    }

    /**
     * Gets the value of the approvedCrncyCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovedCrncyCd() {
        return approvedCrncyCd;
    }

    /**
     * Sets the value of the approvedCrncyCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovedCrncyCd(String value) {
        this.approvedCrncyCd = value;
    }

    /**
     * Gets the value of the approvedCurrencyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getApprovedCurrencyId() {
        return approvedCurrencyId;
    }

    /**
     * Sets the value of the approvedCurrencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setApprovedCurrencyId(Long value) {
        this.approvedCurrencyId = value;
    }

    /**
     * Gets the value of the approvedTermCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getApprovedTermCode() {
        return approvedTermCode;
    }

    /**
     * Sets the value of the approvedTermCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setApprovedTermCode(String value) {
        this.approvedTermCode = value;
    }

    /**
     * Gets the value of the approvedTermValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getApprovedTermValue() {
        return approvedTermValue;
    }

    /**
     * Sets the value of the approvedTermValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setApprovedTermValue(Long value) {
        this.approvedTermValue = value;
    }

    /**
     * Gets the value of the bankOfficerCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankOfficerCd() {
        return bankOfficerCd;
    }

    /**
     * Sets the value of the bankOfficerCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankOfficerCd(String value) {
        this.bankOfficerCd = value;
    }

    /**
     * Gets the value of the bankOfficerId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBankOfficerId() {
        return bankOfficerId;
    }

    /**
     * Sets the value of the bankOfficerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBankOfficerId(Long value) {
        this.bankOfficerId = value;
    }

    /**
     * Gets the value of the buId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getBuId() {
        return buId;
    }

    /**
     * Sets the value of the buId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setBuId(Long value) {
        this.buId = value;
    }

    /**
     * Gets the value of the creditPortfolioId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreditPortfolioId() {
        return creditPortfolioId;
    }

    /**
     * Sets the value of the creditPortfolioId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreditPortfolioId(Long value) {
        this.creditPortfolioId = value;
    }

    /**
     * Gets the value of the creditReasonCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditReasonCd() {
        return creditReasonCd;
    }

    /**
     * Sets the value of the creditReasonCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditReasonCd(String value) {
        this.creditReasonCd = value;
    }

    /**
     * Gets the value of the creditTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditTypeCode() {
        return creditTypeCode;
    }

    /**
     * Sets the value of the creditTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditTypeCode(String value) {
        this.creditTypeCode = value;
    }

    /**
     * Gets the value of the creditTypeId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCreditTypeId() {
        return creditTypeId;
    }

    /**
     * Sets the value of the creditTypeId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCreditTypeId(Long value) {
        this.creditTypeId = value;
    }

    /**
     * Gets the value of the creditUtilMethodCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditUtilMethodCode() {
        return creditUtilMethodCode;
    }

    /**
     * Sets the value of the creditUtilMethodCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditUtilMethodCode(String value) {
        this.creditUtilMethodCode = value;
    }

    /**
     * Gets the value of the crncyCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCrncyCd() {
        return crncyCd;
    }

    /**
     * Sets the value of the crncyCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCrncyCd(String value) {
        this.crncyCd = value;
    }

    /**
     * Gets the value of the currencyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCurrencyId() {
        return currencyId;
    }

    /**
     * Sets the value of the currencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCurrencyId(Long value) {
        this.currencyId = value;
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
     * Gets the value of the depositAcctId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getDepositAcctId() {
        return depositAcctId;
    }

    /**
     * Sets the value of the depositAcctId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setDepositAcctId(Long value) {
        this.depositAcctId = value;
    }

    /**
     * Gets the value of the portFolioCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPortFolioCd() {
        return portFolioCd;
    }

    /**
     * Sets the value of the portFolioCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPortFolioCd(String value) {
        this.portFolioCd = value;
    }

    /**
     * Gets the value of the processType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessType() {
        return processType;
    }

    /**
     * Sets the value of the processType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessType(String value) {
        this.processType = value;
    }

    /**
     * Gets the value of the productCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Gets the value of the productCombinationOption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCombinationOption() {
        return productCombinationOption;
    }

    /**
     * Sets the value of the productCombinationOption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCombinationOption(String value) {
        this.productCombinationOption = value;
    }

    /**
     * Gets the value of the productId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getProductId() {
        return productId;
    }

    /**
     * Sets the value of the productId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setProductId(Long value) {
        this.productId = value;
    }

    /**
     * Gets the value of the purposeOfCreditId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPurposeOfCreditId() {
        return purposeOfCreditId;
    }

    /**
     * Sets the value of the purposeOfCreditId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPurposeOfCreditId(Long value) {
        this.purposeOfCreditId = value;
    }

    /**
     * Gets the value of the repayAcctNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRepayAcctNo() {
        return repayAcctNo;
    }

    /**
     * Sets the value of the repayAcctNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRepayAcctNo(String value) {
        this.repayAcctNo = value;
    }

    /**
     * Gets the value of the repaySourceAcctId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRepaySourceAcctId() {
        return repaySourceAcctId;
    }

    /**
     * Sets the value of the repaySourceAcctId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRepaySourceAcctId(Long value) {
        this.repaySourceAcctId = value;
    }

    /**
     * Gets the value of the requiredAmtCrncyCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRequiredAmtCrncyCd() {
        return requiredAmtCrncyCd;
    }

    /**
     * Sets the value of the requiredAmtCrncyCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRequiredAmtCrncyCd(String value) {
        this.requiredAmtCrncyCd = value;
    }

    /**
     * Gets the value of the requiredDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getRequiredDate() {
        return requiredDate;
    }

    /**
     * Sets the value of the requiredDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setRequiredDate(XMLGregorianCalendar value) {
        this.requiredDate = value;
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
     * Gets the value of the strApplicationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrApplicationDate() {
        return strApplicationDate;
    }

    /**
     * Sets the value of the strApplicationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrApplicationDate(String value) {
        this.strApplicationDate = value;
    }

    /**
     * Gets the value of the strApprovedStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrApprovedStartDate() {
        return strApprovedStartDate;
    }

    /**
     * Sets the value of the strApprovedStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrApprovedStartDate(String value) {
        this.strApprovedStartDate = value;
    }

    /**
     * Gets the value of the strExpiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrExpiryDate() {
        return strExpiryDate;
    }

    /**
     * Sets the value of the strExpiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrExpiryDate(String value) {
        this.strExpiryDate = value;
    }

    /**
     * Gets the value of the strRequiredDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrRequiredDate() {
        return strRequiredDate;
    }

    /**
     * Sets the value of the strRequiredDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrRequiredDate(String value) {
        this.strRequiredDate = value;
    }

    /**
     * Gets the value of the termCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermCode() {
        return termCode;
    }

    /**
     * Sets the value of the termCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermCode(String value) {
        this.termCode = value;
    }

    /**
     * Gets the value of the termValue property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTermValue() {
        return termValue;
    }

    /**
     * Sets the value of the termValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTermValue(Long value) {
        this.termValue = value;
    }

}