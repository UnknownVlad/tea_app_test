package com.example.tea_app_test.registration.controller;


import com.example.tea_app_test.global_error_handling.exeptions.InvalidCodeException;
import com.example.tea_app_test.global_error_handling.exeptions.NotValidFields;
import com.example.tea_app_test.model.product.ProductRepo;
import com.example.tea_app_test.model.user.Role;
import com.example.tea_app_test.model.user.User;
import com.example.tea_app_test.model.user.UserDTO;
import com.example.tea_app_test.registration.in_memoury_config.UTPGatewayImpl;
import com.example.tea_app_test.mail_sender.MailSender;
import com.example.tea_app_test.model.user.UserService;


import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.hibernate5.SpringSessionContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
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


    /*@Autowired
    private ProductRepo productRepo;*/
    @GetMapping("/registration")
    public String registration(UserDTO userDTO) {
        return "index";
    }


    @PostMapping("/my-page")
    public UserDTO myPage(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            User loggedInUser = (User) authentication.getPrincipal();
            return UserDTO.builder()
                    .email(loggedInUser.getEmail())
                    .name(loggedInUser.getName())
                    .surname(loggedInUser.getSurname())
                    .role(loggedInUser.getRoles())
                    .build();
        } else {
            //TO-DO придумать что-нибудь с этой ошибкой, не до конца верна
            throw new IllegalStateException("Пользователь не найден");
        }
    }




    @PostMapping("/registration")
    public ResponseEntity<?> registration(@Valid UserDTO userDTO, BindingResult bindingResult) throws MessagingException {
        if (bindingResult.hasErrors()){
            throw new NotValidFields("Вы предоставили невалидные данные");
        }
        userService.save(userDTO);

        String code = utpGateway.generate();
        utpGateway.save(code, userDTO.getEmail());

        String message =
                "<html><body><a href='http://localhost:8080/activate/%s'>Visit this link</a></body></html>".formatted(code);
        mailSender.sendHtmlMessage(userDTO.getEmail(), "ACTIVATION CODE", message);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/activate/{code}")
    public ResponseEntity<?> activate(@PathVariable("code") String code){
        String email = utpGateway.isValid(code);
        if(email == null){
            throw new InvalidCodeException("Недействительный код или его время истекло");
        }else {
            userService.activateAccount(email);
        }
        return ResponseEntity.ok().build();
    }


}