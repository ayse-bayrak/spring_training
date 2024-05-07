package com.cydeo.entity;


import com.cydeo.enums.State;
import com.cydeo.enums.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Movie")
@Data
@NoArgsConstructor
public class Movie extends BaseEntity{

    private String name;
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private Type type;

    @Enumerated(EnumType.STRING)
    private State state;

    @Column(columnDefinition = "DATE")
    private LocalDate releaseDate;

    private int duration;

    @Column(columnDefinition = "text")// regular String is creating 256 character, but when I define text, there is no limit
    private String summary;


    @ManyToMany
    @JoinTable(name="movie_genre_rel",
                    joinColumns =@JoinColumn(name="movie_id"),
                    inverseJoinColumns =@JoinColumn(name="genre_id"))
    private List<Genre>genreList;
    //Why Set Is Better Than List in @ManyToMany there is very useful web site which is dzone.come
    //In the article, it is proofed Set performance better than List performance
}
