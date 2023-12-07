package com.example.tea_app_test.custom_exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Not valid data")
public class NotValidFields extends RuntimeException {

    public NotValidFields(String message) {
        super(message);
    }
}
