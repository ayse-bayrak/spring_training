package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

@Entity
@Table(name="COURSES")
@Data
@NoArgsConstructor////JPQL NEEDS TO AT LEAST EMPTY CLASS
//JPQL write this one:
//SELECT e EMPLOYEE e WHERE means
//Employee e = new Employee(); How you gonna create object from class? we need a Constructor, What is this parameters represents--> Constructor? where is cpnstructor -->@NoArgConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "RATING")
    private Integer rating;

    @Column(name="DESCRIPTION")
    private String description;
}
