package com.example.tea_app_test.user_service.user_service.model;

import org.springframework.security.core.GrantedAuthority;


import java.util.Arrays;

public enum Role implements GrantedAuthority {
    ADMIN,
    MODERATOR,
    USER;

    @Override
    public String getAuthority() {
        return name();
    }

}
