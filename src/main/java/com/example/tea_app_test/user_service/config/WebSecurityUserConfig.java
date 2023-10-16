package com.example.tea_app_test.user_service.config;



import com.example.tea_app_test.user_service.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityUserConfig {


    @Autowired
    UserService userService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {


        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/").hasRole("USER")
                        .requestMatchers("/hello").hasRole("USER")
                        .requestMatchers("/registration").permitAll()
                        .anyRequest().permitAll()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout((logout) -> logout.permitAll());
        return http.build();
    }

}
