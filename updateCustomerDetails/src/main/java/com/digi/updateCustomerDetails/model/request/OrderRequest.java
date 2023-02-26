package com.digi.updateCustomerDetails.model.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class OrderRequest {

    public String orderId;
    public String partyId;
    public ArrayList<BillingAccount> billingAccount;
    public ArrayList<ServiceAccount> serviceAccount;
}
