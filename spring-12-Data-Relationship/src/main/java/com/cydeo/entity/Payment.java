package com.cydeo.entity;

import com.cydeo.enums.Status;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor
@Data
@Table(name="payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "DATE")
    private LocalDate createdDate;
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    private Status paymentStatus;

    //@OneToOne(cascade = CascadeType.ALL) // based on business logic,
    //@JoinColumn(name = "ayse") // column name could be changed with this annotation, but common usage is to be used as default column name payment_detail_id
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})// you can mention one by one
    private PaymentDetail paymentDetail;

    // I don't need to provide the payment detail by myself. This information is going to come through the joins from the table by SpringBoot.
    // That's why i am not adding to Constructor.

    //Spring boot is gonna create the relationship between two tables which is payment and paymentDetail
    //but SpringBoot does not know what kind of relationship these two table has

    //whenever i put here this annotation(@OneToOne) this field, foreign key is gonna be created inside this tables,
    //join has happen, that is fundamental thing,
    //payment_detail_id --> inside this class's table (here it is payments table)
    //that is the naming convention of created foreign key ==> payment_detail_id

    //cascading mean whenever we save a payment Spring Boot is gonna go to paymentDetail and
    //it's gonna save the payment detail as well automatically for me, this is called cascading
    //kind of like do both action, same time for the table
    //when you do something in the table, same thing is gonna happen in the child as well
    //cascading operations are specified on the owning side of the relationship, not on the inverse side.



    @ManyToOne// Many Payments One Merchant, one amazon many payments
    private Merchant merchant;
    //if it is unidirectional is enough, you put just it here
    // usually we use unidirectional

    @ManyToOne
    private Customer customer;
    public Payment(LocalDate createdDate, BigDecimal amount, Status status) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }

    //I CAN NOT allArgConstructor because Id is created by postgres
    //so i need to put custom constructor
}
