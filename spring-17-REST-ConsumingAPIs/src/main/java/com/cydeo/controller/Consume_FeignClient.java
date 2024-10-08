package com.cydeo.controller;

import com.cydeo.client.EmployeeClient;
import com.cydeo.client.UserClient;
import com.cydeo.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {

    private final UserClient userClient;
    private final EmployeeClient employeeClient;

    public Consume_FeignClient(UserClient userClient, EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient = employeeClient;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers() {
        return ResponseEntity.ok(new ResponseWrapper("UserList is retrieved", userClient.getUsers() ));
    }
    // now we apply with header
//FeignClient needs to dto so we converted all fields to dto by using jsonschemapojo2 and Employee class is ready


    @GetMapping("/api/v1/employee")
    public ResponseEntity<ResponseWrapper> getEmployee() {
        return ResponseEntity.ok(new ResponseWrapper("Employee is retrieved", employeeClient.getEmployee("6298ebfecd0551211fce37a6") ));
    }

}
