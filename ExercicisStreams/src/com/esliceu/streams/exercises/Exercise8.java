package com.esliceu.streams.exercises;

import com.esliceu.streams.domain.Movie;
import com.esliceu.streams.service.InMemoryMovieService;
import com.esliceu.streams.service.MovieService;

import java.util.stream.Collectors;


public class Exercise8 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Group the movies by the year and list them
		movieService.findAllMovies().stream()
				.collect(Collectors.groupingBy(Movie::getYear))
				.forEach((any, llista) -> System.out.printf("A l'any %d, es varen estrenar aquestes pelicules: %s\n", any, llista
						.stream().map(p -> p.getTitle()).toList()));
	}
}
// pelicula.stream().forEach(movie -> movie.getTitle()