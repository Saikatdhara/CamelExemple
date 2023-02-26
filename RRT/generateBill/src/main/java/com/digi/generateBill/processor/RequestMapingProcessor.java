package com.digi.generateBill.processor;

import com.digi.generateBill.model.servicea.request.ServiceARequest;
import com.digi.generateBill.model.serviceb.request.ServiceBRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class RequestMapingProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        ServiceARequest serviceARequest = exchange.getIn().getBody(ServiceARequest.class);
        ServiceBRequest serviceBRequest = new ServiceBRequest();
        serviceBRequest.setMsisdn(serviceARequest.getRelatedParty().getMsisdn());
        serviceBRequest.setAccountNo(serviceARequest.getBillingAccount().getId());
        exchange.setProperty("requestBodyA",serviceARequest);
        exchange.getIn().setBody(serviceBRequest);
    }
}
