package com.numa.soap.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.numa.soap.entity.Player;
import com.numa.soap.repository.PlayerRepository;


@Service
public class ImpPlayerService implements IntPlayerService {
	@Autowired
	private PlayerRepository playerRepository;
	
	@Override
	public Player getPlayerById(long playerId) {
		Player obj = playerRepository.findByPlayerId(playerId);
		return obj;
	}	
	@Override
	public List<Player> getAllPlayers(){
		List<Player> list = new ArrayList<>();
		playerRepository.findAll().forEach(e -> list.add(e));
		return list;
	}
	@Override
	public synchronized boolean addPlayer(Player player){
	   List<Player> list = playerRepository.findByNameAndPosition(player.getName(), player.getPosition());
       if (list.size() > 0) {
    	   return false;
       } else {
    	   player = playerRepository.save(player);
    	   return true;
       }
	}
	@Override
	public void updatePlayer(Player player) {
		playerRepository.save(player);
	}
	@Override
	public void deletePlayer(Player player) {
		playerRepository.delete(player);
	}
}
