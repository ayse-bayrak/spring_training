package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
public class Location extends BaseEntity{

    @NotBlank
    @Size(max=12, min=2)
    private String name;

    private BigDecimal latitude;
    private BigDecimal longitude;
    private String country;
    private String city;
    private String state;
    private String postalCode;
    private String address;

}
