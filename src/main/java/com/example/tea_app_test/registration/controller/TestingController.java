package com.example.tea_app_test.registration.controller;

import com.example.tea_app_test.model.abstract_model.ProductRepo;
import com.example.tea_app_test.model.abstract_model.Review;
import com.example.tea_app_test.model.abstract_model.ReviewRepo;
import com.example.tea_app_test.model.user.User;
import com.example.tea_app_test.repository.UserRepository;
import com.example.tea_app_test.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller

public class TestingController {
    @Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ReviewRepo reviewRepo;

    User user = new User();
    @GetMapping("/p")
    public String putUsrRew() {
        System.out.println(user);
        userRepository.save(user);
        Review r1 = new Review(3);
        r1.setAuthor(user);

        Review r2 = new Review(2);
        r2.setAuthor(user);

        reviewRepo.save(r1);
        reviewRepo.save(r2);
        return "";
    }

    @GetMapping("/d")
    public String delUsrRew() {
        userRepository.deleteById(user.getId());
        return "";
    }
}
