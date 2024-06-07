package com.cydeo.streotype_annotation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// no bean no method
// i have something else..@ComponentScan
// hey spring i want to search all packages, if the class @Component, create the Bean
// and put inside the container
@Configuration
@ComponentScan("com.cydeo.streotype_annotation")
// we  write base package ==> where it is looking that @Component annotation, check all the classes

public class PcConfig {

}
