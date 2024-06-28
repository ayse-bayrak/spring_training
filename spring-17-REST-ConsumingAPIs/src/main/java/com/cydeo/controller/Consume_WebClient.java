package com.cydeo.controller;

import com.cydeo.dto.GenreDTO;
import com.cydeo.dto.MovieCinemaDTO;
import com.cydeo.service.GenreService;
import com.cydeo.service.MovieCinemaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

// we are learning how to create our API in a reactive way by using reactive programming of Java which is MONO and FLUX
//1- Mono: if my endpoints returns one object we say Mono
//2- Flux: if my endpoints returns more than one object we call Flux

//what is reactive programming
//Java is providing me this directly programming mono and flux
//How you can create reactive APIs?
//with Mono and Flux java already gives us
//How you can consume reactive APIs?
//With webClient
//How you are implementing the webClient?
//Create instance as field (with inject Webclient webclient) and then follow structure
//.get
//.uri
//.header
//.retrieve
//.bodyToFlux or bodyToMono --> whatever that consuming API is providing
@RestController
public class Consume_WebClient {

    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
    // I am consuming my own API, I define base URL here in the top
    // and then when I consume something by using web client, we say webClient.
    private final MovieCinemaService movieCinemaService;
    private final GenreService genreService;

    public Consume_WebClient(MovieCinemaService movieCinemaService, GenreService genreService) {
        this.movieCinemaService = movieCinemaService;
        this.genreService = genreService;
    }

    @GetMapping("/flux-movie-cinemas") // localhost:8080/flux-movie-cinemas
    public Flux<MovieCinemaDTO> readAllCinemaFlux(){ // flux meaning it is returning more than one
        //this is works as a reactive way meaning async way
        return Flux.fromIterable(movieCinemaService.findAll());

    }

//    @GetMapping("/mono-movie-cinema/{id}")
//    public Mono<MovieCinemaDTO> readById(@PathVariable("id") Long id){
//
//        return Mono.just(movieCinemaService.findById(id));
//
//    } // regular way, not ResponseEntity

    @GetMapping("/mono-movie-cinema/{id}") // localhost:8080
    public ResponseEntity<Mono<MovieCinemaDTO>> readById(@PathVariable("id") Long id){
    // only one object
        return ResponseEntity.ok(Mono.just(movieCinemaService.findById(id)));

    }

    @PostMapping("/create-genre")
    public Mono<GenreDTO> createGenre(@RequestBody GenreDTO genre){

        GenreDTO createdGenre = genreService.save(genre);

        return Mono.just(createdGenre);
//        return Mono.just(genreRepository.save(genre));

    }

    @DeleteMapping("/delete/genre/{id}")
    public Mono<Void> deleteGenre(@PathVariable("id") Long id){

        genreService.deleteById(id);

        return Mono.empty();
    }

//    ---------------------------WEBCLIENT---------------------------
    // for consuming
    @GetMapping("/flux")
    public Flux<MovieCinemaDTO> readWithWebClient(){

        return webClient
                .get()
                .uri("/flux-movie-cinemas")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .retrieve()
                .bodyToFlux(MovieCinemaDTO.class);

    }

    @GetMapping("/mono/{id}")
    public Mono<MovieCinemaDTO> readMonoWithWebClient(@PathVariable("id") Long id){

        return webClient
                .get()
                .uri("/mono-movie-cinema/{id}",id)
                .retrieve()
                .bodyToMono(MovieCinemaDTO.class);

    }

}
