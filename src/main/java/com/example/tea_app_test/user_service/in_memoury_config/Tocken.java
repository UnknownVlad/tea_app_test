package com.example.tea_app_test.user_service.in_memoury_config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Tocken implements Serializable {
    @Id
    private String id;

    private String code;

    private Long creatingTime;

    public Tocken(String id, String code) {
        this.id = id;
        this.code = code;
        this.creatingTime = System.currentTimeMillis();
    }

    public long timeLife(){
        return (System.currentTimeMillis() - this.creatingTime)/1000;
    }
}
