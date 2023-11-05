package com.example.tea_app_test.in_memoury_config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.HashMap;


@Service
public class UTPGatewayImpl implements UTPGateway {
    private HashMap<String, String> codes = new HashMap<>();
    @Override
    public void save(String code, String email) {
        codes.put(code, email);
    }
    @Override
    public String isValid(String code) {
        return codes.getOrDefault(code, null);
    }

}
