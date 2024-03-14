package com.example.tea_app_test.registration.controller;


import com.example.tea_app_test.global_error_handling.exeptions.InvalidCodeException;
import com.example.tea_app_test.global_error_handling.exeptions.NotValidFields;
import com.example.tea_app_test.mail_sender.MailSender;
import com.example.tea_app_test.model.user.User;
import com.example.tea_app_test.model.user.UserDTO;
import com.example.tea_app_test.model.user.UserService;
import com.example.tea_app_test.registration.in_memoury_config.UTPGatewayImpl;
import com.example.tea_app_test.utils.ValidEmail;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reset")
public class UpdUserDataController {

    @Autowired
    private UTPGatewayImpl utpGateway;
    @Autowired
    private UserService userService;
    @Autowired
    private MailSender mailSender;

    //Подумать как убрать BindingResult
    @PostMapping("/forgot/password")
    public ResponseEntity<?> forgotPassword(@RequestParam String email) throws MessagingException {

        //мб для безопасности данные не стоит вообще сигнализировать об этом
        if (userService.findByEmail(email) == null) {
            throw new IllegalArgumentException("Пользователя с таким email не существует");
        }

        String code = utpGateway.generate();
        utpGateway.save(code, email);

        String message = "Код подтверждения для обновления пароля: \n%s".formatted(code);
        mailSender.sendHtmlMessage(email, "Upd password", message);

        return ResponseEntity.ok().build();
        /*System.out.println("ПАРОЛЬ");
        if (bindingResult.hasErrors()){
            throw new NotValidFields("Вы предоставили невалидные данные");
        } else if (userService.findByEmail(email) == null) {
            throw new IllegalArgumentException("Пользователя с таким email не существует");
        } else {
            //мб, есть смысл пользователя неактивным в этот момент
            String code = utpGateway.generate();
            utpGateway.save(code, email);

            String message = "Код подтверждения для обновления пароля: \n%s".formatted(code);
            mailSender.sendHtmlMessage(email, "Upd password", message);
        }
        return ResponseEntity.ok().build();*/
    }

    //подумать, как реализовать слегка иначе
    @PostMapping("/forgot/password/update")
    public ResponseEntity<?> upd(
            @RequestParam String code,
            @RequestParam("new_password") String newPassword
    ) {
        String email = utpGateway.isValid(code);

        if (email == null){
            throw new InvalidCodeException("Недействительный код или его время истекло");
        }else {
            User user = userService.findByEmail(email);
            user.setPassword(newPassword);
        }

        return ResponseEntity.ok().build();

    }




}
