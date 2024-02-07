package com.example.tea_app_test.model.product.tea;

import com.example.tea_app_test.model.product.tea.Tea;

import javax.persistence.*;

@Entity
@Table(name = "tea_price")
public class TeaPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
//    private Double weight;
    private Integer gram;
    private Double price;

    @ManyToOne
    @JoinColumn(name = "tea_id")
    private Tea tea;

}
