package com.example.tea_app_test.user_service.user_service.dto;

import com.example.tea_app_test.user_service.user_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
