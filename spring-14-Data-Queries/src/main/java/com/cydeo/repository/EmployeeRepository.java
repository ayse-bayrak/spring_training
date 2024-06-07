package com.cydeo.repository;

import com.cydeo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
// Why we are using JpaRepository? Because it is covers everything CrudRepository and other repository, So why not?
//I am writing all Query type inside repository Why?
// Because this is where bussiness is happening,
// You can think Database service implementation

//I can building Derived Queries I need a business which JPA Repository doesn't give it to me,
//JPA Repository doesn't give it to me.. means if we go to JpaRepostory there is not method related needed business


    //Find All courses by category -- this is business, right now is your chouce
    // either use Derived, or JPQL or Native
    // if something is really basic with a couple of parameter you can use derived queriess

    // we have three different ways to create Query
    //1-Derived Queries
    //2-JPQL(Java Persistence Query Language)
    //3-Native Query

    //What is Derived Queri: we are writing a method and
    // then in the behind the scene in the implementation Spring Data is creating Query for this one and running in the database
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



    //-----------------------2-JPQL Java Persistence Query Language-----------------------------

    //Repository is implementation of a SQL, we use @Query JPQL and Native Queries,
    // in Derived Queries we don't need to @Query
    //in JPQL everything is related with the Java
    //Employee --> Java Class
    //employee--> object from Java Class
    //email--> java class fields

    // If we have More than two/three parameter building with Derived query is not so good,
    //because it's becoming very complicated, in this case 2 option , JPQL or pure SQL, both case you need to @Query
    //method name does not matter, whenever this method is called, this query is executed

    @Query("Select e FROM Employee e where e.email='amcnee1@google.es'")
    Employee retrieveEmployeeDetail(); // this is not derived query

    //when i put Employee e, because of noArgConstructor we are putting in the entity, it is creating one object for us

    // e is object created from Employee class

    @Query("SELECT e.salary FROM Employee e WHERE e.email='amcnee1@google.es'")
    Integer retrieveEmployeeSalary();

    // which queries we use? in the company Totally we are gonna decide based on the situation
    // probably most the case %90 just we build derive queried and then move on

    // email is hardcoded, how we parameterized this one?
    //Positional Parameters
    //Named Parameters
    //Positional Parameters
    // Operator is to define the parameter is question mark?
    //?1 you need to give the position, 1 meaning first parameter


    //1- Positional Parameters

    //Not Equal
    @Query("SELECT e from Employee e where e.salary<>?1")
    List<Employee> retrieveEmployeeSalaryNotEqual(int salary);


    //Like / contains / Starts with / EndsWith

    @Query("select e from Employee e where e.firstName LIKE ?1")
    List<Employee> retrieveEmployeeFirstNameLike(String pattern);

    //Less than
    @Query("select from e Employee e where e.salary < ?1")
    List<Employee> retrieveEmployeeSalaryLessThan(int salary);

    //greater than employee name
    @Query("select e.firstName||' '||e.lastName from Employee e where e.salary > ?1")
    List<String> retrieveEmployeeNameSalaryGreaterThan(int salary);

    //  between
    @Query("select e from Employee e where e.salary BETWEEN  ?1 AND ?2")
    List<Employee> retrieveEmployeeSalaryBetween(int salary1, int salary2);

    //  beFORE
    @Query("select e from Employee e where e.hireDate > ?1")
    List<Employee> retrieveEmployeeHireDateBefore(LocalDate date);

    //  null
    @Query("select e from Employee e where e.email is null ")
    List<Employee> retrieveEmployeeEmailIsNull();

    //  null
    @Query("select e from Employee e where e.email is not null ")
    List<Employee> retrieveEmployeeEmailIsNotNull();

    //  sorting in asc Order
    @Query("select e from Employee e order by e.salary asc ")
    List<Employee> retrieveEmployeeSalaryOrderAsc();

    //  sorting in desc Order
    @Query("select e from Employee e order by e.salary desc ")
    List<Employee> retrieveEmployeeSalaryOrderDesc();


    //2-Named Parameters
    @Query("select e from Employee e where e.salary = :salary")
    List<Employee> retrieveEmployeeSalary(@Param("salary") int salary);

    //3-Native Query --
    // first rule--> add @Query
    //value=".. pure SQL query", nativeQuery = true

    @Query(value = "SELECT * FROM employees WHERE salary = ?1",nativeQuery = true)
    List<Employee> retrieveEmployeeDetailBySalary(int salary);




}
