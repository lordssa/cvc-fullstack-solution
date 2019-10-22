package com.cvc.service.factory;

import java.util.List;
import org.springframework.stereotype.Service;

import com.cvc.domain.enums.ServiceType;
import com.cvc.domain.model.Cotacao;
import com.cvc.domain.strategy.DetalheHotel;
import com.cvc.domain.strategy.HoteisCidade;
import com.cvc.domain.strategy.IHotelStrategy;


/**
 * Created by Cid Soares on 20/10/2019.
 *
 * Factory pattern:
 * - creates objects without exposing the instantiation logic to the client.
 * - refers to the newly created object through a common interface 
 */

@Service
public class HotelFactoryService {
	
	private IHotelStrategy hotelCidade;
	private IHotelStrategy hotelDetalhe;
	
	public HotelFactoryService() {
		hotelCidade = new HoteisCidade();
		hotelDetalhe = new DetalheHotel();		
	}

	public List<Cotacao> Search(ServiceType type, int code, int amountDaily){
		if(ServiceType.HotelsByCity == type) {
			return hotelCidade.Search(code, amountDaily);
		}else if(ServiceType.HotelDetail == type) {
			return hotelDetalhe.Search(code, amountDaily);
		}
		
		return null;
	}

}
