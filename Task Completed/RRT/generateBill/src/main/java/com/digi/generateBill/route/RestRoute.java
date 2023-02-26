package com.digi.generateBill.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class RestRoute extends RouteBuilder {

    @Value("${api.generatebill.path}")
    private String generateBillapiPath;

    @Override
    public void configure() throws Exception {

//        DataFormat channelRequest = new JacksonDataFormat(ServiceARequest.class);
//        DataFormat serviceAResponse = new JacksonDataFormat(ServiceAResponse.class);
//        DataFormat errorResponse = new JacksonDataFormat(ErrorResponse.class);
//        DataFormat serviceBRequest = new JacksonDataFormat(ServiceBRequest.class);
//        DataFormat serviceBResponse = new JacksonDataFormat(ServiceBResponse.class);

//        onException(ValidationException.class, javax.validation.ValidationException.class)
//                .handled(true)
//                .process(new Processor() {
//                    @Override
//                    public void process(Exchange exchange) throws Exception {
//                        ErrorResponse errorResponse = new ErrorResponse();
//                        errorResponse.setCode("A:00003");
//                        errorResponse.setReason("Validation error");
//                        errorResponse.setMessage("Either BillingAccountId or MSISDN is required cannot be null or empty, ESB:EX00003");
//                        exchange.getIn().setBody(errorResponse);
//                    }
//                })
//                .setHeader(Exchange.HTTP_RESPONSE_CODE,constant(400))
//                .marshal(errorResponse)
//        ;
//        onException(HttpOperationFailedException.class, ConnectException.class, SocketTimeoutException.class, SocketException.class)
//                .handled(true)
//                .process(new Processor() {
//                    @Override
//                    public void process(Exchange exchange) throws Exception {
//                        ErrorResponse errorResponse = new ErrorResponse();
//                        errorResponse.setCode("A:00003");
//                        errorResponse.setReason("Internal Server Error");
//                        errorResponse.setMessage("Something Wrong in Server, Please Try After Some Time ESB:EX00003");
//                        exchange.getIn().setBody(errorResponse);
//                    }
//                })
//                .setHeader(Exchange.HTTP_RESPONSE_CODE,constant(500))
//                .marshal(errorResponse);


        restConfiguration()
                .component("undertow")
                .port("9091")
                .scheme("http")
                .contextPath("api")
                .bindingMode(RestBindingMode.off);

        rest(generateBillapiPath)
                .id("service-a-api")
                .post()
                .consumes(MediaType.APPLICATION_JSON_VALUE)
                .produces(MediaType.APPLICATION_JSON_VALUE)
                .to("direct:call-service-b");
//        from("direct:call-service-b")
//                .log("Receive Request form Client")
//                .unmarshal(channelRequest)
//                .to("bean-validator://request-validation")
//                .process(new RequestProcessor())
//                .marshal(serviceBRequest)
//                .removeHeaders("*")
//                .setHeader(Exchange.HTTP_METHOD, constant(HttpMethod.POST))
//                .log("Call to Mock Service B")
//                .to("http://localhost:3000/B/billingManagement/mock")//Using Mockoon
//                .unmarshal(serviceBResponse)
//                .log("Received Response from service B => ${body}")
//                .process(new ResponseProcessor())
//                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(201))
//                .marshal(serviceAResponse)
//                .log("Response Sent to Client");


    }
}
