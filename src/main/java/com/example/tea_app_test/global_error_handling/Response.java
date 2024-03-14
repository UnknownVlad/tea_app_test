package com.example.tea_app_test.global_error_handling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Deprecated
public class Response {
    private String message;
    private Integer status;

    public String toJson() {
        return "{\"message\":\"" + message + "\",\"status\":" + status + "}";
    }
}
