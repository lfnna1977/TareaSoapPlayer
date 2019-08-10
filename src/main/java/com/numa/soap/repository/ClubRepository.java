package com.numa.soap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.numa.soap.entity.Club;

public interface ClubRepository extends CrudRepository<Club, Long>  {
	Club findByClubId(long clubId);
    List<Club> findByNameAndCity(String name, String city);
}
