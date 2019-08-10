package com.numa.soap.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.numa.soap.entity.Club;
import com.numa.soap.gs_ws.AddClubRequest;
import com.numa.soap.gs_ws.AddClubResponse;
import com.numa.soap.gs_ws.ClubInfo;
import com.numa.soap.gs_ws.DeleteClubRequest;
import com.numa.soap.gs_ws.DeleteClubResponse;
import com.numa.soap.gs_ws.GetAllClubsResponse;
import com.numa.soap.gs_ws.GetClubByIdRequest;
import com.numa.soap.gs_ws.GetClubByIdResponse;
import com.numa.soap.gs_ws.ServiceStatus;
import com.numa.soap.gs_ws.UpdateClubRequest;
import com.numa.soap.gs_ws.UpdateClubResponse;
import com.numa.soap.service.IClubService;
	
@Endpoint
public class ClubEndpoint {
	private static final String NAMESPACE_URI = "http://www.numapage.com/club-ws";
	@Autowired
	private IClubService clubService;	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getClubByIdRequest")
	@ResponsePayload
	public GetClubByIdResponse getClub(@RequestPayload GetClubByIdRequest request) {
		GetClubByIdResponse response = new GetClubByIdResponse();
		ClubInfo clubInfo = new ClubInfo();
		BeanUtils.copyProperties(clubService.getClubById(request.getClubId()), clubInfo);
		response.setClubInfo(clubInfo);
		return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllClubsRequest")
	@ResponsePayload
	public GetAllClubsResponse getAllClubs() {
		GetAllClubsResponse response = new GetAllClubsResponse();
		List<ClubInfo> ClubInfoList = new ArrayList<>();
		List<Club> ClubList = clubService.getAllClubs();
		for (int i = 0; i < ClubList.size(); i++) {
			 ClubInfo ob = new ClubInfo();
		     BeanUtils.copyProperties(ClubList.get(i), ob);
		     ClubInfoList.add(ob);    
		}
		response.getClubInfo().addAll(ClubInfoList);
		return response;
	}	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addClubRequest")
	@ResponsePayload
	public AddClubResponse addClub(@RequestPayload AddClubRequest request) {
		AddClubResponse response = new AddClubResponse();		
    	ServiceStatus serviceStatus = new ServiceStatus();		
		Club club = new Club();
		club.setName(request.getName());
		club.setCity(request.getCity());
		club.setTelephone(request.getTelephone());
		club.setNumSocios(request.getNumSocios());
        boolean flag = clubService.addClub(club);
        if (flag == false) {
        	serviceStatus.setStatusCode("CONFLICT");
        	serviceStatus.setMessage("Content Already Available");
        	response.setServiceStatus(serviceStatus);
        } else {
			ClubInfo clubInfo = new ClubInfo();
	        BeanUtils.copyProperties(club, clubInfo);
			response.setClubInfo(clubInfo);
        	serviceStatus.setStatusCode("SUCCESS");
        	serviceStatus.setMessage("Content Added Successfully");
        	response.setServiceStatus(serviceStatus);
        }
        return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateClubRequest")
	@ResponsePayload
	public UpdateClubResponse updateClub(@RequestPayload UpdateClubRequest request) {
		Club club = new Club();
		BeanUtils.copyProperties(request.getClubInfo(), club);
		clubService.updateClub(club);
    	ServiceStatus serviceStatus = new ServiceStatus();
    	serviceStatus.setStatusCode("SUCCESS");
    	serviceStatus.setMessage("Content Updated Successfully");
    	UpdateClubResponse response = new UpdateClubResponse();
    	response.setServiceStatus(serviceStatus);
    	return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteClubRequest")
	@ResponsePayload
	public DeleteClubResponse deleteClub(@RequestPayload DeleteClubRequest request) {
		Club club = clubService.getClubById(request.getClubId());
    	ServiceStatus serviceStatus = new ServiceStatus();
		if (club == null ) {
	    	serviceStatus.setStatusCode("FAIL");
	    	serviceStatus.setMessage("Content Not Available");
		} else {
			clubService.deleteClub(club);
	    	serviceStatus.setStatusCode("SUCCESS");
	    	serviceStatus.setMessage("Content Deleted Successfully");
		}
    	DeleteClubResponse response = new DeleteClubResponse();
    	response.setServiceStatus(serviceStatus);
		return response;
	}	
}
