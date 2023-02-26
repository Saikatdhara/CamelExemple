package com.digi.modifyUserOrderForUser.route;

import com.digi.modifyUserOrderForUser.model.service.request.UserRequest;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.component.jacksonxml.JacksonXMLDataFormat;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spi.DataFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

    @Value("${api.modifyUserOrder.path}")
    String apiPath;
    @Value("${spring.activemq.queue}")
    //@PropertyInject("{{spring.activemq.queue}}")
    private String queueName;
    @Override
    public void configure() throws Exception {

        DataFormat userRequest = new JacksonDataFormat(UserRequest.class);
        JacksonXMLDataFormat xmlJsonFormat = new JacksonXMLDataFormat();

         restConfiguration()
                .component("undertow")
                .port("9003")
                .scheme("http")
                .bindingMode(RestBindingMode.off);

         rest("/hello")
                 .id("modify-user-order")
                 .post()
                 .to("direct:get-request-body");
         from("direct:get-request-body")
//                 .from("activemq:queue:" + queueName)
                 .log("Data recived from request body")
                 .unmarshal(xmlJsonFormat)
                 .log("write msg in mq : ${body}")
                 .log("Timer endpoint triggered..").id("producer-log")
                 // send to activemq over myQ queue
                 .to("activemq:queue:" + queueName+"?exchangePattern=InOnly").id("amq-producer")
                 .setBody(constant("Message send successfully to ActiveMq"));
//                 .to("activemq:queue:myQ?exchangePattern=InOnly").id("amq-producer");


    }
}
