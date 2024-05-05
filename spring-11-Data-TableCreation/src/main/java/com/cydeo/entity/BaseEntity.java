package com.cydeo.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    //We can generate the identifiers in different ways which are specified by
    //the @GeneratedValue annotation
    //Id Generation Strategies-AUTO,IDENTITY, SEQUENCE, Table
}
