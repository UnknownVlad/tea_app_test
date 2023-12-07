//package com.example.tea_app_test.registration.errors;
//
//import com.example.tea_app_test.custom_exception.UserExistException;
//import com.example.tea_app_test.custom_exception.UserNotFoundException;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ControllerAdvice;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.ResponseStatus;
//
//@ControllerAdvice
//class GlobalControllerExceptionHandler {
//
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(UserExistException.class)
//    public void userExist() {
//        System.out.println("exist");
//    }
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    @ExceptionHandler(UserNotFoundException.class)
//    public void notFoundUser() {
//        System.out.println("not found");
//    }
//
//}