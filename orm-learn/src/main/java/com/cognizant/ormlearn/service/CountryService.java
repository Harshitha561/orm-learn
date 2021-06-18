package com.cognizant.ormlearn.service;
//import com.cognizant.ormlearn.repository.*;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import java.util.List;
import java.util.Optional;

@Service

public class CountryService {
	@Autowired
	private CountryRepository countryRepository;
	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}
	
	@Transactional

	public Country findCountryByCode(String countryCode) throws CountryNotFoundException{
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) 
			throw new CountryNotFoundException("not found");
		
		
			Country country = result.get();
		
			return country;
		
	}
}
