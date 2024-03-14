package com.example.tea_app_test.global_error_handling.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.CONFLICT, reason="Пользователь с таким email адресом уже существует")
public class UserExistException extends RuntimeException {

    public UserExistException(String message) {
        super(message);
    }
}
