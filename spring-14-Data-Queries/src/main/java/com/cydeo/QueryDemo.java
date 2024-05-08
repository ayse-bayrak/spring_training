package com.cydeo;

import com.cydeo.repository.DepartmentRepository;
import com.cydeo.repository.EmployeeRepository;
import com.cydeo.repository.RegionRepository;
import jdk.swing.interop.SwingInterOpUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QueryDemo implements CommandLineRunner {

    private final RegionRepository regionRepository;
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    public QueryDemo(RegionRepository regionRepository, DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        this.regionRepository = regionRepository;
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // we have three different ways to create Query
        //1-Derived Queries
        //2-JPQL(Java Persistence Query Language)
        //3-Native Query

        //What is Derived Queri: we are writing a method and
        // then in the behind the scene in the implementation Spring Data iscreating Query for this one and running in the database
        //To be able to create the structure drive query , we need to follow a naming convention find-->select, by --> where
// whenever we retrive data we can do anything, just pass UI exc.

        // --------------1-DERIVED QUERIES---------------- WE GONNA USE MOST THIS ONE
        System.out.println("-------------REGIONS----------------------");
        System.out.println("findByCountry:" + regionRepository.findByCountry("Canada"));
        System.out.println("findByCountryContaining:" + regionRepository.findByCountryContaining("United"));
        System.out.println("findByCountryContainingOrderByRegionDesc:" + regionRepository.findByCountryContainingOrderByRegionDesc("United"));
        System.out.println("findTop2ByCountry:" + regionRepository.findTop2ByCountry("United States"));
        System.out.println("findTopByCountryContainsOrderByRegion:" + regionRepository.findTopByCountryContainsOrderByRegion("United States"));

        System.out.println("-------------DEPARTMENTS----------------------");

        System.out.println("findByDepartment:" + departmentRepository.findByDepartment("Furniture"));
        System.out.println("findTopByDivision:" + departmentRepository.findTopByDivision("Health"));
        System.out.println("findByDivisionEndsWith:" + departmentRepository.findByDivisionEndsWith("ics"));
        System.out.println("findDistinctTop3ByByDivision:" + departmentRepository.findDistinctTop3ByDivision("Health"));
        // all this stuff is why? they are giving all this kind of mechanism
        // because they don't want to take developers with this extra verbose code writing,
        // that kind of things. They want to pay attention business logic,
        // they don't want to waste developers time with the writing queries

        //-----------------------2-JPQL Java Persistence Query Language-----------------------------

        //Repository is implementation of a SQL, we use @Query JPQL and Native Queries,
        // in Derived Queries we don't need to @Query
        //in JPQL everything is related with the Java
        //Employee --> Java Class
        //employee--> object from Java Class
        //email--> java class fields
        System.out.println("=========EMPLOYEES==================");
        System.out.println(employeeRepository.retrieveEmployeeDetail());

    }
}
