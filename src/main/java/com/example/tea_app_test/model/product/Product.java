package com.example.tea_app_test.model.product;

import javax.persistence.*;
import java.util.Base64;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;

    private List<Base64> photos;
    private double rate;

    @OneToOne(mappedBy = "products", orphanRemoval = true)
    private Price price;

    private String description;

    @OneToMany(mappedBy = "products", orphanRemoval = true)
    private List<Review> reviews;

}
