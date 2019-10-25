package com.cvc.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.cvc.domain.model.Cotacao;
import com.cvc.domain.model.Hotel;
import com.cvc.domain.model.PriceDetail;
import com.cvc.domain.model.RoomCotacao;

public abstract class BaseHotelRepository {
	final private String BASE_URL = "https://cvcbackendhotel.herokuapp.com/hotels/";	
	
	/**
	 * 
	 * @param hotelCode Hotel Code
	 * @return Hotel details
	 */
	protected List<Hotel> showHotelDetail(int hotelCode){		
		return Find(String.valueOf(hotelCode));
	}
	
	List<Hotel> Find(String queryString) {
		RestTemplate restTemplate = new RestTemplate();		
		ResponseEntity<Hotel[]> responseEntity = restTemplate.getForEntity(BASE_URL+queryString, Hotel[].class);
		Hotel[] objects = responseEntity.getBody();
		List<Hotel> list = new ArrayList<Hotel>(Arrays.asList(objects));
		return list;		
	}
	
	protected List<Cotacao> getCotacoes(List<Hotel> lista, int amountDaily){
		return lista.stream()
            .map(new Function<Hotel, Cotacao>(){

				@Override
				public Cotacao apply(Hotel hotel) {		
					
					List<RoomCotacao> listRoomCotacao = hotel.getRooms().stream()
							            .map(room -> new RoomCotacao(room.getRoomID(),
							            		                     room.getCategoryName(),
							            		                     room.getPrice().getTotalPrice(amountDaily),
							            		                     new PriceDetail(room.getPrice().getAdult(), room.getPrice().getChild())))
							            .collect(Collectors.toList());
					
					return new Cotacao(hotel.getId(), hotel.getCityName(), listRoomCotacao);
				}
            	
            })
            .collect(Collectors.toList());
	}
	
}
