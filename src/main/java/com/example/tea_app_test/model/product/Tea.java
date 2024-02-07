package com.example.tea_app_test.model.product;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Entity
@DiscriminatorValue("tea")
public class Tea extends Product{


    //Остальные атрибуты
    @OneToMany(mappedBy = "tea", cascade = CascadeType.ALL)
    private Collection<TeaPrice> prices;

    public Tea(String title, String description, boolean availability, List<Review> reviews, Collection<TeaPrice> prices) {
        super(title, description, availability, reviews);
        prices = new HashSet<>();
    }

    public Tea() {
    }
}
