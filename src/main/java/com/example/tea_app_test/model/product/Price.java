package com.example.tea_app_test.model.product;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.util.Map;

@Entity
@Table(name = "prices")
@AllArgsConstructor
@NoArgsConstructor
public class Price {

//    @Id
//    @ManyToOne
//    @JoinColumn(foreignKey = @ForeignKey(name = "product_id"))
//    private Product product;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "product_id"))
    private Product product;

    private Map<Pressing, Double> pricesOfPress;
    private Map<Placer, Double> pricesOfGram; // вроде в hibernate нельзя так делать

    public void setPricesOfPress(Pressing pressing, double price) {
        pricesOfPress.put(pressing, price);
    }

    public double getPricesOfPress(Pressing pressing) {
        return pricesOfPress.get(pressing);
    }

    public void setPricesOfGram(Placer placer, double price) {
        pricesOfGram.put(placer, price);
    }

    public double getPricesOfGram(Placer placer) {
        return pricesOfGram.get(placer);
    }
}
