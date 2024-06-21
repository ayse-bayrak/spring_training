package com.cydeo.client;

import com.cydeo.dto.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(url= "https://jsonplaceholder.typicode.com", name ="USER-CLIENT") // you think as a definer key and value, this is the user-client is representing this URL
public interface UserClient { // that is usually naming convention, maybe ProductClient, EmployeeClient
// like controller structure, @RestController @RequestMapping concatenate for example base url/users
  @GetMapping("/users")
  List<User> getUsers();

    // whenever I call this getUsers() method this endpoint (https://jsonplaceholder.typicode.com/users) will be executed with GetMapping
    // and then Json is coming and then Json is going to be assign to our DTO (in here assign to User)
    // right now we have all the users in our system
    // in the microservice we will implement a lot
}
