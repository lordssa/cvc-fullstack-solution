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
		return getAdult()*amountDaily+getChild()*amountDaily+getComissao();
	}
	
	private double getComissao() {
		return getAdult()/0.7d+getChild()/0.7d;
	}
	
}

