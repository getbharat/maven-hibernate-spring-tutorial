package com.country.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "Country")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Country_ID")
	private int countryId;
	
	@Column(name = "Country_Name")
	private String countryName;
	
	@Column(name = "Country_Code")
	private String countryCode;
	
	@ElementCollection
	@CollectionTable(name="Country_TimeZone", joinColumns=@JoinColumn(name="Country_ID"))
	@Column(name = "Time_Zone")
	private List<String> timeZone ;

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public List<String> getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(List<String> timeZone) {
		this.timeZone = timeZone;
	}

}
