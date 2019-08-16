package com.numa.soap.service;

import java.util.List;

import com.numa.soap.entity.Player;

public interface IntPlayerService {
     List<Player> getAllPlayers();
     Player getPlayerById(long playerId);
     boolean addPlayer(Player player);
     void updatePlayer(Player player);
     void deletePlayer(Player player);
}
