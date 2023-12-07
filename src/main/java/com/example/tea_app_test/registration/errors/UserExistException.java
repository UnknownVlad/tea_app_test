package com.example.tea_app_test.registration.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Email already used")
public class UserExistException extends RuntimeException {

    public UserExistException(String message) {
        super(message);
    }
}
