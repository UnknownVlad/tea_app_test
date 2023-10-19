package com.example.tea_app_test.user_service.controller;


import com.example.tea_app_test.user_service.domain.Role;
import com.example.tea_app_test.user_service.domain.User;
import com.example.tea_app_test.user_service.dto.UserDto;
import com.example.tea_app_test.user_service.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    /***
     *     public String add(@RequestParam String email,
     *                       @RequestParam String password,
     *                       @RequestParam String name,
     *                       @RequestParam String surname
     *                       ) {
     *
     *        ...
     *     }
     */

    @GetMapping("/registration")
    public String registration() {



        return "registration";
    }


    @PostMapping("/registration")
    public String add(@Valid UserDto userDto) {
        userService.save(userDto);
        return "redirect:/login";
    }


}