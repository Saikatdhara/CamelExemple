package com.digi.modifyUserOrderForUser.model.service.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class UserRequest {
    public String orderType;
    public String userId;
    public String subscriberId;
    public String msisdn;
    public String imsi;
    public String iccid;
    public String staffIdAmb;
    public boolean smsNotifySettingsFlag;
    public ArrayList<RelatedParty> relatedParty;
    public ArrayList<LanguageAbility> languageAbility;
    public ArrayList<LifecycleInfo> lifecycleInfo;
    public ArrayList<PartyCharacteristic> partyCharacteristic;
    public CreditLimit creditLimit;
    public ThirdProxyParty thirdProxyParty;
    public Payment payment;
}
