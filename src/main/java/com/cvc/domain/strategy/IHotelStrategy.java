package com.cvc.domain.strategy;

import java.util.List;

import com.cvc.domain.model.Cotacao;

/**
 * Created by Cid Soares on 20/10/2019.
 *
 * Strategy pattern:
 * Define a family of algorithms, encapsulate each one, and make them interchangeable.
 * Strategy lets the algorithm vary independently from clients that use it.
 */
public interface IHotelStrategy {
	List<Cotacao> Search(int code, int amountDaily);
}
