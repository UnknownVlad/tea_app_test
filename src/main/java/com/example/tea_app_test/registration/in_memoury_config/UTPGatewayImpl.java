package com.example.tea_app_test.registration.in_memoury_config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;


@Service
public class UTPGatewayImpl implements UTPGateway {

    @Value("${spring.gateway.ttl}")
    private Long TTL;
    //private static final Long TTL = 1000L;
    private HashMap<String, String> codes = new HashMap<>();
    private HashMap<String, Long> creationTimes = new HashMap<>();

    @Override
    public void save(String code, String email) {
        codes.put(code, email);
        creationTimes.put(code, System.currentTimeMillis() / 1000L);
        System.out.println();
    }

    //мб есть смысл переназвать метод
    @Override
    public String isValid(String code) {
        Long creationTime = creationTimes.remove(code);
        if(creationTime == null)
            return null;

        String mail = codes.remove(code);

        if (isFinish(creationTime)) {
            return null;
        }

        return mail;
    }

    private boolean isFinish(Long creationTime){
        return System.currentTimeMillis() / 1000L - creationTime > TTL;
    }
    @Scheduled(fixedDelay = 5000)
    private void clearNonValid(){
        Set<String> keys = new HashSet<>(codes.keySet());
        for (String code: keys) {
            Long creationTime = creationTimes.get(code);
            if (creationTime == null || isFinish(creationTime)){
                codes.remove(code);
                creationTimes.remove(code);
            }
        }
    }



}
