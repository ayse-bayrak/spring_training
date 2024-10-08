package com.cydeo.repository;

import com.cydeo.entity.Movie;
import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a movie with a name
    List<Movie>findByName(String name);

    //Write a derived query to list all movies between a range of prices
List<Movie>findByPriceBetween(BigDecimal p1, BigDecimal p2);

    //Write a derived query to list all movies where duration exists in the specific list of duration
List<Movie> findByDurationIn(List<Integer> duration);

    //Write a derived query to list all movies with higher than a specific release date
List<Movie>findByReleaseDateGreaterThan(LocalDate localDate);

    //Write a derived query to list all movies with a specific state and type
List<Movie>findByStateAndType(MovieState movieState, MovieType movieType);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query to list all movies between a range of prices

    @Query("select m from Movie m where m.price between ?1 and ?2")
    List<Movie> findBetweenPrice(BigDecimal p1, BigDecimal p2);

    //Write a JPQL query that returns all movie names
    @Query("select m.name from Movie m")
    List<String> findName();


    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns a movie by name
    @Query(value = "select m.* from movie m where m.name =?1", nativeQuery = true)
    List<Movie> returnByName(String name);


    //Write a native query that return the list of movies in a specific range of prices
     @Query(value = "select m.* from movie m where m.price between ?1 and ?2", nativeQuery = true)
    List<Movie> returnBetweenPrice(BigDecimal p1, BigDecimal p2);

    //Write a native query to return all movies where duration exists in the range of duration
    @Query(value = "select m.* from movie m where m.duration between ?1 and ?2", nativeQuery = true)
    List<Movie> returnBetweenDuration(int d1, int d2);


    //Write a native query to list the top 5 most expensive movies
    @Query(value = "select m.* from movie m order by price desc limit(5)", nativeQuery = true)
    List<Movie> most5ExpensiveMovies();

}
