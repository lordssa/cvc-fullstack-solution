package com.cvc.service.factory;

import java.util.List;
import org.springframework.stereotype.Service;

import com.cvc.domain.enums.ServiceType;
import com.cvc.domain.model.Cotacao;
import com.cvc.domain.strategy.DetalheHotel;
import com.cvc.domain.strategy.HoteisCidade;
import com.cvc.domain.strategy.IHotelStrategy;
import com.cvc.repository.HotelRepository;


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
	
	
	public void Load(int cityCode) {
		HotelRepository.getInstance().LoadListHotel(cityCode);
	}
	
	public List<Cotacao> Search(ServiceType type, int code, int amountDaily){
		if(ServiceType.HotelsByCity == type) {
			hotelCidade = new HoteisCidade();
			return hotelCidade.Search(code, amountDaily);
		}else if(ServiceType.HotelDetail == type) {
			hotelDetalhe = new DetalheHotel();	
			return hotelDetalhe.Search(code, amountDaily);
		}
		
		return null;
	}

}
