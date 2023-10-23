package com.example.tea_app_test.user_service.controller;


import com.example.tea_app_test.user_service.dto.UserDto;

import com.example.tea_app_test.user_service.in_memoury_config.Tocken;
import com.example.tea_app_test.user_service.in_memoury_config.TockenService;
import com.example.tea_app_test.user_service.mail_sender.MailSender;
import com.example.tea_app_test.user_service.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.UUID;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private TockenService tockenSevice;

    @Autowired
    private MailSender mailSender;


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

    /*@PostMapping("/registration")
    public String registration(UserDto userDto, @RequestParam String action){
        System.out.println(userDto);
        if (action.equals("add")){
            System.out.println("add");
        }else if (action.equals("send")){
            System.out.println("send");
        }

        return "registration";
    }
    */
    @GetMapping("/registration")
    public String registration() {
        return "registration";
    }


    @PostMapping("/registration")
    public String registration(@Valid UserDto userDto){
        if(userService.findByEmail(userDto.getEmail()) != null){
            System.out.println("User already exist");
            return null;
        }else {
            UUID tocken = tockenSevice.createTocken(userDto);

            String message =
                    String.format("Hello, %s! \n", userDto.getName()) +
                    "Please, visit next link: \n" +
                    "http://localhost:8080/activate/" + tocken.toString();

            mailSender.send(userDto.getEmail(), "ACTIVATION CODE", message);
        }
        tockenSevice.print();

        return "registration";
    }

    @GetMapping("/activate/{code}")
    public String activate(@PathVariable("code") String code){
        System.out.println("+++++");

        UUID tocken = UUID.fromString(code);
        UserDto userDto = tockenSevice.getTocken(tocken);
        if(userDto == null){
            System.out.println("Activateion code dont actual");
            return "";
        }else {
            userService.save(userDto);
            tockenSevice.removeTocken(tocken);
        }

        return "login";

    }







}