package com.country.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.country.dao.impl.CountryDAOImpl;
import com.country.model.Country;
import com.country.service.CountryService;

/**
 * @author Bharat
 *
 */
@Service
public class CountryServiceImpl implements CountryService {

	final static Logger LOGGER = LoggerFactory.getLogger(CountryServiceImpl.class);
	
	private CountryDAOImpl countryDAO;
	
	public void setCountryDAO(CountryDAOImpl countryDAO) {
		this.countryDAO = countryDAO;
	}
     
	
	@Override
	@Transactional
	public void addCountry(final Country country) {
		countryDAO.addCountry(country);
	}

	@Override
	public void updateCountry(Country country) {
		countryDAO.updateCountry(country);

	}

	@Override
	public void deleteCountry(int id) {
		countryDAO.deleteCountry(id);

	}

	@Override
	public List<Country> getCountries() {
		return countryDAO.getCountries();
	}

	@Override
	public Country getCountryById(int id) {
		return countryDAO.getCountryById(id);

	}

}
