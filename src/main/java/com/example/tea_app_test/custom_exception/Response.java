package com.example.tea_app_test.custom_exception;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Response {
    private String message;
    private String debugMessage;

    public Response(String message) {
    }
}
