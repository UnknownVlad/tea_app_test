package com.example.tea_app_test.model.product;

import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@DiscriminatorValue("dishes")
@NoArgsConstructor
public class Dishes extends Product{

    private DishesType dishesType;
    private Material materialType;
    private Form form;

    private Double price;

    public Dishes(String title, String description, boolean availability, List<Review> reviews, DishesType dishesType, Material materialType, Form form, Double price) {
        super(title, description, availability, reviews);
        this.dishesType = dishesType;
        this.materialType = materialType;
        this.form = form;
        this.price = price;
    }
}
