package com.java.demo.firstDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
//		(exclude = { SecurityAutoConfiguration.class })
public class FirstDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstDemoApplication.class, args);
	}

}

//@Configuration
//
//@EnableAutoConfiguration
//
//@ComponentScan

//model
//controller
//services
//repository -- DAO (Data access object)

