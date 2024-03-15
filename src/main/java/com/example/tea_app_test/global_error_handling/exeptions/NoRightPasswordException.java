package com.example.tea_app_test.global_error_handling.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Не верный старый пароль")
public class NoRightPasswordException extends RuntimeException {

    public NoRightPasswordException(String message) {
        super(message);
    }
}
