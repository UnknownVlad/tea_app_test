package com.example.tea_app_test.registration.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/hello").setViewName("hello");
//        registry.addViewController("/login").setViewName("index");
//        registry.addViewController("/").setViewName("main");
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/t").setViewName("authorization");
    }
}
