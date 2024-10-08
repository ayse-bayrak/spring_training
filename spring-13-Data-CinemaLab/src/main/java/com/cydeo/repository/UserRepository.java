package com.cydeo.repository;

import com.cydeo.entity.User;
import org.hibernate.resource.beans.container.spi.ExtendedBeanManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to read a user with an email?
    User findByEmail(String email);

    //Write a derived query to read a user with a username?
    User findByUsername(String username);

    //Write a derived query to list all users that contain a specific name?
    List<User>findByUsernameContaining(String pattern); // there is not differences than previous one it can be another solution

    //Write a derived query to list all users that contain a specific name in the ignore case mode?
    List<User>findByUsernameContainingIgnoreCase(String pattern);

    //Write a derived query to list all users with an age greater than a specified age?
List<User> findByAccount_AgeGreaterThan(int age);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns a user read by email?
    @Query("select u from User u where u.email=?1")
    User readByEmail(String email);

    //Write a JPQL query that returns a user read by username?
    @Query("select u from User u where u.username=?1")
    User readByUserName(String username);

    //Write a JPQL query that returns all users?
    @Query("select u from User u")
    List<User> returnAllUsers();

    // ------------------- Native QUERIES ------------------- //

    //Write a native query that returns all users that contain a specific name?
    @Query(value = "select ua.* from user_account ua where ua.username like %?1%", nativeQuery = true)
    List<User>returnAllUsersContainName(String name);

    //Write a native query that returns all users?
    @Query(value = "select ua.* from user_account ua", nativeQuery = true)
    List<User>returnAllUsersNative();

    //Write a native query that returns all users in the range of ages?
    @Query(value = "select ua.* from user_account ua join account_details ad on ua.account_details_id=ad.id where ad.age between ?1 and ?2", nativeQuery = true)
    List<User>returnAllUsersBetweenAge(int a1, int a2);

    //Write a native query to read a user by email?
    @Query(value = "select * from user_account u where u.email=?1", nativeQuery = true)
    User readByEmailNative(String email);

}
