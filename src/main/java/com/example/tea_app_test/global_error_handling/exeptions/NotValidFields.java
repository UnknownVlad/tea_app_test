package com.example.tea_app_test.global_error_handling.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Вы предоставили невалидные данные")
public class NotValidFields extends RuntimeException {

    public NotValidFields(String message) {
        super(message);
    }
}
