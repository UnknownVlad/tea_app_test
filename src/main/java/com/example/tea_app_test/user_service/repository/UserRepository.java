package com.example.tea_app_test.user_service.repository;



import com.example.tea_app_test.user_service.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
