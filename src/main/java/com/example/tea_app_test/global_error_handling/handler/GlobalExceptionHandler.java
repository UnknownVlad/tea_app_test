package com.example.tea_app_test.global_error_handling.handler;

import com.example.tea_app_test.global_error_handling.CustomErrorResponse;
import com.example.tea_app_test.global_error_handling.exeptions.InvalidCodeException;
import com.example.tea_app_test.global_error_handling.exeptions.NoRightPasswordException;
import com.example.tea_app_test.global_error_handling.exeptions.NotValidFields;
import com.example.tea_app_test.global_error_handling.exeptions.UserExistException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(NotValidFields.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomErrorResponse handleNotValidFields(NotValidFields ex, HttpServletRequest request) {

        return CustomErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
    }

    @ExceptionHandler(UserExistException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    @ResponseBody
    public CustomErrorResponse handleEmailAlreadyUse(UserExistException ex, HttpServletRequest request) {
        return CustomErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.CONFLICT.value())
                .error(HttpStatus.CONFLICT.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
    }


    @ExceptionHandler(InvalidCodeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomErrorResponse handleInvalidCode(InvalidCodeException ex, HttpServletRequest request) {
        return CustomErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
    }

    @ExceptionHandler(NoRightPasswordException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public CustomErrorResponse handleNoRightPassword(NoRightPasswordException ex, HttpServletRequest request) {
        return CustomErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .message(ex.getMessage())
                .path(request.getRequestURI())
                .build();
    }


}
