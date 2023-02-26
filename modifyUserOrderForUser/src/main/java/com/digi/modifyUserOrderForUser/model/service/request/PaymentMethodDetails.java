package com.digi.modifyUserOrderForUser.model.service.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentMethodDetails {
    public String paymentMethod;
    public long paymentAmount;
    public String bankCode;
    public String bankName;
    public String cardType;
    public String cardNumber;
    public String chequeNumber;
    public String remarks;
}
