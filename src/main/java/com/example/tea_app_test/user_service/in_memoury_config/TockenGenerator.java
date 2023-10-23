package com.example.tea_app_test.user_service.in_memoury_config;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class TockenGenerator {

    /*public String generate(int length){
        return IntStream.range(0, length)
                .mapToObj(i -> String.valueOf(new Random().nextInt(10)))
                .collect(Collectors.joining());
    }*/
    public UUID generate(){
        return UUID.randomUUID();
    }
}
