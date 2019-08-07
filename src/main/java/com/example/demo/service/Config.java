package com.example.demo.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * @author Vlados Guskov
 */

@Configuration
public class Config {
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.example.demo.model");
        return marshaller;
    }

    @Bean
    public Connector connector(Jaxb2Marshaller marshaller) {
        Connector client = new Connector();
        client.setDefaultUri("http://npchk.nalog.ru:80/FNSNDSCAWS_2");
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }
}
