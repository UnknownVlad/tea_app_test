package com.example.tea_app_test.user_service.repository;



import com.example.tea_app_test.user_service.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);
}
