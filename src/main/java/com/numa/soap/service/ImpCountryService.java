package com.numa.soap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numa.soap.entity.Country;
import com.numa.soap.repository.CountryRepository;


@Service
public class ImpCountryService implements IntCountryService {
	@Autowired
	private CountryRepository CountryRepository;
	
	@Override
	public Country getCountryById(long countryId) {
		Country obj = CountryRepository.findByCountryId(countryId);
		return obj;
	}	
	@Override
	public List<Country> getAllCountrys(){
		List<Country> list = new ArrayList<>();
		CountryRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	@Override
	public synchronized boolean addCountry(Country country){
	   List<Country> list = CountryRepository.findByNameAndCode(country.getName(), country.getCode());
       if (list.size() > 0) {
    	   return false;
       } else {
    	   country = CountryRepository.save(country);
    	   return true;
       }
	}
	@Override
	public void updateCountry(Country country) {
		CountryRepository.save(country);
	}
	@Override
	public void deleteCountry(Country country) {
		CountryRepository.delete(country);
	}
}
