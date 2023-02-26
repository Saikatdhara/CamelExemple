package com.digi.generateBill.processor;

import com.digi.generateBill.model.servicea.request.ServiceARequest;
import com.digi.generateBill.model.serviceb.response.ServiceBResponse;
import com.digi.generateBill.model.servicea.response.BillingAccount;
import com.digi.generateBill.model.servicea.response.CustomerBill;
import com.digi.generateBill.model.servicea.response.RelatedParty;
import com.digi.generateBill.model.servicea.response.ServiceAResponse;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class ResponseProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        ServiceBResponse serviceBResponse = exchange.getIn().getBody(ServiceBResponse.class);

        ServiceAResponse serviceAResponse = new ServiceAResponse();
        BillingAccount billingAccount = new BillingAccount();
        CustomerBill customerBill = new CustomerBill();
        RelatedParty relatedParty = new RelatedParty();

        ServiceARequest aRequestBody = (ServiceARequest) exchange.getProperty("requestBodyA");
//        System.out.println(aRequestBody.toString());

        customerBill.setId(serviceBResponse.getBillNumber());
        customerBill.setName("BillOnCustomerDemand");

        billingAccount.setId(serviceBResponse.getAccountNo());
        billingAccount.setReferredType(aRequestBody.getBillingAccount().getReferredType());

        relatedParty.setMsisdn(serviceBResponse.getMsisdn());
        relatedParty.setReferredType(aRequestBody.getRelatedParty().getReferredType());

        serviceAResponse.setBillingAccount(billingAccount);
        serviceAResponse.setCustomerBill(customerBill);
        serviceAResponse.setRelatedParty(relatedParty);
        exchange.getIn().setBody(serviceAResponse);
    }
}
