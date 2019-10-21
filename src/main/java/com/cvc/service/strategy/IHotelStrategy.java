package com.cvc.service.strategy;

import java.util.List;

import com.cvc.model.Hotel;

/**
 * Created by Cid Soares on 20/10/2019.
 *
 * Strategy pattern:
 * Define a family of algorithms, encapsulate each one, and make them interchangeable.
 * Strategy lets the algorithm vary independently from clients that use it.
 */
public interface IHotelStrategy {
	List<Hotel> Search(int code);
}
