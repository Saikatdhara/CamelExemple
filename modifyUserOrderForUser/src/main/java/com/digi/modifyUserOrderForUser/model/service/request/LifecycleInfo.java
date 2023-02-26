package com.digi.modifyUserOrderForUser.model.service.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class LifecycleInfo {
    public String expiry;
    public String state;
    public String reason;
}
