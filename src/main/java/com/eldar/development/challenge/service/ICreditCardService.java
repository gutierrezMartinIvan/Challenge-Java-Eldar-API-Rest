package com.eldar.development.challenge.service;

import com.eldar.development.challenge.models.request.CreditCardRequest;
import com.eldar.development.challenge.models.response.CreditCardResponse;

public interface ICreditCardService {

    CreditCardResponse getFeeOperation(CreditCardRequest creditCardRequest);
}
