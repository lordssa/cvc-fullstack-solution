package com.cvc.repository;

import java.util.List;


import com.cvc.domain.model.Hotel;

public class HotelRepository extends BaseHotelRepository {
	
	
	private static HotelRepository _instance;
	private List<Hotel> listHotel; 
	private int cityCode;
	
	
	private HotelRepository() {
		
	}
	
	public static synchronized HotelRepository getInstance() {
		if(_instance == null) {			
			_instance = new HotelRepository();
		}
		
		return _instance;
	}
	

	/**
	 * 
	 * @param cityCode Code of city
	 * @return List of hotels filtered by city
	 */
	public List<Hotel> ListAllByCity(int cityCode) {				
		LoadListHotel(cityCode);			
		return this.listHotel;		
	}
	
	/**
	 * 
	 * @param cityCode Code of city
	 * @return Load hotel list filtered by city in memory
	 */
	public void LoadListHotel(int cityCode) {		
		if(this.listHotel == null || this.cityCode != cityCode) {	
			String queryString = "avail/"+cityCode;
			this.listHotel = Find(queryString);	
			this.cityCode = cityCode;
		}		
	}
	
	

}
