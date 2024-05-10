package com.cydeo.repository;

import com.cydeo.entity.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
Long countAllBy();

    //Write a derived query to list all tickets by specific email
List<Ticket> findByUserAccountEmail(String email);

    //Write a derived query to count how many tickets are sold for a specific movie
Long countByMovieCinemaMovieName(String name);

    //Write a derived query to list all tickets between a range of dates
List<Ticket> findByDateTimeBetween(LocalDate d1, LocalDate d2);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket  t where t.userAccount.id=?1")
    List<Ticket>ticketsBuyUser(Long id);
    //Write a JPQL query that returns all tickets between a range of dates
    @Query("select t from Ticket  t where t.dateTime between ?1 and ?2")
    List<Ticket>dateTimeBetweenRange(LocalDate d1, LocalDate d2);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query (value = "select count(*) from ticket t where t.user_account_id = ?1", nativeQuery = true)
    Long countTicketsByUser(Long id);

    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query (value = "select count(*) from ticket t where t.user_account_id = ?1 and t.date_time between ?2 and ?3", nativeQuery = true)
    Long countTicketsByUserAndBetweenDate(Long id, LocalDate d1, LocalDate d2);

    //Write a native query to distinct all tickets by movie name
    @Query (value = "select distinct t.* from ticket t join movie_cinema mc on t.movie_cinema_id=mc.id join movie m on mc.movie_id=m.id where m.name= ?1", nativeQuery = true)
    List<Ticket> distinctTicketsByMovieName(String movieName);


    //Write a native query to find all tickets by user email
    @Query(value = "select t.* from ticket t join user_account ua on t.user_account_id=ua.id where ua.email=?1", nativeQuery = true)
    List<Ticket> findByUserEmail(String email);

    //Write a native query that returns all tickets
    @Query(value = "select t.* from ticket t ", nativeQuery = true)
    List<Ticket> returnAllTickets();

    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
    @Query(value = "select t.* from ticket t join user_account ua on t.user_account_id=ua.id join account_details ad on ua.account_details_id=ad.id join movie_cinema mc on t.movie_cinema_id=mc.id join movie m on mc.movie_id=m.id where m.name like %?1% or ua.username like %?1% or ad.name like %?1%  ", nativeQuery = true)
    List<Ticket> findContainUserOrMovieOrAccount(String pattern);

}
