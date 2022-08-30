package com.eldar.development.challenge.models.request;


import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class CreditCardRequest {

    @ApiModelProperty(notes = "Name of the issuer", example = "VISA", required = true)
    private String issuer;
    @ApiModelProperty(notes = "Money only can be between $00.01 and $999.99", example = "544", required = true)
    private Double money;
    @ApiModelProperty(notes = "Credit card expiration date", example = "09/29")
    private String expirationDate;

}
