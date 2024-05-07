package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "departments")
@NoArgsConstructor
@Data
public class Department {
    // I am not extending from base entity, because primary key in the department table it is not ID, it is department field
    @Id
    private String department;
    private String division;

   // @mapped by
}
