package com.example.tea_app_test.registration.errors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<UserExistException> handleException(Exception e) {
        String errorMessage = "Произошла ошибка: " + e.getMessage();
        UserExistException errorResponse = new UserExistException(errorMessage);
        System.out.println("Перехватил");
        return ResponseEntity.badRequest().body(errorResponse);
    }
}