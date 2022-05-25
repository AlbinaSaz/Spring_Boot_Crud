package com.example.newspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Configuration
public class NewSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(NewSpringBootApplication.class, args);
    }

}
