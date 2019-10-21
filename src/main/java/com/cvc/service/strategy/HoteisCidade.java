package com.cvc.service.strategy;

import java.util.List;

import com.cvc.model.Hotel;

public class HoteisCidade extends AbstractHotel implements IHotelStrategy{

	@Override
	public List<Hotel> Search(int code) {
		String queryString = "avail/"+code;
		List<Hotel> lista = Find(queryString);

		return lista;
	}

}
