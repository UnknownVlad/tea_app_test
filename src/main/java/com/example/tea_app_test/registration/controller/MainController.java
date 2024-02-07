package com.example.tea_app_test.registration.controller;


import com.example.tea_app_test.custom_exception.NotValidFields;
import com.example.tea_app_test.custom_exception.Response;
import com.example.tea_app_test.custom_exception.UserExistException;
import com.example.tea_app_test.model.product.ProductRepo;
import com.example.tea_app_test.model.product.Test;
import com.example.tea_app_test.model.user.UserDto;
import com.example.tea_app_test.registration.in_memoury_config.UTPGatewayImpl;
import com.example.tea_app_test.mail_sender.MailSender;
import com.example.tea_app_test.model.user.UserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.mail.MessagingException;
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


    @Autowired
    private ProductRepo productRepo;
    @GetMapping("/registration")
    public String registration(UserDto userDto) {
        productRepo.save(
                new Test()
        );
        return "index";
    }




    @PostMapping("/registration")
    public ResponseEntity<Response> registration(@Valid UserDto userDto, BindingResult bindingResult) throws MessagingException {
        if (bindingResult.hasErrors()){
            throw new NotValidFields("not valid fields");
        } else if(userService.findByEmail(userDto.getEmail()) != null){
            throw new UserExistException("user exist");
        }else {
            String code = utpGateway.generate();
            userService.save(userDto);
            utpGateway.save(code, userDto.getEmail());
            String message =
                    "<html><body><a href='http://localhost:8080/activate/%s'>Visit this link</a></body></html>".formatted(code);

            mailSender.sendHtmlMessage(userDto.getEmail(), "ACTIVATION CODE", message);
        }

        return ResponseEntity.ok().build();
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
        return "index";
    }


}