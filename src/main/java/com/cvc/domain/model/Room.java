package com.cvc.domain.model;

import com.cvc.domain.model.Price;

public class Room extends AbstractRoom{

	private Price price;

	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}

}
