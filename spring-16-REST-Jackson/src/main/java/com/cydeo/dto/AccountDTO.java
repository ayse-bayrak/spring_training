package com.cydeo.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties(value = {"address", "country"}, ignoreUnknown = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDTO {

    @JsonIgnore
    private String name;
    private String address;
    private String country;
    private String state;
    private String city;
    private Integer age;
    private String postalCode;

    @JsonBackReference  // This field is not going to be serialized, means you are not gonna see this object to be converted as Json inside the Account
    private UserDTO user;
// this is going to hide the userDTO, of course we need to also put @JsonManagedReference to private AccountDTO account
    // in UserDTO, it means that DTO hide UserDTO from AccountDTO, but show AccountDTO inside UserDTO
}
