package com.digi.generateBill.model.serviceb.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceBRequest {
    private String accountNo;
    private String msisdn;
}
