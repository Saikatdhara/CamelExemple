package com.digi.RetrieveBusinessEntity.model.error;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ErrorResponse {

    String code;
    String reason;
    String message;
}
