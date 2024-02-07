package com.example.tea_app_test.model.abstract_model;

import com.sun.xml.bind.v2.TODO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Base64;
import java.util.Collection;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "product_type")
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "product_type", insertable = false, updatable = false)
    private String productType;

    private String title;
    private String description;


    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<Review> reviews;

    public Product(String title, String description, List<Review> reviews) {
        this.title = title;
        this.description = description;
        this.reviews = reviews;
    }
}
