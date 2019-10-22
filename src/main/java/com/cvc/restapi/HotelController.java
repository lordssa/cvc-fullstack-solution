package com.cvc.restapi;

import java.util.Date;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cvc.service.HotelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping(value = "/api/hoteis")
@Api(value = "API CVC - Hoteis")
@CrossOrigin(origins = "*")
public class HotelController {

	@Autowired
	HotelService _hotelService;

	
	@GetMapping("/consultar")
	@ApiOperation(value = "Retorna detalhes da cotação de reserva")
	public ResponseEntity ValoresCotacao(@RequestParam(value="codHotel") int codHotel) {
		try {
			return new ResponseEntity(codHotel, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}		
	
	@GetMapping("/porCidade")
	@ApiOperation(value = "Retorna cotações de hoteis por cidade")
	public ResponseEntity RetornaCotacaoPorCidade(@RequestParam(value="cityCode") int cityCode,
												  @RequestParam(value="checkin") @DateTimeFormat(pattern = "dd/MM/yyyy") Date checkin,
												  @RequestParam(value="checkout") @DateTimeFormat(pattern = "dd/MM/yyyy") Date checkout,
												  @RequestParam(value="adults") int adults,
												  @RequestParam(value="children") int children) {
		try {
			return new ResponseEntity(_hotelService.HotelsByCity(cityCode, checkin, checkout, adults, children), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/detalhes")
	@ApiOperation(value = "Retorna detalhes da cotação de um hotels")
	public ResponseEntity DetalheCotacao(@RequestParam(value="codHotel") int codHotel) {
		try {
			return new ResponseEntity(_hotelService.HotelDetail(codHotel), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
}
