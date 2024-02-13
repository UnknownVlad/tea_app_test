package com.example.tea_app_test;

import com.example.tea_app_test.model.user.Role;
import com.example.tea_app_test.model.user.User;
import com.example.tea_app_test.model.user.UserRepository;
import com.example.tea_app_test.model.user.UserService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureDataJpa
public class UserTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @After
    public void tearDown() {
        userRepository.deleteAll();
    }

    @Test
    public void insertionNewValidUserTest() {
        User user = new User(
                "e@mail.ru",
                "12345678AasSf",
                "name",
                "surname",
                Set.of(Role.USER),
                true
        );

        userRepository.save(user);
        User foundUser = userRepository.findByEmail(user.getEmail());

        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getName()).isEqualTo(user.getName());
        // Дополнительные проверки, если необходимо
    }
}