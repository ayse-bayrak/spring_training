package com.cydeo.dto;

import com.cydeo.enums.UserRole;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // it is good to put this one in all DTOs
public class UserDTO {

    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // JsonProperty means some field, in here password is property
    private String password;
    private String username;
    private UserRole role;

    @JsonManagedReference  // This field is going to be serialized, i will be able to see a AccountDTO in the UserDTO
    private AccountDTO account;

}
