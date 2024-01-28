package com.example.tea_app_test.model.abstract_model;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@DiscriminatorValue("tea")
public class Tea extends Product{

    //Остальные атрибуты
    @OneToMany(mappedBy = "tea", cascade = CascadeType.ALL)
    private Collection<TeaPrice> prices;

}
