package com.esliceu.streams.exercises;

import com.esliceu.streams.dao.InMemoryWorldDao;
import com.esliceu.streams.dao.WorldDao;
import com.esliceu.streams.domain.Country;

import java.util.LongSummaryStatistics;
import java.util.function.BiConsumer;
import java.util.stream.Collectors;

/**
 * 
 * 
 *
 */
public class Exercise12 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	private static final BiConsumer<String, LongSummaryStatistics> printEntry = (continent, statistics) -> System.out.printf("%s: %s\n", continent, statistics);

	public static void main(String[] args) {
		// Find the minimum, the maximum and the average population of each continent.
		worldDao.findAllCountries().stream()
				.collect(Collectors.groupingBy(Country::getContinent))
				.forEach((continent, countries) -> {
					Long maxPob = countries.stream()
							.mapToLong(c -> c.getPopulation())
							.max().getAsLong();
					Long minPob = countries.stream().filter(c -> c.getPopulation() != 0)
							.mapToLong(c -> c.getPopulation())
							.min().orElse(0);
					Long avgPob = countries.stream()
							.mapToLong(c -> c.getPopulation())
							.reduce(0, (a, b) -> a+b);
					System.out.println(continent + " te una població màxima de: " + maxPob + " una població minima de: " + minPob + " y un avg de: " + avgPob);
				});

	}
}
