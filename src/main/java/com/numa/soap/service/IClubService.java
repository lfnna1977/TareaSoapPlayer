package com.numa.soap.service;

import java.util.List;

import com.numa.soap.entity.Club;

public interface IClubService {
     List<Club> getAllClubs();
     Club getClubById(long clubId);
     boolean addClub(Club club);
     void updateClub(Club club);
     void deleteClub(Club club);
}
