package com.cvc.service.factory;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.cvc.enums.TipoServico;
import com.cvc.model.Hotel;
import com.cvc.service.strategy.DetalheHotel;
import com.cvc.service.strategy.HoteisCidade;
import com.cvc.service.strategy.IHotelStrategy;


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

	public List<Hotel> Search(TipoServico tipoServico, int code){
		if(TipoServico.HoteisPorCidade == tipoServico) {
			return hotelCidade.Search(code);
		}else if(TipoServico.DetalheHotel == tipoServico) {
			return hotelDetalhe.Search(code);
		}
		
		return null;
	}

}
