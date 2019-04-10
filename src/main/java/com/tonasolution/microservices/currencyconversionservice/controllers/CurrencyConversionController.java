package com.tonasolution.microservices.currencyconversionservice.controllers;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tonasolution.microservices.currencyconversionservice.models.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		
		Map<String, String> uriVaribales = new HashMap<>();
		uriVaribales.put("from", from);
		uriVaribales.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> forEntity = new RestTemplate().getForEntity(
				"http://localhost:8001/currency-exchange/from/{from}/to/{to}", 
				CurrencyConversionBean.class,
				uriVaribales
				);
		CurrencyConversionBean response = forEntity.getBody();
		
		return new CurrencyConversionBean(
				response.getId(), 
				from, 
				to, 
				response.getConversionMultiple(),
				quantity, 
				quantity.multiply(response.getConversionMultiple()),
				response.getPort()
		);
		
	}
	
	
}
