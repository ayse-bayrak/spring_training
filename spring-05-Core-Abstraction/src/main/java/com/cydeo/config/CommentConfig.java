package com.cydeo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
@ComponentScan(basePackages = "com.cydeo")
//@ComponentScan(basePackages = {"com.cydeo.proxy", "com.cydeo.service", "com.cydeo.repository"}) // this is valid also
public class CommentConfig {
}
// if there is a Spring in the picture, we need Configuration.
//Otherwise there is no meaning Bean