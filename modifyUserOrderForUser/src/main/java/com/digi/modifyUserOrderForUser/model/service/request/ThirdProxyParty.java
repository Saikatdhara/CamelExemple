package com.digi.modifyUserOrderForUser.model.service.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Getter
@Setter
@ToString
public class ThirdProxyParty {
    public String name;
    public String relationship;
    public ArrayList<IndividualIdentification> individualIdentification;
}
