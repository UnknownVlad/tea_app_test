package com.example.tea_app_test.registration.controller;

import com.example.tea_app_test.global_error_handling.exeptions.NotValidFields;
import com.example.tea_app_test.mail_sender.MailSender;
import com.example.tea_app_test.model.user.Role;
import com.example.tea_app_test.model.user.User;
import com.example.tea_app_test.model.user.UserDTO;
import com.example.tea_app_test.model.user.UserService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/test")
public class TestingController {
    @Autowired
    private UserService userService;

    @Autowired
    private MailSender mailSender;
    //Тут ошибка исправить

    @PostMapping("/mail-sender/send")
    public ResponseEntity<?> sendMessage(String email, String message) throws MessagingException {
        mailSender.sendHtmlMessage(email, "Common message", message);

        return ResponseEntity.ok().build();
    }

    @PostMapping("/create-roles-pack")
    public ResponseEntity<?> createRolesPack(){

        Set<Role> names = Set.of(Role.ROLE_ADMIN, Role.ROLE_MODERATOR);
        for (Role r: names){
            if (userService.findByEmail(r.name()) == null){

                userService.save(
                        User.builder()
                                .email(r.name())
                                .name(r.name())
                                .surname(r.name())
                                .roles(Set.of(r))
                                .active(true)
                                .password(r.name())
                                .build()
                );
            }
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-all")
    public List<User> getAll(){
        System.out.println("+");
        return userService.findAll();
    }

}
