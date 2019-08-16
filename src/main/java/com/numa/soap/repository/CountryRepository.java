package com.numa.soap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.numa.soap.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Long>  {
	Country findByCountryId(long countryId);
    List<Country> findByNameAndCode(String name, String code);
}
