package com.esliceu.streams.exercises;

import com.esliceu.streams.dao.InMemoryWorldDao;
import com.esliceu.streams.dao.WorldDao;

public class Exercise9 {
	private static final WorldDao worldDao = InMemoryWorldDao.getInstance();
	
	public static void main(String[] args) {
		// Sort the countries by their population densities in descending order ignoring
		// zero population countries
		worldDao.findAllCountries().stream().filter(countP -> countP.getPopulation() !=0)
				.sorted((c1, c2) -> {
					double dens1 = c1.getPopulation() / c1.getSurfaceArea();
					double dens2 = c2.getPopulation() / c2.getSurfaceArea();
					return Double.compare(dens2, dens1);
				})
				.forEach(country -> {
					double dens = country.getPopulation() / country.getSurfaceArea();
					System.out.println(country.getName() + " - Densidad: " + dens);
				});
	}
}
