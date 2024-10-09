package com.esliceu.streams.exercises;

import com.esliceu.streams.dao.InMemoryWorldDao;
import com.esliceu.streams.dao.WorldDao;
import com.esliceu.streams.domain.Country;

import java.util.stream.Collectors;


public class Exercise11 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the minimum, the maximum and the average population of world countries

		Long maxPob = worldDao.findAllCountries().stream()
				.mapToLong(c -> c.getPopulation())
				.max().getAsLong();

		System.out.println(maxPob);

		Long minPob = worldDao.findAllCountries().stream().filter(c -> c.getPopulation() != 0)
				.mapToLong(Country::getPopulation)
				.min().getAsLong();

		System.out.println(minPob);

		Long avgPob = worldDao.findAllCountries().stream().mapToLong(c -> c.getPopulation()).reduce(0, (a, b) -> a+b);
		System.out.println(avgPob);
	}
}
