package com.cydeo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user_account")
public class User extends BaseEntity{

    @NotNull
    @Email
    private String email;


    @Size(max=12, min=6)
    @NotBlank
    @Pattern(regexp = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{4,}")
    private String password;
    private String username;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_details_id")
    private Account account;
}
