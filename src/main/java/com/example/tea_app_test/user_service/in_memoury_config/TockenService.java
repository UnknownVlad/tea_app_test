package com.example.tea_app_test.user_service.in_memoury_config;

import com.example.tea_app_test.user_service.dto.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.function.Predicate;


@Slf4j
@Service
public class TockenService {

    @Autowired
    private TockenGenerator tockenGenerator;

    @Autowired
    private InMemouryContainer<UUID, UserDto> inMemouryContainer;

    private static final int TTL = 2;

    public UserDto getTocken(UUID id){
        return inMemouryContainer.get(id);
    }
    public UUID createTocken(UserDto userDto){
        UUID id = tockenGenerator.generate();
        inMemouryContainer.put(id, userDto);
        return id;
    }

    public void removeTocken(UUID id){
        inMemouryContainer.remove(id);
    }


    /*
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
            inMemouryContainer.remove(tocken.getEmail());
    }
    */

    public void print(){
        for (UUID uuid:inMemouryContainer.getConteiner().keySet()) {
            System.out.println(uuid + "  =  " + inMemouryContainer.get(uuid));
        }
    }
}
