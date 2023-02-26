package com.digi.billgenerate.processor;

import com.digi.billgenerate.model.servicea.RequestA;
import com.digi.billgenerate.model.serviceb.RequestB;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessAPI implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        RequestA ra =  exchange.getIn().getBody(RequestA.class);

        System.out.println(ra.toString());
//        String data = exchange.getIn().getBody(String.class);
//
//        ObjectMapper objectMapper = new ObjectMapper();
//        JsonNode jsonNode = objectMapper.readTree(data);
//        System.out.println(data);
//        RequestB requestB = new RequestB();
//        requestB.setAccountNo(ra.getBillingAccount().id);
//        requestB.setMsisdn(ra.getRelatedParty().msisdn);
    }
}
