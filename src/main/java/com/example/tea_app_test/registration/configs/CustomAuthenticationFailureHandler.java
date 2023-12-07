package com.example.tea_app_test.registration.configs;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {


    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException exception) throws IOException {


        ErrorResponse errorResponse = new ErrorResponse("Authentication failed", HttpServletResponse.SC_UNAUTHORIZED);



        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.getWriter().write(errorResponse.toJson());




    }
    private static class ErrorResponse {
        private final String message;
        private final int status;

        public ErrorResponse(String message, int status) {
            this.message = message;
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public int getStatus() {
            return status;
        }

        // Дополнительные методы, если необходимо
        public String toJson() {
            // Пример преобразования объекта в JSON
            return "{\"message\":\"" + message + "\",\"status\":" + status + "}";
        }
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
