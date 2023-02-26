package com.digi.billgenerate.model.servicea;

public class BillingAccount {
    public String id;
    public String referredType;

    @Override
    public String toString() {
        return "BillingAccount{" +
                "id='" + id + '\'' +
                ", referredType='" + referredType + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getReferredType() {
        return referredType;
    }

    public void setReferredType(String referredType) {
        this.referredType = referredType;
    }
}
