package com.example.tea_app_test.in_memoury_config;

import org.apache.commons.lang3.RandomStringUtils;

public interface UTPGateway {
    default String generate(){
        return RandomStringUtils.random(20, true, true);
    }
    void save(String code, String email);
    String isValid(String code);



}
