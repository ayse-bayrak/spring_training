package com.cydeo.controller;

import com.cydeo.dto.CourseDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/courses/api/v3")
public class CourseController_ResponseWrapper {
// this version is final version to create API endpoints, because we need to modify output (change status add header etc) and
// we need to customize Json object also, so we use ResponseEntity (ready class which have a lot of method like status, headers, body, ok ...)
// and we use ResponseWrapper(custom class) class
    private final CourseService courseService;

    public CourseController_ResponseWrapper(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses() {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .header("Verion", "Cydeo")
                .body(new ResponseWrapper("courses succesfully retrieved" , courseService.getCourses()));
        //              new ResponseWrapper(     String message         , Object data) // at the end of courseService.getCourses()) is Object data (List<CourseDTO>)
    }

    @GetMapping("{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") long courseId) {
        return ResponseEntity
                .ok(new ResponseWrapper("course "+courseId+" retrieved", courseService.getCourseById(courseId)));
    }
    }
