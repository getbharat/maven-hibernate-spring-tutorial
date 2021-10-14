package com.country.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.country.model.Country;
import com.country.service.CountryService;

@RestController
public class CountryController {

	final static Logger LOGGER = LoggerFactory.getLogger(CountryController.class);
	private CountryService countryService;

	@Autowired(required = true)
	@Qualifier(value = "countryService")
	public void setCountryService(final CountryService countryService) {
		this.countryService = countryService;
	}

	@GetMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Country>> getCountries() {
		List<Country> listOfCountries;
		try {
			listOfCountries = countryService.getCountries();
		} catch (final Exception e) {
			LOGGER.error("Couldn't fetch countries :: method :: getCountries", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<List<Country>>(listOfCountries, HttpStatus.OK);

	}

	@PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addCountry(@RequestBody Country country) {
		try {
			countryService.addCountry(country);
		} catch (final Exception e) {
			LOGGER.error("Couldn't add country :: method :: addCountry ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<String>("Country Added!", HttpStatus.OK);
	}

	@PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateCountry(@RequestBody Country country) {
		try {
			countryService.updateCountry(country);
		} catch (final Exception e) {
			LOGGER.error("Couldn't update country :: method :: updateCountry ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Country updated!", HttpStatus.OK);
	}

	@DeleteMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> deleteCountryById(@PathVariable(name = "id") int id) {
		try {
			countryService.deleteCountry(id);
		} catch (final Exception e) {
			LOGGER.error("Couldn't delete country :: method :: deleteCountry ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Country deleted!", HttpStatus.OK);
	}

	@GetMapping(value = "/getCountry", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Country> getCountryById(@RequestParam(name = "id") int id) {
		Country country = null;
		try {
			country = countryService.getCountryById(id);
		} catch (final Exception e) {
			LOGGER.error("Couldn't get country :: method :: getCountryById ", e);
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Country>(country, HttpStatus.OK);
	}

}
