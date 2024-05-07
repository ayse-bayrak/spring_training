package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

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
}
