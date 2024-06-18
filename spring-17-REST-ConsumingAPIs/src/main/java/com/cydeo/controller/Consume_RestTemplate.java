package com.cydeo.controller;

import com.cydeo.dto.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

//now, we will learn how to consume API by using Rest Template way..
//we will implement three methods in the Rest Template
//1-getForEntity:we are using API that output is gonna be map to DTO and I am gonnaa output whatever my DTO has it
//2-getForObject: we don't have dto, it is just taking from the third part API and then whatever Json output result is we see in our endpoint
//3-exchange : if you want tp pass any header, whenever we want to pass headers
// just know this part it is enough, syntax we don't need to remember
@RestController
@RequestMapping("/cydeo")
public class Consume_RestTemplate {
    private final String URI = "https://jsonplaceholder.typicode.com/users";
    private final RestTemplate restTemplate;// I will consume through the RestTemplate,
    // I need to access to methods belongs to this class

    public Consume_RestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping
    public ResponseEntity<User[]> readAllUsers() {
        return restTemplate.getForEntity(URI, User[].class); // we don't need to write response entity which is returning responseEntity,
        // because these already returning response entity.
        // getForEntity meaning give me the URI that we are trying to consume, and show me the DTO we have
    } // mostly we gonna notice this  one(probably we are not gonna notice getForObject)
    //because we will always have dto, we need to mention our dto which needs to be converted

    @GetMapping("{id}")
    public Object readUser(@PathVariable("id") Integer id) {
       String URL = URI+ "/{id}";
        // that consume and show me as an output
       // last point we gonna consume and return
        return restTemplate.getForObject(URL, Object.class, id);
    }

    @GetMapping("/test")
    public ResponseEntity<Object> consumePostFromDummyApi(){
// we are setting the headers
        HttpHeaders headers =new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.set("app-id","6298ebfecd0551211fce37a6");

        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("https://dummyapi.io/data/v1/user?limit=10", HttpMethod.GET,entity,Object.class);

    }
}
