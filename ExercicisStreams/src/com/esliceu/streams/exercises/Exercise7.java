package com.esliceu.streams.exercises;

import com.esliceu.streams.service.InMemoryMovieService;
import com.esliceu.streams.service.MovieService;

import java.util.stream.Collectors;

/**
 *
 */
public class Exercise7 {
    private static final MovieService movieService = InMemoryMovieService.getInstance();

    public static void main(String[] args) {
        // Find the list of movies having the genres "Drama" and "Comedy" only
        movieService.findAllMovies().stream().filter(movie -> movie.getGenres().size() == 2)
                .filter(movie -> movie.getGenres().stream().anyMatch(g -> g.getName().equals("Drama")))
                .filter(movie -> movie.getGenres().stream().filter(g -> g.getName().equals("Comedy")).count() != 0)
                .forEach(peli -> {
                    System.out.printf("Les pelicules que tenen els generes de %s i %s son: %s\n", peli.getGenres().get(0).getName(), peli.getGenres().get(1).getName(), peli.getTitle());
                });

    }
}
