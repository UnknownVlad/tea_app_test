package com.example.tea_app_test.user_service.in_memoury_config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.function.Predicate;

//@Repository
@Slf4j
@Service("TockenService")
public class TockenService {
    @Autowired
    private TockenGenerator tockenGenerator;

    @Autowired
    private InMemouryContainer<String, Tocken> inMemouryContainer;
    private static final int TOCKEN_LENGTH = 6;

    private static final int TTL = 2;

    public Tocken getTocken(String id){
        removeTockenEndedTTL(id);

        return inMemouryContainer.get(id);
    }

    public Tocken createTocken(String id){
        Tocken tocken = new Tocken(id, tockenGenerator.generate(TOCKEN_LENGTH));
        inMemouryContainer.put(id, tocken);
        return tocken;
    }

    private boolean isTockenValid(String id){
        Tocken tocken = getTocken(id);
        if(tocken == null || tocken.timeLife() > TTL)
            return false;

        return true;
    }

    public void removeTockenEndedTTL(String id){
        removeTockenIf(id, tocken -> tocken.timeLife() >= TTL);
    }

    public void removeTockenIf(String id, Predicate<Tocken> predicate){
        Tocken tocken = getTocken(id);
        if(tocken == null)
            return;

        if (predicate.test(tocken))
            inMemouryContainer.remove(tocken.getId());
    }




}
