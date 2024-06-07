package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "items")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;

    //with mappedBy drops table we don't need to
    @ManyToMany(mappedBy = "itemList")
    private List<Cart> carts;

    public Item(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
