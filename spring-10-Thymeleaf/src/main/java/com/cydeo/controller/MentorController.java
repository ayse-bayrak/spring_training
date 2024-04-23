package com.cydeo.controller;

import com.cydeo.model.Mentor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/mentor")  // class level endpoint // it's gonna concatenate method level @RequestMapping
public class MentorController {

    @GetMapping("/register") //localhost:8080/mentor/register
    public String register(Model model){

        List<String> batchList = Arrays.asList("JD1", "JD2", "JD3");// for drop down menu, we always use this structure for dropdown
        // we will create list for any dropdown menu
        model.addAttribute("batchList", batchList);
        model.addAttribute("mentor", new Mentor());
        return "mentor/mentor-register";
    }
    @PostMapping("/confirm")
    public String submitForm(@ModelAttribute("mentor") Mentor mentor){
        // whatever attribute you have in different methods, you can catch this one with @ModelAttribute
        // we caught "mentor" attribute from the register html side via th:action="@{/mentor/confirm}"
        return "/mentor/mentor-confirmation";
        // requirement --> we need to write putting information in the register page to confirm page
        // what if requirement do not see confirmation page and again new register page
        // it can be like this:
      // return "redirect:/mentor/register"; // again new page for create new object
    }
}
