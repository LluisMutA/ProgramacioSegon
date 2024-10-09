package com.esliceu.streams.exercises;

import com.esliceu.streams.dao.CityDao;
import com.esliceu.streams.dao.CountryDao;
import com.esliceu.streams.dao.InMemoryWorldDao;

/**
 * 
 * 
 *
 */
public class Exercise4 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
	private static final CityDao cityDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the highest populated capital city
		countryDao.findAllCountries().stream()
				.map(c -> c.getCapital())
				.map(id -> cityDao.findCityById(id))
				.filter(c -> c != null)
				.sorted((a, b) -> b.getPopulation() - a.getPopulation())
				.findFirst().ifPresent(System.out::println);
	}
}
