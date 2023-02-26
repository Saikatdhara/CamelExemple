package com.digi.billgenerate.model.servicea;


public class RequestA {

    public BillingAccount billingAccount;
    public RelatedParty relatedParty;

    @Override
    public String toString() {
        return "RequestA{" +
                "billingAccount=" + billingAccount +
                ", relatedParty=" + relatedParty +
                '}';
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
