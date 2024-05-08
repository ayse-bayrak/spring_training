package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Struct;
import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer> {
// Why we are using JpaRepository? Because it is covers everything CrudRepository and other repository, So why not?
//I am writing all Query type inside repository Why?
// Because this is where bussiness is happening,
// You can think Database service implementation

//I can building Derived Queries I need a business which JPA Repository doesn't give it to me,
//JPA Repository doesn't give it to me.. means if we go to JpaRepostory there is not method related needed business


    //Find All courses by category -- this is business, right now is your chouce
    // either use Derived, or JPQL or Native
    // if something is really basic with a couple of parameter you can use derived queriess


    //Display all regions in Canada
    List<Region> findByCountry(String country);
    List<Region> getByCountry(String country); // it is doing same thing both are same

    //Display all regions with country name includes 'United'
    List<Region> findByCountryContaining(String country); //contains it is doing same job

    //Display all regions with country name include 'United' in order (region)
    List<Region> findByCountryContainingOrderByRegionDesc(String country);

    //Display top 2 regions in United States
    List<Region> findTopByCountry(String country);
    List<Region> findTop2ByCountry(String country);

    List<Region>findTopByCountryContainsOrderByRegion(String country);

}
