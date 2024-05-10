package com.cydeo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class MovieCinema extends BaseEntity{

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDate dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    private Cinema cinema;

    @ManyToOne(fetch = FetchType.LAZY)
    private Movie movie;

    @Override
    public String toString() {
        return "MovieCinema{" +
                "dateTime=" + dateTime +
                ", cinema=" + cinema +
                ", movie=" + movie +
                '}';
    }
}
