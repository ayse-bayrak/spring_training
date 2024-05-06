package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//Table Creation / @Entity
@Entity // table is created, I am saying Spring--> make table
public class Employee { // icon says this is table
    @Id// i am saying Spring --> I am making the this field (ID) as a primary key
    private int id;
    private String name;

    //Persistent entity 'Employee' should have primary key
    //An entity represents a table stored in a database
    // Every instance of an entity represents a row in the table
    // whatever i create in class in the entity package, it's gonna be created as a table in the database
    //and whatever object i create in form any class inside the entity package, is gonna be save as a data in the database in the table

}
//Hibernate: create table employee (id integer not null, name varchar(255), primary key (id))
// whenever i put @Entity
//in the behind the scene this SQL query will execute by Spring
//String convert to varchar
//Integer convert to int
//those are basically belongs to database
//firstName converts first_name
//when I put as a camelCase, it is gonna be created with underscore
//That is the naming convention, hibernate is created in the behind the scene
