package com.digi.RetrieveBusinessEntity.route;

import com.digi.RetrieveBusinessEntity.model.BusinessEntityCIMResponse;
import com.digi.RetrieveBusinessEntity.model.BusinessEntityDetails;
import com.digi.RetrieveBusinessEntity.model.Response;
import com.digi.RetrieveBusinessEntity.model.error.ErrorResponse;
import com.digi.RetrieveBusinessEntity.process.FinalResponseProcess;
import com.digi.RetrieveBusinessEntity.process.ProcessResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.http.common.HttpOperationFailedException;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.camel.spi.DataFormat;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;

@Component
public class MainRoute extends RouteBuilder {



    @Value(value = "api.RetrieveBusinessEntity.path")
    String apiPath;
    @Override
    public void configure() throws Exception {

        DataFormat cimResponse = new JacksonDataFormat(BusinessEntityCIMResponse.class);
        DataFormat finalResponse = new JacksonDataFormat(Response.class);
        DataFormat errorResponse = new JacksonDataFormat(ErrorResponse.class);

        onException(HttpOperationFailedException.class, ConnectException.class, SocketTimeoutException.class, SocketException.class)
                .handled(true)
                .process(new Processor() {
                    @Override
                    public void process(Exchange exchange) throws Exception {
                        ErrorResponse errorResponse = new ErrorResponse();
                        errorResponse.setCode("DAG:00001");
                        errorResponse.setReason("Connection Error. Exception happened while processing the request");
                        errorResponse.setMessage("Connection Error. ESB:EX00001");
                        exchange.getIn().setBody(errorResponse);
                    }
                })
                .setHeader(Exchange.HTTP_RESPONSE_CODE, constant(400))
                .marshal(errorResponse);



        restConfiguration().component("undertow")
                .port(9901)
                .scheme("http")
                .bindingMode(RestBindingMode.off);


            rest("{{api.RetrieveBusinessEntity.path}}")
                    .get()
                    .produces(MediaType.APPLICATION_JSON_VALUE)
                    .consumes(MediaType.APPLICATION_JSON_VALUE)
                    .to("direct:consume-param-from-url");
            from("direct:consume-param-from-url")
                    .process(new ProcessResponse())
                    .log("Headers => ${headers} , body => ${body}")
                    .to("direct:call-cim-service");
            from("direct:call-cim-service")
                    .removeHeaders("*")
                    .setHeader(Exchange.HTTP_METHOD, constant(HttpMethod.GET))
                    .to("http://localhost:3000/DAG/subscriberManagement/v1/CIM")
                    .unmarshal(cimResponse)
                    .log("called service CIM")
                    .to("direct:process-for-final-response");
            from("direct:process-for-final-response")
                    .process(new FinalResponseProcess())
                    .setHeader(Exchange.HTTP_RESPONSE_CODE,constant(200))
//                    .setHeader(Exchange.H)
                    .marshal(finalResponse)
                    .log("${body}");
    }
}
