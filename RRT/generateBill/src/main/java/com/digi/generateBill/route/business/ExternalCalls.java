package com.digi.generateBill.route.business;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class ExternalCalls extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("direct:call-to-B-system")
                .removeHeaders("*")
                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethod.POST))
                .log("Call to Mock Service B")
                .to("{{outbound.b.url}}");//Using Mockoon

    }
}
