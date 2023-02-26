package com.digi.generateBill.model.servicea.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class BillingAccount {
    @NotNull
    private String id;
    @JsonProperty("@referredType")
    private String referredType;
}
