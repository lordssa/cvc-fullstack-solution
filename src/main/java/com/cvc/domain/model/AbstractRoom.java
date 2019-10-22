package com.cvc.domain.model;

public abstract class AbstractRoom {

	private int roomID;
	private String categoryName;

	public AbstractRoom() {			
	}
	
	public AbstractRoom(int roomID, String categoryName) {		
		this.roomID = roomID;
		this.categoryName = categoryName;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
}
