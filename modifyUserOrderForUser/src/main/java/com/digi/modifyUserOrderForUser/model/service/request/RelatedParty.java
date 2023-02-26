package com.digi.modifyUserOrderForUser.model.service.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RelatedParty {

    @JsonProperty("@referredType")
    public String referredType;
    public String id;
}
