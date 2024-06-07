package com.cydeo.repository;

import com.cydeo.entity.Course;
import jdk.jfr.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.stream.Stream;

public interface CourseRepository extends JpaRepository<Course, Long> {
// Why we are using JpaRepository? Because it is covers everything
// CrudRepository and other repository, So why not?
//I am writing all Query type inside repository Why?
// Because this is where business is happening,
// You can think Database service implementation

//I can building Derived Queries I need a business which JPA Repository doesn't give it to me,
//JPA Repository doesn't give it to me.. means if we go to JpaRepostory there is not method related needed business


    //Find All courses by category -- this is business, right now is your choice
    // either use Derived, or JPQL or Native
    // if something is really basic with a couple of parameter you can use derived queries

    //select * from courses where category = ...
    //in the derived query select mean get/read/find , by meaning where
    //do we need to from courses No, because Spring JPA already knows which table we are working with
    //How? because we are inside in this Repository, meaning related table (here Course)
        //This repository is not working with the other table like Employee table

    List<Course> findByCategory(String category);

    //find all courses by category and order the entities by name

    List<Course> findByCategoryOrderByName(String category);

    // check if a course with the supplied name exists, return true if exits, otherwise false

    boolean existsByName(String name);

    //return the count of courses for the given category

    int countByCategory(String category);

    //finds all the courses that start with the given course name String

    List<Course> findByNameStartsWith(String pattern);

    //Find all course by category and returns a stream

    Stream<Course> streamAllByCategory(String category);

    // NAMED PARAMETER
    @Query("SELECT c FROM Course c WHERE c.category= :category AND c.rating >: rating ")
    List<Course> retrieveAllByCategoryAndRatingGreaterThan(@Param("category") String category, @Param("ratying") int rating);
}
