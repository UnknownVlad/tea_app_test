package com.example.tea_app_test.model.product;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.List;

@Entity
@DiscriminatorValue("test")
public class Test extends Product{

    //Остальные атрибуты
    private String test;

    public Test(String title, String description, List<Review> reviews) {
        super(title, description, reviews);
    }

    public Test() {
    }
}
