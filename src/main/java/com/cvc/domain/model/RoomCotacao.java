package com.cvc.domain.model;

public class RoomCotacao extends AbstractRoom{
	
	private double totalPrice;
	private PriceDetail priceDetail;	
	
	public RoomCotacao(int roomID, String categoryName, double totalPrice, PriceDetail priceDetail) {
		super(roomID, categoryName);
		this.totalPrice = totalPrice;
		this.priceDetail = priceDetail;
	} 
	
	public double getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	public PriceDetail getPriceDetail() {
		return priceDetail;
	}
	public void setPriceDetail(PriceDetail priceDetail) {
		this.priceDetail = priceDetail;
	}
}


