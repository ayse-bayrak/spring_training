package com.cydeo;

import com.cydeo.enums.UserRole;
import com.cydeo.repository.*;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

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
//        System.out.println("=======================AccountRepository=======================");
        //   System.out.println(accountRepository.findByCountryOrState("United States", "Kentucky"));
        //   System.out.println(accountRepository.findByAgeLessThanEqual(40));
        //   System.out.println(accountRepository.findByRole(UserRole.USER));
        //   System.out.println(accountRepository.findByAgeBetween(15, 50));
        System.out.println("=======================CinemaRepository=======================");
//        System.out.println(cinemaRepository.getByName("Hall 1 - EMPIRE"));
//        System.out.println(cinemaRepository.getTop3BySponsoredNameContains("Kodak"));
//        System.out.println(cinemaRepository.getByLocation_Country("United States"));
//        System.out.println(cinemaRepository.getByNameOrSponsoredName("Hall 2 - EMPIRE", "Kodak"));
//        System.out.println(cinemaRepository.readCinemaNameWithId(5L));
//        System.out.println(cinemaRepository.readCinemaByLocationCountry("United States"));
//        System.out.println(cinemaRepository.readByNameOrSponsoredNameWithSpecificPattern("EMP", "Kod"));
//        System.out.println(cinemaRepository.sortCinemaOrderByName());
//        System.out.println(cinemaRepository.distinctCinemaByName());

        System.out.println("=========================GenreRepository=========================");
//        System.out.println(genreRepository.allGenres());
//        System.out.println(genreRepository.allGenresByContainingName("Horror"));
        System.out.println("=========================MovieCinemaRepository=========================");

       // System.out.println(movieCinemaRepository.findById(1L));
//        System.out.println(movieCinemaRepository.countByCinema_Id(1L));//6
//        System.out.println(movieCinemaRepository.countByMovie_Id(1L));//5
//        System.out.println(movieCinemaRepository.findByDateTimeAfter(LocalDate.of(2020, 12, 06)));
//        System.out.println(movieCinemaRepository.findTop3ByOrderByMovie_PriceDesc());
//        System.out.println(movieCinemaRepository.findByMovieNameContaining("Gentleman"));
//        System.out.println(movieCinemaRepository.findByCinema_Location_Name("AMC Lincoln Square 13"));
//        System.out.println(movieCinemaRepository.higherThanSpecificDate(LocalDate.of(2020, 12, 06)));
//        System.out.println(movieCinemaRepository.countMovieCinemaWithId(1L));
//        System.out.println(movieCinemaRepository.findByCinemaLocationName("AMC Empire 25"));
        System.out.println("=========================MovieRepository=========================");





    }
}
