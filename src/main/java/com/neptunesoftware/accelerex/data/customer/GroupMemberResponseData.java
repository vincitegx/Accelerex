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
 * <p>Java class for groupMemberResponseData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="groupMemberResponseData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="groupCustomerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="groupExecutiveFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="groupMemberId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="groupMemberRefNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="groupRelationshipCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="independentCustomerFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="memberCustomerNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="memberPrimaryAcctNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="memberSecondaryAcctNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="subGroupExecutiveFlag" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *         &lt;element name="subGroupId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/&gt;
 *         &lt;element name="subGroupRelshipCd" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "groupMemberResponseData", namespace = "http://data.customer.server.ws.supernova.neptunesoftware.com/", propOrder = {
        "groupCustomerNumber",
        "groupExecutiveFlag",
        "groupMemberId",
        "groupMemberRefNumber",
        "groupRelationshipCd",
        "independentCustomerFlag",
        "memberCustomerNumber",
        "memberPrimaryAcctNumber",
        "memberSecondaryAcctNumber",
        "status",
        "subGroupExecutiveFlag",
        "subGroupId",
        "subGroupRelshipCd"
})
public class GroupMemberResponseData {

    protected String groupCustomerNumber;
    protected boolean groupExecutiveFlag;
    protected Long groupMemberId;
    protected String groupMemberRefNumber;
    protected String groupRelationshipCd;
    protected boolean independentCustomerFlag;
    protected String memberCustomerNumber;
    protected String memberPrimaryAcctNumber;
    protected String memberSecondaryAcctNumber;
    protected String status;
    protected boolean subGroupExecutiveFlag;
    protected Long subGroupId;
    protected String subGroupRelshipCd;

    /**
     * Gets the value of the groupCustomerNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGroupCustomerNumber() {
        return groupCustomerNumber;
    }

    /**
     * Sets the value of the groupCustomerNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGroupCustomerNumber(String value) {
        this.groupCustomerNumber = value;
    }

    /**
     * Gets the value of the groupExecutiveFlag property.
     */
    public boolean isGroupExecutiveFlag() {
        return groupExecutiveFlag;
    }

    /**
     * Sets the value of the groupExecutiveFlag property.
     */
    public void setGroupExecutiveFlag(boolean value) {
        this.groupExecutiveFlag = value;
    }

    /**
     * Gets the value of the groupMemberId property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getGroupMemberId() {
        return groupMemberId;
    }

    /**
     * Sets the value of the groupMemberId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setGroupMemberId(Long value) {
        this.groupMemberId = value;
    }

    /**
     * Gets the value of the groupMemberRefNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGroupMemberRefNumber() {
        return groupMemberRefNumber;
    }

    /**
     * Sets the value of the groupMemberRefNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGroupMemberRefNumber(String value) {
        this.groupMemberRefNumber = value;
    }

    /**
     * Gets the value of the groupRelationshipCd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getGroupRelationshipCd() {
        return groupRelationshipCd;
    }

    /**
     * Sets the value of the groupRelationshipCd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setGroupRelationshipCd(String value) {
        this.groupRelationshipCd = value;
    }

    /**
     * Gets the value of the independentCustomerFlag property.
     */
    public boolean isIndependentCustomerFlag() {
        return independentCustomerFlag;
    }

    /**
     * Sets the value of the independentCustomerFlag property.
     */
    public void setIndependentCustomerFlag(boolean value) {
        this.independentCustomerFlag = value;
    }

    /**
     * Gets the value of the memberCustomerNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMemberCustomerNumber() {
        return memberCustomerNumber;
    }

    /**
     * Sets the value of the memberCustomerNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMemberCustomerNumber(String value) {
        this.memberCustomerNumber = value;
    }

    /**
     * Gets the value of the memberPrimaryAcctNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMemberPrimaryAcctNumber() {
        return memberPrimaryAcctNumber;
    }

    /**
     * Sets the value of the memberPrimaryAcctNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMemberPrimaryAcctNumber(String value) {
        this.memberPrimaryAcctNumber = value;
    }

    /**
     * Gets the value of the memberSecondaryAcctNumber property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getMemberSecondaryAcctNumber() {
        return memberSecondaryAcctNumber;
    }

    /**
     * Sets the value of the memberSecondaryAcctNumber property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setMemberSecondaryAcctNumber(String value) {
        this.memberSecondaryAcctNumber = value;
    }

    /**
     * Gets the value of the status property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the subGroupExecutiveFlag property.
     */
    public boolean isSubGroupExecutiveFlag() {
        return subGroupExecutiveFlag;
    }

    /**
     * Sets the value of the subGroupExecutiveFlag property.
     */
    public void setSubGroupExecutiveFlag(boolean value) {
        this.subGroupExecutiveFlag = value;
    }

    /**
     * Gets the value of the subGroupId property.
     *
     * @return possible object is
     * {@link Long }
     */
    public Long getSubGroupId() {
        return subGroupId;
    }

    /**
     * Sets the value of the subGroupId property.
     *
     * @param value allowed object is
     *              {@link Long }
     */
    public void setSubGroupId(Long value) {
        this.subGroupId = value;
    }

    /**
     * Gets the value of the subGroupRelshipCd property.
     *
     * @return possible object is
     * {@link String }
     */
    public String getSubGroupRelshipCd() {
        return subGroupRelshipCd;
    }

    /**
     * Sets the value of the subGroupRelshipCd property.
     *
     * @param value allowed object is
     *              {@link String }
     */
    public void setSubGroupRelshipCd(String value) {
        this.subGroupRelshipCd = value;
    }

}
