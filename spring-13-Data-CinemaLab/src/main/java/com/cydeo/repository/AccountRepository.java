package com.cydeo.repository;

import com.cydeo.entity.Account;
import com.cydeo.enums.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    // ------------------- DERIVED QUERIES ------------------- //
    //This Queries database independent
    //Write a derived query to list all accounts with a specific country or state
    List<Account>findByCountryOrState(String country, String state);
    //Write a derived query to list all accounts with age lower than or equal to a specific value
    List<Account> findByAgeLessThanEqual(int age);
    //Write a derived query to list all accounts with a specific role
    List<Account> findByRole(UserRole role);
    //Write a derived query to list all accounts between a range of ages
    List<Account>findByAgeBetween(int age1, int age2);
    //Write a derived query to list all accounts where the beginning of the address contains the keyword
    List<Account>findByAddressStartingWith(String pattern);
    //Write a derived query to sort the list of accounts with age
    List<Account> findByOrderByAge ();



    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all accounts
    @Query("Select a FROM Account a")
    List<Account> fetchAllAccounts(); // this is not derived query
    //Write a JPQL query to list all admin accounts
    @Query("select a from Account a where a.role <> 'ADMIN' ")
    List<Account> fetchAllAdminAccount();
    //Write a JPQL query to sort all accounts with age
    @Query("select a from Account a order by a.age desc")
    List<Account> fetchAllOrderBasedOnAge();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to read all accounts with an age lower than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age <= ?1",nativeQuery = true)
    List<Account> readAccountLowerThanAge(int age);
    //Write a native query to read all accounts that a specific value can be containable in the name, address, country, state city
    @Query(value = "SELECT * FROM account_details WHERE name ILIKE concat('%',?1,'%') OR address  ILIKE concat('%',?1,'%') " +
            " OR country  ILIKE concat('%',?1,'%') OR state  ILIKE concat('%',?1,'%') OR city  ILIKE concat('%',?1,'%')",nativeQuery = true)
    List<Account> retrieveBySearchCriteria(String pattern);

    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age > :age",nativeQuery = true)
    List<Account> readAccountAllAgeHigher(@Param("age") Integer age);

    //Write a native query to read all accounts with an age higher than a specific value
    @Query(value = "SELECT * FROM account_details WHERE age >= ?1 ",nativeQuery = true)
    List<Account> readAccountAgeHigherThan(int age);


}
