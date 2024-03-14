package com.example.tea_app_test.global_error_handling.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Недействительный код или его время истекло")
public class InvalidCodeException extends RuntimeException {

    public InvalidCodeException(String message) {
        super(message);
    }
}