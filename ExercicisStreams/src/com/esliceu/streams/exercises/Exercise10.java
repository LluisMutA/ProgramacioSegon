package com.esliceu.streams.exercises;

import com.esliceu.streams.dao.InMemoryWorldDao;
import com.esliceu.streams.dao.WorldDao;
import com.esliceu.streams.domain.Country;

import java.util.Comparator;
import java.util.stream.Collectors;


public class Exercise10 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();
	public static void main(String[] args) {
		// Find the richest country of each continent with respect to their GNP (Gross National Product) values.
		worldDao.findAllCountries().stream()
				.collect(Collectors.groupingBy(Country::getContinent))
				.forEach((continent, country) ->{
						country.sort((a, b) -> Double.compare(b.getGnp(), a.getGnp()));
						Country RC = country.getFirst();
							System.out.println(RC.getName() + " és el país més ric de " +continent);
						});
//				.collect(Collectors.groupingBy(
//						Country::getContinent,
//						Collectors.maxBy(Comparator.comparingDouble(Country::getGnp))
//				))
//				.forEach((cont, richestCountryS)-> {
//					richestCountryS.ifPresent(richestCountry -> {
//						System.out.println(richestCountry.getName() + " es el país más rico de " + cont);
//					});
//				});

//				.collect(Collectors.groupingBy(Country::getContinent))

//				.forEach(continent, country -> {
//					country.sort((a, b) -> {
//						double png1 = a.getGnp();
//						double png2 = b.getGnp();
//						return Double.compare(png2, png1);
//					})
//					System.out.println(country.getName() + " es el pais més ric de " + country.getContinent());
//				});
//				.collect(Collectors.groupingBy(Country::getContinent))
//				.forEach((continent, countries) -> {
//					countries.sort((a, b) -> Double.compare(b.getGnp(), a.getGnp()));
//
//					Country richestCountry = countries.getFirst();
//
//					System.out.println(richestCountry.getName() + " es el país más rico de " + continent);
//				});
	}
}
