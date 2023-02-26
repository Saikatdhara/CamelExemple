package com.digi.RetrieveBusinessEntity.process;

import com.digi.RetrieveBusinessEntity.model.BusinessEntityCIMResponse;
import com.digi.RetrieveBusinessEntity.model.BusinessEntityDetails;
import com.digi.RetrieveBusinessEntity.model.Response;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class FinalResponseProcess implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        BusinessEntityCIMResponse finalObj = exchange.getIn().getBody(BusinessEntityCIMResponse.class);
        Response response = new Response();
        BusinessEntityDetails businessEntityDetails = new BusinessEntityDetails();
        businessEntityDetails.setId(finalObj.beId);
        businessEntityDetails.setSubRootId(finalObj.subRootId);
        response.setBusinessEntityDetails(businessEntityDetails);
        exchange.getIn().setBody(response);
    }
}
