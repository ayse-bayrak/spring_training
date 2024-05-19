package com.cydeo.repository;

import com.cydeo.entity.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

    // ------------------- DERIVED QUERIES ------------------- //
    //Write a derived query to get cinema with a specific name
    Optional<Cinema> getByName(String name);
    //Write a derived query to read sorted the top 3 cinemas that contains a specific sponsored name
    List<Cinema> getTop3BySponsoredNameContainsOrderBySponsoredName(String specificSponsoredName);
    //Write a derived query to list all cinemas in a specific country
    List<Cinema> getByLocation_Country(String country);
    //Write a derived query to list all cinemas with a specific name or sponsored name
    List<Cinema> getByNameOrSponsoredName(String name, String sponsoredName);
    // ------------------- JPQL QUERIES ------------------- //
    //Write a JPQL query to read the cinema name with a specific id
    @Query("select c from Cinema c where c.id=?1")
    List<Cinema> readCinemaNameWithId(Long id);
    // ------------------- Native QUERIES ------------------- //
    //Write a native query to read all cinemas by location country
    @Query(value = "select c.* from cinema c join location l on c.location_id=l.id where l.country =?1", nativeQuery = true)
    List<Cinema> readCinemaByLocationCountry(String country);
    //Write a native query to read all cinemas by name or sponsored name contains a specific pattern
    @Query(value = "SELECT * from cinema c where c.name like %?1% or c.sponsored_name like %?2%", nativeQuery = true)
    List<Cinema> readByNameOrSponsoredNameWithSpecificPattern(String namePattern, String countryPattern);
    //Write a native query to sort all cinemas by name
    @Query(value = "SELECT * from cinema c order by c.name", nativeQuery = true)
    List<Cinema> sortCinemaOrderByName();
    //Write a native query to distinct all cinemas by sponsored name
    @Query(value = "SELECT distinct sponsored_name from cinema ", nativeQuery = true)
    List<String> distinctCinemaByName();
}
