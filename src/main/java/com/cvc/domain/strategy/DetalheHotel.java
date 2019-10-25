package com.cvc.domain.strategy;

import java.util.List;

import com.cvc.domain.model.Cotacao;
import com.cvc.domain.model.Hotel;
import com.cvc.repository.BaseHotelRepository;

public class DetalheHotel extends BaseHotelRepository implements IHotelStrategy {

	@Override
	public List<Cotacao> Search(int code, int amountDaily){		
		List<Hotel> lista = showHotelDetail(code);		
		return getCotacoes(lista, amountDaily);
	}
}
