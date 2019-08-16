package com.numa.soap.endpoints;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.numa.soap.entity.Country;
import com.numa.soap.gs_ws.AddCountryRequest;
import com.numa.soap.gs_ws.AddCountryResponse;
import com.numa.soap.gs_ws.CountryInfo;
import com.numa.soap.gs_ws.DeleteCountryRequest;
import com.numa.soap.gs_ws.DeleteCountryResponse;
import com.numa.soap.gs_ws.GetAllCountrysResponse;
import com.numa.soap.gs_ws.GetCountryByIdRequest;
import com.numa.soap.gs_ws.GetCountryByIdResponse;
import com.numa.soap.gs_ws.ServiceStatusCountry;
import com.numa.soap.gs_ws.UpdateCountryRequest;
import com.numa.soap.gs_ws.UpdateCountryResponse;
import com.numa.soap.service.IntCountryService;
	
@Endpoint
public class CountryEndpoint {
	private static final String NAMESPACE_URI = "http://www.numapage.com/country-ws";
	@Autowired
	private IntCountryService countryService;	

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryByIdRequest")
	@ResponsePayload
	public GetCountryByIdResponse getCountry(@RequestPayload GetCountryByIdRequest request) {
		GetCountryByIdResponse response = new GetCountryByIdResponse();
		CountryInfo countryInfo = new CountryInfo();
		BeanUtils.copyProperties(countryService.getCountryById(request.getCountryId()), countryInfo);
		response.setCountryInfo(countryInfo);
		return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllCountrysRequest")
	@ResponsePayload
	public GetAllCountrysResponse getAllCountrys() {
		GetAllCountrysResponse response = new GetAllCountrysResponse();
		List<CountryInfo> countryInfoList = new ArrayList<>();
		List<Country> CountryList = countryService.getAllCountrys();
		for (int i = 0; i < CountryList.size(); i++) {
			 CountryInfo ob = new CountryInfo();
		     BeanUtils.copyProperties(CountryList.get(i), ob);
		     countryInfoList.add(ob);
		}
		response.getCountryInfo().addAll(countryInfoList);
		return response;
	}	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "addCountryRequest")
	@ResponsePayload
	public AddCountryResponse addCountry(@RequestPayload AddCountryRequest request) {
		AddCountryResponse response = new AddCountryResponse();		
    	ServiceStatusCountry serviceStatusCountry = new ServiceStatusCountry();
		Country country = new Country();
		country.setCode(request.getCode());
		country.setName(request.getName());
        boolean flag = countryService.addCountry(country);
        if (flag == false) {
        	serviceStatusCountry.setStatusCode("CONFLICT");
        	serviceStatusCountry.setMessage("Content Already Available");
        	response.setServiceStatusCountry(serviceStatusCountry);
        } else {
			CountryInfo countryInfo = new CountryInfo();
	        BeanUtils.copyProperties(country, countryInfo);
			response.setCountryInfo(countryInfo);
        	serviceStatusCountry.setStatusCode("SUCCESS");
        	serviceStatusCountry.setMessage("Content Added Successfully");
        	response.setServiceStatusCountry(serviceStatusCountry);
        }
        return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "updateCountryRequest")
	@ResponsePayload
	public UpdateCountryResponse updateCountry(@RequestPayload UpdateCountryRequest request) {
		Country country = new Country();
		BeanUtils.copyProperties(request.getCountryInfo(), country);
		countryService.updateCountry(country);
    	ServiceStatusCountry serviceStatusContry = new ServiceStatusCountry();
    	serviceStatusContry.setStatusCode("SUCCESS");
    	serviceStatusContry.setMessage("Content Updated Successfully");
    	UpdateCountryResponse response = new UpdateCountryResponse();
    	response.setServiceStatusCountry(serviceStatusContry);
    	return response;
	}
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteCountryRequest")
	@ResponsePayload
	public DeleteCountryResponse deleteCountry(@RequestPayload DeleteCountryRequest request) {
		Country country = countryService.getCountryById(request.getCountryId());
    	ServiceStatusCountry serviceStatusCountry = new ServiceStatusCountry();
		if (country == null ) {
			serviceStatusCountry.setStatusCode("FAIL");
			serviceStatusCountry.setMessage("Content Not Available");
		} else {
			countryService.deleteCountry(country);
			serviceStatusCountry.setStatusCode("SUCCESS");
			serviceStatusCountry.setMessage("Content Deleted Successfully");
		}
    	DeleteCountryResponse response = new DeleteCountryResponse();
    	response.setServiceStatusCountry(serviceStatusCountry);
		return response;
	}	
}
