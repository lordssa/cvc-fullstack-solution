package com.cvc.domain.model;

public class PriceDetail {

	private double pricePerDayAdult;
	private double pricePerDayChild;

	public PriceDetail(double pricePerDayAdult, double pricePerDayChild) {		
		this.pricePerDayAdult = pricePerDayAdult;
		this.pricePerDayChild = pricePerDayChild;
	}

	public double getPricePerDayAdult() {
		return pricePerDayAdult;
	}

	public void setPricePerDayAdult(double pricePerDayAdult) {
		this.pricePerDayAdult = pricePerDayAdult;
	}

	public double getPricePerDayChild() {
		return pricePerDayChild;
	}

	public void setPricePerDayChild(double pricePerDayChild) {
		this.pricePerDayChild = pricePerDayChild;
	}

}
