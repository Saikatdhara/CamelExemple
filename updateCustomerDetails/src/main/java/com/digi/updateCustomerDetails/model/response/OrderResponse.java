package com.digi.updateCustomerDetails.model.response;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class OrderResponse {
    public String orderId;
    public String partyId;
    public String code;
    public String message;
    public ArrayList<BillingAccountResponse> billingAccount;
    public ArrayList<ServiceAccountResponse> serviceAccount;
}
