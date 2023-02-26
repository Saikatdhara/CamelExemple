package com.digi.billgenerate.route;

import com.digi.billgenerate.model.servicea.RequestA;
import com.digi.billgenerate.processor.ProcessAPI;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.ListJacksonDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class GenerateBillService extends RouteBuilder {
    @Override
    public void configure() throws Exception {

                restConfiguration().component("undertow").port(5001)
                .contextPath("api")
                .bindingMode(RestBindingMode.auto);

        rest().consumes("application/json").produces("application/json")
                .post("/A/billingManagement/v1/generateBill")
                .to("direct:myroute");


        from("direct:myroute")
                .unmarshal( new ListJacksonDataFormat(RequestA.class))
//                .json(JsonLibrary.Jackson, RequestA.class)
                .process(new ProcessAPI());
//                .bean(new ProcessAPI())
//                .log("${body}");

//        from("timer:mytimer?repeatCount=1")
//                .to("http://www.google.com")
//                .log("invoke")
//                .log("${body}");

//        rest("/getBill")
//                .get("/hello")
//                .responseMessage(200, "Hii how are you");

    }
}
