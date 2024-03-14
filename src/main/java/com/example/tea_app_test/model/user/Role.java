package com.example.tea_app_test.model.user;


import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_ADMIN,
    ROLE_MODERATOR,
    ROLE_USER;

    @Override
    public String getAuthority() {
        return name();
    }


}
