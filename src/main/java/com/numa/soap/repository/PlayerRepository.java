package com.numa.soap.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.numa.soap.entity.Player;

public interface PlayerRepository extends CrudRepository<Player, Long>  {
	Player findByPlayerId(long PlayerId);
    List<Player> findByNameAndPosition(String name, String position);
}
