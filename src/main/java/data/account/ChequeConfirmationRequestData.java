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
 * <p>Java class for chequeConfirmationRequestData complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="chequeConfirmationRequestData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;extension base="{http://data.account.server.ws.supernova.neptunesoftware.com/}accountRequest"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="issueAmount" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/&gt;
 *         &lt;element name="strChequeDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/extension&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "chequeConfirmationRequestData", namespace = "http://data.account.server.ws.supernova.neptunesoftware.com/", propOrder = {
    "issueAmount",
    "strChequeDate"
})
public class ChequeConfirmationRequestData
    extends AccountRequest
{

    protected BigDecimal issueAmount;
    protected String strChequeDate;

    /**
     * Gets the value of the issueAmount property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getIssueAmount() {
        return issueAmount;
    }

    /**
     * Sets the value of the issueAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setIssueAmount(BigDecimal value) {
        this.issueAmount = value;
    }

    /**
     * Gets the value of the strChequeDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStrChequeDate() {
        return strChequeDate;
    }

    /**
     * Sets the value of the strChequeDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStrChequeDate(String value) {
        this.strChequeDate = value;
    }

}
