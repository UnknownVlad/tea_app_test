package com.example.tea_app_test.user_service.tocken_service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tocken {
    private UUID id;

    private String tocken;

    public Tocken(UUID id) {
        this.id = id;
    }
}
