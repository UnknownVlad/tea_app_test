package com.example.tea_app_test.controller;


import com.example.tea_app_test.in_memoury_config.UTPGateway;
import com.example.tea_app_test.in_memoury_config.UTPGatewayImpl;
import com.example.tea_app_test.mail_sender.MailSender;
import com.example.tea_app_test.repository.UserService;
import com.example.tea_app_test.dto.UserDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private UTPGatewayImpl utpGateway;

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
            String code = utpGateway.generate();
            userService.save(userDto);
            utpGateway.save(code, userDto.getEmail());
            String message =
                    String.format("Hello, %s! \n", userDto.getName()) +
                    "Please, visit next link: \n" +
                    "http://localhost:8080/activate/" + code;
            mailSender.send(userDto.getEmail(), "ACTIVATION CODE", message);
        }


        return "registration";
    }

    @GetMapping("/activate/{code}")
    public String activate(@PathVariable("code") String code){
        String email = utpGateway.isValid(code);
        if(email == null){
            System.out.println("Activateion code dont actual");
            return null;
        }else {
            userService.activateAccount(email);
        }
        return "login";
    }

    








}