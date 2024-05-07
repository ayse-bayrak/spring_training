package com.cydeo.repository;

import com.cydeo.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, String> {

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

    List<Department> findDistinctTop3ByByDivision(String division);


    // display


}
