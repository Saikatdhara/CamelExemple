package com.digi.generateBill.model.servicea.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class BillingAccount {
    private String id;
    @JsonProperty("@referredType")
    private String referredType;
}
