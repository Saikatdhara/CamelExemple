package com.digi.generateBill.model.servicea.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceAResponse {
    private CustomerBill customerBill;
    private BillingAccount billingAccount;
    private RelatedParty relatedParty;
}
