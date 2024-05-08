package com.cydeo.entity;

import com.cydeo.enums.Gender;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "employees")
@NoArgsConstructor
@Data
public class Employee extends BaseEntity {
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate hireDate;

    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Integer salary;

    @ManyToOne
    @JoinColumn(name="department") // we need change table name because Spring boot is created department_id by default,
    // but in our data.sql there is department field in the employee table, it is a good different case example
    private Department department;

    @ManyToOne
    @JoinColumn(name="region_id") // we don't need to put region_id but it is better to write like this because for examle Jpa hibrenate is chnage and it can be different rule for naming
    private Region region;

}
