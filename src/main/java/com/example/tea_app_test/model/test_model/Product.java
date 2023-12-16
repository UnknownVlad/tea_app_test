package com.example.tea_app_test.model.test_model;

import com.example.tea_app_test.model.product.Placer;
import com.example.tea_app_test.model.product.Pressing;

import javax.persistence.*;
import java.util.List;
import java.util.Map;


public class Product {


    private Long id;
    private String title;

    //Фото
    //private List<Base64> photos;


    private List<Price1> prices1;


    private List<Review> reviews;

    public Double getRate(){
        //выссчитать рейтинг из отзывов
        return null;
    }
}
