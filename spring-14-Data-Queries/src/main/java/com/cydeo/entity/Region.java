package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name="regions")
@Data
public class Region extends BaseEntity{

    private String region;
    private String country;
}
