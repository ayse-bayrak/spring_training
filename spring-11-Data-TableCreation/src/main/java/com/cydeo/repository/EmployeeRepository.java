package com.cydeo.repository;

import com.cydeo.entity.Employee;
import com.cydeo.entity.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee2, Integer> {

}
