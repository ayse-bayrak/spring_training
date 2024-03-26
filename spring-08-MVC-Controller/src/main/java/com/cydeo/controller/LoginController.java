package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping({"/login","/giris"})
    public String getHomePage4() {
        return "login.html";
    }
}
