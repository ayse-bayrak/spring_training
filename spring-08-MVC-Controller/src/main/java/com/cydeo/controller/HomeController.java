package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
//1-This class will define as a bean and its gonna manage inside the container by Spring
//2-This class is gonna register  in the handler mapping for you. Because at controller
// repeat==> class needs to be annotated with the @Controller,
// because this class will register in the handler mapping
    // then you need to define your end points in the method,
    // how? by using @RequestMapping
    //The controller actions are methods associated with specific HTTP requests.

    @RequestMapping("/home")  // defined with /home endpoint
    public String getHomePage() {
    return "home.html";
    }
    //@RequestMapping=>This annotation maps HTTP requests to handler methods of MVC and REST controllers
    //It can be applied to class level and/or method level.


    @RequestMapping("/ayse")
    public String getHomePage2() {
        return "home.html";
    }
    @RequestMapping // nothing and / ==> default
    public String home() {
        return "home.html";
    }

    @RequestMapping({"/apple","/orange"}) //for same page, more than one end points with the this structure
    //sometimes we are using, because in our application we want to get a same certain view with different endpoints.
    public String getHomePage3() {
        return "home.html";
    }

    //http://localhost:8080/home ===> Welcome to Home Page!!!
    //whenever we request /home, Spring is gonna look for all the controller classes,
    //and it's gonna find the method with describe this  endpoint which is /home



}
