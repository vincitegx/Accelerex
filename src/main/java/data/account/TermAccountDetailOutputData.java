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
 * <p>Java class for termAccountDetailOutputData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="termAccountDetailOutputData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://data.account.server.ws.supernova.neptunesoftware.com/}accountSummaryOutputData"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="strInterestAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strInterestRate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strInterestSettlementFreqCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strInterestSettlementFreqValue" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="strMaturityDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strNoticeAmt" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strNxtSettlementDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strRolloverOptCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strStartDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="strtermCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="termValue" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "termAccountDetailOutputData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "strInterestAccount",
    "strInterestRate",
    "strInterestSettlementFreqCd",
    "strInterestSettlementFreqValue",
    "strMaturityDate",
    "strNoticeAmt",
    "strNxtSettlementDate",
    "strRolloverOptCode",
    "strStartDate",
    "strtermCode",
    "termValue"
})
public class TermAccountDetailOutputData
    extends AccountSummaryOutputData
{

    protected String strInterestAccount;
    protected String strInterestRate;
    protected String strInterestSettlementFreqCd;
    protected int strInterestSettlementFreqValue;
    protected String strMaturityDate;
    protected String strNoticeAmt;
    protected String strNxtSettlementDate;
    protected String strRolloverOptCode;
    protected String strStartDate;
    protected String strtermCode;
    protected int termValue;

    /**
     * Gets the value of the strInterestAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrInterestAccount() {
        return strInterestAccount;
    }

    /**
     * Sets the value of the strInterestAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrInterestAccount(String value) {
        this.strInterestAccount = value;
    }

    /**
     * Gets the value of the strInterestRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrInterestRate() {
        return strInterestRate;
    }

    /**
     * Sets the value of the strInterestRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrInterestRate(String value) {
        this.strInterestRate = value;
    }

    /**
     * Gets the value of the strInterestSettlementFreqCd property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrInterestSettlementFreqCd() {
        return strInterestSettlementFreqCd;
    }

    /**
     * Sets the value of the strInterestSettlementFreqCd property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrInterestSettlementFreqCd(String value) {
        this.strInterestSettlementFreqCd = value;
    }

    /**
     * Gets the value of the strInterestSettlementFreqValue property.
     * 
     */
    public int getStrInterestSettlementFreqValue() {
        return strInterestSettlementFreqValue;
    }

    /**
     * Sets the value of the strInterestSettlementFreqValue property.
     * 
     */
    public void setStrInterestSettlementFreqValue(int value) {
        this.strInterestSettlementFreqValue = value;
    }

    /**
     * Gets the value of the strMaturityDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrMaturityDate() {
        return strMaturityDate;
    }

    /**
     * Sets the value of the strMaturityDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrMaturityDate(String value) {
        this.strMaturityDate = value;
    }

    /**
     * Gets the value of the strNoticeAmt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNoticeAmt() {
        return strNoticeAmt;
    }

    /**
     * Sets the value of the strNoticeAmt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNoticeAmt(String value) {
        this.strNoticeAmt = value;
    }

    /**
     * Gets the value of the strNxtSettlementDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrNxtSettlementDate() {
        return strNxtSettlementDate;
    }

    /**
     * Sets the value of the strNxtSettlementDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrNxtSettlementDate(String value) {
        this.strNxtSettlementDate = value;
    }

    /**
     * Gets the value of the strRolloverOptCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrRolloverOptCode() {
        return strRolloverOptCode;
    }

    /**
     * Sets the value of the strRolloverOptCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrRolloverOptCode(String value) {
        this.strRolloverOptCode = value;
    }

    /**
     * Gets the value of the strStartDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrStartDate() {
        return strStartDate;
    }

    /**
     * Sets the value of the strStartDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrStartDate(String value) {
        this.strStartDate = value;
    }

    /**
     * Gets the value of the strtermCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrtermCode() {
        return strtermCode;
    }

    /**
     * Sets the value of the strtermCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrtermCode(String value) {
        this.strtermCode = value;
    }

    /**
     * Gets the value of the termValue property.
     * 
     */
    public int getTermValue() {
        return termValue;
    }

    /**
     * Sets the value of the termValue property.
     * 
     */
    public void setTermValue(int value) {
        this.termValue = value;
    }

}
