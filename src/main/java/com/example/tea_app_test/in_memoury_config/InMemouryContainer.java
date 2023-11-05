package com.example.tea_app_test.in_memoury_config;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class InMemouryContainer<K, V> {
    private HashMap<K, V> conteiner = new HashMap<>();


    public V get(K id){

        return conteiner.getOrDefault(id, null);
    }

    public void put(K key, V value){
        conteiner.put(key, value);
    }

    public V remove(K key){
        return conteiner.remove(key);
    }

    public HashMap<K, V> getConteiner() {
        return conteiner;
    }


}
