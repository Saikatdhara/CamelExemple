package com.digi.generateBill.model.servicea.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ServiceARequest{
    @Valid
    @NotNull
    private BillingAccount billingAccount;
    @Valid
    @NotNull
    private RelatedParty relatedParty;
}
