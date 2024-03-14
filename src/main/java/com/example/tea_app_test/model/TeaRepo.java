package com.example.tea_app_test.model;

import com.example.tea_app_test.model.product.tea.Tea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Year;
import java.util.Optional;

public interface TeaRepo extends JpaRepository<Tea, Long> {

    public Optional<Tea> findById(long id);
}
