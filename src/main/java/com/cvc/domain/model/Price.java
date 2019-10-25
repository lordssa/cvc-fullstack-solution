package com.cvc.domain.model;


public class Price {
	private double adult;
	private double child;
	
	public double getAdult() {
		return adult;
	}
	public void setAdult(double adult) {
		this.adult = adult;
	}
	public double getChild() {
		return child;
	}
	public void setChild(double child) {
		this.child = child;
	}
	
	public double getTotalPrice(int amountDaily) {
		return Math.round((getValueTripAdult(amountDaily)+getValueTripChild(amountDaily)+getComissao(amountDaily))*100d)/100d;
	}
	
	private double getComissao(int amountDaily) {
		return getValueTripAdult(amountDaily)/0.7+getValueTripChild(amountDaily)/0.7;
	}
	
	private double getValueTripAdult(int amountDaily) {
		return getAdult()*amountDaily;
	}
	
	private double getValueTripChild(int amountDaily) {
		return getChild()*amountDaily;
	}
}

