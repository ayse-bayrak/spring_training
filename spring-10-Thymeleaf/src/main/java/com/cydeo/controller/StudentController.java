package com.cydeo.controller;

import com.cydeo.bootsrap.DataGenerator;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/student") // it's gonna concatenate method level @RequestMapping
public class StudentController {

    // creating end-point
    //@RequestMapping(value = "/register", method = RequestMethod.GET) //localhost:8080/student/register
    @GetMapping("/register") // meaning we just retrieve the page, no posting www.amazon.com
    //only it is used in method level, because method needs to be specified with a correct request method
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudent());
        // we put attribute name to thymeleaf
        return "student/register";
    }
    @RequestMapping(value = "/welcome1", method = RequestMethod.POST) //localhost:8080/student/welcome1?id=3
    @PostMapping("/welcome")
    //when you search something, when you put your user and password to log in, then you are using PostMapping
    public String welcome( @RequestParam int id){

        System.out.println(id);
       // model.addAttribute("id", id);
        return "student/welcome";
    }

    @RequestMapping("/welcome") //localhost:8080/student/welcome?id=3
    public String welcome(){
        return "student/welcome";
    }

    @RequestMapping("/welcomeFragments") //localhost:8080/student/welcome?id=3
    public String welcomeFragments(){
        return "student/welcomeForFragments";
    }


//    @RequestMapping("/drop") //localhost:8080/student/drop
//    public String drop(){
//
//        return "student/register";
//    }


}
