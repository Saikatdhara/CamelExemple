package com.digi.billgenerate.model.servicea;

public class RelatedParty {
    public String msisdn;
    public String referredType;

    @Override
    public String toString() {
        return "RelatedParty{" +
                "msisdn='" + msisdn + '\'' +
                ", referredType='" + referredType + '\'' +
                '}';
    }

    public String getMsisdn() {
        return msisdn;
    }

    public void setMsisdn(String msisdn) {
        this.msisdn = msisdn;
    }

    public String getReferredType() {
        return referredType;
    }

    public void setReferredType(String referredType) {
        this.referredType = referredType;
    }
}
