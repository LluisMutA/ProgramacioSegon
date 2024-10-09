package com.esliceu.streams.exercises;

import com.esliceu.streams.dao.CityDao;
import com.esliceu.streams.dao.CountryDao;
import com.esliceu.streams.dao.InMemoryWorldDao;

/**
 * 
 * 
 *
 */
public class Exercise5 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();
	private static final CityDao cityDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the highest populated capital city of each continent
		countryDao.getAllContinents().stream()
				.forEach(cont ->{
					countryDao.findCountriesByContinent(cont).stream()
							.map(country -> country.getCapital())
							.filter(c -> c != null)
							.map(id -> cityDao.findCityById(id))
							.filter(city -> city != null)
							.sorted((a, b) -> b.getPopulation() - a.getPopulation())
							.findFirst().ifPresent(System.out::println);
				});
	}
}