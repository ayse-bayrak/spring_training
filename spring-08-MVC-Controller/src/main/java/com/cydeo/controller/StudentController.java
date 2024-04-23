package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
    @RequestMapping("/student")
    public String getStudentInfo(){
        return "student/welcome";
        // we need to mention about this folder, welcome.html under the static
        // but at the same time inside the student folder so we need to mentioned student folder

        //http://localhost:8080/student ===> Welcome to Cydeo, Java Dev Students!!
    }
}
