package com.example.demo.service;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 * @author Vlados Guskov
 */
public class Connector extends WebServiceGatewaySupport {
    public Object callWebService(String url, Object request){
        return getWebServiceTemplate().marshalSendAndReceive(url, request);
    }
}
