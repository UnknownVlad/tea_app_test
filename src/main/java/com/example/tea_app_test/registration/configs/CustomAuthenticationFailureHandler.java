package com.example.tea_app_test.registration.configs;

import com.example.tea_app_test.registration.errors.UserNotFoundException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;
import org.springframework.validation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {

        BindingResult errors = new MapBindingResult(Collections.emptyMap(), "LoginForm");

        errors.reject("error", "Invalid username or password");

        String referer = request.getHeader("Referer");

        request.getSession().setAttribute("errors", errors);
        response.sendRedirect(referer);

        throw new UserNotFoundException("not valid data");



    }

    /*private BindingResult createFakeBindingResult(String errorMessage) {
        MyError myError = new MyError("loginError", errorMessage);
        List<ObjectError> errors = Collections.singletonList(new ObjectError("loginError", myError.getMessage()));
        return new BeanPropertyBindingResult(new Object(), "loginForm", true, 256) {
            @Override
            public List<ObjectError> getGlobalErrors() {
                return errors;
            }

            @Override
            public boolean hasErrors() {
                return true;
            }
        };
    }

    private static class MyError {
        private final String code;
        private final String message;

        MyError(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }*/
}
