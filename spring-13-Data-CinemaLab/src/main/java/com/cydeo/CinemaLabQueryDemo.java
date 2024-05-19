package com.cydeo;

import com.cydeo.enums.MovieState;
import com.cydeo.enums.MovieType;
import com.cydeo.enums.UserRole;
import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Component
public class CinemaLabQueryDemo implements CommandLineRunner {

    private final AccountRepository accountRepository;
    private final CinemaRepository cinemaRepository;
    private final GenreRepository genreRepository;
    private final MovieCinemaRepository movieCinemaRepository;
    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;
    private final UserRepository userRepository;

    public CinemaLabQueryDemo(AccountRepository accountRepository, CinemaRepository cinemaRepository, GenreRepository genreRepository, MovieCinemaRepository movieCinemaRepository, MovieRepository movieRepository, TicketRepository ticketRepository, UserRepository userRepository) {
        this.accountRepository = accountRepository;
        this.cinemaRepository = cinemaRepository;
        this.genreRepository = genreRepository;
        this.movieCinemaRepository = movieCinemaRepository;
        this.movieRepository = movieRepository;
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=======================AccountRepository=======================");
        System.out.println(accountRepository.findByCountryOrState("United States", "Kentucky"));
        System.out.println(accountRepository.findByAgeLessThanEqual(40));
        System.out.println(accountRepository.findByRole(UserRole.USER));
        System.out.println(accountRepository.findByAgeBetween(15, 50));
        System.out.println(accountRepository.findByAddressStartingWith("Lo"));

        System.out.println("=======================CinemaRepository=======================");
        System.out.println(cinemaRepository.getByName("Hall 1 - EMPIRE"));
//        System.out.println(cinemaRepository.getTop3BySponsoredNameContains("Kodak"));
        System.out.println(cinemaRepository.getByLocation_Country("United States"));
        System.out.println(cinemaRepository.getByNameOrSponsoredName("Hall 2 - EMPIRE", "Kodak"));
        System.out.println(cinemaRepository.readCinemaNameWithId(5L));
        System.out.println(cinemaRepository.readCinemaByLocationCountry("United States"));
        System.out.println(cinemaRepository.readByNameOrSponsoredNameWithSpecificPattern("EMP", "Kod"));
        System.out.println(cinemaRepository.sortCinemaOrderByName());
        System.out.println(cinemaRepository.distinctCinemaByName());

        System.out.println("=========================GenreRepository=========================");
        System.out.println(genreRepository.allGenres());
        System.out.println(genreRepository.allGenresByContainingName("Horror"));
        System.out.println("=========================MovieCinemaRepository=========================");

        System.out.println(movieCinemaRepository.findById(1L));
        System.out.println(movieCinemaRepository.countByCinema_Id(1L));//6
        System.out.println(movieCinemaRepository.countByMovie_Id(1L));//5
        System.out.println(movieCinemaRepository.findByDateTimeAfter(LocalDate.of(2020, 12, 06)));
        System.out.println(movieCinemaRepository.findTop3ByOrderByMovie_PriceDesc());
        System.out.println(movieCinemaRepository.findByMovieNameContaining("Gentleman"));
        System.out.println(movieCinemaRepository.findByCinema_Location_Name("AMC Lincoln Square 13"));
        System.out.println(movieCinemaRepository.higherThanSpecificDate(LocalDate.of(2020, 12, 06)));
        System.out.println(movieCinemaRepository.countMovieCinemaWithId(1L));
        System.out.println(movieCinemaRepository.findByCinemaLocationName("AMC Empire 25"));

        System.out.println("=========================MovieRepository=========================");
        System.out.println(movieRepository.findByName("Tenet"));
        System.out.println(movieRepository.findByPriceBetween(BigDecimal.valueOf(25), BigDecimal.valueOf(40)));
        System.out.println(movieRepository.findByDurationIn(List.of(100, 130, 150)));
        System.out.println(movieRepository.findByReleaseDateGreaterThan(LocalDate.of(2002, 01, 04)));
        System.out.println(movieRepository.findByStateAndType(MovieState.ACTIVE, MovieType.REGULAR));
        System.out.println(movieRepository.findByPriceBetween(BigDecimal.valueOf(20), BigDecimal.valueOf(40)));
        System.out.println(movieRepository.findName());
        System.out.println(movieRepository.returnByName("Tenet"));
        System.out.println(movieRepository.returnBetweenPrice(BigDecimal.valueOf(20), BigDecimal.valueOf(40)));
        System.out.println(movieRepository.returnBetweenDuration(120, 160));
        System.out.println(movieRepository.most5ExpensiveMovies());

        System.out.println("=========================TicketRepository=========================");
//        System.out.println(ticketRepository.countAllByUserAccountId());
        System.out.println(ticketRepository.findByUserAccountEmail("josie_story@email.com"));
        System.out.println(ticketRepository.countByMovieCinemaMovieName("Tenet"));
        System.out.println(ticketRepository.findByDateTimeBetween(LocalDate.of(2020, 12, 06), LocalDate.of(2020, 12, 07)));
        System.out.println(ticketRepository.dateTimeBetweenRange(LocalDate.of(2020, 12, 06), LocalDate.of(2020, 12, 07)));
        System.out.println(ticketRepository.countTicketsByUser(1L));
        System.out.println(ticketRepository.countTicketsByUserAndBetweenDate(1L, LocalDate.of(2020, 12, 05), LocalDate.of(2020, 12, 07)));
        System.out.println(ticketRepository.distinctTicketsByMovieName("Tenet"));
        System.out.println(ticketRepository.findByUserAccountEmail("josie_story@email.com"));
        System.out.println(ticketRepository.returnAllTickets());
        System.out.println(ticketRepository.findContainUserOrMovieOrAccount("The"));

        System.out.println("=========================UserRepository=========================");
        System.out.println(userRepository.findByEmail("josie_story@email.com"));
        System.out.println(userRepository.findByUsername("josieStory"));
        System.out.println(userRepository.findByUsernameContaining("josie"));
        System.out.println(userRepository.findByUsernameContainingIgnoreCase("Josie"));
        System.out.println(userRepository.findByAccount_AgeGreaterThan(30));
        System.out.println(userRepository.readByEmail("josie_story@email.com"));
        System.out.println(userRepository.readByUserName("faith"));
        System.out.println(userRepository.returnAllUsers());
        System.out.println(userRepository.returnAllUsersContainName("john"));
        System.out.println(userRepository.returnAllUsersNative());
        System.out.println(userRepository.returnAllUsersBetweenAge(25, 40));
        System.out.println(userRepository.readByEmailNative("faith.p@email.com"));


    }
}
