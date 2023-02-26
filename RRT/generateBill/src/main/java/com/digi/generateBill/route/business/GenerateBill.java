package com.digi.generateBill.route.business;

import com.digi.generateBill.model.servicea.request.ServiceARequest;
import com.digi.generateBill.model.servicea.response.ErrorResponse;
import com.digi.generateBill.model.servicea.response.ServiceAResponse;
import com.digi.generateBill.model.serviceb.request.ServiceBRequest;
import com.digi.generateBill.model.serviceb.response.ServiceBResponse;
import com.digi.generateBill.processor.RequestMapingProcessor;
import com.digi.generateBill.processor.ResponseProcessor;
import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;

@Component
public class GenerateBill extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        DataFormat channelRequest = new JacksonDataFormat(ServiceARequest.class);
        DataFormat serviceAResponse = new JacksonDataFormat(ServiceAResponse.class);
//        DataFormat errorResponse = new JacksonDataFormat(ErrorResponse.class);
        DataFormat serviceBRequest = new JacksonDataFormat(ServiceBRequest.class);
        DataFormat serviceBResponse = new JacksonDataFormat(ServiceBResponse.class);

        from("direct:call-service-b")
                .routeId("direct-call-service-b")
                .to("direct:req-validation-route");
        from("direct:req-validation-route")
                .log("Receive Request form Client")
                .unmarshal(channelRequest)
                .to("bean-validator://request-validation")
                .to("direct:req-mapping-generate-bill-route");
        from("direct:req-mapping-generate-bill-route")
                .process(new RequestMapingProcessor())
                .marshal(serviceBRequest)
                .to("direct:call-to-B-system")
                .to("direct:response-mapping-route");
        from("direct:response-mapping-route")
                .unmarshal(serviceBResponse)
                .log("Received Response from service B => ${body}")
                .process(new ResponseProcessor())
                .to("direct:final-response-route");
        from("direct:final-response-route")
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201))
                .marshal(serviceAResponse)
                .log("Response Sent to Client");



    }
}
