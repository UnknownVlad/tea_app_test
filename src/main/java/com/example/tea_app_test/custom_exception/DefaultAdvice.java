package com.example.tea_app_test.custom_exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DefaultAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<Response> handleException1(UserExistException e) {
        System.out.println("handleException1");
        Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST); // HttpStatus.OK может быть и HttpStatus.BAD_REQUEST
    }


    @ExceptionHandler(NotValidFields.class)
    public ResponseEntity<Response> handleException2(NotValidFields e) {
        System.out.println("handleException2");

        Response response = new Response(e.getMessage(), HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }



    /*@Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable
            (HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        Response response = new Response(ex.getMessage(), HttpStatus.BAD_REQUEST.value());
        System.out.println(status);
        return new ResponseEntity<>(response, status);
    }*/
}
