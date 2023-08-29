//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2023.07.04 at 10:57:41 AM WAT 
//


package com.neptunesoftware.accelerex.data.account;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlSeeAlso;
import jakarta.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for accountSummaryOutputData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="accountSummaryOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://data.account.server.ws.supernova.neptunesoftware.com/}accountBalanceOutputData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="accountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="accountTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="chargeArrears" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="creditInterestAccrued" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="currencyISOCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="debitInterestAccrued" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="expiryDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="lastDepositAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="lastWithdrawalAmount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="openDate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/&gt;
 *         &lt;element name="producCategoryType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="productDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="statusDesc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strAvailableBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strClearedBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strCreditNextSettlementDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strCreditTurnOver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strDebitNextSettlementDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strDebitTurnOver" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strLastActivityDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strLastDepositDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strLastWithdrawalDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strLedgerBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strUnclearedChequesBalance" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "accountSummaryOutputData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "accountName",
    "accountTitle",
    "chargeArrears",
    "creditInterestAccrued",
    "currencyISOCode",
    "debitInterestAccrued",
    "expiryDate",
    "lastDepositAmount",
    "lastWithdrawalAmount",
    "openDate",
    "producCategoryType",
    "productDesc",
    "status",
    "statusDesc",
    "strAvailableBalance",
    "strClearedBalance",
    "strCreditNextSettlementDate",
    "strCreditTurnOver",
    "strDebitNextSettlementDate",
    "strDebitTurnOver",
    "strLastActivityDate",
    "strLastDepositDate",
    "strLastWithdrawalDate",
    "strLedgerBalance",
    "strUnclearedChequesBalance"
})
@XmlSeeAlso({
    LoanAccountDetailOutputData.class,
    TermAccountDetailOutputData.class
})
public class AccountSummaryOutputData
    extends AccountBalanceOutputData
{

    protected String accountName;
    protected String accountTitle;
    protected String chargeArrears;
    protected String creditInterestAccrued;
    protected String currencyISOCode;
    protected String debitInterestAccrued;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar expiryDate;
    protected String lastDepositAmount;
    protected String lastWithdrawalAmount;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar openDate;
    protected String producCategoryType;
    protected String productDesc;
    protected String status;
    protected String statusDesc;
    protected String strAvailableBalance;
    protected String strClearedBalance;
    protected String strCreditNextSettlementDate;
    protected String strCreditTurnOver;
    protected String strDebitNextSettlementDate;
    protected String strDebitTurnOver;
    protected String strLastActivityDate;
    protected String strLastDepositDate;
    protected String strLastWithdrawalDate;
    protected String strLedgerBalance;
    protected String strUnclearedChequesBalance;

    /**
     * Gets the value of the accountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Sets the value of the accountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountName(String value) {
        this.accountName = value;
    }

    /**
     * Gets the value of the accountTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAccountTitle() {
        return accountTitle;
    }

    /**
     * Sets the value of the accountTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAccountTitle(String value) {
        this.accountTitle = value;
    }

    /**
     * Gets the value of the chargeArrears property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeArrears() {
        return chargeArrears;
    }

    /**
     * Sets the value of the chargeArrears property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeArrears(String value) {
        this.chargeArrears = value;
    }

    /**
     * Gets the value of the creditInterestAccrued property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreditInterestAccrued() {
        return creditInterestAccrued;
    }

    /**
     * Sets the value of the creditInterestAccrued property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreditInterestAccrued(String value) {
        this.creditInterestAccrued = value;
    }

    /**
     * Gets the value of the currencyISOCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCurrencyISOCode() {
        return currencyISOCode;
    }

    /**
     * Sets the value of the currencyISOCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCurrencyISOCode(String value) {
        this.currencyISOCode = value;
    }

    /**
     * Gets the value of the debitInterestAccrued property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDebitInterestAccrued() {
        return debitInterestAccrued;
    }

    /**
     * Sets the value of the debitInterestAccrued property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDebitInterestAccrued(String value) {
        this.debitInterestAccrued = value;
    }

    /**
     * Gets the value of the expiryDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getExpiryDate() {
        return expiryDate;
    }

    /**
     * Sets the value of the expiryDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setExpiryDate(XMLGregorianCalendar value) {
        this.expiryDate = value;
    }

    /**
     * Gets the value of the lastDepositAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastDepositAmount() {
        return lastDepositAmount;
    }

    /**
     * Sets the value of the lastDepositAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastDepositAmount(String value) {
        this.lastDepositAmount = value;
    }

    /**
     * Gets the value of the lastWithdrawalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLastWithdrawalAmount() {
        return lastWithdrawalAmount;
    }

    /**
     * Sets the value of the lastWithdrawalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLastWithdrawalAmount(String value) {
        this.lastWithdrawalAmount = value;
    }

    /**
     * Gets the value of the openDate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getOpenDate() {
        return openDate;
    }

    /**
     * Sets the value of the openDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setOpenDate(XMLGregorianCalendar value) {
        this.openDate = value;
    }

    /**
     * Gets the value of the producCategoryType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProducCategoryType() {
        return producCategoryType;
    }

    /**
     * Sets the value of the producCategoryType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProducCategoryType(String value) {
        this.producCategoryType = value;
    }

    /**
     * Gets the value of the productDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductDesc() {
        return productDesc;
    }

    /**
     * Sets the value of the productDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductDesc(String value) {
        this.productDesc = value;
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
     * Gets the value of the statusDesc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusDesc() {
        return statusDesc;
    }

    /**
     * Sets the value of the statusDesc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusDesc(String value) {
        this.statusDesc = value;
    }

    /**
     * Gets the value of the strAvailableBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrAvailableBalance() {
        return strAvailableBalance;
    }

    /**
     * Sets the value of the strAvailableBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrAvailableBalance(String value) {
        this.strAvailableBalance = value;
    }

    /**
     * Gets the value of the strClearedBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrClearedBalance() {
        return strClearedBalance;
    }

    /**
     * Sets the value of the strClearedBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrClearedBalance(String value) {
        this.strClearedBalance = value;
    }

    /**
     * Gets the value of the strCreditNextSettlementDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrCreditNextSettlementDate() {
        return strCreditNextSettlementDate;
    }

    /**
     * Sets the value of the strCreditNextSettlementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrCreditNextSettlementDate(String value) {
        this.strCreditNextSettlementDate = value;
    }

    /**
     * Gets the value of the strCreditTurnOver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrCreditTurnOver() {
        return strCreditTurnOver;
    }

    /**
     * Sets the value of the strCreditTurnOver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrCreditTurnOver(String value) {
        this.strCreditTurnOver = value;
    }

    /**
     * Gets the value of the strDebitNextSettlementDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrDebitNextSettlementDate() {
        return strDebitNextSettlementDate;
    }

    /**
     * Sets the value of the strDebitNextSettlementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrDebitNextSettlementDate(String value) {
        this.strDebitNextSettlementDate = value;
    }

    /**
     * Gets the value of the strDebitTurnOver property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrDebitTurnOver() {
        return strDebitTurnOver;
    }

    /**
     * Sets the value of the strDebitTurnOver property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrDebitTurnOver(String value) {
        this.strDebitTurnOver = value;
    }

    /**
     * Gets the value of the strLastActivityDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrLastActivityDate() {
        return strLastActivityDate;
    }

    /**
     * Sets the value of the strLastActivityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrLastActivityDate(String value) {
        this.strLastActivityDate = value;
    }

    /**
     * Gets the value of the strLastDepositDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrLastDepositDate() {
        return strLastDepositDate;
    }

    /**
     * Sets the value of the strLastDepositDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrLastDepositDate(String value) {
        this.strLastDepositDate = value;
    }

    /**
     * Gets the value of the strLastWithdrawalDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrLastWithdrawalDate() {
        return strLastWithdrawalDate;
    }

    /**
     * Sets the value of the strLastWithdrawalDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrLastWithdrawalDate(String value) {
        this.strLastWithdrawalDate = value;
    }

    /**
     * Gets the value of the strLedgerBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrLedgerBalance() {
        return strLedgerBalance;
    }

    /**
     * Sets the value of the strLedgerBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrLedgerBalance(String value) {
        this.strLedgerBalance = value;
    }

    /**
     * Gets the value of the strUnclearedChequesBalance property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrUnclearedChequesBalance() {
        return strUnclearedChequesBalance;
    }

    /**
     * Sets the value of the strUnclearedChequesBalance property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrUnclearedChequesBalance(String value) {
        this.strUnclearedChequesBalance = value;
    }

}
