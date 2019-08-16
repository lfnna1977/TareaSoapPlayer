package com.numa.soap.service;

import java.util.List;

import com.numa.soap.entity.Country;

public interface IntCountryService {
     List<Country> getAllCountrys();
     Country getCountryById(long countryId);
     boolean addCountry(Country country);
     void updateCountry(Country country);
     void deleteCountry(Country country);
}
