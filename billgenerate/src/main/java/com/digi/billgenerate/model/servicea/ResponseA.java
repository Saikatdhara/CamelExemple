package com.digi.billgenerate.model.servicea;

public class ResponseA {

    private CustomerBill customerBill;
    private BillingAccount billingAccount;
    private RelatedParty relatedParty;

    public CustomerBill getCustomerBill() {
        return customerBill;
    }

    public void setCustomerBill(CustomerBill customerBill) {
        this.customerBill = customerBill;
    }

    public BillingAccount getBillingAccount() {
        return billingAccount;
    }

    public void setBillingAccount(BillingAccount billingAccount) {
        this.billingAccount = billingAccount;
    }

    public RelatedParty getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(RelatedParty relatedParty) {
        this.relatedParty = relatedParty;
    }
}
