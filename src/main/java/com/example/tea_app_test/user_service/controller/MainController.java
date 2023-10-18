package com.example.tea_app_test.user_service.controller;


import com.example.tea_app_test.user_service.domain.Role;
import com.example.tea_app_test.user_service.domain.User;
import com.example.tea_app_test.user_service.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
import java.util.Set;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    /*@GetMapping("/hello")
    public String greeting(
            @RequestParam(name="name", required=false, defaultValue="World") String name,
            Map<String, Object> model
    ) {
        System.out.println("hello");
        model.put("name", name);
        return "hello";
    }*/

    @GetMapping("/registration")
    public String registration(Map<String, Object> model) {
        System.out.println("get registration");

        return "registration";
    }

    @PostMapping("/registration")
    public String add(@RequestParam String email,
                      @RequestParam String password,
                      @RequestParam String name,
                      @RequestParam String surname,
                      Map<String, Object> model) {

        System.out.println("post registration");
        User user = new User(email, password, name, surname,
                Set.of(Role.ADMIN, Role.USER, Role.MODERATOR),
                true);


        userService.save(user);



        model.put("users", user);


        return "redirect:/login";
    }

    /*@GetMapping("/login")
    public String login(Map<String, Object> model) {
        System.out.println("get registration");

        return "login";
    }
    @PostMapping("/login")
    public String loginning(@RequestParam String email,
                      @RequestParam String password,
                      Map<String, Object> model) {


        System.out.println("TESTING");
        System.out.println(email);
        System.out.println(password);


        return "redirect:/hello";
    }
*/


}