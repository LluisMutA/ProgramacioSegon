package com.esliceu.streams.dao;

import java.util.List;

import com.esliceu.streams.domain.City;

/**
 *
 * 
 */
public interface CityDao {
	City findCityById(int id);

	City removeCity(City city);

	City addCity(City city);

	City updateCity(City city);

	List<City> findAllCities();

	List<City> findCitiesByCountryCode(String countryCode);
}
