package com.cydeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateTime;
    private Integer seatNumber;
    private Integer rowNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private MovieCinema movieCinema;

    @ManyToOne(fetch = FetchType.LAZY)
    private User userAccount;

    @Override
    public String toString() {
        return "Ticket{" +
                "dateTime=" + dateTime +
                ", seatNumber=" + seatNumber +
                ", rowNumber=" + rowNumber +
                ", movieCinema=" + movieCinema +
                ", userAccount=" + userAccount +
                '}';
    }
}
