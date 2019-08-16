package com.numa.soap.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.numa.soap.entity.Player;
import com.numa.soap.gs_ws.AddPlayerRequest;
import com.numa.soap.gs_ws.AddPlayerResponse;
import com.numa.soap.gs_ws.DeletePlayerRequest;
import com.numa.soap.gs_ws.DeletePlayerResponse;
import com.numa.soap.gs_ws.GetAllPlayersResponse;
import com.numa.soap.gs_ws.GetPlayerByIdRequest;
import com.numa.soap.gs_ws.GetPlayerByIdResponse;
import com.numa.soap.gs_ws.PlayerInfo;
import com.numa.soap.gs_ws.ServiceStatusPlayer;
import com.numa.soap.gs_ws.UpdatePlayerRequest;
import com.numa.soap.gs_ws.UpdatePlayerResponse;
import com.numa.soap.service.IntPlayerService;
	
@Endpoint
public class PlayerEndpoint {
	private static final String NAMESPACE_URI = "http://www.numapage.com/player-ws";
	@Autowired
	private IntPlayerService playerService;	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getPlayerByIdRequest")
	@ResponsePayload
	public GetPlayerByIdResponse getplayer(@RequestPayload GetPlayerByIdRequest request) {
		GetPlayerByIdResponse response = new GetPlayerByIdResponse();
		PlayerInfo playerInfo = new PlayerInfo();
		BeanUtils.copyProperties(playerService.getPlayerById(request.getPlayerId()), playerInfo);
		response.setPlayerInfo(playerInfo);
		return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllPlayersRequest")
	@ResponsePayload
	public GetAllPlayersResponse getAllplayers() {
		GetAllPlayersResponse response = new GetAllPlayersResponse();
		List<PlayerInfo> playerInfoList = new ArrayList<>();
		List<Player> playerList = playerService.getAllPlayers();
		for (int i = 0; i < playerList.size(); i++) {
			 PlayerInfo ob = new PlayerInfo();
		     BeanUtils.copyProperties(playerList.get(i), ob);
		     playerInfoList.add(ob);    
		}
		response.getPlayerInfo().addAll(playerInfoList);
		return response;
	}	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addPlayerRequest")
	@ResponsePayload
	public AddPlayerResponse addplayer(@RequestPayload AddPlayerRequest request) {
		AddPlayerResponse response = new AddPlayerResponse();		
    	ServiceStatusPlayer serviceStatusPlayer = new ServiceStatusPlayer();
		Player player = new Player();
		player.setCi(request.getCi());
		player.setName(request.getName());
		player.setGender(request.getGender());
		player.setPosition(request.getPosition());
		player.setAditionalData(request.getAditionalData());
		player.setCountryId(request.getCountryId());
		player.setClubId(request.getClubId());
        boolean flag = playerService.addPlayer(player);
        if (flag == false) {
        	serviceStatusPlayer.setStatusCode("CONFLICT");
        	serviceStatusPlayer.setMessage("Content Already Available");
        	response.setServiceStatusPlayer(serviceStatusPlayer);
        } else {
			PlayerInfo playerInfo = new PlayerInfo();
	        BeanUtils.copyProperties(player, playerInfo);
			response.setPlayerInfo(playerInfo);
        	serviceStatusPlayer.setStatusCode("SUCCESS");
        	serviceStatusPlayer.setMessage("Content Added Successfully");
        	response.setServiceStatusPlayer(serviceStatusPlayer);
        }
        return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updatePlayerRequest")
	@ResponsePayload
	public UpdatePlayerResponse updatePlayer(@RequestPayload UpdatePlayerRequest request) {
		Player player = new Player();
		BeanUtils.copyProperties(request.getPlayerInfo(), player);
		playerService.updatePlayer(player);
    	ServiceStatusPlayer serviceStatusPlayer = new ServiceStatusPlayer();
    	serviceStatusPlayer.setStatusCode("SUCCESS");
    	serviceStatusPlayer.setMessage("Content Updated Successfully");
    	UpdatePlayerResponse response = new UpdatePlayerResponse();
    	response.setServiceStatusPlayer(serviceStatusPlayer);
    	return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deletePlayerRequest")
	@ResponsePayload
	public DeletePlayerResponse deleteplayer(@RequestPayload DeletePlayerRequest request) {
		Player player = playerService.getPlayerById(request.getPlayerId());
    	ServiceStatusPlayer serviceStatusPlayer = new ServiceStatusPlayer();
		if (player == null ) {
	    	serviceStatusPlayer.setStatusCode("FAIL");
	    	serviceStatusPlayer.setMessage("Content Not Available");
		} else {
			playerService.deletePlayer(player);
	    	serviceStatusPlayer.setStatusCode("SUCCESS");
	    	serviceStatusPlayer.setMessage("Content Deleted Successfully");
		}
    	DeletePlayerResponse response = new DeletePlayerResponse();
    	response.setServiceStatusPlayer(serviceStatusPlayer);
		return response;
	}	
}
