package com.example.tea_app_test;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
@EnableScheduling
public class ExchangeApplication {

	public static void main(String[] args) {


		SpringApplication.run(ExchangeApplication.class, args);
	}

}
