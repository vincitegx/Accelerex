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
 * <p>Java class for transactionInquiryRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transactionInquiryRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="createDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="drCrFg" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="fromDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="lowerTxnDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="passBookUpdated" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="productCat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="requestDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="stmtTyp" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="toDate" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="txnCurrencyCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="txnDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="txnJournalId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="txnTypeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="txnUserId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="upperTxnDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transactionInquiryRequest", namespace = "http://data.transaction.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "accountNumber",
    "createDate",
    "drCrFg",
    "fromDate",
    "lowerTxnDate",
    "passBookUpdated",
    "productCat",
    "requestDate",
    "stmtTyp",
    "toDate",
    "txnCurrencyCode",
    "txnDate",
    "txnJournalId",
    "txnTypeCode",
    "txnUserId",
    "upperTxnDate"
})
public class TransactionInquiryRequest
    extends XAPIRequestBaseObject
{

    protected String accountNumber;
    protected String createDate;
    protected String drCrFg;
    protected Long fromDate;
    protected String lowerTxnDate;
    protected String passBookUpdated;
    protected String productCat;
    protected Long requestDate;
    protected String stmtTyp;
    protected Long toDate;
    protected String txnCurrencyCode;
    protected String txnDate;
    protected Long txnJournalId;
    protected String txnTypeCode;
    protected Long txnUserId;
    protected String upperTxnDate;

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
     * Gets the value of the createDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * Sets the value of the createDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreateDate(String value) {
        this.createDate = value;
    }

    /**
     * Gets the value of the drCrFg property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrCrFg() {
        return drCrFg;
    }

    /**
     * Sets the value of the drCrFg property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrCrFg(String value) {
        this.drCrFg = value;
    }

    /**
     * Gets the value of the fromDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getFromDate() {
        return fromDate;
    }

    /**
     * Sets the value of the fromDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setFromDate(Long value) {
        this.fromDate = value;
    }

    /**
     * Gets the value of the lowerTxnDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLowerTxnDate() {
        return lowerTxnDate;
    }

    /**
     * Sets the value of the lowerTxnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLowerTxnDate(String value) {
        this.lowerTxnDate = value;
    }

    /**
     * Gets the value of the passBookUpdated property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPassBookUpdated() {
        return passBookUpdated;
    }

    /**
     * Sets the value of the passBookUpdated property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPassBookUpdated(String value) {
        this.passBookUpdated = value;
    }

    /**
     * Gets the value of the productCat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCat() {
        return productCat;
    }

    /**
     * Sets the value of the productCat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCat(String value) {
        this.productCat = value;
    }

    /**
     * Gets the value of the requestDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getRequestDate() {
        return requestDate;
    }

    /**
     * Sets the value of the requestDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setRequestDate(Long value) {
        this.requestDate = value;
    }

    /**
     * Gets the value of the stmtTyp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStmtTyp() {
        return stmtTyp;
    }

    /**
     * Sets the value of the stmtTyp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStmtTyp(String value) {
        this.stmtTyp = value;
    }

    /**
     * Gets the value of the toDate property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getToDate() {
        return toDate;
    }

    /**
     * Sets the value of the toDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setToDate(Long value) {
        this.toDate = value;
    }

    /**
     * Gets the value of the txnCurrencyCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnCurrencyCode() {
        return txnCurrencyCode;
    }

    /**
     * Sets the value of the txnCurrencyCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnCurrencyCode(String value) {
        this.txnCurrencyCode = value;
    }

    /**
     * Gets the value of the txnDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnDate() {
        return txnDate;
    }

    /**
     * Sets the value of the txnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnDate(String value) {
        this.txnDate = value;
    }

    /**
     * Gets the value of the txnJournalId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTxnJournalId() {
        return txnJournalId;
    }

    /**
     * Sets the value of the txnJournalId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTxnJournalId(Long value) {
        this.txnJournalId = value;
    }

    /**
     * Gets the value of the txnTypeCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTxnTypeCode() {
        return txnTypeCode;
    }

    /**
     * Sets the value of the txnTypeCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTxnTypeCode(String value) {
        this.txnTypeCode = value;
    }

    /**
     * Gets the value of the txnUserId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTxnUserId() {
        return txnUserId;
    }

    /**
     * Sets the value of the txnUserId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTxnUserId(Long value) {
        this.txnUserId = value;
    }

    /**
     * Gets the value of the upperTxnDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpperTxnDate() {
        return upperTxnDate;
    }

    /**
     * Sets the value of the upperTxnDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpperTxnDate(String value) {
        this.upperTxnDate = value;
    }

}
