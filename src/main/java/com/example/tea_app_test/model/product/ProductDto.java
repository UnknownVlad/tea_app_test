package com.example.tea_app_test.model.product;

import java.util.Base64;
import java.util.List;

public class ProductDto {
    private String title;
    private List<Base64> photos;
    private double rate;
    private Price price;
    private String description;
    private List<Review> reviews;
}
