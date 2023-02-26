package com.digi.generateBill.model.serviceb.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ServiceBResponse {
    private String accountNo;
    private String msisdn;
    private String billNumber;
    private String requestStatus;

}
