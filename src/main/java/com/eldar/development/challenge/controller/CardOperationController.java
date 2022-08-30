package com.eldar.development.challenge.controller;

import com.eldar.development.challenge.models.request.CreditCardRequest;
import com.eldar.development.challenge.models.response.CreditCardResponse;
import com.eldar.development.challenge.service.ICreditCardService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/card")
@Api(value = "Credit card controller", tags = "Credit Card")
public class CardOperationController {

    @Autowired
    private ICreditCardService cardService;

    @PutMapping
    public ResponseEntity<CreditCardResponse> getFeeOperation(@RequestBody CreditCardRequest creditCardRequest) {
        CreditCardResponse response = cardService.getFeeOperation(creditCardRequest);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
