package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
public class Employee extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;

    @ManyToOne
    @JoinColumn(name="department") // we need change table name because Spring boot is created department_id by default, but in our data.sql there is department field in the employee table
    private Department department;

    @ManyToOne
    @JoinColumn(name="region_id")
    private Region region;

}
