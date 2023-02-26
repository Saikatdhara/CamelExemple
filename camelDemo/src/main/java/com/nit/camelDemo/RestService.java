package com.nit.camelDemo;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RestService extends RouteBuilder {
    @Override
    public void configure() throws Exception {
//        restConfiguration().component("undertow").port(5000)
//                .contextPath("api")
//                .bindingMode(RestBindingMode.auto);
//
//        rest().consumes("application/json").produces("application/json")
//                .get("/hello").to("log:${headers}");
//
//        from("timer:hii")
//                .setHeader("name",simple("gabluu"))
//                .to("http://localhost:5000/api/hello")
//                .log("invoke");
        from("timer:mytimer?period=5000")
                .setBody(constant("HELLO from Camel!"))
                .to("jms:queue:HELLO.WORLD")
                .log("Msg sent");

        from("jms:queue:HELLO.WORLD")
                .log("Received a message - ${body}");

    }
}
