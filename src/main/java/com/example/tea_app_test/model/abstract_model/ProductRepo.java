package com.example.tea_app_test.model.abstract_model;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Collection<Product> findAllByProductType(String productType);


}
