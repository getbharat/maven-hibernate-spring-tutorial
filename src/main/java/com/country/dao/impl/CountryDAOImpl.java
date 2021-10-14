package com.country.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.country.dao.CountryDAO;
import com.country.model.Country;

@Repository
public class CountryDAOImpl implements CountryDAO {

	private SessionFactory sessionFactory;
	final static Logger LOGGER = LoggerFactory.getLogger(CountryDAOImpl.class);

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public void addCountry(Country country) {
		final Session session = this.sessionFactory.getCurrentSession();
		session.update(country);
		LOGGER.info("Country updates successfully, Country Details="+country);

	}

	@Override
	public void updateCountry(Country country) {
		final Session session = this.sessionFactory.getCurrentSession();
		session.persist(country);
		LOGGER.info("Country saved successfully, Country Details="+country);

	}

	@Override
	public void deleteCountry(int id) {
		final Session session = this.sessionFactory.getCurrentSession();
		Country country = (Country)session.load(Country.class, new Integer(id));
		if(null != country) {
			session.delete(country);
		}
		LOGGER.info("Country deleted successfully, Country Details="+id);

	}

	@Override
	public List<Country> getCountries() {
		final Session session = this.sessionFactory.getCurrentSession();
		List<Country> countries = session.createQuery("From Country").list();
		LOGGER.info("Countries fetched successfully, Country count="+countries.size());
		return countries;
		
	}

	@Override
	public Country getCountryById(int id) {
		final Session session = this.sessionFactory.getCurrentSession();
		final Country country = (Country)session.load(Country.class, new Integer(id));
		LOGGER.info("Country fetched successfully, Country Details="+country);
		return country;

	}

}
