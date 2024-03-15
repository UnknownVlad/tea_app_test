package com.example.tea_app_test.registration.controller;


import com.example.tea_app_test.global_error_handling.exeptions.InvalidCodeException;
import com.example.tea_app_test.global_error_handling.exeptions.NoRightPasswordException;
import com.example.tea_app_test.global_error_handling.exeptions.NotValidFields;
import com.example.tea_app_test.mail_sender.MailSender;
import com.example.tea_app_test.model.user.User;
import com.example.tea_app_test.model.user.UserDTO;
import com.example.tea_app_test.model.user.UserService;
import com.example.tea_app_test.registration.in_memoury_config.UTPGatewayImpl;
import com.example.tea_app_test.utils.ValidEmail;
import com.example.tea_app_test.utils.ValidPassword;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;

    //Подумать как убрать BindingResult
    @PostMapping("/password/update")
    public ResponseEntity<?> forgotPassword(@ValidEmail @RequestParam String email) throws MessagingException {
        //мб для безопасности данные не стоит вообще сигнализировать об этом
        /*if (userService.findByEmail(email) == null) {
            throw new IllegalArgumentException("Пользователя с таким email не существует");
        }*/
        String code = utpGateway.generate();
        utpGateway.save(code, email);

        String message = "Код подтверждения для обновления пароля: \n%s".formatted(code);
        mailSender.sendMessage(email, "Upd password", message);

        return ResponseEntity.ok().build();
    }


    //возможно, стоит кидать более короткие коды подтверждения(опционально, тогда придется менять гетвей)
    @PostMapping("/password/update/forgot")
    public ResponseEntity<?> updateForgottenPassword(
            @RequestParam String code,
            @ValidPassword @RequestParam("new_password") String newPassword
    ) {
        String email = utpGateway.isValid(code);

        if (email == null){
            throw new InvalidCodeException("Недействительный код или его время истекло");
        }else {
            User user = userService.findByEmail(email);
            user.setPassword(newPassword);
            userService.save(user);
        }
        return ResponseEntity.ok().build();
    }


    //Протестить в последствии
    @PostMapping("/password/update/new")
    public ResponseEntity<?> updateOldPassword(
            @RequestParam String oldPassword,
            @ValidPassword @RequestParam("new_password") String newPassword
    ) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof User) {
            User loggedInUser = (User) authentication.getPrincipal();
            if (loggedInUser.getPassword().equals(passwordEncoder.encode(oldPassword))){
                loggedInUser.setPassword(newPassword);
                userService.save(loggedInUser);
            }else{
                throw new NoRightPasswordException("Не верный старый пароль");
            }
        }
        return ResponseEntity.ok().build();
    }




}
