package com.example.tea_app_test.repository;



import com.example.tea_app_test.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findById(long id);
}
