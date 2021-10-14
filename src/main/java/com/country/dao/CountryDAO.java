package com.country.dao;

import java.util.List;

import com.country.model.Country;

/**
 * 
 * Base interface that defines database operations.
 */
public interface CountryDAO {

	/**
	 * Adds a country.
	 * 
	 * @param country {@Country} to be added.
	 */
	void addCountry(final Country country);

	/**
	 * Updates a country
	 * 
	 * @param country {@Country} to be updated.
	 */
	void updateCountry(Country country);

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
