package com.neptunesoftware.accelerex.createCustomer;

import org.springframework.ws.WebServiceMessage;
import org.springframework.ws.client.core.WebServiceMessageCallback;
import org.springframework.ws.soap.SoapHeader;
import org.springframework.ws.soap.SoapHeaderElement;
import org.springframework.ws.soap.SoapMessage;

import javax.xml.namespace.QName;
import javax.xml.transform.TransformerException;
import java.io.IOException;

public class CustomSoapHeaderCallback implements WebServiceMessageCallback {

    private static final String NAMESPACE_URI = "http://schemas.microsoft.com/exchange/services/2006/types";
    private static final String PREFIX = "ns3";
    private static final String HEADER_ELEMENT = "RequestServerVersion";
    private static final String ATTRIBUTE_NAME = "Version";
    private static final String ATTRIBUTE_VALUE = "Exchange2010_SP2";

    @Override
    public void doWithMessage(WebServiceMessage message) throws IOException, TransformerException {
        SoapMessage soapMessage = (SoapMessage) message;
        SoapHeader soapHeader = soapMessage.getSoapHeader();

        // Create the SOAP header elements
        QName requestServerVersionQName = new QName(NAMESPACE_URI, HEADER_ELEMENT, PREFIX);
        SoapHeaderElement requestServerVersionHeader = soapHeader.addHeaderElement(requestServerVersionQName);

        // Set the attribute for RequestServerVersion
        requestServerVersionHeader.addAttribute(new QName(ATTRIBUTE_NAME), ATTRIBUTE_VALUE);
    }
}