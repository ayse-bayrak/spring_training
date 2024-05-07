package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Struct;
import java.util.List;

public interface RegionRepository extends JpaRepository<Region, Integer> {
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
