package com.example.myoltuoauth2startersimple;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan(basePackages = {"com.github.ganity.oauth2", "com.example.myoltuoauth2startersimple"})
public class MyOltuOauth2StarterSimpleApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyOltuOauth2StarterSimpleApplication.class, args);
	}
}
