package com.digi.updateCustomerDetails.route;

import com.digi.updateCustomerDetails.model.request.OrderRequest;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerDetailsRoute extends RouteBuilder {
    @Value("${spring.activemq.queue}")
    String activemqPath;

    @Override
    public void configure() throws Exception {



        restConfiguration()
                .component("undertow")
                .scheme("http")
                .port(9905)
                .bindingMode(RestBindingMode.off);

        rest("/updateCustomer")
                .id("update order details")
                .get()
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .to("direct:consume-activemq-data");
        from("direct:consume-activemq-data")
                .log("after invoke mq")
                .from("activemq:queue:"+activemqPath+"?exchangePattern=InOnly")
                .unmarshal(new JacksonDataFormat(OrderRequest.class))
                .log("Body is ${body}");
//                .marshal();


    }
}
