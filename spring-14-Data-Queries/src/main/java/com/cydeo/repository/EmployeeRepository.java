package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // we have three different ways to create Query
    //1-Derived Queries
    //2-JPQL(Java Persistence Query Language)
    //3-Native Query

    //What is Derived Queri: we are writing a method and
    // then in the behind the scene in the implementation Spring Data iscreating Query for this one and running in the database
    //To be able to create the structure drive query , we need to follow a naming convention find-->select, by --> where
// whenever we retrive data we can do anything, just pass UI exc.
    // --------------1-DERIVED QUERIES---------------- WE GONNA USE MOST THIS ONE

    //Display all employees with email address

    List<Employee> findByEmail(String email);

    //Display all employees with firstName "" last Name "",
    // also show all employees with email address ""

    List<Employee> findByFirstNameAndLastNameOrEmail(String firstName, String lastName, String email);

    //Display all employees that first name is not ""
    List<Employee> findByFirstNameIsNot(String firstname);

    //Display all employees where lastname starts with ""

    List<Employee> findByLastNameStartingWith(String pattern);

    //Display all employees with salaries higher than
    List<Employee> findBySalaryGreaterThan(Integer salary);

    //Display all employees with salaries less than
    List<Employee> findBySalaryLessThan(Integer salary);

    //Display all employees that has been hired between "" and ""
    List<Employee> findByHireDateBetween(LocalDate startDate, LocalDate endDate);

    //Display all employees where salaries greate and equal to "" order
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(Integer salary);

    //Display top unique 3 employees that is making less than ""
    List<Employee> findDistinctTop3BySalaryLessThan(Integer salary);

    //Display all employees that do not have email adress
    List<Employee> findByEmailIsNull(); // we don't need to any parameter because shows all null

    // --------------2-JPQL----------------
    //Repository is implementation of a SQL, Derived Queries we don't need to @Query
    @Query("Select e FROM Employee e where e.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail(); // this is not derived query

    // e is object created from Employee class

//    @Query("")
//    Integer retrieveEmployeeSalary();
}
