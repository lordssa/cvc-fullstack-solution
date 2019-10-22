package com.cvc.service;

import java.util.Date;
import java.util.List;

import org.joda.time.Days;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvc.domain.enums.ServiceType;
import com.cvc.domain.model.Cotacao;
import com.cvc.service.factory.HotelFactoryService;

@Service
public class HotelService {
	
   private HotelFactoryService hotelFactoryService;
	
	@Autowired
	public HotelService(HotelFactoryService hotelFactoryService) {
		this.hotelFactoryService = hotelFactoryService;
	}
	
	public List<Cotacao> HotelDetail(int code){
		int amountDaily = 0;
		return hotelFactoryService.Search(ServiceType.HotelDetail, code, amountDaily);	
	}
	
	public List<Cotacao> HotelsByCity(int code, Date checkin, Date checkout, int adults, int children){
		int amountDaily = Days.daysBetween(new LocalDate(checkin), new LocalDate(checkout)).getDays();		
		return hotelFactoryService.Search(ServiceType.HotelsByCity, code, amountDaily);
	}
}
