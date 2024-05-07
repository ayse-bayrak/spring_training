package com.cydeo.entity;


import com.cydeo.enums.UserRole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_details")
@Data
@NoArgsConstructor
public class Account extends BaseEntity{


    private String address;
    private int age;

    private String city;
    private String country;
    private String name;


    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role;
    private String state;

    @OneToOne(mappedBy = "account")
    private User user;



}
