package com.cvc.domain.strategy;

import java.util.List;

import com.cvc.domain.model.Cotacao;
import com.cvc.domain.model.Hotel;

public class DetalheHotel extends AbstractHotel implements IHotelStrategy {

	@Override
	public List<Cotacao> Search(int code, int amountDaily){		
		List<Hotel> lista = Find(String.valueOf(code));
		return null;
	}
}
