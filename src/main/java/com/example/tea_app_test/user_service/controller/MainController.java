package com.example.tea_app_test.user_service.controller;


import com.example.tea_app_test.user_service.dto.UserDto;

import com.example.tea_app_test.user_service.in_memoury_config.Tocken;
import com.example.tea_app_test.user_service.in_memoury_config.TockenService;
import com.example.tea_app_test.user_service.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private TockenService tockenSevice;




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
    public String add(@Valid UserDto userDto) throws InterruptedException {
        userService.save(userDto);
        return "redirect:/login";
    }
    //@PostMapping("/registration")
    public void sendCode(@RequestParam("email") String email) throws InterruptedException {
        Tocken tocken = tockenSevice.createTocken(email);
        System.out.println(tocken);
    }
    @GetMapping(value="/send")
    public void run(){
        System.out.println("Test1");
        System.out.println("Test2");
        System.out.println("Test3");
        System.out.println("Test4");
    }


}