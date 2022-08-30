package com.eldar.development.challenge.service.impl;

import com.eldar.development.challenge.exception.AmountExceededException;
import com.eldar.development.challenge.exception.InvalidCreditCardException;
import com.eldar.development.challenge.models.mapper.CreditCardMapper;
import com.eldar.development.challenge.models.request.CreditCardRequest;
import com.eldar.development.challenge.models.response.CreditCardResponse;
import com.eldar.development.challenge.service.ICreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService implements ICreditCardService {
    private Double fee;
    @Autowired
    private CreditCardMapper cardMapper;
    @Override
    public CreditCardResponse getFeeOperation(CreditCardRequest creditCardRequest) {
        fee = getCreditCardFee(creditCardRequest.getIssuer().toLowerCase(), creditCardRequest.getExpirationDate());
        if (fee==null)
            throw new InvalidCreditCardException("Please insert a valid credit card");
        CreditCardResponse response;
        if (isOperationValid(creditCardRequest.getMoney()))
            response = cardMapper.creditCardRequest2CreditCardResponse(creditCardRequest, fee);
        else
            throw new AmountExceededException("The operation can only be carried out with a value of up to $999.99");
        return response;
    }

    private boolean isOperationValid(Double money) {
        return money < 1000D && money > 0;
    }

    private Double getCreditCardFee(String issuer, String expirationDate) {
        String result = expirationDate.replaceAll("/", "");
        final int mid = result.length() / 2;
        String[] parts = {result.substring(0, mid), result.substring(mid)};
        switch (issuer){
            case "visa":
                fee = Double.parseDouble(parts[0]) / Double.parseDouble(parts[1]);
                break;
            case "nara":
                fee = Double.parseDouble(parts[0]) * 0.1;
                break;
            case "amex":
                fee = Double.parseDouble(parts[0]) * 0.5;
                break;
            default:
                fee = null;
        }
        return fee;
    }
}
