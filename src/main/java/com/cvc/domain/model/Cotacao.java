package com.cvc.domain.model;

import java.util.List;

public class Cotacao {
	
	private int id;
	private String cityName;
	private List<RoomCotacao> rooms;
	
	public Cotacao(int id, String cityName, List<RoomCotacao> rooms) {		
		this.id = id;
		this.cityName = cityName;
		this.rooms = rooms;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public List<RoomCotacao> getRooms() {
		return rooms;
	}
	public void setRooms(List<RoomCotacao> rooms) {
		this.rooms = rooms;
	}
	
}


