package com.digi.RetrieveBusinessEntity.process;

import com.digi.RetrieveBusinessEntity.model.BusinessEntityDetails;
import com.digi.RetrieveBusinessEntity.model.Response;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ProcessResponse implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getHeaders());
        String msisdn = exchange.getIn().getHeader("CamelHttpQuery",String.class);
        System.out.println("hii"+ msisdn);

        exchange.getIn().setBody(msisdn);

    }
}
