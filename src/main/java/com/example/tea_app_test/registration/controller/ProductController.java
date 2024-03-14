package com.example.tea_app_test.registration.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ProductController {


    //private

    /*@Autowired
    private UserService userService;
    @Autowired
    private UTPGatewayImpl utpGateway;
    @Autowired
    @PostMapping("/registration")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<?> createModer(@Valid UserDTO userDTO, BindingResult bindingResult) throws MessagingException {
        if (bindingResult.hasErrors()){
            throw new NotValidFields("Вы предоставили невалидные данные");
        }

        userService.save(userDTO, Set.of(Role.MODERATOR));

        String code = utpGateway.generate();
        utpGateway.save(code, userDTO.getEmail());

        String message =
                "<html><body><a href='http://localhost:8080/activate/%s'>Visit this link</a></body></html>".formatted(code);
        mailSender.sendHtmlMessage(userDTO.getEmail(), "ACTIVATION CODE", message);

        return ResponseEntity.ok().build();
    }*/

}
