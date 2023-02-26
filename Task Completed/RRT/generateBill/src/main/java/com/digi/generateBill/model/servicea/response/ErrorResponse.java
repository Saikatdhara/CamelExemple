package com.digi.generateBill.model.servicea.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private String code;
    private String reason;
    private String message;
}
