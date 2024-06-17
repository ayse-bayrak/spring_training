package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// most of the developer put version here
@RestController
@RequestMapping("/courses/api/v2")//this is the best practice to create our endpoints. API/v2, these version can change
public class CourseController_ResponseEntity {

    private final CourseService courseService;


    public CourseController_ResponseEntity(CourseService courseService) {
        this.courseService = courseService;
    }
    //I am trying to do manipulate something on this API side, I want to pass some headers I want to change some statistic
    //I don't want to put all the time 200.
    //we can pass headers, we can manipulate our status code with ResponseEntity<T> class
    //it is used to ResponseEntity to specify the
    //response body, the status and headers on the HTTP response.

    @GetMapping
    public ResponseEntity<List<CourseDTO>> getAllCourses(){
    return ResponseEntity
            .status(HttpStatus.ACCEPTED) // I want to change the status code by myself
            .header("Version", "Cydeo.V2")
            .header("Operation", "Get List") // we can pass more than one header, I am modifying output
            .body(courseService.getCourses());
    }
    // First way nobody is using first way, everybody is using Response Entity

    @GetMapping("{id}")
    public ResponseEntity<CourseDTO> getCourseById(@PathVariable ("id") long courseId) {
    return ResponseEntity.ok(courseService.getCourseById(courseId));
    }

    @GetMapping("category/{name}")
    public ResponseEntity<List<CourseDTO>> getCoursesByCategory(@PathVariable ("name") String category) {
        return ResponseEntity.ok(courseService.getCoursesByCategory(category));
    }

    @PostMapping
    public ResponseEntity<CourseDTO> createCourse(@RequestBody CourseDTO courseDTO) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation", "Create")
                .body(courseService.createCourse(courseDTO));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteCourseById(@PathVariable ("id") Long courseID) {
        courseService.deleteCourseById(courseID);
        return ResponseEntity.noContent().build();
    }
    // if you don't want to show anything is A Json output. You just put void

    @PutMapping("{id}")
    public ResponseEntity<Void> updateCourseById(@PathVariable ("id") Long courseId, @RequestBody CourseDTO courseDTO) {
        courseService.deleteCourseById(courseId);
        return ResponseEntity.noContent().build();
    }
}
