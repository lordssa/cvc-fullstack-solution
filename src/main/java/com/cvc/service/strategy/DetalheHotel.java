package com.cvc.service.strategy;

import java.util.List;

import com.cvc.model.Hotel;

public class DetalheHotel extends AbstractHotel implements IHotelStrategy {

	@Override
	public List<Hotel> Search(int code) {		
		List<Hotel> lista = Find(String.valueOf(code));
		return lista;
	}
}
