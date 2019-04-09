package com.tonasolution.microservices.currencyconversionservice;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.tonasolution.microservices.currencyconversionservice.models.CurrencyConversionBean;

@RestController
public class CurrencyConversionController {

	@GetMapping("/currency-exchange/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(
			@PathVariable String from,
			@PathVariable String to,
			@PathVariable BigDecimal quantity
			) {
		return new CurrencyConversionBean(
				1L, 
				from, 
				to, 
				BigDecimal.valueOf(65),
				quantity, 
				BigDecimal.valueOf(7),
				0
		);
		
	}
	
	
}
