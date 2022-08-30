package com.eldar.development.challenge.models.response;

import lombok.Data;

@Data
public class CreditCardResponse {
    private String issuer;
    private Double money;
    private String expirationDate;
    private String fee;
}
