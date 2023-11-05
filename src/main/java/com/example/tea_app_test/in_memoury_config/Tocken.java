package com.example.tea_app_test.in_memoury_config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tocken implements Serializable {

    private String email;

    private String code;

    private Long creatingTime = System.currentTimeMillis();

    public Tocken(String email, String code) {
        this.email = email;
        this.code = code;
        //this.creatingTime = System.currentTimeMillis();
    }
    public long timeLife(){
        return (System.currentTimeMillis() - this.creatingTime)/1000;
    }
}
