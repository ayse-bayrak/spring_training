package com.cydeo.entity;


import com.cydeo.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account_details")
@Data
@NoArgsConstructor
public class Account extends BaseEntity{

    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private int age;
    private String postalCode;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    /* Ozzy added
    @OneToOne(mappedBy = "accountDetails")
    private User user; // does it needed

     */

}
