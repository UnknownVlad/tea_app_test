package com.example.tea_app_test.utils;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = PasswordConstraintValidator.class)
public @interface ValidPassword {
    String message() default "Пароль должен содержать не менее 8 символов и содержать буквы верхнего и нижнего регистра";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}