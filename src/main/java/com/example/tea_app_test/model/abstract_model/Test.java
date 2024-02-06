package com.example.tea_app_test.model.abstract_model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;
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
