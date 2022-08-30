package com.eldar.development.challenge.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
public class ApiErrorResponse {
    private HttpStatus status;
    private String message;
}
