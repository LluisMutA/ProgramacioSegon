package com.esliceu.streams.exercises;

import com.esliceu.streams.domain.Movie;
import com.esliceu.streams.service.InMemoryMovieService;
import com.esliceu.streams.service.MovieService;

import java.util.Optional;
/**
 * 
 * 
 *
 */
public class Exercise3 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		// Find the number of genres of each director's movies
		movieService.findAllDirectors().stream()
				.forEach(director -> {
					System.out.printf("--------------------Director $s------------------------\n", director.getName());
					movieService.findAllMoviesByDirectorId(director.getId()).stream()
							.forEach(mov -> {
								System.out.printf("Movie %s num genres %d\n", mov.getTitle(), mov.getGenres().size());
							});
				});
	}
}