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
public class Exercise6 {
	private static final CountryDao countryDao = InMemoryWorldDao.getInstance();

	public static void main(String[] args) {
		// Sort the countries by number of their cities in descending order
		countryDao.findAllCountries().stream()
						.sorted((a,b) -> b.getCities().size() - a.getCities().size())
								.forEach(count -> {
									System.out.printf("El pais %s te %d ciutats\n", count.getName(), count.getCities().size());
								});
	}
}
