package com.example.tea_app_test.model.user;



import com.example.tea_app_test.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

    User findById(long id);
}
