package com.cydeo.controller;

import com.cydeo.bootsrap.DataGenerator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/student") // it's gonna concatenate method level @RequestMapping
public class StudentController {
    // creating end-point
    @RequestMapping("/register") //localhost:8080/student/register
    public String register(Model model){

        model.addAttribute("students", DataGenerator.createStudent());// we put attribute name to thymleaf
        return "student/register";
    }
    @RequestMapping("/welcome1") //localhost:8080/student/welcome?id=3
    public String welcome( @RequestParam int id){

        System.out.println(id);
       // model.addAttribute("id", id);
        return "student/welcome";
    }

    @RequestMapping("/welcome") //localhost:8080/student/welcome?id=3
    public String welcome( @RequestParam String name){

        System.out.println(name);

        return "student/welcome";
    }


//    @RequestMapping("/drop") //localhost:8080/student/drop
//    public String drop(){
//
//        return "student/register";
//    }


}
