package com.example.tea_app_test.model.abstract_model;

import javax.persistence.*;

@Entity
@Table(name = "tea_price")
public class TeaPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double weight;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "tea_id")
    private Tea tea;

}
