package com.cydeo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//We are capturing something from browser and then we are bringing into our application
@Controller
public class CarController {
    // localhost:8080/info?make=Honda
    @RequestMapping("/info")
    public String carInfo(@RequestParam String make, Model model){

        model.addAttribute("make", make);

        return "car/car-info";
    }
    // localhost:8080/info2    ==> (KIA)
    @RequestMapping("/info2")
    public String carInfo2(@RequestParam (value="make", required = false, defaultValue ="KIA") String make,Model model){

        model.addAttribute("make", make);

        return "car/car-info";
    }
    // localhost:8080/info3?make=Honda&year=2015
    // @RequestParam based on the name, it's matching based on the name
    @RequestMapping("/info3")
    public String carInfo3(@RequestParam String make, @RequestParam int year, Model model){

        model.addAttribute("make", make);
        model.addAttribute("year", year);
        return "car/car-info";
    }
    //localhost:8080/info/Honda/2015 (honda is changing {} ==> dynamic)
    // @PathVariable based on the position not name, it's matching based on the position
    @RequestMapping("/info/{make}/{year}")
    public String getCarInfo(@PathVariable String make, @PathVariable int year){

        System.out.println(make);
        System.out.println(year);
        return "car/car-info";
    }

}

/*
notes of Jamal's Short videos
@RequestParam
I am getting something from client (here firstName), getting to my java file,
putting into my container, transferring to HTML again, and display.
The parameter is not required anymore, it should be worked like default value (here TEST)

 @PathVariable
 Spring understand, yes This is the path variable (so / /), this is something dynamic (so {})
 at firstName will be replaced by the client input, and I'm gonna take it here, pass it as parameter, we're gonna get it
 and send it back to the HTML
 we can not add any optional here
 we can add more than one parameter
 I am accepting last name as a parameter, then I' m adding it to the model
and I am sending back to HTML so that thymeleaf can run and display on the screen

 */
/*
query parameter

https://www.amazon.com/s?k=spring+boot&ref=nav_bb_sb

/s endpoint

?-> end of url
k=spring+boot

&ref=nav_bb_sb

==tomcat --server responcipility : take request and explain to our app
takes the user request via http and converts it into source code logic

Handler Mapping is like a log for Controllers

---Open-Closed Principle of SOLID principles.. our code should be open for extension, closed for modifications

---directly implementable objects inside the dependency objects
 */