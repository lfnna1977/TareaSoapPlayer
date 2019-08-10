package com.numa.soap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numa.soap.entity.Club;
import com.numa.soap.repository.ClubRepository;


@Service
public class ClubService implements IClubService {
	@Autowired
	private ClubRepository clubRepository;
	
	@Override
	public Club getClubById(long clubId) {
		Club obj = clubRepository.findByClubId(clubId);
		return obj;
	}	
	@Override
	public List<Club> getAllClubs(){
		List<Club> list = new ArrayList<>();
		clubRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	@Override
	public synchronized boolean addClub(Club club){
	   List<Club> list = clubRepository.findByNameAndCity(club.getName(), club.getCity());
       if (list.size() > 0) {
    	   return false;
       } else {
    	   club = clubRepository.save(club);
    	   return true;
       }
	}
	@Override
	public void updateClub(Club club) {
		clubRepository.save(club);
	}
	@Override
	public void deleteClub(Club club) {
		clubRepository.delete(club);
	}
}
