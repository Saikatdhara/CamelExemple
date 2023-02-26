package com.digi.updateCustomerDetails.model.errorMsg;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorMessage {

    public String orderId;
    public String partyId;
    public String id;
    public String code;
    public String reason;
    public String message;
}
