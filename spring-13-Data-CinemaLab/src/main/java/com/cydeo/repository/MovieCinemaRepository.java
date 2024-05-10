package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.entity.MovieCinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface MovieCinemaRepository extends JpaRepository<MovieCinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read movie cinema with id
    Optional findById(Long id);

    //Write a derived query to count all movie cinemas with a specific cinema id
  // int countByCinema_(Long id); // I don't sure

    //Write a derived query to count all movie cinemas with a specific movie id
   // int countBy(Long id); // I don;t sure

    //Write a derived query to list all movie cinemas with higher than a specific date
    List<MovieCinema> findByDateTimeAfter(LocalDate date);

    //Write a derived query to find the top 3 expensive movies
    List<Movie> findTopByOrderByMovie_Price(); // I don;t sure

    //Write a derived query to list all movie cinemas that contain a specific movie name
   // List<MovieCinema> findByMovieContaining(String pattern);

    //Write a derived query to list all movie cinemas in a specific location name
    List<MovieCinema> findByCinema_Location_Name(String Name); //_Name does it need to add?

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movie cinemas with higher than a specific date

    @Query("select m from MovieCinema m where m.dateTime>=?1")
    List<MovieCinema> higherThanSpecificDate(LocalDate date);


    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count all movie cinemas by cinema id
    @Query(value = "select count(*)  from movie_cinema m join cinema c on m.cinema_id= c.id where c.id=?1", nativeQuery = true)
    Long countMovieCinemaWithId(Long id);

    //Write a native query that returns all movie cinemas by location name
    @Query(value = "select * from movie_cinema m join cinema c on m.cinema_id= c.id join location l on c.location_id= l.id where l.name=?1", nativeQuery = true)
    List<MovieCinema> findByLocationName(String name);

}
