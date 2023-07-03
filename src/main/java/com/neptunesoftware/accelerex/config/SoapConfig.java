//package com.neptunesoftware.accelerex.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.oxm.jaxb.Jaxb2Marshaller;
//
//@Configuration
//public class SoapConfig {
//    @Bean
//    public Jaxb2Marshaller marshaller() {
//        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
//        // this is the package name specified in the <generatePackage> specified in
//        // pom.xml
//        marshaller.setPackagesToScan("com.neptunesoftware.accelerex.data.account","com.neptunesoftware.accelerex.data.customer");
//        return marshaller;
//    }
//}
