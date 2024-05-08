package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

////Repository is implementation of a SQL, BECAUSE remember picture, repository related with DB, DB understand SQL,
// so we need to SQL and there is 3 different way to write SQL in repository
//we have three different ways to create Query
//1-Derived Queries
//2-JPQL(Java Persistence Query Language)
//3-Native Query

public interface DepartmentRepository extends JpaRepository<Department, String> {
// Why we are using JpaRepository? Because it is covers everything CrudRepository and other repository, So why not?
//I am writing all Query type inside repository Why?
// Because this is where bussiness is happening,
// You can think Database service implementation

//I can building Derived Queries I need a business which JPA Repository doesn't give it to me,
//JPA Repository doesn't give it to me.. means if we go to JpaRepostory there is not method related needed business


    //Find All courses by category -- this is business, right now is your chouce
    // either use Derived, or JPQL or Native
    // if something is really basic with a couple of parameter you can use derived queriess



    // display all departments in the furniture department
    List<Department>findByDepartment(String department);
    // display all departments in the Health Division

    List<Department> findTopByDivision(String division);
    List<Department> findByDivisionIs(String devision);
    List<Department> findByDivisionEquals (String devision);

    //Spring Data JPA inbuilt query building mechanism

    //display all department with division name ends with 'ics'
    List<Department> findByDivisionEndsWith(String pattern);

    //display top 3 departments with division name includes 'Hea' without duplicate

    List<Department> findDistinctTop3ByDivision(String division);


    @Query("select d from Department d where d.division IN ?1 ")
    List<String> retrieveDepartmentDivision(List<String> division);
}
