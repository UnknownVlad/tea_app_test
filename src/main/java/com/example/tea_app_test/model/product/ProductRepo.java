package com.example.tea_app_test.model.product;


import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Collection<Product> findAllByProductType(String productType);


}
