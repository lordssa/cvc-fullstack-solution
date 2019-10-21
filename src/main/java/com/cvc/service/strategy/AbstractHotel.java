package com.cvc.service.strategy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cvc.model.Hotel;


public abstract class AbstractHotel {

	final private String BASE_URL = "https://cvcbackendhotel.herokuapp.com/hotels/";
	
	public List<Hotel> Find(String queryString) {
		RestTemplate restTemplate = new RestTemplate();		
		ResponseEntity<Hotel[]> responseEntity = restTemplate.getForEntity(BASE_URL+queryString, Hotel[].class);
		Hotel[] objects = responseEntity.getBody();
		List<Hotel> list = new ArrayList<Hotel>(Arrays.asList(objects));
		return list;		
	}
	
	
}
