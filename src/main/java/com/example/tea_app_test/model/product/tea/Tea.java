package com.example.tea_app_test.model.product.tea;

import com.example.tea_app_test.model.product.Product;
import com.example.tea_app_test.model.product.Review;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
@DiscriminatorValue("tea")
@NoArgsConstructor
public class Tea extends Product {

    private TeaType teaType;
    private String country;
    private String province; //провинция
    private String city; // город(столица)
    private boolean citySettlement; // город/поселение/деревня
    private boolean factoryFarm; // заводской/фермерский
    private boolean additionalProcessing; // чистый/GABA
    private String variety; //сорт

    // вместо boolean думаю будет лучше enum

    @OneToMany(mappedBy = "tea", cascade = CascadeType.ALL)
    private Collection<TeaPrice> prices; // тут ты как-то цену хотел сделать (граммы/пресовка)

    public Tea(String title, String description, boolean availability, List<Review> reviews, TeaType teaType,
               String province, String city, boolean citySettlement, boolean factoryFarm,
               boolean additionalProcessing, String variety, Collection<TeaPrice> prices) {
        super(title, description, availability, reviews);
        this.teaType = teaType;
        this.country = "Китай";
        this.province = province;
        this.city = city;
        this.citySettlement = citySettlement;
        this.factoryFarm = factoryFarm;
        this.additionalProcessing = additionalProcessing;
        this.variety = variety;
        this.prices = prices;
    }
}
