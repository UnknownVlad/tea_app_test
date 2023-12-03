package com.example.tea_app_test.registration.in_memoury_config;


import lombok.Data;
import lombok.Getter;

@Data
public class ActivationCode {
    private String code;
    private Long creationTime;

    public ActivationCode(String code) {
        this.code = code;
        this.creationTime = System.currentTimeMillis() / 1000L;
    }
}
