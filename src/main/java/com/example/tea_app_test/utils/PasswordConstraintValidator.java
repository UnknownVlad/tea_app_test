package com.example.tea_app_test.utils;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordConstraintValidator implements ConstraintValidator<ValidPassword, String> {
    @Override
    public void initialize(ValidPassword constraintAnnotation) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        if (password == null) {
            return false;
        }
        // Проверка длины пароля
        if (password.length() < 8) {
            return false;
        }
        // Проверка наличия символов верхнего и нижнего регистра
        boolean hasUpperCase = false;
        boolean hasLowerCase = false;
        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) {
                hasUpperCase = true;
            }
            if (Character.isLowerCase(c)) {
                hasLowerCase = true;
            }
        }
        return hasUpperCase && hasLowerCase;
    }
}