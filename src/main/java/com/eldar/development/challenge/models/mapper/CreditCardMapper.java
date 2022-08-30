package com.eldar.development.challenge.models.mapper;

import com.eldar.development.challenge.models.request.CreditCardRequest;
import com.eldar.development.challenge.models.response.CreditCardResponse;
import org.springframework.stereotype.Component;

@Component
public class CreditCardMapper {
    public CreditCardResponse creditCardRequest2CreditCardResponse(CreditCardRequest creditCardRequest, Double fee) {
        CreditCardResponse response = new CreditCardResponse();
        response.setExpirationDate(creditCardRequest.getExpirationDate());
        response.setFee(fee.toString());
        response.setMoney(creditCardRequest.getMoney());
        response.setIssuer(creditCardRequest.getIssuer());
        return response;
    }
}
