package com.example.tea_app_test.user_service.in_memoury_config;

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



}
