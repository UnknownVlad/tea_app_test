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
    private Location location; // город/поселение/деревня
    private Production production; // заводской/фермерский
    private AdditionalProcessing additionalProcessing; // чистый/GABA
    private String variety; //сорт
    private Pressing pressing; //прессовка

    @OneToMany(mappedBy = "tea", cascade = CascadeType.ALL)
    private Collection<TeaPrice> prices; // тут ты как-то цену хотел сделать (граммы/пресовка)

    public Tea(String title, String description, boolean availability, List<Review> reviews, TeaType teaType,
               String province, String city, Location location, Production production,
               AdditionalProcessing additionalProcessing, String variety, Collection<TeaPrice> prices) {
        super(title, description, availability, reviews);
        this.teaType = teaType;
        this.country = "Китай";
        this.province = province;
        this.city = city;
        this.location = location;
        this.production = production;
        this.additionalProcessing = additionalProcessing;
        this.variety = variety;
        this.prices = prices;
    }
}
