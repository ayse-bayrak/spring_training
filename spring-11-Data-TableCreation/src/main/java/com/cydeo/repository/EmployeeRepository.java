package com.cydeo.repository;

import com.cydeo.entity.Employee;
import com.cydeo.entity.Employee2;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee2, Integer> {
//Employee2--> Class of the entity that
// needs to be created, read, updated, deleted in a database
//Integer-->Type of the field of entity

}
    /*
CrudRepository - interface for generic CRUD(Create, Read, Update, and Delete) operations
on a repository for a specific type

PagingAndSortingRepository - Extension of CrudRepository
to provide additional methods to retrieve entities using
the pagination and sorting abstraction

JpaRepository - Extension of PagingAndSortingRepository
to provides JPA related methods such as flushing the
persistence context and deleting records in a batch.

Because of inheritance, it contains all methods of the first
two repository interfaces
     */