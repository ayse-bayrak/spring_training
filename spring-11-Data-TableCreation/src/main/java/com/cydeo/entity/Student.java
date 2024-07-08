package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id is created automatically by Postgres
    private Long id;

    @Column(name= "studentFirstName") // change column name, it is not usual usage
    private String firstName;

    @Column(name= "studentLastName")
    private String lastName;
    private String email;

    @Column(columnDefinition= "DATE")
    private LocalDate birthDate;

    @Column(columnDefinition= "TIME")
    private LocalDate birthTime;

    @Column(columnDefinition= "TIMESTAMP")
    private LocalDate birthDateTime;

    @Enumerated(EnumType.STRING) // we can assign as String
    //@Enumerated(EnumType.ORDINAL) // create integer, it is default one also, f.ex.-> male 0, female 1
    private Gender gender;

    @Transient // sometimes we don't want to create column from some fields
    private String city;



}
