package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="customers")
@Data
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String address;
    private String email;
    private String name;
    private String surName;
    private String userName;

    public Customer(String address, String email, String name, String surName, String userName) {
        this.address = address;
        this.email = email;
        this.name = name;
        this.surName = surName;
        this.userName = userName;
    }
}
