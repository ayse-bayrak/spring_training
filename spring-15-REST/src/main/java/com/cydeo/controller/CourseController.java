package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.service.CourseService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//Whatever we are putting the controller is DTO does not matter UI or API always return DTO
@RestController //@Controller + @ResponseBody-- combination is @Controller and @ResponseBody, now view is gone, no more view
@RequestMapping("/courses")
public class CourseController {

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
    }// we use @RequestBody to capture that object, after we captured the object, it is gono go to database and
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
