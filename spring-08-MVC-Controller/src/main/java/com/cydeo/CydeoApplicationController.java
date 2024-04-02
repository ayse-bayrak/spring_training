package com.cydeo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = AopAutoConfiguration.class)
public class CydeoApplicationController {

    public static void main(String[] args) {
        SpringApplication.run(CydeoApplicationController.class, args);
    }

}
