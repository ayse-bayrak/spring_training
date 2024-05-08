package com.cydeo;

import com.cydeo.repository.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
    System.out.println(accountRepository.findByCountryOrState("United States", "New York"));
    System.out.println(accountRepository.findByAgeLessThanEqual(40));
    System.out.println(accountRepository.findByRole("ADMIN"));
    System.out.println(accountRepository.findByAgeBetween(15, 50));
    }
}
