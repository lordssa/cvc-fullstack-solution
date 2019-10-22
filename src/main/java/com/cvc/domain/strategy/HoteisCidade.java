package com.cvc.domain.strategy;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.cvc.domain.model.Cotacao;
import com.cvc.domain.model.Hotel;
import com.cvc.domain.model.PriceDetail;
import com.cvc.domain.model.RoomCotacao;

public class HoteisCidade extends AbstractHotel implements IHotelStrategy{
		 

	@Override
	public List<Cotacao> Search(int code, int amountDaily) {
		String queryString = "avail/"+code;
		List<Hotel> lista = Find(queryString);
		
		List<Cotacao> cotacoes = lista.stream()
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
		
		return cotacoes;
	}

}
