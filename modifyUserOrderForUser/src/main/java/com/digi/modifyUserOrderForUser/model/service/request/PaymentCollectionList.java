package com.digi.modifyUserOrderForUser.model.service.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentCollectionList {
    public String channelId;
    public String branchCode;
    public PaymentMethodDetails paymentMethodDetails;
}
