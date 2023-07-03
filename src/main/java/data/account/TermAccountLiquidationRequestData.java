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
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for termAccountLiquidationRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="termAccountLiquidationRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://common.ws.supernova.neptunesoftware.com/}XAPIRequestBaseObject"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="chargeSettlementAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="chargeSettlementAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="customerId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="dueInterestAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="glSettlementSusAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="glSettlementSusAccountName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="glSettlementSusAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="interestAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="interestAmountCurrencyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="interestAmountCurrencyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="interestForfeitureAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="interestForfeitureAmountCurrencyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="interestForfeitureAmountCurrencyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="interestSettlementAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="interestSettlementAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="penaltyCharge" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="penaltyChargeAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="penaltyChargeAmountCurrencyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="penaltyChargeAmountCurrencyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="principalAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="principalAmountCurrencyCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="principalAmountCurrencyId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="principalSettlementAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="principalSettlementAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="settlementAccountType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strActionLiquidate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tdAccountLqdCmpt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="tdAccountLqdType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="termAccountId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="termAccountNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "termAccountLiquidationRequestData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "chargeSettlementAccountId",
    "chargeSettlementAccountNo",
    "customerId",
    "dueInterestAmount",
    "glSettlementSusAccountId",
    "glSettlementSusAccountName",
    "glSettlementSusAccountNo",
    "interestAmount",
    "interestAmountCurrencyCd",
    "interestAmountCurrencyId",
    "interestForfeitureAmount",
    "interestForfeitureAmountCurrencyCd",
    "interestForfeitureAmountCurrencyId",
    "interestSettlementAccountId",
    "interestSettlementAccountNo",
    "penaltyCharge",
    "penaltyChargeAmount",
    "penaltyChargeAmountCurrencyCd",
    "penaltyChargeAmountCurrencyId",
    "principalAmount",
    "principalAmountCurrencyCd",
    "principalAmountCurrencyId",
    "principalSettlementAccountId",
    "principalSettlementAccountNo",
    "settlementAccountType",
    "strActionLiquidate",
    "tdAccountLqdCmpt",
    "tdAccountLqdType",
    "termAccountId",
    "termAccountNo"
})
public class TermAccountLiquidationRequestData
    extends XAPIRequestBaseObject
{

    protected Long chargeSettlementAccountId;
    protected String chargeSettlementAccountNo;
    protected Long customerId;
    protected BigDecimal dueInterestAmount;
    protected Long glSettlementSusAccountId;
    protected String glSettlementSusAccountName;
    protected String glSettlementSusAccountNo;
    protected BigDecimal interestAmount;
    protected String interestAmountCurrencyCd;
    protected Long interestAmountCurrencyId;
    protected BigDecimal interestForfeitureAmount;
    protected String interestForfeitureAmountCurrencyCd;
    protected Long interestForfeitureAmountCurrencyId;
    protected Long interestSettlementAccountId;
    protected String interestSettlementAccountNo;
    protected Long penaltyCharge;
    protected BigDecimal penaltyChargeAmount;
    protected String penaltyChargeAmountCurrencyCd;
    protected Long penaltyChargeAmountCurrencyId;
    protected BigDecimal principalAmount;
    protected String principalAmountCurrencyCd;
    protected Long principalAmountCurrencyId;
    protected Long principalSettlementAccountId;
    protected String principalSettlementAccountNo;
    protected String settlementAccountType;
    protected String strActionLiquidate;
    protected String tdAccountLqdCmpt;
    protected String tdAccountLqdType;
    protected Long termAccountId;
    protected String termAccountNo;

    /**
     * Gets the value of the chargeSettlementAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getChargeSettlementAccountId() {
        return chargeSettlementAccountId;
    }

    /**
     * Sets the value of the chargeSettlementAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setChargeSettlementAccountId(Long value) {
        this.chargeSettlementAccountId = value;
    }

    /**
     * Gets the value of the chargeSettlementAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getChargeSettlementAccountNo() {
        return chargeSettlementAccountNo;
    }

    /**
     * Sets the value of the chargeSettlementAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setChargeSettlementAccountNo(String value) {
        this.chargeSettlementAccountNo = value;
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
     * Gets the value of the dueInterestAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDueInterestAmount() {
        return dueInterestAmount;
    }

    /**
     * Sets the value of the dueInterestAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDueInterestAmount(BigDecimal value) {
        this.dueInterestAmount = value;
    }

    /**
     * Gets the value of the glSettlementSusAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getGlSettlementSusAccountId() {
        return glSettlementSusAccountId;
    }

    /**
     * Sets the value of the glSettlementSusAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setGlSettlementSusAccountId(Long value) {
        this.glSettlementSusAccountId = value;
    }

    /**
     * Gets the value of the glSettlementSusAccountName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlSettlementSusAccountName() {
        return glSettlementSusAccountName;
    }

    /**
     * Sets the value of the glSettlementSusAccountName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlSettlementSusAccountName(String value) {
        this.glSettlementSusAccountName = value;
    }

    /**
     * Gets the value of the glSettlementSusAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGlSettlementSusAccountNo() {
        return glSettlementSusAccountNo;
    }

    /**
     * Sets the value of the glSettlementSusAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGlSettlementSusAccountNo(String value) {
        this.glSettlementSusAccountNo = value;
    }

    /**
     * Gets the value of the interestAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInterestAmount() {
        return interestAmount;
    }

    /**
     * Sets the value of the interestAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInterestAmount(BigDecimal value) {
        this.interestAmount = value;
    }

    /**
     * Gets the value of the interestAmountCurrencyCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterestAmountCurrencyCd() {
        return interestAmountCurrencyCd;
    }

    /**
     * Sets the value of the interestAmountCurrencyCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterestAmountCurrencyCd(String value) {
        this.interestAmountCurrencyCd = value;
    }

    /**
     * Gets the value of the interestAmountCurrencyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInterestAmountCurrencyId() {
        return interestAmountCurrencyId;
    }

    /**
     * Sets the value of the interestAmountCurrencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInterestAmountCurrencyId(Long value) {
        this.interestAmountCurrencyId = value;
    }

    /**
     * Gets the value of the interestForfeitureAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInterestForfeitureAmount() {
        return interestForfeitureAmount;
    }

    /**
     * Sets the value of the interestForfeitureAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInterestForfeitureAmount(BigDecimal value) {
        this.interestForfeitureAmount = value;
    }

    /**
     * Gets the value of the interestForfeitureAmountCurrencyCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterestForfeitureAmountCurrencyCd() {
        return interestForfeitureAmountCurrencyCd;
    }

    /**
     * Sets the value of the interestForfeitureAmountCurrencyCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterestForfeitureAmountCurrencyCd(String value) {
        this.interestForfeitureAmountCurrencyCd = value;
    }

    /**
     * Gets the value of the interestForfeitureAmountCurrencyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInterestForfeitureAmountCurrencyId() {
        return interestForfeitureAmountCurrencyId;
    }

    /**
     * Sets the value of the interestForfeitureAmountCurrencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInterestForfeitureAmountCurrencyId(Long value) {
        this.interestForfeitureAmountCurrencyId = value;
    }

    /**
     * Gets the value of the interestSettlementAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getInterestSettlementAccountId() {
        return interestSettlementAccountId;
    }

    /**
     * Sets the value of the interestSettlementAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setInterestSettlementAccountId(Long value) {
        this.interestSettlementAccountId = value;
    }

    /**
     * Gets the value of the interestSettlementAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInterestSettlementAccountNo() {
        return interestSettlementAccountNo;
    }

    /**
     * Sets the value of the interestSettlementAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInterestSettlementAccountNo(String value) {
        this.interestSettlementAccountNo = value;
    }

    /**
     * Gets the value of the penaltyCharge property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPenaltyCharge() {
        return penaltyCharge;
    }

    /**
     * Sets the value of the penaltyCharge property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPenaltyCharge(Long value) {
        this.penaltyCharge = value;
    }

    /**
     * Gets the value of the penaltyChargeAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPenaltyChargeAmount() {
        return penaltyChargeAmount;
    }

    /**
     * Sets the value of the penaltyChargeAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPenaltyChargeAmount(BigDecimal value) {
        this.penaltyChargeAmount = value;
    }

    /**
     * Gets the value of the penaltyChargeAmountCurrencyCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPenaltyChargeAmountCurrencyCd() {
        return penaltyChargeAmountCurrencyCd;
    }

    /**
     * Sets the value of the penaltyChargeAmountCurrencyCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPenaltyChargeAmountCurrencyCd(String value) {
        this.penaltyChargeAmountCurrencyCd = value;
    }

    /**
     * Gets the value of the penaltyChargeAmountCurrencyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPenaltyChargeAmountCurrencyId() {
        return penaltyChargeAmountCurrencyId;
    }

    /**
     * Sets the value of the penaltyChargeAmountCurrencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPenaltyChargeAmountCurrencyId(Long value) {
        this.penaltyChargeAmountCurrencyId = value;
    }

    /**
     * Gets the value of the principalAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPrincipalAmount() {
        return principalAmount;
    }

    /**
     * Sets the value of the principalAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPrincipalAmount(BigDecimal value) {
        this.principalAmount = value;
    }

    /**
     * Gets the value of the principalAmountCurrencyCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipalAmountCurrencyCd() {
        return principalAmountCurrencyCd;
    }

    /**
     * Sets the value of the principalAmountCurrencyCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipalAmountCurrencyCd(String value) {
        this.principalAmountCurrencyCd = value;
    }

    /**
     * Gets the value of the principalAmountCurrencyId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrincipalAmountCurrencyId() {
        return principalAmountCurrencyId;
    }

    /**
     * Sets the value of the principalAmountCurrencyId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrincipalAmountCurrencyId(Long value) {
        this.principalAmountCurrencyId = value;
    }

    /**
     * Gets the value of the principalSettlementAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getPrincipalSettlementAccountId() {
        return principalSettlementAccountId;
    }

    /**
     * Sets the value of the principalSettlementAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setPrincipalSettlementAccountId(Long value) {
        this.principalSettlementAccountId = value;
    }

    /**
     * Gets the value of the principalSettlementAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrincipalSettlementAccountNo() {
        return principalSettlementAccountNo;
    }

    /**
     * Sets the value of the principalSettlementAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrincipalSettlementAccountNo(String value) {
        this.principalSettlementAccountNo = value;
    }

    /**
     * Gets the value of the settlementAccountType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSettlementAccountType() {
        return settlementAccountType;
    }

    /**
     * Sets the value of the settlementAccountType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSettlementAccountType(String value) {
        this.settlementAccountType = value;
    }

    /**
     * Gets the value of the strActionLiquidate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrActionLiquidate() {
        return strActionLiquidate;
    }

    /**
     * Sets the value of the strActionLiquidate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrActionLiquidate(String value) {
        this.strActionLiquidate = value;
    }

    /**
     * Gets the value of the tdAccountLqdCmpt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTdAccountLqdCmpt() {
        return tdAccountLqdCmpt;
    }

    /**
     * Sets the value of the tdAccountLqdCmpt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTdAccountLqdCmpt(String value) {
        this.tdAccountLqdCmpt = value;
    }

    /**
     * Gets the value of the tdAccountLqdType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTdAccountLqdType() {
        return tdAccountLqdType;
    }

    /**
     * Sets the value of the tdAccountLqdType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTdAccountLqdType(String value) {
        this.tdAccountLqdType = value;
    }

    /**
     * Gets the value of the termAccountId property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTermAccountId() {
        return termAccountId;
    }

    /**
     * Sets the value of the termAccountId property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTermAccountId(Long value) {
        this.termAccountId = value;
    }

    /**
     * Gets the value of the termAccountNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTermAccountNo() {
        return termAccountNo;
    }

    /**
     * Sets the value of the termAccountNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTermAccountNo(String value) {
        this.termAccountNo = value;
    }

}
