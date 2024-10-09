package com.esliceu.streams.exercises;

import com.esliceu.streams.dao.CountryDao;
import com.esliceu.streams.dao.InMemoryWorldDao;
import com.esliceu.streams.domain.City;
import com.esliceu.streams.domain.Country;

import java.util.Optional;

/**
 * 
 * 
 *
 */
public class Exercise2 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Find the most populated city of each continent
		countryDao.getAllContinents().stream()
				.forEach(cont -> {
					Optional<City> opt = countryDao.findCountriesByContinent(cont)
							.stream()
							.flatMap(c -> c.getCities().stream())
							.sorted((a, b) -> b.getPopulation() - a.getPopulation())
							.findFirst();
					opt.ifPresent(s -> System.out.printf("Al continent de/d' %s la ciutat més poblada és: %s\n", cont, s.getName()));
				});
	}

}