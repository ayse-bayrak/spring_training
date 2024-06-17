package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// you are creating a class, if you annotate this class with the RestController, you are developing an API
// it is not anymore return view, we are just giving that data return data, data is going to give back to that HTTP method has a Json.
//Whatever we are putting the controller is DTO does not matter UI or API always return DTO
// we are creating an API, advantage is taht whoever needs it can take it and use it.
@RestController //@Controller + @ResponseBody-- combination is @Controller and @ResponseBody, now view is gone, no more view
@RequestMapping("/courses/api/v1")
public class CourseController { // first way to create endpoint, we don't use this one but in interview you can explain
    // They ask you how did you learn the subject, firstly I create very basic by using @RestController
    // and I took one more step and I start implementing ResponseEntity

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<CourseDTO> getAllCourses(){
        return courseService.getCourses();
    }

    @GetMapping("{id}")
    public CourseDTO searchCourseById(@PathVariable("id") long courseId){
        return courseService.getCourseById(courseId);
    }

    @GetMapping("category/{name}")
    public List<CourseDTO> getByCategory(@PathVariable ("name") String category) {
        return courseService.getCoursesByCategory(category);
    }

    // lets create a new Course

    @PostMapping
    public CourseDTO createCourse(@RequestBody CourseDTO course) {
        // we need to capture that one, either MVC (we use @ModelAttribute) or API
        return courseService.createCourse(course);
    }

    @PutMapping("{id}")
    public void updateCourse(@PathVariable("id") long courseId, @RequestBody CourseDTO courseDTO) {
        courseService.updateCourse(courseId, courseDTO);
    }// we use @RequestBody to capture that object, after we captured the object, it is gonna go to database and
    // it's gonna replace this object with whatever in the database

    @DeleteMapping ("{id}")
    public void deleteByCourseId(@PathVariable("id") long courseId) {
    courseService.deleteCourseById(courseId);
    }

    // these are API endpoints, we are creating all of them API endpoints.
    //we did CRUD operators
    //C-Create, R-Retrieve, U-Update, D-Delete
    //

}
