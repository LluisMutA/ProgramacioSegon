package com.esliceu.streams.exercises;

import com.esliceu.streams.service.InMemoryMovieService;
import com.esliceu.streams.service.MovieService;

import java.util.stream.Stream;

/**
 * 
 * 
 *
 */
public class Exercise1 {
	private static final MovieService movieService = InMemoryMovieService.getInstance();

	public static void main(String[] args) {
		movieService
				.findAllDirectors().stream()
	//			.map(d -> {
	//				 String.format("El director %s ha fet %d películes\n", d.getName(),
	//						movieService
	//								.findAllMoviesByDirectorId(d.getId()).stream().count());
				.forEach(d -> {
					long quantes = movieService
							.findAllMoviesByDirectorId(d.getId()).stream().count();
					System.out.printf("El director %s ha fet %d películes\n", d.getName(), quantes);
				});
	}
}
