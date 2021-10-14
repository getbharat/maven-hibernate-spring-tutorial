package com.country.service;

import java.util.List;

import com.country.model.Country;

/**
 * 
 * Base interface to define CRUD operations for {@Country} entity.
 *
 */
public interface CountryService {
	/**
	 * Adds a country.
	 * 
	 * @param country {@Country} to added.
	 */
	void addCountry(final Country country);

	/**
	 * Updates a country.
	 * 
	 * @param country {@Country} to updated.
	 */
	void updateCountry(final Country country);

	/**
	 * Deletes a country.
	 *
	 * @param id {@Country} identifier.
	 */
	void deleteCountry(final int id);

	/**
	 * Fetches all countries.
	 * 
	 * @return list of {@Country}.
	 */
	List<Country> getCountries();

	/**
	 * Fetches the country by id.
	 * 
	 * @param id an identifier of {@Country}.
	 */
	Country getCountryById(final int id);

}
