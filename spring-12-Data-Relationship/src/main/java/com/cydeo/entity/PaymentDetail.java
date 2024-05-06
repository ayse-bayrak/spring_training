package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="paymentDetails")
@NoArgsConstructor
@Data
public class PaymentDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal merchantPayoutAmount;
    private BigDecimal commissionAmount;

    @Column(columnDefinition = "DATE")
    private LocalDate payoutDate;

    @OneToOne(mappedBy = "paymentDetail") //"paymentDetail" is in the Payment class, if we want to uni-directional, it is not necessary mapped by part
    private Payment payment;

    //when i use the mappedBy, I am telling the Spring Boot, do not create any foreign key inside the PaymentDetail table
    //And I want to give the ownership to payment table, what it means payment table will have the foreign key
    //what kind of relationship I created? bi-directional, why? because I have an access to a payment inside the payment detail
    //and also I have an access to payment detail inside the payment.

    public PaymentDetail(BigDecimal merchantPayoutAmount, BigDecimal commissionAmount, LocalDate payoutDate) {
        this.merchantPayoutAmount = merchantPayoutAmount;
        this.commissionAmount = commissionAmount;
        this.payoutDate = payoutDate;
    }
}
