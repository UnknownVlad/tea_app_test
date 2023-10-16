package com.example.tea_app_test.user_service.config;



import com.example.tea_app_test.user_service.repository.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityUserConfig {
    @Autowired
    UserService userService;


    @Bean
    protected SecurityFilterChain  configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .csrf()
                .disable()
                    .authorizeRequests()
                    .antMatchers("/registration").permitAll()
                    .antMatchers("/hello").authenticated()
                    .anyRequest().authenticated()
                .and()
                //comment
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("/")
                    .permitAll()
                .and()
                    .logout().permitAll()
                    .logoutSuccessUrl("/");

        return httpSecurity.build();
    }


}

