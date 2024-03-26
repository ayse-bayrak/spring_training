package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Controller
public class StudentController {
    @RequestMapping ("/welcome")
    public String homePage(Model model){
        // method Model interface
// I want to execute a method belongs to model interface, that's why pass a parameter
        model.addAttribute("name", "Cydeo");
        model.addAttribute("course", "MVC");

        String subject = "Spring Boot";
        model.addAttribute("subject", subject);

        int stdudentId = new Random().nextInt();
        model.addAttribute("id", stdudentId);

        List<Integer> numbers = new ArrayList<>();
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        numbers.add(7);

        model.addAttribute("numbers",numbers);

        LocalDate dt = LocalDate.now();
        model.addAttribute("date", dt);
        return "student/welcome";
    }
    // this is pure html right now, this is template thymeleaf.
    //That's why we are putting here only welcome no need .html
// Model is an interface, ready interface, you can basically use this interface,
// by using some methods you can pass your data to the web
// Model is using to carry a data to the view, how ?
    //by using methods, what is method?
    //addAttribute() ==> takes two parameter one of them attribute name
    //one of them atiribute value, meaning ==> name is holding the cydeo value
    // basically by using thi name attribute in the view you have access to this cydeo value
// i can create as much as I want
}
